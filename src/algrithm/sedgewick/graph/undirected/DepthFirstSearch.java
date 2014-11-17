package algrithm.sedgewick.graph.undirected;

import algrithm.sedgewick.fundamental.programmodel.In;
import algrithm.sedgewick.fundamental.programmodel.StdOut;

public class DepthFirstSearch {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int count; // number of vertices connected to s

	/**
	 * Computes the vertices in graph <tt>G</tt> that are connected to the
	 * source vertex <tt>s</tt>.
	 * 
	 * @param G
	 *            the graph
	 * @param s
	 *            the source vertex
	 */
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	// depth first search from v
	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				dfs(G, w);
			}
		}
	}

	/**
	 * Is there a path between the source vertex <tt>s</tt> and vertex
	 * <tt>v</tt>?
	 * 
	 * @param v
	 *            the vertex
	 * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
	 */
	public boolean marked(int v) {
		return marked[v];
	}

	/**
	 * Returns the number of vertices connected to the source vertex <tt>s</tt>.
	 * 
	 * @return the number of vertices connected to the source vertex <tt>s</tt>
	 */
	public int count() {
		return count;
	}

	/**
	 * Unit tests the <tt>DepthFirstSearch</tt> data type.
	 */
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		int s = Integer.parseInt(args[1]);
		DepthFirstSearch search = new DepthFirstSearch(G, s);
		for (int v = 0; v < G.V(); v++) {
			if (search.marked(v))
				StdOut.print(v + " ");
		}

		StdOut.println();
		if (search.count() != G.V())
			StdOut.println("NOT connected");
		else
			StdOut.println("connected");
	}

}