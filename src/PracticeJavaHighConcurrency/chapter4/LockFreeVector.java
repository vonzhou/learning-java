

package PracticeJavaHighConcurrency.chapter4;

import java.util.AbstractList;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;


/**
 * It is a thread safe and lock-free vector. This class implement algorithm
 * from:<br>
 * <p>
 * "Lock-free Dynamically Resizable Arrays" <br>
 * <p>
 * Damian Dechev, Peter Pirkelbauer, and Bjarne Stroustrup<br>
 * Texas A&M University College Station, TX 77843-3112<br>
 * {dechev, peter.pirkelbauer}@tamu.edu, bs@cs.tamu.edu
 * <p>
 * This vector supports dynamic expansion of vector in a lock-free manner. The
 * elements are stored in an array of segments. The fist segment (with an index
 * of '0') can contain 8 elements. The <i>n</i>th
 * segment can contain 8*(2**<i>n</i>) elements.
 *
 * @param <E> type of element in the vector
 * @author Zhi Gan
 */
public class LockFreeVector<E> extends AbstractList<E> {
    private static final int MARK_FIRST_BIT = 0x80000000;
    private static final boolean DEBUG = false;
    /**
     * Size of the first bucket. sizeof(bucket[i+1])=2*sizeof(bucket[i])
     */
    private static final int FIRST_BUCKET_SIZE = 8;

    /**
     * number of buckets. 30 will allow 8*(2^30-1) elements
     */
    private static final int N_BUCKET = 30;

    /**
     * We will have at most N_BUCKET number of buckets. And we have
     * sizeof(buckets.get(i))=FIRST_BUCKET_SIZE**(i+1)
     */
    private final AtomicReferenceArray<AtomicReferenceArray<E>> buckets;

    /**
     * The descriptor is used to describe write operation.
     *
     * @param <E>
     */
    static class WriteDescriptor<E> {
        /**
         * Old value.
         */
        public E oldV;
        /**
         * New value.
         */
        public E newV;
        /**
         * Address array to be updated.
         */
        public AtomicReferenceArray<E> addr;
        /**
         * Index of address array.
         */
        public int addrInd;

        /**
         * Creating a new descriptor.
         *
         * @param addr    Operation address
         * @param addrInd Index of address
         * @param oldV    old operand
         * @param newV    new operand
         */
        public WriteDescriptor(AtomicReferenceArray<E> addr, int addrInd,
                               E oldV, E newV) {
            this.addr = addr;
            this.addrInd = addrInd;
            this.oldV = oldV;
            this.newV = newV;
        }

        /**
         * set newV to the address.
         */
        public void doIt() {
            addr.compareAndSet(addrInd, oldV, newV);
        }
    }

    /**
     * The descriptor is used to describe current status of vector. It exists so
     * that we can replace two important information in one CAS operation:
     * <ul>
     * <li>size of vector</li>
     * <li>next operation to execute</li>
     * </ul>
     * <p>
     * If we store above two information in two separated variable, it's
     * possible that data race will occur. Eg, if we update size at first, a
     * pushback() will cause popback return <code>null</code> value. On the
     * contrary, if we modify elements first in a push_back() operation, it
     * might be overwrite by push_back() from other threads.
     *
     * @param <E>
     */
    static class Descriptor<E> {
        /**
         * we store size of vector into descriptor to get atomicity.
         */
        public int size;
        /**
         * Write operation.
         */
        volatile WriteDescriptor<E> writeop;

        /**
         * Create a new descriptor.
         *
         * @param size    Size of the vector
         * @param writeop Executor write operation
         */
        public Descriptor(int size, WriteDescriptor<E> writeop) {
            this.size = size;
            this.writeop = writeop;
        }

        /**
         * Complete the write operation.
         */
        public void completeWrite() {
            WriteDescriptor<E> tmpOp = writeop;
            if (tmpOp != null) {
                tmpOp.doIt();
                writeop = null; // this is safe since all write to writeop use
                // null as r_value.
            }
        }
    }

    /**
     * This descriptor which contains important information. such as:
     * <p>
     * <ul>
     * <li>size of vector</li>
     * <li>next operation to execute</li>
     * </ul>
     */
    private AtomicReference<Descriptor<E>> descriptor;

    private static final int ZERO_NUM_FIRST = Integer.numberOfLeadingZeros(FIRST_BUCKET_SIZE);
    ;

    /**
     * Create a new lock-free vector.
     */
    public LockFreeVector() {
        buckets = new AtomicReferenceArray<AtomicReferenceArray<E>>(N_BUCKET);
        buckets.set(0, new AtomicReferenceArray<E>(FIRST_BUCKET_SIZE));
        descriptor = new AtomicReference<Descriptor<E>>(new Descriptor<E>(0,
                null));
    }

    /**
     * add e at the end of vector.
     *
     * @param e element added
     */
    public void pushBack(E e) {
        Descriptor<E> desc;
        Descriptor<E> newd;
        do {
            desc = descriptor.get();
            desc.completeWrite();

            int pos = desc.size + FIRST_BUCKET_SIZE;
            int zeroNumPos = Integer.numberOfLeadingZeros(pos);
            int bucketInd = ZERO_NUM_FIRST - zeroNumPos;

            // Add a new segment if all segments are occupied
            if (buckets.get(bucketInd) == null) {
                int newLen = 2 * buckets.get(bucketInd - 1).length();

                if (DEBUG)
                    System.out.println("New Length is:" + newLen);

                buckets.compareAndSet(bucketInd, null,
                        new AtomicReferenceArray<E>(newLen));
            }

            // Get rid of leading 1 from pos to get idx, which is internal index
            // inside selected bucket
            int idx = (MARK_FIRST_BIT >>> zeroNumPos) ^ pos;

            newd = new Descriptor<E>(desc.size + 1, new WriteDescriptor<E>(
                    buckets.get(bucketInd), idx, null, e));
        } while (!descriptor.compareAndSet(desc, newd));
        descriptor.get().completeWrite();
    }

    /**
     * Remove the last element in the vector. We don't shrink size of segments
     * here. So the memory of vector never shrink.
     *
     * @return element removed
     */
    public E popBack() {
        Descriptor<E> desc;
        Descriptor<E> newd;
        E elem;
        do {
            desc = descriptor.get();
            desc.completeWrite();

            int pos = desc.size + FIRST_BUCKET_SIZE - 1;
            int bucketInd = Integer.numberOfLeadingZeros(FIRST_BUCKET_SIZE)
                    - Integer.numberOfLeadingZeros(pos);
            int idx = Integer.highestOneBit(pos) ^ pos;
            elem = buckets.get(bucketInd).get(idx);
            newd = new Descriptor<E>(desc.size - 1, null);
        } while (!descriptor.compareAndSet(desc, newd)); // CAS to complete all
        // steps if succeed

        return elem;
    }

    /**
     * Get element with the index.
     *
     * @param index index
     * @return element with the index
     */
    @Override
    public E get(int index) {
        int pos = index + FIRST_BUCKET_SIZE;
        int zeroNumPos = Integer.numberOfLeadingZeros(pos);
        int bucketInd = ZERO_NUM_FIRST - zeroNumPos;
        int idx = (MARK_FIRST_BIT >>> zeroNumPos) ^ pos;
        return buckets.get(bucketInd).get(idx);
    }

    /**
     * Set the element with index to e.
     *
     * @param index index of element to be reset
     * @param e     element to set
     * @return old value
     */
    public E set(int index, E e) {
        int pos = index + FIRST_BUCKET_SIZE;
        int bucketInd = Integer.numberOfLeadingZeros(FIRST_BUCKET_SIZE)
                - Integer.numberOfLeadingZeros(pos);
        int idx = Integer.highestOneBit(pos) ^ pos;
        AtomicReferenceArray<E> bucket = buckets.get(bucketInd);
        while (true) {
            E oldV = bucket.get(idx);
            if (bucket.compareAndSet(idx, oldV, e))
                return oldV;
        }
    }

    /**
     * reserve more space.
     *
     * @param newSize new size be reserved
     */
    public void reserve(int newSize) {
        int size = descriptor.get().size;
        int pos = size + FIRST_BUCKET_SIZE - 1;
        int i = Integer.numberOfLeadingZeros(FIRST_BUCKET_SIZE)
                - Integer.numberOfLeadingZeros(pos);
        if (i < 1)
            i = 1;

        int initialSize = buckets.get(i - 1).length();
        while (i < Integer.numberOfLeadingZeros(FIRST_BUCKET_SIZE)
                - Integer.numberOfLeadingZeros(newSize + FIRST_BUCKET_SIZE - 1)) {
            i++;
            initialSize *= FIRST_BUCKET_SIZE;
            buckets.compareAndSet(i, null, new AtomicReferenceArray<E>(
                    initialSize));
        }
    }

    /**
     * return size of vector.
     *
     * @return size of vector
     */
    public int size() {
        return descriptor.get().size;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean add(E object) {
        pushBack(object);
        return true;
    }
}