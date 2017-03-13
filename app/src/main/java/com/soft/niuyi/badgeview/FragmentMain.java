package com.soft.niuyi.badgeview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * 作者：${牛毅}
 * 时间：2017/03/13 17：08
 * 邮箱：niuyi19900923@gmail.com
 * 描述：
 */
public class FragmentMain extends Fragment {

    private TextView textview;

    public static FragmentMain newInstance(String pager) {
        Bundle args = new Bundle();
        args.putString("pager", pager);
        FragmentMain fragment = new FragmentMain();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_main, null);
        textview = (TextView) view.findViewById(R.id.textview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle arguments = getArguments();
        String pager = arguments.getString("pager");
        textview.setText(pager);
    }
}
