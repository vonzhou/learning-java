package basics;

/**
 * Created by vonzhou on 2019/1/26.
 */
public class ClassName {
    static class X {

    }


    public static void main(String[] args) {
        Class obj = new X().getClass();
        System.out.println(obj.getName());

    }
}
