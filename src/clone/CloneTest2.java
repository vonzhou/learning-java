package clone;

public class CloneTest2 {
	public static void main(String[] args) throws Exception {
		Address addr=new Address("shiyan", 442500);
		Customer c=new Customer("vonzhou", addr);
		Customer c2=(Customer)c.clone();
		System.out.println(c2.getName()+c2.getAddress());
		addr=new Address("wuhan", 430065);
		c.setAddress(addr);
		System.out.println(c.getName()+c.getAddress());
		System.out.println(c2.getName()+c2.getAddress());
	}
}

class Customer implements Cloneable{
	private String name;
	private Address address;
	public Customer(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Object clone() throws CloneNotSupportedException {
		Customer c=(Customer)super.clone();
		c.setAddress((Address)address.clone());// µœ÷…ÓøΩ±¥deep clone
		return c;
	}
}

class Address implements Cloneable{
	private String loc;
	private int code;
	public Address(String loc, int code) {
		this.loc = loc;
		this.code = code;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public  Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public String toString() {
		return "  ADDRESS: "+this.loc+"  "+this.code;
	}
}
