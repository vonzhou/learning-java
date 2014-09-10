package io.characterStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest {
	public static void main(String[] args) throws Exception, IOException {
		ObjectOutputStream oos=new ObjectOutputStream(
				new FileOutputStream("person.txt"));
		Student p=new Student(21,"vonzhou",170.20);
		oos.writeObject(p);
		oos.close();
		
		ObjectInputStream ois=new ObjectInputStream(
				new FileInputStream("person.txt"));
		
		Student s=(Student)ois.readObject();
		System.out.println(s.age);
	}

}
class Student implements Serializable{
	int age;
	transient String name;
	double height;
	public Student(int age, String name, double height) {
		this.age = age;
		this.name = name;
		this.height = height;
	}
	
}
