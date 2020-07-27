package com.cvs.devicecontroller.adatper;

import android.view.View;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.csv.devicecontroller.R;
import com.csv.devicecontroller.databinding.DeviceListItemBinding;


import com.cvs.devicecontroller.model.Device;

import java.util.List;

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.DeviceViewHolder> {

    private List<Device> listDevices;
    private DeviceListItemBinding deviceListItemBinding;

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        deviceListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.device_list_item, parent, false);
        return new DeviceListAdapter.DeviceViewHolder(deviceListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
        Device device = listDevices.get(position);

        holder.mDeveloperListItemBinding.setDevicemodel(device);
    }

    @Override
    public int getItemCount() {
        if (listDevices != null) {
            return listDevices.size();
        } else {
            return 0;
        }
    }

    public void setDeviceList(List<Device> listDevices) {
        this.listDevices = listDevices;
    }

    public static class DeviceViewHolder extends RecyclerView.ViewHolder {
        private DeviceListItemBinding mDeveloperListItemBinding;

        public DeviceViewHolder(DeviceListItemBinding deviceListItemBinding) {
            super(deviceListItemBinding.getRoot());
            mDeveloperListItemBinding = deviceListItemBinding;
        }
    }
}
