package oj.swordoffer;


/**
 * 4.实现一个函数，把字符串中的每个空格替换为“%20”,输出
 * @author vonzhou
 *
 */
public class ReplaceBlank {
	public static char[] replaceBlank(char old[]){
		if(old == null || old.length == 0)
			return old;
		int len = old.length;
		int blanks = 0;
		for(int i =0; i< len;i++)
			if(old[i] == ' ')
				blanks ++;
		int newlen = len + 2*blanks;
		char res[] = new char[newlen];
		int p1 = len-1, p2 = newlen-1;
		while(p1 >= 0){
			if(old[p1] != ' '){
				res[p2] = old[p1];
				p1 -= 1;
				p2 -= 1;
			}else{
				p1 -= 1;
				p2 -= 3;
				res[p2+1] = '%';
				res[p2+2] = '2';
				res[p2+3] = '0';
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		char case1[] = "von zhou ".toCharArray();
		//System.out.println(case1.length);
		char case2[] = {'h','h'};   // do not need '\0'
		//System.out.println(case2);
		char case3[] = "".toCharArray();
		
		System.out.println(replaceBlank(case1));
		System.out.println(replaceBlank(case3));
	}

}
