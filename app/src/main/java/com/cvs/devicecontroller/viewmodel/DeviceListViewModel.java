package com.cvs.devicecontroller.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cvs.devicecontroller.model.Device;
import com.cvs.devicecontroller.repository.DeviceListRepository;

import java.util.List;

public class DeviceListViewModel extends ViewModel {

    public MutableLiveData<List<Device>> getAllDeviceList() {
        return new DeviceListRepository().getMutableLiveData();
    }
}