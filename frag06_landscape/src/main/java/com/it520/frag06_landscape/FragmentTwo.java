package com.it520.frag06_landscape;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author 小码哥Android
 * @time 2017/9/10  15:41
 * @desc ${TODD}
 */
public class FragmentTwo extends Fragment {

    private TextView mTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_two, container, false);
        mTv = (TextView) view.findViewById(R.id.tv);
        return view;
    }

    public void setTv(String text){
        mTv.setText(text);
    }
}
