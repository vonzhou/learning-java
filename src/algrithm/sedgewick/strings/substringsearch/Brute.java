package algrithm.sedgewick.strings.substringsearch;

import algrithm.sedgewick.fundamental.programmodel.StdOut;

public class Brute {

	   /***************************************************************************
	    *  String versions
	    ***************************************************************************/

	    // return offset of first match or N if no match
	    public static int search1(String pat, String txt) {
	        int M = pat.length();
	        int N = txt.length();

	        for (int i = 0; i <= N - M; i++) {
	            int j;
	            for (j = 0; j < M; j++) {
	                if (txt.charAt(i+j) != pat.charAt(j))
	                    break;
	            }
	            if (j == M) return i;            // found at offset i
	        }
	        return N;                            // not found
	    }

	    // return offset of first match or N if no match
	    public static int search2(String pat, String txt) {
	        int M = pat.length();
	        int N = txt.length();
	        int i, j;
	        for (i = 0, j = 0; i < N && j < M; i++) {
	            if (txt.charAt(i) == pat.charAt(j)) j++;
	            else { i -= j; j = 0;  }
	        }
	        if (j == M) return i - M;    // found
	        else        return N;        // not found
	    }


	   /***************************************************************************
	    *  char[] array versions
	    ***************************************************************************/

	    // return offset of first match or N if no match
	    public static int search1(char[] pattern, char[] text) {
	        int M = pattern.length;
	        int N = text.length;

	        for (int i = 0; i <= N - M; i++) {
	            int j;
	            for (j = 0; j < M; j++) {
	                if (text[i+j] != pattern[j])
	                    break;
	            }
	            if (j == M) return i;            // found at offset i
	        }
	        return N;                            // not found
	    }

	    // return offset of first match or N if no match
	    public static int search2(char[] pattern, char[] text) { 
	        int M = pattern.length;
	        int N = text.length;
	        int i, j;
	        for (i = 0, j = 0; i < N && j < M; i++) {
	            if (text[i] == pattern[j]) j++;
	            else { i -= j; j = 0;  }
	        }
	        if (j == M) return i - M;    // found
	        else        return N;        // not found
	    } 


	    // test client
	    public static void main(String[] args) {
	        String pat = args[0];
	        String txt = args[1];
	        char[] pattern = pat.toCharArray();
	        char[] text    = txt.toCharArray();

	        int offset1a = search1(pat, txt);
	        int offset2a = search2(pat, txt);
	        int offset1b = search1(pattern, text);
	        int offset2b = search2(pattern, text);

	        // print results
	        StdOut.println("text:    " + txt);

	        // from brute force search method 1a
	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset1a; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);

	        // from brute force search method 2a
	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset2a; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);

	        // from brute force search method 1b
	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset1b; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);

	        // from brute force search method 2b
	        StdOut.print("pattern: ");
	        for (int i = 0; i < offset2b; i++)
	            StdOut.print(" ");
	        StdOut.println(pat);
	    }
	}
