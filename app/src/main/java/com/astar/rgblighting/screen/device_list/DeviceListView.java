package com.astar.rgblighting.screen.device_list;

import com.polidea.rxandroidble2.scan.ScanResult;

public interface DeviceListView {
    void addDeviceToAdapter(ScanResult scanResult);
    void showError(String message);
    void updateFabButton(int res);
}
