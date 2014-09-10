package io.characterStream;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest {
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf=new RandomAccessFile("random.txt","rw");
		Person p=new Person(1,"vonzhou",175.23);
		p.write(raf);
		
		raf.seek(0);//重新定位到文件的开头，否则出现EOFException
		Person p2=new Person();
		p2.read(raf);
		System.out.println(p2.getId());
		System.out.println(p2.getName());
		System.out.println(p2.getHeight());
		
		
		
	}

}

class Person{
	int id;
	String name;
	double height;
	public Person(){}
	
	public Person(int id, String name, double height) {
		this.id = id;
		this.name = name;
		this.height = height;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public void write(RandomAccessFile raf) throws IOException{
		raf.writeInt(this.id);
		raf.writeUTF(name);
		raf.writeDouble(height);
	}
	public void read(RandomAccessFile raf) throws Exception{
		this.id=raf.readInt();
		this.name=raf.readUTF();
		this.height=raf.readDouble();
	}
	
	
}
