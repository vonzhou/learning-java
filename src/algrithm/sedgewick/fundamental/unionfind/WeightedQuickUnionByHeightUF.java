package algrithm.sedgewick.fundamental.unionfind;

import algrithm.sedgewick.fundamental.programmodel.StdIn;
import algrithm.sedgewick.fundamental.programmodel.StdOut;

public class WeightedQuickUnionByHeightUF {
    private int[] id;   // id[i] = parent of i
    private int[] ht;   // ht[i] = height of subtree rooted at i
    private int count;  // number of components

    /**
     * Initializes an empty union-find data structure with N isolated components 0 through N-1.
     * @throws java.lang.IllegalArgumentException if N < 0
     * @param N the number of objects
     */
    public WeightedQuickUnionByHeightUF(int N) {
        count = N;
        id = new int[N];
        ht = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            ht[i] = 0;
        }
    }

    /**
     * Returns the number of components.
     * @return the number of components (between 1 and N)
     */
    public int count() {
        return count;
    }

    /**
     * Returns the component identifier for the component containing site <tt>p</tt>.
     * @param p the integer representing one object
     * @return the component identifier for the component containing site <tt>p</tt>
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    /**
     * Are the two sites <tt>p</tt> and <tt>q</tt> in the same component?
     * @param p the integer representing one object
     * @param q the integer representing the other object
     * @return <tt>true</tt> if the two sites <tt>p</tt> and <tt>q</tt>
     * are in the same component, and <tt>false</tt> otherwise
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

  
    /**
     * Merges the component containing site<tt>p</tt> with the component
     * containing site <tt>q</tt>.
     * @param p the integer representing one site
     * @param q the integer representing the other site
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p < N and 0 <= q < N
     */
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j)
            return;

        // make shorter root point to taller one
        if      (ht[i] < ht[j]) id[i] = j;
        else if (ht[i] > ht[j]) id[j] = i;
        else{// 注意树长高的条件
            id[j] = i;
            ht[i]++;
        }
        count--;
    }

    /**
     * Reads in a sequence of pairs of integers (between 0 and N-1) from standard input, 
     * where each integer represents some object;
     * if the objects are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionByHeightUF uf = new WeightedQuickUnionByHeightUF(N);
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q))
                continue;
            uf.union(p, q);
            StdOut.print(p + " " + q + "  ");
            for (int i = 0; i < N; i++)
                StdOut.print(uf.id[i] + " ");
            StdOut.println();
        }
        StdOut.println(uf.count() + " components");
    }

}
