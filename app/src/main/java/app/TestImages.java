package app;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

/**
 public class TestImages extends Activity {
 /** Called when the activity is first created. */

public class TestImages extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Bitmap bMap = BitmapFactory.decodeFile("/sdcard/test2.png");


    }
}