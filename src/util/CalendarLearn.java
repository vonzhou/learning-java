package util;

import java.util.Calendar;
import java.util.Date;

/**
 * @version 2017/6/28.
 */
public class CalendarLearn {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(new Date());

        cal.add(Calendar.MONTH, 8);
        long mills = cal.getTimeInMillis();
        System.out.println(new Date(mills));

        System.out.println(null instanceof  Object);
    }
}
