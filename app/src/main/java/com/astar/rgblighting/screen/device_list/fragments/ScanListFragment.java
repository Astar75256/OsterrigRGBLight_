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

public class ScanListFragment extends Fragment {

    public static final String TAG = ScanListFragment.class.getSimpleName();

    private DeviceListActivity activity;

    public ScanListFragment() {
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
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_device_list, container, false);
        return view;
    }


    public CharSequence getTitle() {
        return "Сканирование";
    }

}
