package effectivejava.chapter3.item08;

import java.sql.Timestamp;

public class TimestampTest {
	
	public static void main(String[] args) {
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
	}

}
