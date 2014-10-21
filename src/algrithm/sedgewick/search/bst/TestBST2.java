package algrithm.sedgewick.search.bst;

import algrithm.sedgewick.fundamental.programmodel.StdOut;



public class TestBST2 {
    public static void main(String[] args) { 
        String test = "S E A R C H E X A M P L E"; 
        String[] keys = test.split(" "); 
        int N = keys.length; 
        BST<String, Integer> st = new BST<String, Integer>();
        for (int i = 0; i < N; i++) 
            st.put(keys[i], i); 


        // print keys in order using allKeys()
        for (String s : st.keys()) 
            StdOut.println(s + " " + st.get(s)); 
        StdOut.println();
        
        Iterable<String> it = st.levelOrder();
        for(String s: it)
        	System.out.println(s + " " );

    }
}

