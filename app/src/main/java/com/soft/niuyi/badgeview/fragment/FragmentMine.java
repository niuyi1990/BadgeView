package com.soft.niuyi.badgeview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soft.niuyi.badgeview.R;

/**
 * 作者：${牛毅}
 * 时间：2017/03/13 17：08
 * 邮箱：niuyi19900923@gmail.com
 * 描述：
 */
public class FragmentMine extends Fragment {

    public static FragmentMine newInstance() {
        Bundle args = new Bundle();
        FragmentMine fragment = new FragmentMine();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.fragment_mine, null);
        return view;
    }

}
