package oj.swordoffer;


/**
 * 3. 在一个二维数组中，每一行从左至右递增，每一列从上至下递增
 * 判断该数组中是否包含某个整数
 */
public class FindInPartiallySortedMatrix {
	// 从右上角开始缩小查找范围
	static boolean find(int matrix[][], int number){
		if(matrix == null)
			return false;
		int row = matrix.length;
		if(row <= 0)
			return false;
		int col = matrix[0].length;
		if(col <= 0)
			return false;
		
		int irow = 0;
		int icol = col - 1;
		boolean found = false;
		while(irow < row && icol >= 0){
			if(matrix[irow][icol] == number){
				found = true;
				break;
			}
			else if(matrix[irow][icol] > number)
				icol --;
			else irow ++;
		}
		
		return found;
	}
	
	// 从左下角开始
	static boolean find2(int matrix[][], int number){
		if(matrix == null)
			return false;
		int row = matrix.length;
		if(row <= 0)
			return false;
		int col = matrix[0].length;
		if(col <= 0)
			return false;
		
		int irow = row - 1;
		int icol = 0;
		boolean found = false;
		while(irow >= 0 && icol < col){
			if(matrix[irow][icol] == number){
				found = true;
				break;
			}
			else if(matrix[irow][icol] > number)
				irow --;
			else icol ++;
		}
		
		return found;
	}
	
	public static void main(String[] args) {
		int case1[][] = {
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15},
		};
		int case2[][] = null;
		System.out.println(find(case1, 7));
		System.out.println(find(case1, 6));
		System.out.println(find(case2, 7));
		System.out.println(find2(case1, 7));
	}

}
