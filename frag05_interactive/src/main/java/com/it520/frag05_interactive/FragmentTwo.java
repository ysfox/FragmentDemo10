package com.it520.frag05_interactive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author 小码哥Android
 * @time 2017/9/10  11:30
 * @desc ${TODD}
 */
public class FragmentTwo extends Fragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.frag_two, container, false);
        mTextView = (TextView) inflate.findViewById(R.id.tv);
        if(savedInstanceState!=null){
            String text = savedInstanceState.getString("TEXT");
            mTextView.setText(text);
        }
        return inflate;
    }


    public void setTV(String text){
        if(TextUtils.isEmpty(text)){
            return;
        }
        mTextView.setText(text);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String trim = mTextView.getText().toString().trim();
        if(TextUtils.isEmpty(trim)){
            return;
        }
        outState.putString("TEXT",trim);
    }
}
