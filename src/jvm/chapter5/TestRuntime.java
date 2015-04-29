package jvm.chapter5;
//P138
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Executes the specified string command in a separate process.
public class TestRuntime {
	public static void main(String[] args) throws Exception {
		Thread.sleep(5000);
		
		
		Runtime r = Runtime.getRuntime();
		Process p = r.exec("man ls");
		System.out.println(p.isAlive());
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String res ;
		while((res = br.readLine()) != null){
			System.out.println(res);
		}
		//p.destroy();
		System.out.println(p.isAlive());
		
	}
}
