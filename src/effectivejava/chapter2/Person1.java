// Creates lots of unnecessary duplicate objects - page 20-21
package effectivejava.chapter2;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class Person1 {
	private final Date birthDate;

	public Person1(Date birthDate) {
		// Defensive copy - see Item 39
		this.birthDate = new Date(birthDate.getTime());
	}

	// Other fields, methods omitted

	// DON'T DO THIS!
	public boolean isBabyBoomer() {
		// Unnecessary allocation of expensive object
		Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		gmtCal.set(1946, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomStart = gmtCal.getTime();
		gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
		Date boomEnd = gmtCal.getTime();
		return birthDate.compareTo(boomStart) >= 0
				&& birthDate.compareTo(boomEnd) < 0;
	}

	public static void main(String[] args) {
		Person1 p = new Person1(new Date());
		System.out.println(p.isBabyBoomer());

	}

}
