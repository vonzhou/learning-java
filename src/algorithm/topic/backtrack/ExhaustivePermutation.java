package algorithm.topic.backtrack;


/*
 * Classic exhaustive permutation pattern
 * 得到所有的全排列
 */
public class ExhaustivePermutation {
	
	/*
	 * 不断递归，通过参数传递当前已经构成的字符串，以及可供的选择
	 */
	public static void RecPermute(String soFar, String rest)
	{
	    if (rest.length()<=0) {
	        System.out.println(soFar);
	    } else {
	        for (int i = 0; i < rest.length(); i++) {
	            String remaining = rest.substring(0, i)
	                             + rest.substring(i+1);
	            RecPermute(soFar + rest.charAt(i), remaining);
	        }
	    }
	}
	
	public static void main(String[] args) {
		RecPermute("", "ABC");
	}
}
