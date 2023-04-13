package com.example.glm;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;

import java.net.URL;

public class Function21386<TranscodeType>  extends RequestBuilder<TranscodeType> {
  protected Function21386(@NonNull Glide glide, RequestManager requestManager, Class<TranscodeType> transcodeClass, Context context) {
    super(glide, requestManager, transcodeClass, context);
  }

  public RequestBuilder<TranscodeType> load(URL url) {
    return  super.load(url);
}
}