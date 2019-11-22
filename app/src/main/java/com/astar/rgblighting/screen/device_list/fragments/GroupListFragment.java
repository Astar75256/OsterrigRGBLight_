package com.astar.rgblighting.screen.device_list.fragments;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.astar.rgblighting.R;
import com.astar.rgblighting.screen.device_list.DeviceListActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupListFragment extends Fragment {

    private static final String TAG = GroupListFragment.class.getSimpleName();
    private DeviceListActivity activity;

    public GroupListFragment() {
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        DeviceListActivity tmp = null;
        if (context instanceof DeviceListActivity) {
            tmp = (DeviceListActivity) context;
            Log.d(TAG, "onAttach: Это объект класса");
        }
        activity = tmp;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_group_list, container, false);
    }

    public CharSequence getTitle() {
        return "Группы";
    }
}
