package algrithm.sedgewick.strings;


/*
 * 最多保留一个空格Squeeze whitespace. 
 * Write a program Squeeze.java that takes as input a string and removes 
 * adjacent spaces, leaving at most one space in-a-row.
 */
public class Squeeze { 
    public static String squeeze(String s) { 
        char[] a = s.toCharArray();
        int N = 1;
        // 特殊情况就是当前位置和前一个位置都是空格
        for (int i = 1; i < a.length; i++) { 
            a[N] = a[i];
            if      (a[N]   != ' ') N++;
            else if (a[N-1] != ' ') N++;
        }
        return new String(a, 0, N);
    }


    public static void main(String[] args) { 
        System.out.println(squeeze("  von  saf  "));
    }

}

