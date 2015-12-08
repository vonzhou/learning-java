package mythought.thinking;

public class Inc {
	public static void main(String[] args){
		Inc inc = new Inc();
		int i=0;
		inc.fun(i);
		i = i++;
		
		System.out.println(i); //  1
	}
	
	void fun(int i){
		i++;
	}

}
