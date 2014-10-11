package recruitment.qunaer;


/*
 * 给定一个字符串，找出其中首先出现两次的那个字符
 * 
 * 1. 最原始的方法就是遍历，而后记录每个字符出现的次数
 * 2. 对于每个字符，在其后找看是否存在另一个
 * 3......
 */
public class CharTwice {
	
	public static char firstTwice(String s){
		char c = ' ';
		for(int i = 0; i < s.length() - 1; i++){
			char cur = s.charAt(i);
			int next = s.indexOf(cur, i+1);
			
			if(next != -1 && next < s.length())
				return cur;
		}
		return c;
	}
	
	
	public static void main(String[] args) {
		
		String s = "qywyer23tdd";
		System.out.println(firstTwice(s));
	}

}












