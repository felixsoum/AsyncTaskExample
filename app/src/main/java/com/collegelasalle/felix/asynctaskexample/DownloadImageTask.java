package com.collegelasalle.felix.asynctaskexample;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    Activity activity;

    public DownloadImageTask(Activity host) {
        activity = host;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap result = null;
        try {
            result = BitmapFactory.decodeStream(new URL(strings[0]).openStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    protected void onPostExecute(Bitmap result) {
        ImageView imageView = activity.findViewById(R.id.imageView);
        imageView.setImageBitmap(result);
    }
}
