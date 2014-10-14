package algrithm.sedgewick.sorting.priorityqueue;

import algrithm.sedgewick.fundamental.programmodel.StdOut;



public class UnorderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;      // elements
    private int N;         // number of elements

    // set inititial size of heap to hold size elements
    public UnorderedArrayMaxPQ(int capacity) {
        pq = (Key[]) new Comparable[capacity];
        N = 0;
    }

    public boolean isEmpty()   { return N == 0; }
    public int size()          { return N;      }
    public void insert(Key x)  { pq[N++] = x;   }

    public Key delMax() {
        int max = 0;
        for (int i = 1; i < N; i++)
            if (less(max, i)) max = i;
        exch(max, N-1);

        return pq[--N];
    }


   /***********************************************************************
    * Helper functions.
    **********************************************************************/
    private boolean less(int i, int j) {
        return (pq[i].compareTo(pq[j]) < 0);
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


   /***********************************************************************
    * Test routine.
    **********************************************************************/
    public static void main(String[] args) {
        UnorderedArrayMaxPQ<String> pq = new UnorderedArrayMaxPQ<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty()) 
            StdOut.println(pq.delMax());
    }

}
