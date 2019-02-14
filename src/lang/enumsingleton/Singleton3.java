package lang.enumsingleton;

/**
 * @author vonzhou
 * @date 2019/2/14
 */
public class Singleton3 {
    private static Singleton3 INSTANCE = null;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (INSTANCE == null) {
            synchronized (Singleton3.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Singleton3();
                }
            }
        }
        return INSTANCE;
    }
}
