package collection;
import java.util.HashSet;
public class HashSetTest2 {
	public static void main(String[] args) {
		HashSet set=new HashSet();
		set.add(new Student("vonzhou"));
		set.add(new Student("vonzhou"));
		System.out.println(set);
	}
}
class Student{
	String name;
	public Student(String name){
		this.name=name;
	}
	public int hashCode() {
		return this.name.hashCode();
	}
	public boolean equals(Object obj) {
		if(obj==this){return true;}
		if(obj!=null && obj instanceof Student){
			Student s=(Student)obj;
			if(this.name==s.name){return true;}
		}
		return false;
	}
	public String toString() {
		return this.name;
	}
}
