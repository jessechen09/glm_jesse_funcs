package com.example.glm;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import io.reactivex.SingleEmitter;

public class Function2955 {
  
public static final void m19307downloadTextFile$lambda2(String fileUrl, Context context, SingleEmitter<String> emitter) {
    try {
        URL url = new URL(fileUrl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line + "\n");
        }
        reader.close();
        emitter.onSuccess(stringBuilder.toString());
    } catch (MalformedURLException e) {
        emitter.onError(e);
    } catch (Exception e) {
        emitter.onError(e);
    }
}
}