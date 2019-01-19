package collection;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by vonzhou on 2019/1/19.
 */
public class ConcurrentHashMapDemo {


    private static final int MAXIMUM_CAPACITY = 1 << 30;

    //  向上得到2的整次幂
    private static final int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    public static void main(String[] args) {
        System.out.println(tableSizeFor(5));
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("city", "hangzhou");
        map.put("name", "zhou");
        System.out.println(map.get("age"));
        map.remove("name");
        System.out.println(map.size());

    }
}
