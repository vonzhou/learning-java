package algrithm.sedgewick.sorting.priorityqueue;

import java.util.Stack;

import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;



public class TopMInt {   

    // This class should not be instantiated.
    private TopMInt() { }

    public static void main(String[] args) {
    	// ¥”√¸¡Ó–– ‰»ÎM
        int M = 5;
        MinPQ<Integer> pq = new MinPQ<Integer>(M+1); 

        while (StdIn.hasNextLine()) {
            // Create an entry from the next line and put on the PQ. 
            String line = StdIn.readLine();
            int transaction = Integer.parseInt(line);
            pq.insert(transaction); 

            // remove minimum if M+1 entries on the PQ
            if (pq.size() > M) 
                pq.delMin();
        }   // top M entries are on the PQ

        // print entries on PQ in reverse order
        Stack<Integer> stack = new Stack<Integer>();
        for (Integer transaction : pq)
            stack.push(transaction);
        for (Integer transaction : stack)
            StdOut.println(transaction);
    } 
} 