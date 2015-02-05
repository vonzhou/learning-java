package oj.swordoffer;


public class BytesTest {
	public static void main(String[] args) {
		String s = "10 20 30";
		byte bs[] = s.getBytes();
		
		byte temp[] = new byte[100];
		for(int i=0; i < temp.length; i++)
			temp[i] = ' ';
		//temp = Arrays.copyOf(bs, bs.length);
		for(int i=0; i < bs.length; i++)
			temp[i] = bs[i];
		for(int i=0; i < temp.length; i++)
			System.out.println(temp[i]);
		System.out.println(temp.length);
	}

}
