package algorithm.topic.backtrack;

public class PermutationString {
	
	/* Function to print permutations of string
	   This function takes three parameters:
	   1. String
	   2. Starting index of the string
	   3. Ending index of the string. */
	public static void permute(char[] a, int i, int n) 
	{
	   int j; 
	   if (i == n)
	     System.out.println(String.valueOf(a));
	   else
	   {
	        for (j = i; j <= n; j++)
	       {
	          swap(a, i, j);
	          permute(a, i+1, n);
	          swap(a, i, j); //backtrack
	       }
	   }
	} 
	
	private static void swap(char[] a, int i, int j) {
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

	public static void main(String[] args) {
		char[] a = {'A', 'B', 'C'};
		permute(a, 0, 2);
		
		
		/*
		StringBuilder sb = new StringBuilder("vonzhou");
		sb.deleteCharAt(0);
		sb.insert(0, 'A');
		//sb.deleteCharAt(0);
		System.out.println(sb.toString());
		*/
		
		
		
	}

}
