package classloader;

public class Dog {
	public Dog(){
		System.out.println("Dog is loaded :"+this.getClass().getClassLoader());
	}

}
