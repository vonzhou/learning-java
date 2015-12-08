package oj.acmcoder;

import java.util.Stack;

public class Main6 {


	int countLength(String s,int length) {
		if (s == "")
			return 0;
		int counter = 0;
		Stack<Integer> stk = new Stack<Integer>();
		length = s.length();
		
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
		//STACK
		int num = 0;
		// 整理栈中剩余数据
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

	
}
