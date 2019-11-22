package com.astar.rgblighting.connection;

import android.content.Context;
import android.os.Handler;
import android.os.Message;

import com.polidea.rxandroidble2.RxBleClient;
import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanResult;
import com.polidea.rxandroidble2.scan.ScanSettings;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;


public class Bluetooth {

    public static final int MSG_DEVICE_FOUND = 101;
    public static final int MSG_SCAN_ERROR = 102;
    private RxBleClient mRxBleClient;
    private Context mContext;

    private Disposable scanDisposable;
    private Handler mHandler;


    public Bluetooth(Context context) {
        mContext = context;
        mRxBleClient = RxBleClient.create(context);
    }

    public void setHandler(Handler handler) {
        mHandler = handler;
    }

    public void scan() {
        scanDisposable = mRxBleClient.scanBleDevices(
                new ScanSettings.Builder()
                        .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
                        .setCallbackType(ScanSettings.CALLBACK_TYPE_ALL_MATCHES)
                        .build(),
                new ScanFilter.Builder()
                        .build())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(this::dispose)
                .subscribe(this::newDevice, this::onScanError);
    }

    public void stopScan() {
        dispose();
    }

    private void newDevice(ScanResult scanResult) {
        if (mHandler != null) {
            Message message = mHandler.obtainMessage();
            message.what = MSG_DEVICE_FOUND;
            message.obj = scanResult;
            message.sendToTarget();
        }
    }

    private void onScanError(Throwable throwable) {
        if (mHandler != null) {
            Message message = mHandler.obtainMessage();
            message.what = MSG_SCAN_ERROR;
            message.obj = throwable;
            message.sendToTarget();
        }
    }

    private void dispose() {
        scanDisposable = null;
    }

    public boolean isScanning() {
        return scanDisposable != null;
    }

    // TODO: 21.11.2019 Создать соединение с устройством
    public void connect(String macAddress) {
        RxBleDevice rxBleDevice = mRxBleClient.getBleDevice(macAddress);
        Disposable subscribe = rxBleDevice.establishConnection(false)
                .subscribe(rxBleConnection -> {

                }, throwable -> {

                });
    }
}
