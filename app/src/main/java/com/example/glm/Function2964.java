package com.example.glm;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.reactivex.MaybeEmitter;

public class Function2964 {
  
public static final void m18831asyncWork$lambda8(String pdfUrl, MaybeEmitter<InputStream> emitter) {
    try {
        URL url = new URL(pdfUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            emitter.onSuccess(connection.getInputStream());
        } else {
            emitter.onError(new Exception("Invalid response code: " + responseCode));
        }
    } catch (IOException e) {
        emitter.onError(e);
    }
}
}