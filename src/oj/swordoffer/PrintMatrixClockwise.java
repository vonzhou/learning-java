package oj.swordoffer;

public class PrintMatrixClockwise {
	public void printMatrix(int[][] matrix, int col, int row){
		if(matrix == null || col <= 0 || row <= 0)
			return;
		int start = 0;
		while(col > start * 2 && row > start * 2){
			printMatrixCircle(matrix, col, row, start);
			start ++;
		}
	}

	public void printMatrixCircle(int[][] matrix, int col, int row, int start) {
		// ×îÄÚÈ¦¾ØÕóÊÇ (start, start) (endX, endY)
		int endX = col - 1 -  start;
		int endY = row -  1 -  start;
		
		for(int i=start; i<= endX; i++){
			int num = matrix[start][i];
			printNumber(num);
		}
		if(start < endY){
			for(int i=start + 1; i<=endY; i++){
				int num = matrix[i][endX];
				printNumber(num);
				
			}
		}
		if(start < endX && start < endY){
			for(int i=endX-1; i>=start; i--){
				int num = matrix[endY][i];
				printNumber(num);
			}
		}
		
		if(start < endX && start < endY-1){
			for(int i=endY-1; i>start; i--){
				int num = matrix[i][start];
				printNumber(num);
			}
		}
	}

	public void printNumber(int num) {
		System.out.print(num + " ");
	}
	
	
	public static void test1(){
		int[][] matrix = {
				{1,2,3,4,},
				{5,6,7,8,},
				{9,10,11,12,},
				{13,14,15,16},
		};
		new PrintMatrixClockwise().printMatrix(matrix, 4, 4);
	}
	
	public static void test2(){
		int[][] matrix = {
				{1,2,3},
				{5,6,7,},
				{9,10,11,},
		};
		new PrintMatrixClockwise().printMatrix(matrix, 3, 3);
	}
	
	public static void test3(){
		int[][] matrix = {
				{1,2,3},
				{5,6,7,},
				{9,10,11,},
				{12,13,14,},
		};
		new PrintMatrixClockwise().printMatrix(matrix, 3, 4);
	}
	
	public static void main(String[] args) {
		test3();
	}

}
