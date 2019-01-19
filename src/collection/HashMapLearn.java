package collection;

import java.util.HashMap;
import java.util.Map;

/**
 * @version 2017/11/3.
 */
public class HashMapLearn {
    public static void main(String[] args) {
        Map<String, String> m = new HashMap<>();
        m.put("key1", "value1");

        for(int i=1;i<16;i++){
            m.put("key" + i, "value" + i);
        }
    }
}
