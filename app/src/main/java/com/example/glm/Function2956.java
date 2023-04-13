package com.example.glm;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Function2956 {
  public static final void downloadFile(@NotNull String fileURL, @NotNull File directory) {
    try {
        URL url = new URL(fileURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestMethod("GET");
        httpConn.connect();

        if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
            InputStream inputStream = httpConn.getInputStream();
            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            FileOutputStream outputStream = new FileOutputStream(directory.getAbsolutePath() + File.separator + url.getFile().substring(url.getFile().lastIndexOf('/') + 1));

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.close();
            inputStream.close();
        } else {
            throw new IOException("Server returned HTTP response code: " + httpConn.getResponseCode() + " - " + httpConn.getResponseMessage());
        }

        httpConn.disconnect();

    } catch (MalformedURLException e) {
        System.err.println("The specified URL is malformed: " + fileURL);
        e.printStackTrace();
    } catch (IOException e) {
        System.err.println("An I/O error has occurred while downloading the file from " + fileURL);
        e.printStackTrace();
    }
}
}