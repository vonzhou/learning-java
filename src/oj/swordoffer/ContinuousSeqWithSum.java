package oj.swordoffer;

public class ContinuousSeqWithSum {
	
	public void findSeqWithSum(int sum){
		if(sum <= 2)
			return;
		int p1 = 1;
		int p2 = 2;
		int mid = (1+sum)/2;
		int cur = p1+p2;
		while(p1<mid){
			if(cur == sum)
				printSeq(p1,p2);
			// 在这里进行回滚 说明上一步加的p2太大了
			while(cur > sum && p1 <mid){
				cur -= p1;
				p1++;
				if(cur == sum)
					printSeq(p1,p2);
			}
			p2++;
			cur += p2;
		}
		
	}
	
	public void printSeq(int from, int to){
		for(int i=from;i<=to;i++)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String[] args) {
		ContinuousSeqWithSum test = new ContinuousSeqWithSum();
		test.findSeqWithSum(15);
	}
	

}
