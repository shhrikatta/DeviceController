package com.cvs.devicecontroller.viewmodel;

import android.util.Log;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cvs.devicecontroller.model.Device;
import com.cvs.devicecontroller.repository.DeviceListRepository;

import java.util.List;

public class DeviceListViewModel extends ViewModel implements LifecycleObserver {
    private MutableLiveData<Device> mutableLiveDataDevice;

    public MutableLiveData<List<Device>> getAllDeviceList() {
        return new DeviceListRepository().getMutableLiveData();
    }

    public void onItemClick(Device device)  {
        if (mutableLiveDataDevice == null)  mutableLiveDataDevice = new MutableLiveData<Device>();
            mutableLiveDataDevice.postValue(device);
            //        mutableLiveDataDevice.setValue(device);
//        showFindDeviceDialog().setValue(device);
    }

    public LiveData<Device> showFindDeviceDialog() {
        return mutableLiveDataDevice;
    }

}