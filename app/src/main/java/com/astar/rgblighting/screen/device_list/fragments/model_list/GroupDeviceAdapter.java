package com.astar.rgblighting.screen.device_list.fragments.model_list;

import android.bluetooth.BluetoothDevice;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.astar.rgblighting.R;
import com.thoughtbot.expandablecheckrecyclerview.CheckableChildRecyclerViewAdapter;
import com.thoughtbot.expandablecheckrecyclerview.models.CheckedExpandableGroup;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.ArrayList;
import java.util.List;


public class GroupDeviceAdapter extends CheckableChildRecyclerViewAdapter<GroupDeviceViewHolder, ListDeviceViewHolder> {

    List<GroupDevice> groupDevices;

    public GroupDeviceAdapter(List<GroupDevice> groups) {
        super(groups);
        groupDevices = groups;
    }

    public void addGroup(GroupDevice groupDevice) {
        groupDevices.add(groupDevice);
        notifyDataSetChanged();
    }

    public void addDeviceToGroup(GroupDevice groupDevice, ArrayList<BluetoothDevice> device) {
        if (groupDevices.contains(groupDevice)) {
            int index = groupDevices.indexOf(groupDevice);
            GroupDevice groupDeviceIndex = groupDevices.get(index);
            groupDeviceIndex.getItems().add(device);
            notifyDataSetChanged();
        }
    }

    @Override
    public ListDeviceViewHolder onCreateCheckChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.device_child_item_layout, parent, false);
        return new ListDeviceViewHolder(view);
    }

    @Override
    public void onBindCheckChildViewHolder(ListDeviceViewHolder holder, int position,
                                           CheckedExpandableGroup group, int childIndex) {
        final BluetoothDevice device = (BluetoothDevice) group.getItems().get(childIndex);
        holder.setNameDevice(device.getName());
        holder.setMacAddressDevice(device.getAddress());
    }

    @Override
    public GroupDeviceViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.device_group_item_layout, parent, false);
        return new GroupDeviceViewHolder(view);
    }

    @Override
    public void onBindGroupViewHolder(GroupDeviceViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setNameGroup(group);
    }
}
