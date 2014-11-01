package thinkinginjava.generics;
import java.util.*;

public class GenericVarargs {
  public static <T> List<T> makeList(T... args) {
    List<T> result = new ArrayList<T>();
    for(T item : args)
      result.add(item);
    return result;
  }
  public static void main(String[] args) {
    List<String> ls = makeList("A");
    System.out.println(ls);
    
    ls = makeList("A", "B", "C");
    System.out.println(ls);
    
    ls = makeList("ABCDEFFHIJKLMNOPQRSTUVWXYZ".split(""));
    System.out.println(ls);
    
    System.out.println("====================");
    System.out.println(Arrays.asList("abcdef".split("")));
  }
}
