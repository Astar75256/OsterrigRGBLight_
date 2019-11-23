package com.astar.rgblighting.screen.device_list.fragments;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.astar.rgblighting.R;
import com.astar.rgblighting.screen.device_list.DeviceListActivity;
import com.astar.rgblighting.screen.device_list.fragments.model_list.GroupDevice;
import com.astar.rgblighting.screen.device_list.fragments.model_list.GroupDeviceAdapter;
import com.astar.rgblighting.screen.dialogs.AddGroupDialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupListFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = GroupListFragment.class.getSimpleName();
    private DeviceListActivity activity;

    private RecyclerView recyclerView;
    private GroupDeviceAdapter groupDeviceAdapter;
    private List<GroupDevice> groupDevices;

    private FloatingActionButton fabAddGroup;


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
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_group_list, container, false);

        configureViews(view);

        return view;
    }

    private void configureViews(View view) {
        groupDevices = new ArrayList<>();

        groupDevices.add(new GroupDevice("Группа 1", getDevices()));

        groupDeviceAdapter = new GroupDeviceAdapter(groupDevices);
        recyclerView = view.findViewById(R.id.recyclerGroupDeviceList);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(groupDeviceAdapter);

        fabAddGroup = view.findViewById(R.id.fabAddGroup);
        fabAddGroup.setOnClickListener(this);

    }

    ArrayList<BluetoothDevice> getDevices() {
        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        return new ArrayList<BluetoothDevice>(adapter.getBondedDevices());
    }

    public CharSequence getTitle() {
        return "Группы";
    }

    @Override
    public void onClick(View v) {
        if (v.equals(fabAddGroup)) {
            addGroup();
        }
    }

    private void addGroup() {
        AddGroupDialog addGroupDialog = new AddGroupDialog();
        addGroupDialog.setOnClickActionButton(new AddGroupDialog.OnClickActionButton() {
            @Override
            public void onClickSave(String text) {
                GroupDevice groupDevice = new GroupDevice(text, new ArrayList<>());
                groupDeviceAdapter.addGroup(groupDevice);
                groupDeviceAdapter.addDeviceToGroup(groupDevice, getDevices());
            }

            @Override
            public void onClickCancel() {
                addGroupDialog.dismiss();
            }
        });
        addGroupDialog.show(activity.getSupportFragmentManager(), "ADD_GROUP_DIALOG");
    }
}
