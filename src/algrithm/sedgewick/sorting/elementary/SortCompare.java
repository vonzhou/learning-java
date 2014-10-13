package algrithm.sedgewick.sorting.elementary;

import java.util.Arrays;

import algrithm.sedgewick.fundamental.programmodel.StdOut;
import algrithm.sedgewick.fundamental.programmodel.StdRandom;
import algrithm.sedgewick.fundamental.programmodel.Stopwatch;

public class SortCompare { 

    public static double time(String alg, Double[] a) { 
        Stopwatch sw = new Stopwatch(); 
        if (alg.equals("Insertion"))       Insertion.sort(a); 
        else if (alg.equals("InsertionX")) InsertionX.sort(a); 
        else if (alg.equals("Selection"))  Selection.sort(a); 
        else if (alg.equals("Shell"))      Shell.sort(a); 
        else if (alg.equals("Merge"))      Merge.sort(a); 
        else if (alg.equals("MergeX"))     MergeX.sort(a); 
        else if (alg.equals("MergeBU"))    MergeBU.sort(a); 
        else if (alg.equals("Quick"))      Quick.sort(a); 
        else if (alg.equals("Quick3way"))  Quick3way.sort(a); 
        else if (alg.equals("QuickX"))     QuickX.sort(a); 
        else if (alg.equals("Heap"))       Heap.sort(a); 
        else if (alg.equals("System"))     Arrays.sort(a); 
        else throw new IllegalArgumentException("Invalid algorithm: " + alg);
        return sw.elapsedTime(); 
    } 

    // Use alg to sort T random arrays of length N. 
    public static double timeRandomInput(String alg, int N, int T)  {
        double total = 0.0; 
        Double[] a = new Double[N]; 
        // Perform one experiment (generate and sort an array). 
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++) 
                a[i] = StdRandom.uniform(); 
            total += time(alg, a); 
        } 
        return total; 
    } 

    public static void main(String[] args) { 
        String alg1 = args[0]; 
        String alg2 = args[1]; 
        int N = Integer.parseInt(args[2]); 
        int T = Integer.parseInt(args[3]); 
        double time1 = timeRandomInput(alg1, N, T); // Total for alg1. 
        double time2 = timeRandomInput(alg2, N, T); // Total for alg2. 
        StdOut.printf("For %d random Doubles\n    %s is", N, alg1); 
        StdOut.printf(" %.1f times faster than %s\n", time2/time1, alg2); 
    } 
} 
