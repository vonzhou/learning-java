package oj.huawei;
import java.util.Arrays;
import java.util.Scanner;


public class Spelling2DigitNumbers2 {
	// delete UNIT:  "Shi", "Bai", "Qian", "Wan"
	public static String deleteUnit(String s){
		s = deleteAUnit(s, "Shi");
		s = deleteAUnit(s, "Bai");
		s = deleteAUnit(s, "Qian");
		s = deleteAUnit(s, "Wan");
		return s;
	}
	
	private static String deleteAUnit(String s, String unit) {
		if(s == null || s.length() < 3)
			return s;
		if(s.contains(unit)){
			s = s.replace(unit, " ");
		}
		return s;
	}
	
	public static String spelling2digitWrapper(String s){
		if(s.startsWith("Ling")){
			return "0" + spelling2digit(s.substring(4));
		}
		return spelling2digit(s);
	}

	private static String spelling2digit(String substring) {
		String res = "";
		switch(substring){
		case "Yi":			res = "1";break;
		case "Er":			res = "2";break;
		case "San":			res = "3";break;
		case "Si":			res = "4";break;
		case "Wu":			res = "5";break;
		case "Liu":			res = "6";break;
		case "Qi":			res = "7";break;
		case "Ba":			res = "8";break;
		case "Jiu":			res = "9";break;
		default:res = "";
		}
		return res;
	}

	// parse the input to digit spelling\
	public static String parseInput(String s){
		
		String endPadding = dellWithEndPadding(s);
		
		int resLen = getResLen(s);
		
		String str = deleteUnit(s);
		String ss[] = str.split(" ");
//		System.out.println(Arrays.toString(ss));
		String res = "";
		for(int i=0; i<ss.length;i++){
			res += spelling2digitWrapper(ss[i]);
		}
//		System.out.println(res);
		res += endPadding;
		
		String padding = "";
		if(res.length() < resLen){
			for(int i=0; i<resLen - res.length();i++)
				padding += "0";
//			System.out.println("==-====");
		}
//		System.out.println(res);
		int zero = res.indexOf('0');
		String left = res.substring(0, zero);
		String right = res.substring(zero);
//		System.out.println(left + ":" + right);
		res = left + padding + right;
		
		return res;
	}
	
	private static String dellWithEndPadding(String s) {
		String p = "";
		if(s.endsWith("Shi"))
			p="0";
		else if(s.endsWith("Bai"))
			p="00";
		else if(s.endsWith("Qian"))
			p="000";
		else if(s.endsWith("Wan"))
			p="0000";
		return p;
	}

	private static int getResLen(String s) {
		int r = 1;
		if(s.contains("Wan"))
			r = 5;
		else if(s.contains("Qian"))
			r = 4;
		else if(s.contains("Bai"))
			r = 3;
		else if(s.contains("Shi"))
			r = 2;
		return r;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
//		String dict[] = {"Ling", "Yi", "Er", "San", "Si", "Wu","Liu", "Qi", "Ba", "Jiu", "Shi", "Bai", "Qian", "Wan"};
		System.out.println(parseInput(input));
	}
}
