package oj.leetcode;

/*
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * Update (2014-11-02):
 * The signature of the function had been updated to return the index instead of the pointer.
 *  If you still see your function signature returns a char * or String,
 *   please click the reload button  to reset your code definition.
 */
public class ImplementStrStr {
	//�ɲݶѣ���
	//1. ��ֱ�ӵķ�ʽ��Ҫע����Ǳ߽������Ĵ��� �� "",""����ʱ0��������-1 
	public  int strStr1(String haystack, String needle) {
		if(haystack == null || needle == null)
			return -1;
		
		
		int len = haystack.length(), sublen = needle.length();
		if(sublen > len)
			return -1;
		
		// ���ַ�����������
		if(haystack.length() == 0 || needle.length() == 0)
			return 0;
		
		for(int i = 0; i <= len - sublen; i++){
			if(haystack.substring(i, i+sublen).equals(needle))
				return i;
		}
		
		return -1;
	}
	public static void main(String[] args) {
		String s = "";
		System.out.println(s.length());
		//System.out.println(strStr("vonabcdevonz", "vonz"));
	}
}
