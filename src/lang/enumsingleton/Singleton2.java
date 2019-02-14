package lang.enumsingleton;

/**
 * @author vonzhou
 * @date 2019/2/14
 */
public class Singleton2 {
    private static final Singleton2 INSTANCE = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return INSTANCE;
    }
}
