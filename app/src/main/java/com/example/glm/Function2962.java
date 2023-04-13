package com.example.glm;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Function2962 {
  public InputStream doInBackground(String... strArr) {
    try {
        URL url = new URL(strArr[0]);
        HttpURLConnection connection = (HttpURLConnection) FirebasePerfUrlConnection.instrument(url.openConnection());
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return new BufferedInputStream(connection.getInputStream());
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}
}