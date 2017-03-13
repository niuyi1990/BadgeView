package com.soft.niuyi.badgeview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.bv_one)
    BadgeView mBvOne;
    @BindView(R.id.bv_two)
    BadgeView mBvTwo;
    @BindView(R.id.bv_three)
    BadgeView mBvThree;
    @BindView(R.id.bv_four)
    BadgeView mBvFour;

    ArrayList<BadgeView> bvList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ArrayList<Fragment> list = new ArrayList<>();

        FragmentMain one = FragmentMain.newInstance("主页");
        FragmentMain two = FragmentMain.newInstance("分类");
        FragmentMain three = FragmentMain.newInstance("购物车");
        FragmentMain four = FragmentMain.newInstance("我的");

        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);

        bvList.add(mBvOne);
        bvList.add(mBvTwo);
        bvList.add(mBvThree);
        bvList.add(mBvFour);

        mViewpager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), list));

        mViewpager.setCurrentItem(0);
        mViewpager.setOffscreenPageLimit(4);
        mBvOne.setSelected(true);

        mBvOne.addRedCountNumber(5);//未读红点

//        mBtnAdd = (Button) findViewById(R.id.btn_add);/
//        mBtnClear = (Button) findViewById(R.id.btn_clear);
//        mBtnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mBvOne.addRedCountNumber(5);
//            }
//        });
//        mBtnClear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mBvOne.setRedCount(0);
//            }
//        });
    }

    @OnClick({R.id.bv_one, R.id.bv_two, R.id.bv_three, R.id.bv_four})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bv_one:
                mViewpager.setCurrentItem(0);
                switchBadge(0);
                break;
            case R.id.bv_two:
                mViewpager.setCurrentItem(1);
                switchBadge(1);
                break;
            case R.id.bv_three:
                mViewpager.setCurrentItem(2);
                switchBadge(2);
                break;
            case R.id.bv_four:
                mViewpager.setCurrentItem(3);
                switchBadge(3);
                break;
            default:
                break;
        }
    }

    /**
     * 设置Badge被选中状态
     *
     * @param position
     */
    private void switchBadge(int position) {
        for (int i = 0; i < bvList.size(); i++) {
            bvList.get(i).setSelected(position == i);
        }
    }
}
