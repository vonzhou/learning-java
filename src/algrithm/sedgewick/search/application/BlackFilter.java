package algrithm.sedgewick.search.application;

import algrithm.sedgewick.fundamental.programmodel.In;
import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;

/*
 * Read in a blacklist of words from a file. Then read in a list of
 *  words from standard input and print out all those words that
 *  are not in the first file.
 */
public class BlackFilter {  
    public static void main(String[] args) {
        SET<String> set = new SET<String>();

        // read in strings and add to set
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String word = in.readString();
            set.add(word);
        }

        // read in string from standard input, printing out all exceptions
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (!set.contains(word))
                StdOut.println(word);
        }
    }
}
