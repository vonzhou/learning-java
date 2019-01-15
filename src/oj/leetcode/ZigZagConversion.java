package oj.leetcode;


/*
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number
 *  of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * �ҹ��ɵ���Ŀ 
 */
public class ZigZagConversion {
	public String convert(String s, int nRows) {
		if(s == null || s.equals(""))
			return "";
		
		if(nRows <= 0)
			return null;
		if(nRows == 1)
			return s;
		
		
		int step = 2*(nRows - 1);
		int limit = s.length();
		int parts = limit / step;
		int remain = limit % step;
		String levels[] = new String[nRows];
		for(int i = 0; i<nRows;i++)
			levels[i] = "";
		
		int i = 0;
		for(i=0; i <limit && parts > 0; i += step,parts--){
			for(int j = 0; j < nRows; j++)
				levels[j] += s.charAt(i+j) + "";
			for(int j = 1; j < nRows-1; j++)
				levels[nRows-j-1] += s.charAt(i+nRows+j-1) + "";
		}
		
		// ����ʣ���Ԫ��
		if(remain <= nRows){
			for(int j = 0; j < remain; j++)
				levels[j] += s.charAt(i++) + "";
		}else{
			for(int j = 0; j < nRows; j++)
				levels[j] += s.charAt(i++) + "";
			int cnt = remain - nRows;
			//System.out.println(cnt);
			for(int j = 1; j <= cnt; j++)
				levels[nRows-j-1] += s.charAt(i++) + "";
		}
		String res = "";
		for(int j = 0; j < nRows; j++)
			{res += levels[j];}
		return res;
	}

	public static void main(String[] args) {
		ZigZagConversion zc = new ZigZagConversion();
		String a = "vonzhou";
		char c = '.';
		//System.out.println(a + c +"");
		System.out.println(zc.convert("ABCDE", 4));
	}
}
