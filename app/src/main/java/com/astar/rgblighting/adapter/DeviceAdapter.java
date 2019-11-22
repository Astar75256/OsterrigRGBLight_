package com.astar.rgblighting.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.astar.rgblighting.R;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.scan.ScanResult;

import java.util.ArrayList;
import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder> {

    private List<ScanResult> data = new ArrayList<>();

    public void clearList() {
        if (!data.isEmpty()) data.clear();
    }

    public void addDevice(ScanResult scanResult) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getBleDevice().equals(scanResult.getBleDevice())) {
                data.set(i, scanResult);
                notifyItemChanged(i);
                return;
            }
        }
        String nameDevice = scanResult.getBleDevice().getName();
        if ((nameDevice != null && nameDevice.startsWith("Osterrig BLE "))) {
            data.add(scanResult);
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
        RxBleDevice bleDevice = data.get(position).getBleDevice();
        String nameDevice = (bleDevice.getName() == null || bleDevice.getName().isEmpty()) ? "-unnamed-" : bleDevice.getName();
        holder.nameDevice.setText(nameDevice);
        holder.addressDevice.setText(bleDevice.getMacAddress());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class DeviceViewHolder extends RecyclerView.ViewHolder {

        TextView nameDevice;
        TextView addressDevice;
        ImageView iconConnect;

        DeviceViewHolder(@NonNull View itemView) {
            super(itemView);

            nameDevice = itemView.findViewById(R.id.nameDevice);
            addressDevice = itemView.findViewById(R.id.addressDevice);
            iconConnect = itemView.findViewById(R.id.iconConnect);
        }
    }
}
