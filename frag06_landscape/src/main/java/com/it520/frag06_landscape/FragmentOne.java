package com.it520.frag06_landscape;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;

/**
 * @author 小码哥Android
 * @time 2017/9/10  15:41
 * @desc ${TODD}
 */
public class FragmentOne extends Fragment {

    private ListView mLv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_one, container, false);
        mLv = (ListView) view.findViewById(R.id.lv);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strings.add(String.valueOf(i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, strings);

        mLv.setAdapter(arrayAdapter);

        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //点击了item,就通知Activity
                FragmentActivity activity = getActivity();
                String text = strings.get(position);
                ((OnFragmentOneClickListener)activity).setFragmentTwoText(text);
            }
        });
    }
}
