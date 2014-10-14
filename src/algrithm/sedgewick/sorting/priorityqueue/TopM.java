package algrithm.sedgewick.sorting.priorityqueue;

import java.util.Stack;

import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;



public class TopM {   

    // This class should not be instantiated.
    private TopM() { }

    /**
     *  Reads a sequence of transactions from standard input; takes a
     *  command-line integer M; prints to standard output the M largest
     *  transactions in descending order.
     */
    public static void main(String[] args) {
        int M = Integer.parseInt(args[0]); 
        MinPQ<Transaction> pq = new MinPQ<Transaction>(M+1); 

        while (StdIn.hasNextLine()) {
            // Create an entry from the next line and put on the PQ. 
            String line = StdIn.readLine();
            Transaction transaction = new Transaction(line);
            pq.insert(transaction); 

            // remove minimum if M+1 entries on the PQ
            if (pq.size() > M) 
                pq.delMin();
        }   // top M entries are on the PQ

        // print entries on PQ in reverse order
        Stack<Transaction> stack = new Stack<Transaction>();
        for (Transaction transaction : pq)
            stack.push(transaction);
        for (Transaction transaction : stack)
            StdOut.println(transaction);
    } 
} 