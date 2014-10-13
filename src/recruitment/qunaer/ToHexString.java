package recruitment.qunaer;


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












