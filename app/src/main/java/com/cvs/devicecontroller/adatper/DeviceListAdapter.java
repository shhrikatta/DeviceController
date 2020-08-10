package com.cvs.devicecontroller.adatper;

import android.app.Activity;
import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;


import com.csv.devicecontroller.R;
import com.csv.devicecontroller.databinding.DeviceListItemBinding;


import com.cvs.devicecontroller.model.Device;
import com.cvs.devicecontroller.view.DeviceListActivity;
import com.cvs.devicecontroller.view.DeviceLocatorDialgFragment;
import com.cvs.devicecontroller.viewmodel.DeviceListViewModel;

import java.util.List;

public class DeviceListAdapter extends RecyclerView.Adapter<DeviceListAdapter.DeviceViewHolder> {

    private List<Device> listDevices;
    private DeviceListItemBinding deviceListItemBinding;
    private Context context;

    public DeviceListAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        deviceListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.device_list_item, parent, false);
        deviceListItemBinding.setDeviceviewmodel(new DeviceListViewModel());

        return new DeviceListAdapter.DeviceViewHolder(deviceListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
        Device device = listDevices.get(position);

        holder.mDeveloperListItemBinding.setDevicemodel(device);

        holder.mDeveloperListItemBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "getRoot onclick", Toast.LENGTH_SHORT).show();
                showDialog(device);
            }
        });
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

    void showDialog(Device device) {
        // Create the fragment and show it as a dialog.
        DeviceLocatorDialgFragment newFragment = new DeviceLocatorDialgFragment();
        FragmentManager mfFragmentManager = ((AppCompatActivity)context).getSupportFragmentManager();
        newFragment.show(mfFragmentManager, "Find Device");
    }


    public static class DeviceViewHolder extends RecyclerView.ViewHolder {
        private DeviceListItemBinding mDeveloperListItemBinding;

        public DeviceViewHolder(DeviceListItemBinding deviceListItemBinding) {
            super(deviceListItemBinding.getRoot());
            mDeveloperListItemBinding = deviceListItemBinding;
        }
    }
}
