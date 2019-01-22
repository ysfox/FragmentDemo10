package com.it520.frag05_interactive;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends BaseActivity {

    private FragmentTwo mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2 让Activity中间人去通知FragmentTwo去修改文本
        mFragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentByTag("two");
    }

    //2 让Activity中间人去通知FragmentTwo去修改文本
    public void setFragmentTwoTV(String str){
        if(mFragmentTwo!=null){
            mFragmentTwo.setTV(str);
        }
    }
}
