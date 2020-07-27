package com.cvs.devicecontroller.repository;

import androidx.lifecycle.MutableLiveData;
import com.cvs.devicecontroller.model.Device;
import java.util.ArrayList;
import java.util.List;

public class DeviceListRepository {
    private final List<Device> _listDevice = new ArrayList<>();
    private final MutableLiveData<List<Device>> listDevice = new MutableLiveData<>();

    public final MutableLiveData<List<Device>> getMutableLiveData() {
        this._listDevice.add(new Device("Device 1", true));
        this._listDevice.add(new Device("Device 2", false));

        this.listDevice.postValue(this._listDevice);

        return this.listDevice;
    }
}