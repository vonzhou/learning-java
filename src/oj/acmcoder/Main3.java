package oj.acmcoder;


import java.util.Scanner;
import java.util.Stack;

public class Main3 {
	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		
		for(int i=0; i<T; i++){
			String str = s.nextLine();
			
			int res = lenOf(str);
			
			System.out.println(res);
		}
	}

	private static int lenOf(String str) {
		if(str==null || str.length() <= 0)
			return 0;
		
		char[] cc = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int count = 0;
		for(int i=0; i<cc.length; i++){
			if(cc[i] >= '1' && cc[i]<= '9'){
				if(!stack.isEmpty() && stack.peek() != ')'){
					char c = stack.peek();
					for(int k = 0; k< (cc[i] - '0') - 1; k++)
						stack.push(c);
						
				}else{// )
					String sub = "";
					stack.pop();
					while(!stack.isEmpty() && stack.peek() != '('){
						char c = stack.pop();
						sub = c + sub;
					}
					stack.pop();
					
					// 
					for(int k = 0; k < (cc[i] - '0'); k++){
						for(int j=0;j<sub.length();j++)
							stack.push(sub.charAt(j));
					}
					
				}
			}else{ // not number
				stack.push(cc[i]);
			}
		}
		
		return stack.size() + count;
	}


}
