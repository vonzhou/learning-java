package oj.leetcode.array;

/*
 * Given n non-negative integers a1, a2, ..., an, where each represents a 
 * point at coordinate (i, ai). n vertical lines are drawn such that the 
 * two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
 * which together with x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * 
 */
public class ContainerWithMostWater {
	/*
	 * O(n^2) to traverse all the cases , Inefficient
	 *  Time Limit Exceeded
	 */
	public int maxArea1(int[] height) {
		if(height == null || height.length <= 1)
			return 0;
		int max = 0;
		int n = height.length;
		for(int i = 0; i < n-1; i++){
			for(int j = i +1; j < n; j++){
				int area = Math.min(height[i] ,height[j]) * (j-i);
				if(area > max)
					max = area;
			}
		}
		
		return max;
	}
	
	/*
	 * Two pointer - O(N)
	 * how to prove its rightness ???
	 * 如果 h[left] < h[right] 此时的面积是 h[left] * (right - left), 所以左移右指针是不会超过该值
	 * 这样可以减少考察的容器数量
	 */
	public int maxArea(int[] height) {
		if(height == null || height.length <= 1)
			return 0;
		int max = 0;
		int left = 0 , right = height.length -1;
		while(left < right){
			int area = Math.min(height[left] ,height[right]) * (right-left);
			if(area > max)
				max = area;
			if(height[left] < height[right])
				left ++;
			else
				right --;
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		int h[] = {1,3,2};
		System.out.println(new ContainerWithMostWater().maxArea(h));
 	}
}
