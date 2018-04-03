package com.edwindeleon.org.androidagenda.adapters;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Fernando on 02/11/2017.
 */

public class PageAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;

    public PageAdapter(android.support.v4.app.FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
