package com.soft.niuyi.badgeview;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.soft.niuyi.badgeview.fragment.FragmentCart;
import com.soft.niuyi.badgeview.fragment.FragmentMain;
import com.soft.niuyi.badgeview.fragment.FragmentMine;
import com.soft.niuyi.badgeview.fragment.FragmentType;
import com.soft.niuyi.badgeview.view.BadgeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bv_one)
    BadgeView mBvOne;
    @BindView(R.id.bv_two)
    BadgeView mBvTwo;
    @BindView(R.id.bv_three)
    BadgeView mBvThree;
    @BindView(R.id.bv_four)
    BadgeView mBvFour;

    ArrayList<BadgeView> bvList = new ArrayList<>();

    private FragmentManager mManager;
    private FragmentMain mFragmentMain;
    private FragmentType mFragmentType;
    private FragmentCart mFragmentCart;
    private FragmentMine mFragmentMine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mManager = getSupportFragmentManager();

        bvList.add(mBvOne);
        bvList.add(mBvTwo);
        bvList.add(mBvThree);
        bvList.add(mBvFour);

        //默认选择第一个视图
        setChioceFragment(0);

        mBvOne.addRedCountNumber(5);//未读红点
    }

    @OnClick({R.id.bv_one, R.id.bv_two, R.id.bv_three, R.id.bv_four})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bv_one:
                setChioceFragment(0);
                break;
            case R.id.bv_two:
                setChioceFragment(1);
                break;
            case R.id.bv_three:
                setChioceFragment(2);
                break;
            case R.id.bv_four:
                setChioceFragment(3);
                break;
            default:
                break;
        }
    }

    /**
     * 选择视图界面
     *
     * @param index
     */
    private void setChioceFragment(int index) {
        FragmentTransaction transaction = mManager.beginTransaction();
        //设置默认
        switchBadge(index);
        //隐藏页面
        hideFragment(transaction);
        switch (index) {
            case 0:
                if (mFragmentMain == null) {
                    mFragmentMain = FragmentMain.newInstance();
                    transaction.add(R.id.rl_main, mFragmentMain);
                } else {
                    transaction.show(mFragmentMain);
                }
                break;
            case 1:
                if (mFragmentType == null) {
                    mFragmentType = FragmentType.newInstance();
                    transaction.add(R.id.rl_main, mFragmentType);
                } else {
                    transaction.show(mFragmentType);
                }
                break;
            case 2:
                if (mFragmentCart == null) {
                    mFragmentCart = FragmentCart.newInstance();
                    transaction.add(R.id.rl_main, mFragmentCart);
                } else {
                    transaction.show(mFragmentCart);
                }
                break;
            case 3:
                if (mFragmentMine == null) {
                    mFragmentMine = FragmentMine.newInstance();
                    transaction.add(R.id.rl_main, mFragmentMine);
                } else {
                    transaction.show(mFragmentMine);
                }
                break;
            default:
                break;
        }

        //必须提交
        transaction.commit();
    }

    /**
     * 隐藏所有界面
     *
     * @param transaction
     */
    private void hideFragment(FragmentTransaction transaction) {
        if (mFragmentMain != null) {
            transaction.hide(mFragmentMain);
        }
        if (mFragmentType != null) {
            transaction.hide(mFragmentType);
        }
        if (mFragmentCart != null) {
            transaction.hide(mFragmentCart);
        }
        if (mFragmentMine != null) {
            transaction.hide(mFragmentMine);
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
