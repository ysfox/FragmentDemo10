package com.it520.fragmentdemo10;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author 小码哥Android
 * @time 2017/9/10  9:15
 * @desc ${TODD}
 */
public class TestFragment extends Fragment {

    private String mString;


    public static final String FRAG_KEY = "STR";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mString = getClass().getSimpleName();

        Bundle bundle = getArguments();
        if(bundle!=null){
            mString = bundle.getString(FRAG_KEY);
        }
        TextView textView = new TextView(getActivity());
        textView.setText(mString);
        textView.setTextSize(30);
        return textView;
    }
}
