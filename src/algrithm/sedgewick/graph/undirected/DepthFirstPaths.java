package algrithm.sedgewick.graph.undirected;

import algrithm.sedgewick.fundamental.programmodel.In;
import algrithm.sedgewick.fundamental.programmodel.StdOut;
import algrithm.sedgewick.stack.Stack;

public class DepthFirstPaths {
	private boolean[] marked; // marked[v] = is there an s-v path?
	private int[] edgeTo; // edgeTo[v] = last edge on s-v path
	private final int s; // source vertex

	/**
	 * Computes a path between <tt>s</tt> and every other vertex in graph
	 * <tt>G</tt>.
	 * 
	 * @param G
	 *            the graph
	 * @param s
	 *            the source vertex
	 */
	public DepthFirstPaths(Graph G, int s) {
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G, s);
	}

	// depth first search from v
	private void dfs(Graph G, int v) {
		marked[v] = true;
		for (int w : G.adj(v)) {
			if (!marked[w]) {
				edgeTo[w] = v;  // 经过w节点到达v
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
	public boolean hasPathTo(int v) {
		return marked[v];
	}

	/**
	 * v 到 s 的路径
	 * 步步追踪
	 */
	public Iterable<Integer> pathTo(int v) {
		if (!hasPathTo(v))
			return null;
		Stack<Integer> path = new Stack<Integer>();
		for (int x = v; x != s; x = edgeTo[x])
			path.push(x);
		path.push(s);
		return path;
	}

	/**
	 * Unit tests the <tt>DepthFirstPaths</tt> data type.
	 */
	public static void main(String[] args) {
		In in = new In(args[0]);
		Graph G = new Graph(in);
		int s = Integer.parseInt(args[1]);
		DepthFirstPaths dfs = new DepthFirstPaths(G, s);

		for (int v = 0; v < G.V(); v++) {
			if (dfs.hasPathTo(v)) {
				StdOut.printf("%d to %d:  ", s, v);
				for (int x : dfs.pathTo(v)) {
					if (x == s)
						StdOut.print(x);
					else
						StdOut.print("-" + x);
				}
				StdOut.println();
			}

			else {
				StdOut.printf("%d to %d:  not connected\n", s, v);
			}

		}
	}

}
