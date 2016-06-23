package nuvemapp.com.br.exemplomaterialdesignlibfresco.extras;

import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DataUrl {
    private static final Pattern PATTERN = Pattern.compile("__w-((?:-?\\d+)+)__");

    public static String getUrlCustom(String url, int width) {
        Matcher m = PATTERN.matcher(url);
        int bestBucket = 0;
        if (m.find()) {
            String[] found = m.group(1).split("-");
            for (String bucketStr : found) {
                bestBucket = Integer.parseInt(bucketStr);
                if (bestBucket >= width) {
                    // the best bucket is the first immediately
                    // bigger than the requested width
                    break;
                }
            }
            if (bestBucket > 0) {
                url = m.replaceFirst("w"+bestBucket);
            }
            else{
                url = m.replaceFirst("w"+found[ found.length - 1 ]);
            }
        }
        Log.i("LOG", "URL: " + url);
        return url;
    }
}
