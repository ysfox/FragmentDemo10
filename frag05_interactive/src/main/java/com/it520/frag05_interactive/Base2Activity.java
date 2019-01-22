package com.it520.frag05_interactive;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author 小码哥Android
 * @time 2017/9/10  14:35
 * @desc ${TODD}
 */
//做另一个Activity的父类,继承它的这些子类将隐藏标题栏
public abstract class Base2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        //接下来的setContentView这些方法自己就不去实现,交给子类去写
        //setContentView如何交给子类去写
        onChildCreate();
    }

    //onChildCreate交给子类去实现,子类可以在这个方法中去做setContentView的相关代码逻辑
    public abstract void onChildCreate();
}
