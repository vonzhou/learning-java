package framework.disruptor.threadpoolvsdisruptor.threadpool;


import framework.disruptor.threadpoolvsdisruptor.Config;
import framework.disruptor.threadpoolvsdisruptor.MsgGenerator;

/**
 * @author vonzhou
 * @date 2018/11/30
 */
public class Main {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        MsgExecutor msgExecutor = new MsgExecutor();
        for (int i = 0; i < Config.MSG_COUNT; i++) {
            msgExecutor.process(MsgGenerator.get(i));
        }

        while (!Config.stopped){
        }

        System.out.println(String.format("使用线程池处理%s条消息耗时%s ms", Config.MSG_COUNT, (System.currentTimeMillis() - start) ));
        System.exit(0);
    }
}
