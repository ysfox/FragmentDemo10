package com.it520.frag05_interactive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TwoActivity extends Base2Activity implements OnFragmentOneClickLsitener{

    private FragmentTwo mFragmentTwo;

   /* @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }*/

    @Override
    public void onChildCreate() {
        setContentView(R.layout.activity_two);
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
