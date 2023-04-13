package com.example.glm;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;

import java.net.URL;

public class Function2967<TranscodeType> extends RequestBuilder<TranscodeType> {
  protected Function2967(@NonNull Glide glide, RequestManager requestManager, Class<TranscodeType> transcodeClass, Context context) {
    super(glide, requestManager, transcodeClass, context);
  }

  public RequestBuilder<TranscodeType> mo17449load(@Nullable URL url) {
    return super.load(url);
}
}