package recruitment.qunaer;

public class BinarySearch {
	
	// a is sorted
	public static int bisearch(int a[], int key){
		if(a == null || a.length == 0)
			return -1;
		return bis(a, key);
	}
	
	public static int bis(int a[], int key){
		int left = 0, right = a.length - 1, middle = -1;
		while(left <= right){
			middle = (left + right)/2;
			if(a[middle] > key)
				right = middle -1;
			else if(a[middle] < key)
				left = middle + 1;
			else return middle;
		}
		
		return middle;
	}
	
	public static void main(String[] args) {
		int a[] = {1,3,4,6,8,9,11,};
		System.out.println(bisearch(a, 4));
	}
	
	

}
