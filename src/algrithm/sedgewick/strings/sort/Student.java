package algrithm.sedgewick.strings.sort;

public class Student {
	private String name;
	private int grp; 
	public Student(String name, int grp){
		this.name = name;
		this.grp = grp;
	}
	
	public int key(){
		return this.grp;
	}
	public String getName(){
		return this.name;
	}

}
