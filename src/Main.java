import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int group;
		int mountain;
		int[] heights;
		String temp;
		int a, b;
		group = Integer.parseInt(cin.nextLine());
		
		for(int x=0; x < group; x++){
			mountain = Integer.parseInt(cin.nextLine());
			heights = new int[mountain];
			int sum = 0;
			if (mountain > 1) {
				temp = cin.nextLine();
				String[] res = temp.split(" ");
				for (int i = 0; i < res.length; i++)
					heights[i] = Integer.parseInt(res[i]);
				int h = 0;
				
				int i = 0;
				for (i = 0; i < heights.length; i++) {
					sum += Math.abs(heights[i] - h) * 2;
					h = heights[i];
				}
				sum += heights[i - 1] * 2;
			}else if(mountain==1){
				sum = heights[0] * 2;
			}else{
				sum = -1;
			}
			System.out.println(sum);
		}
		
	}
}
