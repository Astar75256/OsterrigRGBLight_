package com.astar.rgblighting.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.astar.rgblighting.screen.device_list.fragments.GroupListFragment;
import com.astar.rgblighting.screen.device_list.fragments.ScanListFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private Fragment[] fragments;

    public ViewPagerAdapter(@NonNull FragmentManager fm, Fragment[] fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        Fragment fragment = fragments[position];
        CharSequence title = "";
        if (fragment instanceof GroupListFragment) {
            title = ((GroupListFragment) fragment).getTitle();
        }
        if (fragment instanceof ScanListFragment) {
            title = ((ScanListFragment) fragment).getTitle();
        }
        return title;
    }
}
