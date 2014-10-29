package oj.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/*
 * Determine if a Sudoku is valid
 * The Sudoku board could be partially filled, where empty cells are
 *  filled with the character '.'.
 *  A partially filled sudoku which is valid.
 *  Note:
 *  A valid Sudoku board (partially filled) is not necessarily solvable.
 *   Only the filled cells need to be validated.
 *   
 * 1.最自然的想法是依次检查这个三个规则，行，列，9个宫，元素是否重复也是对hash表的考察,O(n^2)
 * 2.方法1有很多重复的逻辑，而且利用的 HashSet 并没有太大必要
 *   在索引上需要技巧，同时利用三个标志向量来处理三个规则，flags[0-9]分别用于保存对应数字是否出现过；
 * 3. 完全用空间换时间，用三个矩阵分别用于保存j是否出现在第i个(行/列/网格)
 */
public class ValidSudoku {
	// 1.
	public boolean isValidSudoku1(char[][] board) {
		if(board == null || board.length == 0 || board[0].length == 0)
			return false;
		int m = board.length, n = board[0].length;
		if(!(m == n && m % 3 == 0))
			return false;
		//
		Set<Character> set = new HashSet<Character>();
		// row case
		for(int i = 0; i < m ; i++){
			set.clear();
			// 迭代这一行
			for(char c : board[i]){
				boolean isValid = checkValid(set,c);
				if(!isValid) return false;
			}
		}
		
		// column case
		for(int j = 0; j < n; j++){
			set.clear();
			//迭代这一列
			for(int i = 0; i < m; i++){
				boolean isValid = checkValid(set, board[i][j]);
				if(!isValid) return false;
			}
		}
		
		// 9 grids
		for(int i = 0; i < m; i += 3)
			for(int j = 0; j < n; j += 3){
				// test this grid
				boolean isValid = checkGridValid(board,i,j,set);
				if(!isValid) return false;
			}
		
	 return true;       
	}

	// 检查每个3X3网格是否符合规则
	private boolean checkGridValid(char board[][], int m, int n, Set<Character> set) {
		set.clear();
		for(int i = m; i < m + 3; i++)
			for(int j = n; j < n + 3; j++){
				boolean isValid = checkValid(set,board[i][j]);
				if(!isValid) return false;
			}
		return true;
	}

	// 在集合中查看是否重复
	private boolean checkValid(Set<Character> set, char c) {
		if(c == '.') return true;
		if(set.contains(c)) return false;
		else set.add(c);
		return true;
	}
	
	//这里边界检查不是重点
	public boolean isValidSudoku2(char[][] board) {
		boolean rows[] = new boolean[9]; //用于标识  每一趟1-9是否已出现
		boolean cols[] = new boolean[9];
		boolean grid[] = new boolean[9];
		
		for(int i = 0; i < 9; i++){
			// 在处理下一 (行/列/网格)之前先初始化为不存在
			Arrays.fill(rows, false);
			Arrays.fill(cols, false);
			Arrays.fill(grid, false);
			for(int j = 0; j < 9; j++){
				boolean rowValid = checkValid2(rows, board[i][j]);
				if(!rowValid) return false;
				// 这样做效率很差
				boolean colValid = checkValid2(cols, board[j][i]);
				if(!colValid) return false;
				
				//第一个网格对应的分别是0-0,0-1..0-9，依次类推
				boolean gridValid = checkValid2(grid, board[3*(i/3) + j/3][3*(i%3) + j%3]);
				if(!gridValid) return false;
				
			}
		}
		return true;
	}

	private boolean checkValid2(boolean[] set, char c) {
		if(c == '.') return true;
		int index = c - '0' - 1;
		if(index < 0 || index > 9)
			return false;
		if(set[index] == true) return false;
		else set[index] = true;
		return true;
	}
	
	//3.
	public boolean isValidSudoku(char[][] board) {
		//充分利用这些数字的特点
		// xxx[i][j] 表示 j是否出现在第i个行/列/子宫格 中
		boolean rowContainer[][] = new boolean[9][9];
		boolean colContainer[][] = new boolean[9][9];
		boolean gridContainer[][] = new boolean[9][9];
		
		for(int i = 0; i < 9; i++)
			for(int j = 0; j < 9; j++){
				if(board[i][j] == '.') continue;
				int cur = board[i][j] - '1';  // index from 0
				if(rowContainer[i][cur] || colContainer[j][cur]
						|| gridContainer[3*(i/3)+j/3][cur])
					return false;
				//update
				rowContainer[i][cur] = true;
				colContainer[j][cur] = true;
				gridContainer[3*(i/3)+j/3][cur] = true;
			}
		
 		return true;
	}
	
	
}










