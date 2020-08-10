package com.cvs.devicecontroller.view;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.cvs.devicecontroller.model.Device;

import com.csv.devicecontroller.R;

public class DeviceLocatorDialgFragment extends DialogFragment {

    private Device device;
    private String title;

    public DeviceLocatorDialgFragment(Device device, String title) {
        this.device = device;
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("dialog", "onCreateView");

        View v = inflater.inflate(R.layout.dialog_device_locator, container, false);

        TextView tvTitle = v.findViewById(R.id.tvTitle);
        TextView tvLastUserTitle = v.findViewById(R.id.tvLastUser);
        TextView tvCurrentStatus = v.findViewById(R.id.tvCurrentStatus);

        tvTitle.setText(title);
        tvLastUserTitle.setText(getString(R.string.device_id, device.getDeviceName()));
        tvCurrentStatus.setText(getString(R.string.dialog_connection_status, device.isConnected() ? "Connected" : "Disconnected"));

        Button btnClose = v.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(view -> {
            dismiss();
        });

        Button btnFindDevice = v.findViewById(R.id.btnFindDevice);
        btnFindDevice.setOnClickListener(view -> {
            Toast.makeText(getContext(), "Find my device btn clicked", Toast.LENGTH_SHORT).show();
        });

        return v;
    }
}
