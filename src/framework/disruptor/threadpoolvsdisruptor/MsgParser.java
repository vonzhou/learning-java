package framework.disruptor.threadpoolvsdisruptor;

/**
 * @author vonzhou
 * @date 2018/11/30
 */
public class MsgParser {
    public static void parse(String s) {
        try {
//            long start = System.currentTimeMillis();
            System.out.println(s);
            for (int i = 0; i < 10000; i++) {

            }
//            System.out.println(System.currentTimeMillis()-start);
//           Thread.sleep(Config.MSG_PROC_TIME);
        } catch (Exception e) {
        }
    }
}
