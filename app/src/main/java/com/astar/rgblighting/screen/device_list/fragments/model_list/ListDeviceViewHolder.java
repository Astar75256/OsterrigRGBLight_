package com.astar.rgblighting.screen.device_list.fragments.model_list;

import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.TextView;

import com.astar.rgblighting.R;
import com.thoughtbot.expandablecheckrecyclerview.viewholders.CheckableChildViewHolder;

public class ListDeviceViewHolder extends CheckableChildViewHolder {

    private TextView childNameDevice;
    private TextView childMacAddressDevice;
    private CheckBox checkBox;

    public ListDeviceViewHolder (View itemView) {
        super(itemView);

        childNameDevice = itemView.findViewById(R.id.childNameDevice);
        childMacAddressDevice = itemView.findViewById(R.id.childMacAddressDevice);
        checkBox = itemView.findViewById(R.id.checkBox);
    }

    @Override
    public Checkable getCheckable() {
        return checkBox;
    }

    public void setNameDevice(String name) {
        childNameDevice.setText(name);
    }

    public void setMacAddressDevice(String macAddressDevice) {
        childMacAddressDevice.setText(macAddressDevice);
    }

}
