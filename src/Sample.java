

public class Sample {
	public Sample(){
		System.out.println("Sample is loaded :"+this.getClass().getClassLoader());
		
		new Dog();
	}

}
