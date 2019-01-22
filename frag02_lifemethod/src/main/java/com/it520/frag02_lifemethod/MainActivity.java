package com.it520.frag02_lifemethod;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.e(getClass().getSimpleName() + "xmg", "onCreate: " + "super 之前");
        super.onCreate(savedInstanceState);
        Log.e(getClass().getSimpleName() + "xmg", "onCreate: " + "super 之后");
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        Log.e(getClass().getSimpleName() + "xmg", "onStart: " + "super 之前");
        super.onStart();
        Log.e(getClass().getSimpleName() + "xmg", "onStart: " + "super 之后");
    }

    @Override
    protected void onResume() {
        Log.e(getClass().getSimpleName() + "xmg", "onResume: " + "super 之前");
        super.onResume();
        Log.e(getClass().getSimpleName() + "xmg", "onResume: " + "super 之后");
    }

    @Override
    protected void onPause() {
        Log.e(getClass().getSimpleName() + "xmg", "onPause: " + "super 之前");
        super.onPause();
        Log.e(getClass().getSimpleName() + "xmg", "onPause: " + "super 之后");
    }

    @Override
    protected void onStop() {
        Log.e(getClass().getSimpleName() + "xmg", "onStop: " + "super 之前");
        super.onStop();
        Log.e(getClass().getSimpleName() + "xmg", "onStop: " + "super 之后");
    }

    @Override
    protected void onRestart() {
        Log.e(getClass().getSimpleName() + "xmg", "onRestart: " + "super 之前");
        super.onRestart();
        Log.e(getClass().getSimpleName() + "xmg", "onRestart: " + "super 之后");
    }

    @Override
    protected void onDestroy() {
        Log.e(getClass().getSimpleName() + "xmg", "onDestroy: " + "super 之前");
        super.onDestroy();
        Log.e(getClass().getSimpleName() + "xmg", "onDestroy: " + "super 之后");
    }
}
