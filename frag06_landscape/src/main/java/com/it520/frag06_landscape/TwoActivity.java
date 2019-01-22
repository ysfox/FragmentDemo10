package com.it520.frag06_landscape;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        FragmentTwo two = (FragmentTwo) getSupportFragmentManager().findFragmentByTag("two");
        Intent intent = getIntent();
        if(intent!=null){
            String text = intent.getStringExtra("TEXT");
            two.setTv(text);
        }
    }
}
