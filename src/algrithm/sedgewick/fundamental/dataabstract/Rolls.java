package algrithm.sedgewick.fundamental.dataabstract;

import algrithm.sedgewick.fundamental.programmodel.StdOut;
import algrithm.sedgewick.fundamental.programmodel.StdRandom;

//对象数组
public class Rolls {
    public static void main(String[] args) {
        int T = 1000;
        int SIDES = 6;

        //定义数组，但是每个引用还没有初始化
        Counter[] rolls = new Counter[SIDES+1];
        
        for (int i = 1; i <= SIDES; i++) {
            rolls[i] = new Counter(i + "'s");
        }

        // flip dice
        for (int t = 0; t < T; t++) {
            int result = StdRandom.uniform(1, SIDES+1);
            rolls[result].increment();
        }

        // print results
        for (int i = 1; i <= SIDES; i++) {
            StdOut.println(rolls[i]);
        }
    }
}
