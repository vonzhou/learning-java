package algrithm.sedgewick.search.balance;

import algrithm.sedgewick.fundamental.programmodel.StdOut;
import algrithm.sedgewick.fundamental.programmodel.StdRandom;

public class TestRedBlackBST {

    public static void main(String[] args) {

        String test = "S E A R C H E X A M P L E"; 
        String[] keys = test.split(" "); 
        RedBlackBST<String, Integer> st = new RedBlackBST<String, Integer>();
        for (int i = 0; i < keys.length; i++) 
            st.put(keys[i], i); 

        StdOut.println("size = " + st.size());
        StdOut.println("min  = " + st.min());
        StdOut.println("max  = " + st.max());
        StdOut.println();


        // print keys in order using allKeys()
        StdOut.println("Testing keys()");
        StdOut.println("--------------------------------");
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();

        // print keys in order using select
        StdOut.println("Testing select");
        StdOut.println("--------------------------------");
        for (int i = 0; i <= st.size(); i++)
            StdOut.println(i + " " + st.select(i)); 
        StdOut.println();

        // test rank, floor, ceiling
        StdOut.println("key rank floor ceil");
        StdOut.println("-------------------");
        for (char i = 'A'; i <= 'Z'; i++) {
            String s = i + "";
            StdOut.printf("%2s %4d %4s %4s\n", s, st.rank(s), st.floor(s), st.ceiling(s));
        }
        StdOut.println();

        // test range search and range count
        String[] from = { "A", "Z", "X", "0", "B", "C" };
        String[] to   = { "Z", "A", "X", "Z", "G", "L" };
        StdOut.println("range search");
        StdOut.println("-------------------");
        for (int i = 0; i < from.length; i++) {
            StdOut.printf("%s-%s (%2d) : ", from[i], to[i], st.size(from[i], to[i]));
            for (String s : st.keys(from[i], to[i]))
                StdOut.print(s + " ");
            StdOut.println();
        }
        StdOut.println();

        // delete the smallest keys
        for (int i = 0; i < st.size() / 2; i++) {
            st.deleteMin();
        }
        StdOut.println("After deleting the smallest " + st.size() / 2 + " keys");
        StdOut.println("--------------------------------");
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();

        // delete all the remaining keys
        while (!st.isEmpty()) {
            st.delete(st.select(st.size() / 2));
        }
        StdOut.println("After deleting the remaining keys");
        StdOut.println("--------------------------------");
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();

        StdOut.println("After adding back N keys");
        StdOut.println("--------------------------------");
        for (int i = 0; i < keys.length; i++) 
            st.put(keys[i], i); 
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();

        StdOut.println();




        // insert N elements in order if one command-line argument supplied
        if (args.length == 0) return;
        int N = Integer.parseInt(args[0]);
        RedBlackBST<Integer, Integer> st2 = new RedBlackBST<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            st2.put(i, i);
            int h = st2.height();
            StdOut.println("i = " + i + ", height = " + h + ", size = " + st2.size());
        }

        // delete keys in random order
        StdOut.println("Deleting keys in random order");
        while (st2.size() > 0) {
            int i = StdRandom.uniform(N);
            if (st2.contains(i)) {
                st2.delete(i);
                int h = st2.height();
                StdOut.println("i = " + i + ", height = " + h + ", size = " + st2.size());
            }
        }

        StdOut.println("size = " + st2.size());
    }
}
