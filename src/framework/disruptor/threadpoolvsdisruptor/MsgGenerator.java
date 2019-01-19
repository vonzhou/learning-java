package framework.disruptor.threadpoolvsdisruptor;

/**
 * @author vonzhou
 * @date 2018/11/30
 */
public class MsgGenerator {
    static String prefix = "message";

    public static String get(int i) {
        return prefix + i;
    }
}
