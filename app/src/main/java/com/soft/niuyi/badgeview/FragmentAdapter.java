package com.soft.niuyi.badgeview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 作者：${牛毅}
 * 时间：2017/03/13 17：08
 * 邮箱：niuyi19900923@gmail.com
 * 描述：
 */
public class FragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> mList;

    public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> list) {
        super(fm);
        this.mList = list;
    }

    @Override
    public Fragment getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getCount() {
        return mList.size();
    }
}
