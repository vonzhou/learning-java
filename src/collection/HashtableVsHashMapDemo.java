package collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap 和 Hashtable 的对比
 */
public class HashtableVsHashMapDemo {
    public static void main(String args[]) {
        Hashtable<String, String> table = new Hashtable<String, String>();
        table.put(null, "vonzhou"); // java.lang.NullPointerException
//        table.put("key", null);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put(null, "vonzou");
        System.out.println(map.get(null));


        ConcurrentHashMap<String, String> c = new ConcurrentHashMap<>();
//        c.put(null, "xxx");//不能
//        c.put("嘻嘻嘻", null);//不能

    }


}
