package com.it520.frag07_change;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn01 = (Button) findViewById(R.id.btn01);
        //通过代码去触发第一个按钮的点击事件
        btn01.performClick();
    }


    //思路:点击时,让两个Fragment都去隐藏hide,
    // 然后点击第一个按钮,就show第一个Fragment
    // 然后点击第二个按钮,就show第二个Fragment
    public void click01(View view) {
        //如果是第一次点击,先add或者replace,将Fragment放入到容器中进行显示
        //不是第一次点击,按照先前的show和hide逻辑来走
        //先隐藏一下,能隐藏就隐藏
        FragmentTwo fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentByTag("two");
        if(fragmentTwo!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.hide(fragmentTwo);
            fragmentTransaction.commit();
        }
        FragmentOne fragmentOne = (FragmentOne) getSupportFragmentManager().findFragmentByTag("one");
        if(fragmentOne==null){
            fragmentOne = new FragmentOne();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fl,fragmentOne,"one");
            fragmentTransaction.commit();
        }else{
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.show(fragmentOne);
            fragmentTransaction.commit();
        }
    }

    public void click02(View view) {

        FragmentTwo fragmentTwo = (FragmentTwo) getSupportFragmentManager().findFragmentByTag("two");
        FragmentOne fragmentOne = (FragmentOne) getSupportFragmentManager().findFragmentByTag("one");

        //如果fragmentOne不为null,将其隐藏
        if(fragmentOne!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.hide(fragmentOne);
            fragmentTransaction.commit();
        }

        //如果fragmentTwo为null,说明是第一次点击
        if(fragmentTwo==null){
            //第一次点击,将fragmentTwo添加容器进行显示,设置好TAG
            fragmentTwo = new FragmentTwo();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.fl,fragmentTwo,"two");
            fragmentTransaction.commit();
        }else{
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.show(fragmentTwo);
            fragmentTransaction.commit();
        }
    }
}
