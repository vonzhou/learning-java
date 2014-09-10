package collection;
import java.util.Collections;
import java.util.TreeSet;
public class TreeSetTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		TreeSet set=new TreeSet();
		Person p1=new Person("vonzhou",100);
		Person p2=new Person("lijie",80);
		Person p3=new Person("zhangsan" ,50);
		set.add(p1);
		set.add(p2);
		set.add(p3);
		System.out.println(set);
		System.out.println(Collections.max(set));
	}
}

@SuppressWarnings("unchecked")
class Person implements Comparable{
	String name;
	int score;
	public Person(String name, int score) {
		this.name = name;
		this.score = score;
	}
	public int compareTo(Object o) {
		
			Person p=(Person)o;
			if(this.score>p.score){
				return 1;
			}
			else if(this.score==p.score){return 0;}
			else{return -1;}
	}
	public String toString() {
		return this.name+":"+this.score;
	}
}
