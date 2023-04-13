package com.example.glm;

import android.graphics.drawable.Drawable;

import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.net.URL;

public class Function21384 {
  public RequestBuilder<Drawable> load(URL url) {
    Object context = null;
    Target<Drawable> imageView = null;
    return (RequestBuilder<Drawable>) GlideApp.with(context)
            .load(url)
            .apply(new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .placeholder(R.drawable.placeholder_image))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageView);
}

  private static class GlideApp {
    public static Function21384 with(Object context) {
      return null;
    }

  }
}