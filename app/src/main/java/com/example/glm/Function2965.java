package com.example.glm;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;

import java.net.URL;

public class Function2965 {
  
public RequestBuilder<Drawable> load(@Nullable URL url) {
    Activity context = null;
    return Glide.with(context).load(url).placeholder(R.drawable.placeholder_image).error(R.drawable.error_image);
}
}