package algrithm.sedgewick.strings.sort;


/*
 * 最多保留一个空格
 */
public class Squeeze { 
    public static String squeeze(String s) { 
        char[] a = s.toCharArray();
        int N = 1;
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

