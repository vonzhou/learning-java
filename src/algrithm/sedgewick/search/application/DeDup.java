package algrithm.sedgewick.search.application;

import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;


public class DeDup {  
    public static void main(String[] args) {
        SET<String> set = new SET<String>();

        // read in strings and add to set
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (!set.contains(key)) {
                set.add(key);
                StdOut.println(key);
            }
        }
    }
}
