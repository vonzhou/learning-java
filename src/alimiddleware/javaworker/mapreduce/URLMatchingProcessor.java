package com.alibaba.taobao.worker.mapreduce;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alibaba.taobao.worker.TaskProcessor;
import com.alibaba.taobao.worker.WorkerTask;

public class URLMatchingProcessor implements TaskProcessor {
    private static final String URL_PATTERN = "http(s)?://[\\w\\.\\/]*(\\.htm|\\.do|\\.html|\\.xhtm|\\.xhtml)";

    @Override
    public void process(WorkerTask<?> task) {
        if (!(task instanceof MapReducePageURLMiningTask))
            throw new IllegalArgumentException("Excepted PageURLMiningTask but was: " + task.getClass().getSimpleName());

        MapReducePageURLMiningTask mapReduceURLMiningTask = (MapReducePageURLMiningTask) task;

        try {
            Matcher matcher = Pattern.compile(URL_PATTERN).matcher(mapReduceURLMiningTask.getPageContent());
            while (matcher.find()) {
                mapReduceURLMiningTask.addMinedURL(matcher.group());
            }

            mapReduceURLMiningTask.setDone(true);
        } catch (Exception e) {
            System.err.println("Error while fetching specified URL: " + mapReduceURLMiningTask.getTargetURL()
                    + "\nException" + e.toString());
        } finally {
            synchronized (mapReduceURLMiningTask) {
                mapReduceURLMiningTask.notifyAll();
            }
        }
    }
}
