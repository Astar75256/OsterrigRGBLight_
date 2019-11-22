package com.astar.rgblighting.screen.device_list;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.astar.rgblighting.R;
import com.astar.rgblighting.adapter.ViewPagerAdapter;
import com.astar.rgblighting.screen.device_list.fragments.GroupListFragment;
import com.astar.rgblighting.screen.device_list.fragments.ScanListFragment;
import com.google.android.material.tabs.TabLayout;
import com.polidea.rxandroidble2.scan.ScanResult;

public class DeviceListActivity extends AppCompatActivity implements
        DeviceListView,
        View.OnClickListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter pagerAdapter;


    private Fragment[] fragments;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, DeviceListActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        fragments = new Fragment[] {
                new ScanListFragment(),
                new GroupListFragment(),
        };

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);
        setSupportActionBar(toolbar);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void addDeviceToAdapter(ScanResult scanResult) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void updateFabButton(int res) {

    }
}