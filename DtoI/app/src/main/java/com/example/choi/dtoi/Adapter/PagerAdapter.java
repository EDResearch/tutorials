package com.example.choi.dtoi.Adapter;

import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.choi.dtoi.Fragment.FragmentOne;
import com.example.choi.dtoi.Fragment.FragmentTwo;

/**
 * Created by choi on 2017. 7. 22..
 */

public class PagerAdapter extends FragmentStatePagerAdapter {
    int tabCount;
    public PagerAdapter(android.support.v4.app.FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }
    public PagerAdapter(android.support.v4.app.FragmentManager fm) {
        super(fm);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentOne();
            case 1:
                return new FragmentTwo();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
