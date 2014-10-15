package algrithm.sedgewick.sorting.quicksort;

import algrithm.sedgewick.fundamental.programmodel.StdOut;

public class QuickKR {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        exch(a, lo, (lo + hi) / 2);  // use middle element as partition
        int last = lo;
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[lo])) exch(a, ++last, i);
        exch(a, lo, last);
        sort(a, lo, last-1);
        sort(a, last+1, hi);
    }


   /***********************************************************************
    *  Helper sorting functions
    ***********************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***********************************************************************
    *  Check if array is sorted - useful for debugging
    ***********************************************************************/
    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }



    // test client
    public static void main(String[] args) {

        // generate array of N random reals between 0 and 1
        int N = Integer.parseInt(args[0]);
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = Math.random();
            // a[i] = (double) StdRandom.uniform(2);
        }
        
        // sort the array
        sort(a);

        // display results
        for (int i = 0; i < N; i++) {
            StdOut.println(a[i]);
        }
        StdOut.println("isSorted = " + isSorted(a));
    }

}

