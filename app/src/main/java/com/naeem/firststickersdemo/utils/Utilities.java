package com.naeem.firststickersdemo.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class Utilities {
    public static int stringToInt(String val) {
        try {
            if (!TextUtils.isEmpty(val))
                return Integer.valueOf(val);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void getIamgeFromAssets(Context context,ImageView imageView, int identifire, String imageName) {
        try {
            // get input stream
            InputStream ims =context. getAssets().open(identifire+"/"+imageName);
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // set image to ImageView
            imageView.setImageDrawable(d);
            ims.close();
        } catch (IOException ex) {
            return;
        }
    }
}
