package alimiddleware.javaworker;

public interface TaskProcessor {
    void process(WorkerTask<?> task);
}
