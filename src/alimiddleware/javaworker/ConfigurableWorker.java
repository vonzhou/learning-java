package alimiddleware.javaworker;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConfigurableWorker implements Runnable, LifeCycle {
    private BlockingQueue<WorkerTask<?>> taskQueue = new ArrayBlockingQueue<WorkerTask<?>>(5);

    private Thread thread;

    private HashMap<WorkerEvent, CopyOnWriteArrayList<WorkerListener>> listenerMap;

    private TaskProcessor taskProcessor;

    private volatile boolean initiated = false;

    private String workerID;

    public ConfigurableWorker(String workerID) {
        this.workerID = workerID;
    }

    @Override
    public void start() {
        if (!initiated) {
            init();
        }

        thread.start();
    }

    @Override
    public void init() {
        if (initiated)
            return;

        if (taskProcessor == null)
            throw new IllegalStateException("Task Processor must be set first");

        thread = new Thread(this);
        thread.setDaemon(true);

        listenerMap = new HashMap<WorkerEvent, CopyOnWriteArrayList<WorkerListener>>();

        initiated = true;
    }

    @Override
    public void stop() {
        thread.interrupt();
    }

    public void fireEvent(WorkerEvent event, Object... args) {
        CopyOnWriteArrayList<WorkerListener> listeners = listenerMap.get(event);

        if (listeners == null)
            return;

        for (WorkerListener listener : listeners) {
            listener.onEvent(event, args);
        }
    }

    public synchronized void addListener(WorkerListener listener) {
        if (!initiated) {
            init();
        }

        List<WorkerEvent> intrestEvents = listener.intrests();
        for (WorkerEvent event : intrestEvents) {
            CopyOnWriteArrayList<WorkerListener> listeners = listenerMap.get(event);
            if (listeners == null) {
                listeners = new CopyOnWriteArrayList<WorkerListener>();
            }

            listeners.add(listener);
            listenerMap.put(event, listeners);
        }
    }

    public String addTask(WorkerTask<?> task) {
        if (!initiated) {
            init();
        }

        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            thread.interrupt();
        }

        return task.getTaskID();
    }

    @Override
    public void run() {
        try {
            for (;;) {
                WorkerTask<?> task = taskQueue.take();

                taskProcessor.process(task);

                if (task.isDone()) {
                    fireEvent(WorkerEvent.TASK_COMPLETE, task);
                    continue;
                }

                fireEvent(WorkerEvent.TASK_FAILED, task);
            }
        } catch (InterruptedException e) {
            System.out.println("Worker mission canceled, remaining task size: " + taskQueue.size());
            return;
        }
    }

    public TaskProcessor getTaskProcessor() {
        return taskProcessor;
    }

    public void setTaskProcessor(TaskProcessor taskProcessor) {
        this.taskProcessor = taskProcessor;
    }

    public String getWorkerID() {
        return workerID;
    }
}
