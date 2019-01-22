package com.it520.frag03_transaction;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View view) {
        LogFragment logFragment = new LogFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        //add 可以重复叠加
        beginTransaction.add(R.id.fl,logFragment,"LOG");
        beginTransaction.commit();
    }


    public void replace(View view) {
        LogFragment logFragment = new LogFragment();
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        //replace 可以重复操作
        beginTransaction.replace(R.id.fl,logFragment,"LOG");
        beginTransaction.commit();
    }


    public void detach(View view) {
        //必须找那些建立了关系的Fragment来分手
        Fragment log = getSupportFragmentManager().findFragmentByTag("LOG");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        //detach方法只是将Fragment的内部View给干掉,分手分的不彻底,藕断丝连,还可以通过attach来恢复View
        beginTransaction.detach(log);
        beginTransaction.commit();
    }


    public void attach(View view) {
        //找那些建立了关系的Fragment来复合关系
        Fragment log = getSupportFragmentManager().findFragmentByTag("LOG");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.attach(log);
        beginTransaction.commit();
    }


    public void remove(View view) {
        //将一个Fragment从Activity删除，注意必须找那些建立了关系的Fragment来删除
        Fragment log = getSupportFragmentManager().findFragmentByTag("LOG");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        //remove 不可重复操作，一旦删除了再次remove则会报错误
        beginTransaction.remove(log);
        beginTransaction.commit();
    }


    public void show(View view) {
        //显示一个Fragment，找那些建立了关系的Fragment来显示
        Fragment log = getSupportFragmentManager().findFragmentByTag("LOG");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.show(log);
        beginTransaction.commit();
    }

    public void hide(View view) {
        //找那些建立了关系的Fragment来隐藏
        Fragment log = getSupportFragmentManager().findFragmentByTag("LOG");
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.hide(log);
        beginTransaction.commit();
    }

    public void delay(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //里面的代码被延时执行,如果应用退出到后台系统会自动保存Fragment的状态数据，此时提交会报错误
                //解决方法是不要调用commit而是使用commitAllowingStateLoss
                LogFragment logFragment = new LogFragment();
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.add(R.id.fl,logFragment,"LOG");
                beginTransaction.commitAllowingStateLoss();
            }
        },5000);
    }
}
