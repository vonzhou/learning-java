package recruitment.qunaer;

<<<<<<< HEAD

/**
 * Returns a string representation of the integer argument as an unsigned integer in base 16. 
 * The unsigned integer value is the argument plus 232 if the argument is negative; 
 * otherwise, it is equal to the argument. This value is converted to a string of 
 * ASCII digits in hexadecimal (base 16) with no extra leading 0s. If the unsigned 
 * magnitude is zero, it is represented by a single zero character '0' ('\u0030'); 
 * otherwise, the first character of the representation of the unsigned magnitude 
 * will not be the zero character. The following characters are used as hexadecimal digits: 
 * 
 * 0123456789abcdef 
 * 
 * @author vonzhou
 *
 */
public class ToHexString {
	
	public static String toHexString(int i)
    {
		    boolean b = false;//是正否为负数
		    if(i==0)return  "0";
		    else if(i<0) {
		        b = true;//是负数
		        i=-i;
		    }
		    char[] hex = "0123456789ABCDEF".toCharArray();
		    String result = "" ; 
		    while(i!=0){
		        result=hex[i%16]+result;
		        i/=16;
		    }
		    if(b) result="-"+result;
		    return result;   
    }
	
	public static void main(String[] args) {
		int a = -100;
		System.out.println(toHexString(a));
		System.out.println(new Test().toHexString(a));
		System.out.println(Integer.toHexString(a));
	}

}
 class Test {
    public static void main(String[] args) {
    System.out.println(toHexString(-100));
    }
    public static String toHexString(int input) {
    boolean b = false;//是正否为负数
    if (input < 0) {
        b = true;
        input = -input;
    }
    String output = "";
    int base = 16;
    int c = 0;
    int lowbit = 0;
    base >>= 1;
    do {
        lowbit = input & 1;
        input = (input >> 1) & 0xffffffff;
        c = ((input % base) << 1) + lowbit;
        if (c < 10)
        c += '0';
        else
        c += 'A';
        output += (char) c;
    } while ((input /= base) != 0);
 
    StringBuffer sb = new StringBuffer(output);
 
    output = sb.reverse().toString();
    if (b)
        output = "-" + output;
    return output;
    }
}












=======
public class ToHexString {
	public static String toHexString(int i) {
		return toUnsignedString0(i, 4);
	}

	private static String toUnsignedString0(int val, int shift) {
		// assert shift > 0 && shift <=5 : "Illegal shift value";
		int mag = Integer.SIZE - Integer.numberOfLeadingZeros(val);
		int chars = Math.max(((mag + (shift - 1)) / shift), 1);
		char[] buf = new char[chars];

		formatUnsignedInt(val, shift, buf, 0, chars);

		// Use special constructor which takes over "buf".
		return new String(buf);
	}

	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
			'9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l',
			'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y',
			'z' };

	// 补码二进制表示开头有多个0
	public static int numberOfLeadingZeros(int i) {
		if (i == 0)
			return 32;
		int n = 1;
		if (i >>> 16 == 0) {
			n += 16;
			i <<= 16;
		}
		if (i >>> 24 == 0) {
			n += 8;
			i <<= 8;
		}
		if (i >>> 28 == 0) {
			n += 4;
			i <<= 4;
		}
		if (i >>> 30 == 0) {
			n += 2;
			i <<= 2;
		}
		n -= i >>> 31;
		return n;
	}

	static int formatUnsignedInt(int val, int shift, char[] buf, int offset,
			int len) {
		int charPos = len;
		int radix = 1 << shift;
		int mask = radix - 1;
		do {
			buf[offset + --charPos] = digits[val & mask];
			val >>>= shift;
		} while (val != 0 && charPos > 0);

		return charPos;
	}

	public static void main(String[] args) {
		int x = 0x1234;
		System.out.println(numberOfLeadingZeros(x));
		System.out.println(Integer.toHexString(x));
	}

}
>>>>>>> 916a1e51514f47765b01f0f00337142509b4079c
