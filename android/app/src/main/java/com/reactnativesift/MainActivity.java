package com.reactnativesift;

import android.os.Bundle;

import com.facebook.react.ReactActivity;

import siftscience.android.Sift;


public class MainActivity extends ReactActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_hello_sift);

    }
    @Override
    protected void onPause() {
        super.onPause();
        Sift.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
        Sift.resume(this);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Sift.close();
    }

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "reactNativeSift";
    }
}
