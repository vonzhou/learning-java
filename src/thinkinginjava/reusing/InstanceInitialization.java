package thinkinginjava.reusing;
//P 127
class AAAAA{
	int i;
	public AAAAA(){
		System.out.println("A constructor .....");
	}
	{
		i = 12;
		System.out.println("block ...");
	}
}



public class InstanceInitialization {
	public static void main(String[] args) {
		AAAAA a = new AAAAA();
	}
	
}
