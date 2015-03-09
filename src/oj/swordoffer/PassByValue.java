package oj.swordoffer;

import java.util.Arrays;

class Dog{
	String name;
	public Dog(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
}
public class PassByValue {
	public static void main( String[] args ){
	    Dog aDog = new Dog("Max");
	    foo(aDog);
	    if( aDog.getName().equals("Max") ){ //true
	        System.out.println( "Java passes by value." );
	    }else if( aDog.getName().equals("Fifi") ){
	        System.out.println( "Java passes by reference." );
	    }
	    
	    // 对于数组 同样如此 
	    char[] s1 = "We are students".toCharArray();
	    System.out.println(s1);
		func(s1);
		System.out.println(s1);
	}
	/*
	 * 传给foo方法的是引用的值 自动变量d的生命周期就是在方法内
	 * 可以重新指向一个新的对象 但不会改变之前的对象状态
	 */
	public static void foo(Dog d) {
	  d.getName().equals("Max"); // true
	  d = new Dog("Fifi");
	  d.getName().equals("Fifi"); // true
	}
	
	public static void func(char[] a){
		a = "hello".toCharArray();
		System.out.print("in func : ");
		System.out.println(a);
	}
}
