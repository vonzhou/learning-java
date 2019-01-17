package jvm.ch06class;

/**
 * P189
 * javac -g:vars xxxxx
 * Created by vonzhou on 2018/2/20.
 */
public class TestLocalVariable {
    public int f(int m) {
        int var = 1000;
        int var2 = var + 1;
        return m + var;
    }

}
