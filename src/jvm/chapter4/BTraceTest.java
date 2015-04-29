package jvm.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BTraceTest {
	public int add(int a,int b){
		return a+b;
	}
	
	public static void main(String[] args) throws IOException {
		BTraceTest test = new BTraceTest();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<10; i++){
			br.readLine();
			int a = (int)Math.round(Math.random() * 1000);
			int b = (int)Math.round(Math.random() * 1000);
			System.out.println(test.add(a, b));
		}
	}

}
