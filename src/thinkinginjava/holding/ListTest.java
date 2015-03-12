package thinkinginjava.holding;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			list.add(i);
		List<Integer> sub = list.subList(1, 7);
		System.out.println(sub);
		sub.set(0, 100); // 对sub list 所做的修改会反映到原始列表中
		System.out.println(list);
		
	}
}
