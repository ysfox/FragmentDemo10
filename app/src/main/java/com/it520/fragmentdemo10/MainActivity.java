package com.it520.fragmentdemo10;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static com.it520.fragmentdemo10.TestFragment.FRAG_KEY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestFragment testFragment = new TestFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //第三个参数表示的是这个fragment的tag
        //只要设置了这个tag之后就可以通过FragmentManager.findFragmentByTag(tag)找到这个fragment
        fragmentTransaction.replace(R.id.fl,testFragment,"TEST");
        fragmentTransaction.commit();

    }

    //注意在Fragment已经激活状态下再传递参数会报错误：Fragment already activite
    public void click(View view) {
        //把Fragment添加到容器中
        String text = "今天礼拜天天气挺好";
        Bundle bundle = new Bundle();
        bundle.putString(FRAG_KEY,text);
        Fragment testFragment = getSupportFragmentManager().findFragmentByTag("TEST");
        if(testFragment!=null){
            testFragment.setArguments(bundle);
        }
    }
}
