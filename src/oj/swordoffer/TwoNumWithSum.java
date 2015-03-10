package oj.swordoffer;

public class TwoNumWithSum {
	
	
	
	/*
	 * 1.my thought:利用哈希表  遍历然后判断(s-a[i])是否存在
	 * 时间O(n)空间  O(n)
	 */
	
	/*
	 * 2.Use Two pointers 
	 * 时间O(n)
	 */
	public static int[] findTwoNum(int[] data, int len, int sum){
		if(data == null || len < 1)
			return null;
		int p1 = 0, p2 = len-1;
		int[] res = new int[2];
		while(p1 < p2){
			int cur = data[p1] + data[p2];
			if(cur == sum){
				res[0] = data[p1];
				res[1] = data[p2];
				return res;
			}else if(cur > sum)
				p2--;
			else p1++;
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,4,7,11,15};
		int[] res = findTwoNum(a, a.length,15);
		System.out.println(res[0] + ", " + res[1]);
	}

}
