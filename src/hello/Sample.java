package hello;

public class Sample {
	private static int a=1;
	static   {a=2;}
	static   {a=4;}
	public static void main(String[] args) {
		System.out.println("a="+a);//Ö´ÐÐ½á¹ûa=4
	}
}
