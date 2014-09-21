package alimiddleware.javaworker;

import java.util.concurrent.Future;

public abstract class WorkerTask<T> implements Future<T> {
    protected String taskID;

    protected boolean done = false;

    protected int priority;

    public WorkerTask(int priority) {
        taskID = SimpleTaskIDGenerator.genTaskID();
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        this.taskID = taskID;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
