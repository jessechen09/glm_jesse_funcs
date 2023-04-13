package com.example.glm;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Function23054 {
  public final String m24077b(String str) throws IOException {
    String redirectUrl = str;
    int count = 0;
    while (count < 15) {
        URL url = new URL(redirectUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setInstanceFollowRedirects(false);
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return redirectUrl;
        } else if (responseCode == HttpURLConnection.HTTP_MOVED_TEMP || responseCode == HttpURLConnection.HTTP_MOVED_PERM || responseCode == HttpURLConnection.HTTP_SEE_OTHER) {
            String location = connection.getHeaderField("Location");
            if (location == null) {
                return redirectUrl;
            }
            redirectUrl = location;
        } else {
            return redirectUrl;
        }
        count++;
    }
    return redirectUrl;
}
}