package com.astar.rgblighting.screen.device_list;

import android.content.Context;
import android.os.Handler;

import com.astar.rgblighting.R;
import com.astar.rgblighting.connection.Bluetooth;
import com.polidea.rxandroidble2.scan.ScanResult;

public class DeviceListPresenter {

    private Bluetooth mBluetooth;
    private Handler mHandler;

    private DeviceListView mDeviceListView;

    DeviceListPresenter(Context context) {
        mBluetooth = new Bluetooth(context);
        mHandler = eventHandler();
        mBluetooth.setHandler(mHandler);
    }

    void setDeviceListView(DeviceListView deviceListView) {
        mDeviceListView = deviceListView;
    }

    public Handler getHandler() {
        return mHandler;
    }

    private Handler eventHandler() {
        return new Handler(msg -> {
            switch (msg.what) {
                case Bluetooth.MSG_DEVICE_FOUND:
                    mDeviceListView.addDeviceToAdapter((ScanResult) msg.obj);
                    break;
                case Bluetooth.MSG_SCAN_ERROR:
                    mDeviceListView.showError(((Throwable) msg.obj).getMessage());
                    break;
            }
            return true;
        });
    }

    void scanDevice(boolean isScan) {
        if (isScan) mBluetooth.scan(); else mBluetooth.stopScan();
        int resImage = (mBluetooth.isScanning()) ? R.drawable.ic_stop_search : R.drawable.ic_search;
        mDeviceListView.updateFabButton(resImage);
    }

    public boolean isBLEScanning() {
        return mBluetooth.isScanning();
    }
}
