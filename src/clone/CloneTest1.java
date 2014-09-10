package clone;

public class CloneTest1 {
	public static void main(String[] args) throws Exception {
		Person p=new Person();
		p.setAge(21);
		p.setName("vonzhou");
		Person p2=(Person)p.clone();
		System.out.println(p2.getName()+" : "+p2.getAge());
		p2.setName("fengzhou");//浅拷贝，name指向了新的String对象
		p2.setAge(10);
		System.out.println("==========================");
		System.out.println(p.getName()+" : "+p.getAge());
		System.out.println(p2.getName()+" : "+p2.getAge());
		
	}

}

class Person implements Cloneable{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
