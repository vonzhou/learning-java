package oj.leetcode;

/*
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", 
 * it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * 
 * ����������
 * 1) "0" "1"
 * 2) "01" "1"  
 * 3)Input:	"1.2", "1.10" Output:	1   Expected:	-1
 * 4) "0.1", "0.0.1"
 * 5) "1.9.9.9", "1.10.0.0" 
 */
public class CompareVersionNumbers {

	/*
	 * 0. �ȱȽ����汾�� XXX û�������Ŀ��˼·����
	 */
	public int compareVersionWrong(String version1, String version2) {
		// �Ƿ���Ҫ��֤������Ч�ԣ�

		int k1 = version1.indexOf('.');
		int k2 = version2.indexOf('.');
		String v1a, v2a;
		// System.out.println(k1 + ":" + k2);
		v1a = k1 != -1 ? version1.substring(0, k1) : version1 + "";
		v2a = k2 != -1 ? version2.substring(0, k2) : version2 + "";
		// ������ͷ��0, ���ڴΰ汾�Ų���Ҫ���ִ���
		// System.out.println(v1a + ":" + v2a);
		int res = Integer.parseInt(v1a) - Integer.parseInt(v2a);

		if (res != 0)
			return (res > 0 ? 1 : -1);
		else {
			String v1b, v2b;
			v1b = k1 != -1 ? version1.substring(k1 + 1) : "0";
			v2b = k2 != -1 ? version2.substring(k2 + 1) : "0";
			// System.out.println(v1b + ":" + v2b);
			float res2 = Float.parseFloat(v1b) - Float.parseFloat(v2b);
			// System.out.println(res2);
			// System.out.println();
			if (res2 != 0)
				return (res2 > 0 ? 1 : -1);
			return 0;
		}
	}

	/*
	 * 1. �ָ��ɶ���������飬������룬���ν��бȽ�
	 * �������˼·һ����Accept !!
	 */
	public int compareVersion(String version1, String version2) {
		String[] arr1 = version1.split("\\.");
		String[] arr2 = version2.split("\\.");
		int M = arr1.length > arr2.length ? arr1.length : arr2.length;
		int[] iarr1 = new int[M];
		int[] iarr2 = new int[M];

		for (int i = 0; i < arr1.length; i++)
			iarr1[i] = Integer.parseInt(arr1[i]);
		for (int i = 0; i < arr2.length; i++)
			iarr2[i] = Integer.parseInt(arr2[i]);

		 //show(iarr1);
		// show(iarr2);

		int res = compareIntArr(iarr1, iarr2);
		if(res == 0)
			return 0;
		return res > 0 ? 1:-1;
	}

	public int compareIntArr(int[] a, int[] b){
		int M = a.length;
		int res = 0;
		for(int i = 0; i<M; i++){
			res = a[i] - b[i];
			if(res != 0)
				break;
		}
		return res;
	}
	
	// �õݹ������������ ����������XXX
	public int compareIntArr2(int[] a, int[] b, int from) {
		int res = a[from] - b[from];
		System.out.println(res);
		if (from == a.length - 1)
			return res;

		if (res == 0)
			compareIntArr2(a, b, from + 1);
		
		return res;
	}

	public static void show(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String[] args) {
		CompareVersionNumbers cvn = new CompareVersionNumbers();
		// System.out.println(cvn.compareVersion("2.0", "1.2"));
		// System.out.println(cvn.compareVersion("1.2", "13.37"));
		// System.out.println(cvn.compareVersion("1", "0"));
		// System.out.println(cvn.compareVersion("1", "01"));
		 //System.out.println(cvn.compareVersion("0.1", "0.01"));
		// System.out.println(cvn.compareVersion("1.2", "1.10"));
		//System.out.println(cvn.compareVersion("0.1", "0.0.1"));
		System.out.println(cvn.compareVersion("1.9.9.9", "1.10.0.0" ));
		// System.out.println("0".compareTo("2"));
	}
}
