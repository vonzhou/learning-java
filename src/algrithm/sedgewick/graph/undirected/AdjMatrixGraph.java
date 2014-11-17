package algrithm.sedgewick.graph.undirected;

import java.util.Iterator;
import java.util.NoSuchElementException;

import algrithm.sedgewick.fundamental.programmodel.StdOut;

public class AdjMatrixGraph {
	private int V;
	private int E;
	private boolean[][] adj;

	// empty graph with V vertices
	public AdjMatrixGraph(int V) {
		if (V < 0)
			throw new RuntimeException("Number of vertices must be nonnegative");
		this.V = V;
		this.E = 0;
		this.adj = new boolean[V][V];
	}

	// random graph with V vertices and E edges
	public AdjMatrixGraph(int V, int E) {
		this(V);
		if (E < 0)
			throw new RuntimeException("Number of edges must be nonnegative");
		if (E > V * (V - 1) + V)
			throw new RuntimeException("Too many edges");

		// can be inefficient
		while (this.E != E) {
			int v = (int) (V * Math.random());
			int w = (int) (V * Math.random());
			addEdge(v, w);
		}
	}

	// number of vertices and edges
	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	// add undirected edge v-w
	public void addEdge(int v, int w) {
		if (!adj[v][w])
			E++;
		adj[v][w] = true;
		adj[w][v] = true;
	}

	// does the graph contain the edge v-w?
	public boolean contains(int v, int w) {
		return adj[v][w];
	}

	// return list of neighbors of v
	public Iterable<Integer> adj(int v) {
		return new AdjIterator(v);
	}

	// support iteration over graph vertices
	private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
		int v, w = 0;

		AdjIterator(int v) {
			this.v = v;
		}

		public Iterator<Integer> iterator() {
			return this;
		}

		public boolean hasNext() {
			while (w < V) {
				if (adj[v][w])
					return true;
				w++;
			}
			return false;
		}

		public Integer next() {
			if (hasNext()) {
				return w++;
			} else {
				throw new NoSuchElementException();
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	// string representation of Graph - takes quadratic time
	public String toString() {
		String NEWLINE = System.getProperty("line.separator");
		StringBuilder s = new StringBuilder();
		s.append(V + " " + E + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (int w : adj(v)) {
				s.append(w + " ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	// test client
	public static void main(String[] args) {
		int V = Integer.parseInt(args[0]);
		int E = Integer.parseInt(args[1]);
		AdjMatrixGraph G = new AdjMatrixGraph(V, E);
		StdOut.println(G);
	}

}
