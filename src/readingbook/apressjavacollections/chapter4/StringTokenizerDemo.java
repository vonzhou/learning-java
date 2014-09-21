package readingbook.apressjavacollections.chapter4;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
	public static void main(String[] args) {
		StringTokenizer st = new StringTokenizer("  vonzhou  , inhao .");
		while(st.hasMoreElements()){
			// 而nextElement方法返回的是Object类型
			System.out.println(st.nextElement());
		}
		
		System.out.println("=============================");
		st = new StringTokenizer("  vonzhou  , inhao .");
		while(st.hasMoreTokens()){
			// 和上面的区别是nextToken方法返回的是 String类型
			System.out.println(st.nextToken());
		}
	}

}
