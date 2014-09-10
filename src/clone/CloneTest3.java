package clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/**
 * 使用序列化实现深拷贝
 * @author vonzhou
 *
 */
public class CloneTest3 {
	public static void main(String[] args) throws Exception {
		Address2 addr=new Address2("shiyan", 442500);
		Customer2 c=new Customer2("vonzhou", addr);
		Customer2 c2=(Customer2)c.deepCopy();
		System.out.println(c2.getName()+c2.getAddress());
		addr=new Address2("wuhan", 430065);
		c.setAddress(addr);
		System.out.println(c.getName()+c.getAddress());
		System.out.println(c2.getName()+c2.getAddress());
	
	}

}

class Customer2 implements Serializable{
	private String name;
	private Address2 address;
	public Customer2(String name, Address2 address) {
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address2 getAddress() {
		return address;
	}
	public void setAddress(Address2 address) {
		this.address = address;
	}
	
	public Object deepCopy() throws Exception{
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		//
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		
		
		oos.writeObject(this);
		
		ObjectInputStream ois=new ObjectInputStream(
				new ByteArrayInputStream(bos.toByteArray()));
		
		return ois.readObject();
		
		
	}
	
	
}

class Address2 implements Serializable{
	private String loc;
	private int code;
	public Address2(String loc, int code) {
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
	@Override
	public String toString() {
		return "  ADDRESS: "+this.loc+"  "+this.code;
	}
	
	
}
