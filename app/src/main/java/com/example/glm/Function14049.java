package com.example.glm;

import java.net.MalformedURLException;
import java.net.URL;

public class Function14049 {
  private String getTitleFromUrl(String str) {
  try {
    URL url = new URL(str);
    String host = url.getHost();
    if (host == null || host.isEmpty()) {
      if (str.startsWith("file:")) {
        String file = url.getFile();
        return file.substring(file.lastIndexOf('/') + 1);
      }
    } else {
      return host;
    }
  } catch (MalformedURLException e) {
    // do nothing and fall through to return the original string
  }
  return str;
}
}