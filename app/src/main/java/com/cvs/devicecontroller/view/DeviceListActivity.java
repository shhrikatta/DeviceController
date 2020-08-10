package com.cvs.devicecontroller.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.csv.devicecontroller.R;
import com.csv.devicecontroller.databinding.ActivityDevicelistBinding;
import com.cvs.devicecontroller.adatper.DeviceListAdapter;
import com.cvs.devicecontroller.viewmodel.DeviceListViewModel;
import com.cvs.devicecontroller.model.Device;

public final class DeviceListActivity extends AppCompatActivity {
    private ActivityDevicelistBinding activityDeviceListBinding;
    private DeviceListViewModel DeviceListViewModel;
    private DeviceListAdapter deviceListAdapter;

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityDeviceListBinding = (ActivityDevicelistBinding)DataBindingUtil.setContentView((Activity)this, R.layout.activity_devicelist);

        activityDeviceListBinding.idDeviceRecyclerView.setLayoutManager((LayoutManager)(new LinearLayoutManager((Context)this)));
        activityDeviceListBinding.idDeviceRecyclerView.setHasFixedSize(true);

        DeviceListViewModel = (DeviceListViewModel)ViewModelProviders.of(this).get(DeviceListViewModel.class);
        activityDeviceListBinding.setLifecycleOwner(this);
        activityDeviceListBinding.setViewmodel(DeviceListViewModel);

        deviceListAdapter = new DeviceListAdapter(this);
        activityDeviceListBinding.idDeviceRecyclerView.setAdapter(deviceListAdapter);

        activityDeviceListBinding.loadBar.setVisibility(View.VISIBLE);
        getAllDevices();

/*
        DeviceListViewModel.showFindDeviceDialog().observe(this, new Observer<Device>() {
            @Override
            public void onChanged(Device device) {
                Toast.makeText(DeviceListActivity.this, "id - " + device.getDeviceName(), Toast.LENGTH_SHORT).show();
                showDialog(device);
            }
        });

*/
    }

    void showDialog(Device device) {
        // Create the fragment and show it as a dialog.
        DialogFragment newFragment = DeviceLocatorDialgFragment.newInstance();
        newFragment.show(getSupportFragmentManager(), "Find Device");
    }

    private void getAllDevices() {
        DeviceListViewModel.getAllDeviceList().observe(this, listDevices -> {
            deviceListAdapter.setDeviceList(listDevices);
            activityDeviceListBinding.loadBar.setVisibility(View.GONE);
        });
    }
}
