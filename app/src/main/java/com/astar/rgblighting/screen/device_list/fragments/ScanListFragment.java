package com.astar.rgblighting.screen.device_list.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.astar.rgblighting.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScanListFragment extends Fragment {


    public ScanListFragment() {
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
