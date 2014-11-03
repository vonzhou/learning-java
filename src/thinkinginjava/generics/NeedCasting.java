package thinkinginjava.generics;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

class AAA{
	
}

public class NeedCasting {
	@SuppressWarnings("unchecked")
	public void f(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				args[0]));
		List<AAA> shapes = (List<AAA>) in.readObject();
	}
} // /:~
