package algrithm.sedgewick.search.symboltable;

import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;
import algrithm.sedgewick.stack.Queue;


/*
 * 习题3.1.2
 * 和有序数组相比 put的速度快，但是get的复杂度O(N)
 */
public class ArrayST<Key, Value> {
    private static final int INIT_SIZE = 8;

    private Value[] vals;   // symbol table values
    private Key[]   keys;   // symbol table keys
    private int N = 0;      // number of elements in symbol table

    public ArrayST() {
        keys = (Key[])new Object[INIT_SIZE];
        vals = (Value[])new Object[INIT_SIZE];
    }

    // return the number of key-value pairs in the symbol table
    public int size() { return N; }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // resize the parallel arrays to the given capacity
    private void resize(int capacity) {
        Key[]   tempk = (Key[])new Object[capacity];
        Value[] tempv = (Value[])new Object[capacity];
        for (int i = 0; i < N; i++) 
        	tempk[i] = keys[i];
        for (int i = 0; i < N; i++) 
        	tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }

    // insert the key-value pair into the symbol table
    public void put(Key key, Value val) {

        // to deal with duplicates
        delete(key);

        // double size of arrays if necessary
        if (N >= vals.length) resize(2*N);

        // add new key and value at the end of array
        vals[N] = val;
        keys[N] = key;
        N++;
    }

    public Value get(Key key) {
        for (int i = 0; i < N; i++)
            if (keys[i].equals(key)) return vals[i];
        return null;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < N; i++)
            queue.enqueue(keys[i]);
        return queue;
    }

    // remove given key (and associated value)
    public void delete(Key key) {
        for (int i = 0; i < N; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[N-1];
                vals[i] = vals[N-1];
                keys[N-1] = null;
                vals[N-1] = null;
                N--;
                if (N > 0 && N == keys.length/4) resize(keys.length/2);
                return;
            }
        }
    } 




   /***********************************************************************
    * Test routine.
    **********************************************************************/
    public static void main(String[] args) {
        ArrayST<String, Integer> st = new ArrayST<String, Integer>();
        for (int i = 0; !StdIn.isEmpty(); i++) {
            String key = StdIn.readString();
            st.put(key, i);
        }
        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
}

