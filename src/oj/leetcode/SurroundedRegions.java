package oj.leetcode;


/*
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
利用Union find算法，划分为不同的连通组件，然后连通组件是O并且不包含边缘的O，那么就说明被包围
所以在UF算法基础上，需要增加额外的记录

用时 ： 2h
 */
public class SurroundedRegions {
	int unionSet[];
	boolean hasEdgeO[];  //所在行列是否有边界上的O
	
	public void solve(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0)
			return;
		
		int row = board.length, col = board[0].length;
		int unionSize = row * col;
		unionSet = new int[unionSize];
		hasEdgeO = new boolean[unionSize];
		// 初始化并查集合标识向量
		for(int i = 0; i < unionSize; i ++){
			unionSet[i] = i;
			int x = i / col, y = i % col; // locate
			hasEdgeO[i] = (board[x][y]=='O') && 
					(x == 0 || x == row - 1 || y == 0 || y == col - 1);
		}
		
		//遍历这个矩阵，比对当前元素和它的上方，右方，看能否合并
		for(int i = 0; i < unionSize ; i++){
			int x = i / col, y = i % col;
			int up = x - 1, right = y + 1;
			if(up >= 0 && board[x][y] == board[up][y])
				union(i, i - col);
			if(right < col && board[x][y] == board[x][right])
				union(i, i + 1);
		}
		
		//然后 flipping
		for(int i = 0; i < unionSize ; i++){
			int x = i / col, y = i % col;
			// 特别要注意这里 要看根节点的情况
			if(board[x][y] == 'O' && !hasEdgeO[find(i)])
				board[x][y] = 'X';
		}
	}

	// 这里采用 quick-union 方法
	private void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		//约定合并到后一个连通分量
		unionSet[rootX] = rootY;
		boolean b = hasEdgeO[rootX] || hasEdgeO[rootY];
		hasEdgeO[rootX] = b;
		hasEdgeO[rootY] = b;
	}
	
	private int find(int x){
		if(x == unionSet[x])
			return x;
		unionSet[x] = find(unionSet[x]);
		return unionSet[x];
	}
	
	public static void main(String[] args) {
		SurroundedRegions sr = new SurroundedRegions();
		char board[][] = {
				{'O','X','X','O','X'},
				{'X','O','O','X','O'},
				{'X','O','X','O','X'},
				{'O','X','O','O','O'},
				{'X','X','O','X','O'}
				};
		
		sr.solve(board);
		//System.out.println();
		}
}



