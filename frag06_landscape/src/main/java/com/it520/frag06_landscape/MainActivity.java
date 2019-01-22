package com.it520.frag06_landscape;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity implements OnFragmentOneClickListener{

    private FragmentTwo mFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentByTag("two");
    }

    //去通知FragmentTwo,让FragmentTwo去修改文本
    @Override
    public void setFragmentTwoText(String text) {
        //判断是否为横竖屏
        //第一种判断方案:判断mFragmentTwo对象是否为null
        //第二种判断方案:判断宽大一些还是高大一些(比较通用一些)
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int widthPixels = displayMetrics.widthPixels;
        int heightPixels = displayMetrics.heightPixels;
        //宽大于高说明是横屏模式，那么就直接去通知FragmentTwo,让FragmentTwo去修改文本
        if(widthPixels>heightPixels){
            mFragmentTwo.setTv(text);
        }else{//如果是竖屏模式就跳转到TwoActivity去
            //开启Activity页面,去展示一个TextView文本
            Intent intent = new Intent(getApplicationContext(), TwoActivity.class);
            //通过intent传递数据
            intent.putExtra("TEXT",text);
            startActivity(intent);
        }
    }
}
