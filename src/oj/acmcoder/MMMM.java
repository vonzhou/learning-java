package oj.acmcoder;

import java.util.Scanner;
import java.util.Stack;

public class MMMM {
	public static int lenOf(String str)	{
	    Stack<Integer> s = new Stack<Integer>();
	    s.push(0);
	    
	    for ( int i=0 ;  i<str.length(); i++) {
	    	char c = str.charAt(i);
	        if (c>= 'A' && c <= 'Z') {
	            if (s.size() >= 2) {
	                int val1 = s.pop();
	                int val2 = s.pop();
	                int val = val1 + val2;
	                s.push(val);
	            }
	            s.push(1);
	        } else if (c == '(') {
	            s.push(0);
	            s.push(0);
	        } else if (c == ')') {
	            if (s.size() >= 2) {
	            	  int val1 = s.pop();
		             int val2 = s.pop();
	                int val = val1 + val2;
	                s.push(val);
	            }
	        } else if (c >= '0' && c <= '9') {
	            int num = c - '0';
	            int j;
	            for (j=i+1;j<str.length() && str.charAt(j) <= '9' && str.charAt(j) >= '0' ; j++)
	            {
	                num = num * 10 + str.charAt(j) - '0';
	            }
	            int val = s.pop();
	            val = val * num;
	            s.push(val);
	            i = j -1 ;
	        } else {
	            continue;
	        }
	    }
	    int ret = 0;
	    while (s.size() > 0) {
	        int val = s.pop();
	        ret += val;
	    }
	    return ret;
	}
	public static int countLength(String s) {
		if (s == null || s.isEmpty())
			return 0;
		int counter = 0;
		Stack<Integer> stk = new Stack<Integer>();
		int length = s.length();
		
		for (int i = 0; i < length; ++i) {
			
			if (s.charAt(i) == '(') {	
				stk.push(0);
			}
			else if (s.charAt(i) == ')') {
				int counter1 = 0;
				int num = 0;
				int num1 = 0;
				// 计算括号中结果
				while(!stk.empty() && (num = stk.peek())!=0)
				{
					stk.pop();
					if(num == 1)//CHAR
						++counter1;
					else{//*
						counter1 = counter1 + num * stk.pop();
					}
				}
				stk.pop();
				stk.push(counter1);
			} else if (s.charAt(i)>= 'a' && s.charAt(i) <= 'z' ||
					s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				stk.push(1);//CHAR
			} else if ('0' <= s.charAt(i) && s.charAt(i) <= '9'){ //NUM
				int num = 0;
				do{
					num = num * 10 + s.charAt(i) - '0';
					++i;
				}while(i<length &&'0' <= s.charAt(i) && s.charAt(i) <= '9');
				stk.push(num);
				--i;
			}
		}
		int num = 0;
		while(!stk.empty() && (num = stk.peek())!=0)
		{
			stk.pop();
			if(num == 1)
				++counter;
			else{
				counter = counter + num * stk.pop();
			}
		}
		return counter;
	}

	public static void main(String[]  args){
		Scanner s = new Scanner(System.in);
		int T = Integer.parseInt(s.nextLine());
		
		for(int i=0; i<T; i++){
			String str = s.nextLine();
			
			int res = countLength(str);
			
			System.out.println(res);
		}
	}

}
