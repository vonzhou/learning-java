package alimiddleware.javaworker;

import java.net.URL;
import java.util.Comparator;

/**
 * Comparator which makes most significant different URLs stay in top of the TreeSet
 */
public class SimpleURLComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        try {
            if(o1.equals(o2))
                return 0;

            URL url_1 = new URL(o1);
            URL url_2 = new URL(o2);

            if (!url_1.getHost().equals(url_2.getHost()))
                return 1;

            String urlPath_1 = url_1.getPath();
            String urlPath_2 = url_2.getPath();

            int shortestURLLength = urlPath_1.length();
            if (urlPath_2.length() < shortestURLLength) {
                shortestURLLength = urlPath_2.length();
            }

            int similarStrSize = 0;
            for (int i = 0; i < shortestURLLength; i++) {
                if (urlPath_1.charAt(i) == urlPath_2.charAt(i)) {
                    similarStrSize++;
                    continue;
                }

                break;
            }

            return similarStrSize * 100 / shortestURLLength > 40 ? -1 : 1;
        } catch (Exception e) {
            // not an URL, no need to comparate
            return 0;
        }
    }
}