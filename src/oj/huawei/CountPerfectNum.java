package oj.huawei;
import java.util.Scanner;

public class CountPerfectNum {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int low = scan.nextInt();
		int high = scan.nextInt();
//		System.out.println(low);
//		System.out.println(high);
		int res = 0;
		if(low <= high && high <= 10000 && low>0){
			res = countPerfect(low, high);
		}
		
		System.out.println(res);
	}

	public static int countPerfect(int low, int high) {
		int count = 0;
		for(int i=low; i<=high; i++){
			if(i%2 == 0 && i%3==0 && i%5==0)
				count++;
		}
		return count;
	}

}
