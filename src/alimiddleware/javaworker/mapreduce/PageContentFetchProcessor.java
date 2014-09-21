package com.alibaba.taobao.worker.mapreduce;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import com.alibaba.taobao.worker.TaskProcessor;
import com.alibaba.taobao.worker.WorkerTask;

public class PageContentFetchProcessor implements TaskProcessor {
    private static final int MAX_PAGE_SIZE = 1024 * 1024 * 10;

    private static final int BUFFER_SIZE = 128 * 1024;

    @Override
    public void process(WorkerTask<?> task) {
        if (!(task instanceof MapReducePageURLMiningTask))
            throw new IllegalArgumentException("Excepted PageURLMiningTask but was: " + task.getClass().getSimpleName());

        MapReducePageURLMiningTask mapReduceURLMiningTask = (MapReducePageURLMiningTask) task;

        try {
            URL url = new URL(mapReduceURLMiningTask.getTargetURL());

            URLConnection urlConnection = url.openConnection();
            urlConnection.setConnectTimeout((int) TimeUnit.SECONDS.toMillis(2));
            urlConnection.setReadTimeout((int) TimeUnit.SECONDS.toMillis(2));

            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream), BUFFER_SIZE);

            StringBuilder pageContent = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                pageContent.append(line);

                if (line.length() > MAX_PAGE_SIZE || pageContent.length() > MAX_PAGE_SIZE) {
                    break;
                }
            }

            mapReduceURLMiningTask.setPageContent(pageContent.toString());
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
