package com.it520.frag05_interactive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author 小码哥Android
 * @time 2017/9/10  11:30
 * @desc ${TODD}
 */
public class FragmentOne extends Fragment {

    private int mIndex = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            mIndex = savedInstanceState.getInt("index");
        }
        View inflate = inflater.inflate(R.layout.frag_one, container, false);
        Button btn = (Button) inflate.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndex++;
                String str = "这是第"+mIndex+"次点击";
                //要调用FragmentTwo当中的setTV方法
                //1 通知Activity中间人,去修改文本
                FragmentActivity activity = getActivity();
                //不能去强制的依赖的某个Activity,会违背设计的初衷
                //(我们需要让Fragment能够灵活在很多页面都能使用)
                ((OnFragmentOneClickLsitener)activity).setFragmentTwoTV(str);
            }
        });
        return inflate;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index",mIndex);
    }
}
