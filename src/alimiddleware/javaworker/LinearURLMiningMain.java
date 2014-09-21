package alimiddleware.javaworker;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

import alimiddleware.javaworker.linear.PageURLMiningProcessor;
import alimiddleware.javaworker.linear.PageURLMiningTask;


/**
 * Linear version of page URL mining. It's slow but simple.
 * Average time cost for 1000 URLs is: 3800ms
 *
 * @author xuanyin.zy E-mail:xuanyin.zy@taobao.com
 * @since Sep 16, 2012 5:35:40 PM
 */
public class LinearURLMiningMain implements WorkerListener {
    private static final String EMPTY_STRING = "";

    private static final int URL_SIZE_TO_MINE = 10000;

    private static ConcurrentHashMap<String, WorkerTask<?>> taskID2TaskMap = new ConcurrentHashMap<String, WorkerTask<?>>();

    private static ConcurrentSkipListSet<String> foundURLs = new ConcurrentSkipListSet<String>(new SimpleURLComparator());

    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        ConfigurableWorker worker = new ConfigurableWorker("W001");
        worker.setTaskProcessor(new PageURLMiningProcessor());

        addTask2Worker(worker, new PageURLMiningTask("http://www.taobao.com"));
        addTask2Worker(worker, new PageURLMiningTask("http://www.xinhuanet.com"));
        addTask2Worker(worker, new PageURLMiningTask("http://www.zol.com.cn"));
        addTask2Worker(worker, new PageURLMiningTask("http://www.163.com"));

        LinearURLMiningMain mainListener = new LinearURLMiningMain();
        worker.addListener(mainListener);

        worker.start();

        String targetURL = EMPTY_STRING;
        while (foundURLs.size() < URL_SIZE_TO_MINE) {
            targetURL = foundURLs.pollFirst();

            if (targetURL == null) {
                TimeUnit.MILLISECONDS.sleep(50);
                continue;
            }

            PageURLMiningTask task = new PageURLMiningTask(targetURL);
            taskID2TaskMap.putIfAbsent(worker.addTask(task), task);

            TimeUnit.MILLISECONDS.sleep(100);
        }

        worker.stop();

        for (String string : foundURLs) {
            System.out.println(string);
        }

        System.out.println("Time Cost: " + (System.currentTimeMillis() - startTime) + "ms");
    }

    private static void addTask2Worker(ConfigurableWorker mapWorker_1, PageURLMiningTask task) {
        String taskID = mapWorker_1.addTask(task);
        taskID2TaskMap.put(taskID, task);
    }

    @Override
    public List<WorkerEvent> intrests() {
        return Arrays.asList(WorkerEvent.TASK_COMPLETE, WorkerEvent.TASK_FAILED);
    }

    @Override
    public void onEvent(WorkerEvent event, Object... args) {
        if (WorkerEvent.TASK_FAILED == event) {
            System.err.println("Error while extracting URLs");
            return;
        }

        if (WorkerEvent.TASK_COMPLETE != event)
            return;

        PageURLMiningTask task = (PageURLMiningTask) args[0];
        if (!taskID2TaskMap.containsKey(task.getTaskID()))
            return;

        foundURLs.addAll(task.getMinedURLs());

        System.out.println("Found URL size: " + foundURLs.size());

        taskID2TaskMap.remove(task.getTaskID());
    }
}
