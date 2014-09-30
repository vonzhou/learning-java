package algrithm.sedgewick.fundamental.dataabstract;

import algrithm.sedgewick.fundamental.programmodel.StdOut;
import algrithm.sedgewick.fundamental.programmodel.StdRandom;

public class Flips {
    public static void main(String[] args) {
        //int T = Integer.parseInt(args[0]);
    	int T = 10000;
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        //Ëæ»úÔö¼Ó
        for (int t = 0; t < T; t++) {
            if (StdRandom.bernoulli(0.5)) heads.increment();
            else   tails.increment();
        }
        
        StdOut.println(heads);
        StdOut.println(tails);
        int delta = heads.tally() - tails.tally();
        StdOut.println("delta: " + Math.abs(delta));
    }
}



