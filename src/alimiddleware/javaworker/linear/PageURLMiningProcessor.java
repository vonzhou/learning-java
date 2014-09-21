package alimiddleware.javaworker.linear;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import alimiddleware.javaworker.TaskProcessor;


/**
 * Given a specified URL, the processor will try to mine all of the URLs out from the page. The URLs
 * are guaranteed to be unique.
 *
 * @author xuanyin.zy E-mail:xuanyin.zy@taobao.com
 * @since Sep 15, 2012 4:19:15 PM
 */
public class PageURLMiningProcessor implements TaskProcessor {
    private static final String URL_PATTERN = "http(s)?://[\\w\\.\\/]*(\\.htm|\\.do|\\.html|\\.xhtm|\\.xhtml)";

    private static final int MAX_PAGE_SIZE = 1024 * 1024 * 10;

    private static final int BUFFER_SIZE = 128 * 1024;

    @Override
    public void process(WorkerTask<?> task) {
        if (!(task instanceof PageURLMiningTask))
            throw new IllegalArgumentException("Excepted PageURLMiningTask but was: " + task.getClass().getSimpleName());

        PageURLMiningTask urlMiningTask = (PageURLMiningTask) task;

        try {
            URL url = new URL(urlMiningTask.getTargetURL());

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

            Matcher matcher = Pattern.compile(URL_PATTERN).matcher(pageContent);
            while (matcher.find()) {
                urlMiningTask.addMinedURL(matcher.group());
            }

            urlMiningTask.setDone(true);
        } catch (Exception e) {
            System.err.println("Error while fetching specified URL: " + urlMiningTask.getTargetURL() + "\nException"
                    + e.toString());
        } finally {
            synchronized (urlMiningTask) {
                urlMiningTask.notifyAll();
            }
        }
    }
}
