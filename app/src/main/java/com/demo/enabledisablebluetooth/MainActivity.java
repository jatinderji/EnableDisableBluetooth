package com.demo.enabledisablebluetooth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    BluetoothAdapter bAdapter;
    SwitchCompat btnOnOff;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bAdapter = BluetoothAdapter.getDefaultAdapter();
        txtStatus = findViewById(R.id.txt);
        btnOnOff = findViewById(R.id.btnOnOff);
        if(bAdapter.isEnabled())
        {
            btnOnOff.setChecked(true);
            txtStatus.setText("Bluetooth is Enabled Now");
        }
        else
        {
            btnOnOff.setChecked(false);
            txtStatus.setText("Bluetooth is Disabled Now");
        }

        btnOnOff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    bAdapter.enable();
                    txtStatus.setText("Bluetooth is Enabled Now");
                }
                else{
                    bAdapter.disable();
                    txtStatus.setText("Bluetooth is Disabled Now");
                }
            }
        });
    }

    private void disableBluetoothNow()
    {
        ;
    }
    private void enableBluetoothNow()
    {

    }
}
