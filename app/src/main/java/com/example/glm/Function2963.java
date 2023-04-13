package com.example.glm;

import android.app.ActionBar;
import android.view.View;
import android.widget.Toolbar;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeOnSubscribe;

public class Function2963 {
  private final Maybe<InputStream> asyncWork(final String str) {
    return Maybe.create(new MaybeOnSubscribe<InputStream>() {
        @Override
        public void subscribe(MaybeEmitter<InputStream> emitter) throws Exception {
            try {
                URL url = new URL(str);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.setDoInput(true);
                connection.connect();
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    emitter.onSuccess(connection.getInputStream());
                } else {
                    emitter.onComplete();
                }
            } catch (Exception e) {
                emitter.onError(e);
            }
        }
    });
}

/*
* This code is part of a PdfViewActivity class in an Android application. This code implements two methods, asyncWork and initActionBar. The asyncWork method takes in a String parameter and returns a Maybe<InputStream>. It creates a MaybeOnSubscribe, which is an interface from the io.reactivex.MaybeOnSubscribe class. The interface subscribes to a function, which is passed in as a parameter. This function takes in a String and a MaybeEmitter, which is from the io.reactivex.MaybeEmitter class. This function attempts to connect to the URL link passed in and emit an InputStream if the connection is successful. The initActionBar method takes in an ActivityViewPdfBinding parameter and sets up the action bar for the activity. It sets the title to "PDF" and adds a back button, which activates the onBackPressed method when clicked.
*
* @param  ActivityViewPdfBinding binding
*
* @return  void
*/
private void initActionBar(ActivityViewPdfBinding binding) {
    setSupportActionBar(binding.toolbar);
    getSupportActionBar().setTitle("PDF");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    binding.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            onBackPressed();
        }
    });
}

    private void setSupportActionBar(Toolbar toolbar) {
    }

    private void onBackPressed() {
    }

    private ActionBar getSupportActionBar() {
    return null;
    }

    private class ActivityViewPdfBinding {
        public Toolbar toolbar;
    }
}