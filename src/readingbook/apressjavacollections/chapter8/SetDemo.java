package readingbook.apressjavacollections.chapter8;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
	public static void main(String[] args) {
		Set s = new HashSet();
		// 因为这几个的hashcode都一样，所以只有第一个插入成功
		//剩下的返回FALSE（底层发生了替换？？）
		System.out.println(s.add("Hello"));
		System.out.println(s.add("Hello"));
		System.out.println(s.add(new String("Hello")));
	}

}
