import java.util.*;

public class Main2 {
	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int T;
		int[] res;
		String temp;
		
		T = Integer.parseInt(cin.nextLine());
		if (T <= 0 || T > 1000)
			return;
		res = new int[T];
		for (int i = 0; i < T; i++) {
			temp = cin.nextLine();
			temp = toLowercase(temp);
			res[i] = getWeight(temp);
		}

		for (int i = 0; i < T; i++)
			System.out.println(res[i]);
			

	}

	private static int getWeight(String temp) {
		int res = 0;
		char pre = 0;
		int count = 0;
		for (int j = 0; j < temp.length(); j++) {
			char cur = temp.charAt(j);
			if (cur != pre) {
				//System.out.println("!=");
				res += getWeight(pre) * count * count;
				pre = cur;
				count = 1;
			} else {
				//System.out.println("=");
				count++;
			}
		}
		//System.out.println("inner :" + count);
		res += getWeight(pre) * count * count;
		return res;
	}
	private static int getWeight(char x) {
		return x-'a'+1;
	}

	private static String toLowercase(String temp) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < temp.length(); i++)
			sb.append(toLowercase(temp.charAt(i)));
		return sb.toString();
	}

	private static String toLowercase(char temp) {
		if (temp <= 'z' && temp >= 'a')
			return temp + "";
		else if (temp >= 'A' && temp <= 'Z')
			return (char) ('a' + temp - 'A') + "" + (char) ('a' + temp - 'A');
		else
			return "";
	}
}
