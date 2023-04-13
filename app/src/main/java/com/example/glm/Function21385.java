package com.example.glm;

import android.content.Context;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;

import java.security.Key;

public class Function21385<TranscodeType> extends RequestBuilder<TranscodeType> {
  protected Function21385(@NonNull Glide glide, RequestManager requestManager, Class<TranscodeType> transcodeClass, Context context) {
    super(glide, requestManager, transcodeClass, context);
  }

  public RequestBuilder<TranscodeType> signature(Key key) {
    return  super.signature((com.bumptech.glide.load.Key) key);
}
}