package algrithm.sedgewick.strings.sort;

/**
 * 键索引计数法
 */
public class KeyIndexedCountSort {
	public static void sort(Student[] a) {

		int N = a.length;
		Student[] aux = new Student[N];
		int R = 256; // extend ASCII alphabet size

		// compute frequency counts
		int[] count = new int[R + 1];
		for (int i = 0; i < N; i++) 
			count[a[i].key() + 1] ++; 

		// frequency convert to starting index
		for (int r = 0; r < R; r++)
			count[r + 1] += count[r];

		// move data (data grouping)
		for (int i = 0; i < N; i++) 
			aux[count[a[i].key()] ++] = a[i];

		// copy back
		for (int i = 0; i < N; i++)
			a[i] = aux[i];
	}
	
	public static void main(String[] args) {
		Student[] a = {
				new Student("Anderson", 2),
				new Student("Brown", 3),
				new Student("Davis", 3),
				new Student("Harris", 1),
		};
		
		sort(a);
		
		int N = a.length;
		for(int i=0; i < N; i++){
			System.out.println(a[i].getName() + "  " + a[i].key());
		}
	}

}
