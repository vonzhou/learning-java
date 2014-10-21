package oj.leetcode.binarysearch;


/*
 * Write an efficient algorithm that searches for a value in an m x n matrix. 
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0)
			return false;
		int row = matrix.length;
		int col = matrix[0].length;
		//System.out.println(row + " " + col);
		int first = 0 , last = row * col - 1;
		int mid;
		while(first <= last){
			mid = first + (last - first)/2;
			int tmp = matrix[mid/col][mid%col];
			if(tmp == target)
				return true;
			else if(target > tmp)
				first = mid + 1;
			else last = mid - 1;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Search2DMatrix sd = new Search2DMatrix();
		int[][] matrix = {
				{1,   3,  5,  7},
				{10, 11, 16, 20},
				{23, 30, 34, 50},
		};
		int target = 55;
		System.out.println(sd.searchMatrix(matrix, target));
	}
}
