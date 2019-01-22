package com.it520.frag07_change;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author 小码哥Android
 * @time 2017/9/10  16:19
 * @desc ${TODD}
 */
public class FragmentTwo extends LogFragment {
    
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_two, container, false);
        return view;
    }
}
