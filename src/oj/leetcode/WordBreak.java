package oj.leetcode;

import java.util.Set;


/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into 
 * a space-separated sequence of one or more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * 
 */
public class WordBreak {
	
	/*
	 * author : acmachine
	 */
    public boolean wordBreak(String s, Set<String> dict) {
        boolean [] breakable = new boolean[s.length()+1];
        breakable[0] = true;

        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++){
                if(breakable[j] && dict.contains(s.substring(j,i))){
                    breakable[i] = true;
                    break;
                }
            }
        }
        return breakable[s.length()];
    }
}
