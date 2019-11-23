package com.astar.rgblighting.screen.device_list.fragments.model_list;

import android.bluetooth.BluetoothDevice;

import com.thoughtbot.expandablecheckrecyclerview.models.MultiCheckExpandableGroup;

import java.util.List;

public class GroupDevice extends MultiCheckExpandableGroup {

    public GroupDevice(String title, List<BluetoothDevice> items) {
        super(title, items);
    }
}