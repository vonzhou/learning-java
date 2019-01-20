package framework.guava;

import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

import java.util.Iterator;

/**
 * @author vonzhou
 * @date 2019/1/20
 */
public class MultisetDemo {
    public static String[] words = {"hello", "alpha", "vonzhou", "chownvon", "chownvon"};

    /**
     * use guava multiset
     */
    public static void wordsSort2() {
        Multiset<String> set = TreeMultiset.create();
        for (int i = 0; i < words.length; i++) {
            set.add(words[i]);
        }

        System.out.println(set);

        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void main(String[] args) {
        wordsSort2();
    }
}
