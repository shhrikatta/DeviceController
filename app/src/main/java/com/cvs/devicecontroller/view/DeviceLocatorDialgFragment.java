package com.cvs.devicecontroller.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.csv.devicecontroller.R;

public class DeviceLocatorDialgFragment extends DialogFragment {
    static DeviceLocatorDialgFragment newInstance() {
        return new DeviceLocatorDialgFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_device_locator, container, false);
        View tv = v.findViewById(R.id.tvTitle);
        ((TextView)tv).setText("Find Device");
        return v;
    }
}
