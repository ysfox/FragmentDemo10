package com.it520.frag04_backstack;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int mIndex = 0;
    public void add(View view) {
        LogFragment logFragment = new LogFragment();
        Bundle bundle = new Bundle();
        mIndex++;
        bundle.putString(LogFragment.FRAG_KEY,"这是第"+mIndex+"个Fragment");
        logFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        //将Fragment添加到返回栈中
        fragmentTransaction.addToBackStack(String.valueOf(mIndex));
        fragmentTransaction.add(R.id.fl,logFragment,"LOG");
        fragmentTransaction.commit();
    }

    //Activity中监听后退键执行的方法，之所以点击后退键可以退出应用是因为调用了super.onBackPressed();
    @Override
    public void onBackPressed() {
        //也可以指定一个Fragment的tag，这样点击返回按钮的时候会直接回退到该tag的Fragment
        //FragmentManager.POP_BACK_STACK_INCLUSIVE 表示回退包含指定tag的Fragment，这里如果弹出包含tag为1的Fragment则会直接回到Activity界面
        if(getSupportFragmentManager().popBackStackImmediate("1",FragmentManager.POP_BACK_STACK_INCLUSIVE)){
            return;
        }
        finish();
    }
}
