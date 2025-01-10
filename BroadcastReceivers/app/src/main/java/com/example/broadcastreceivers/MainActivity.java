package com.example.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver batteryReceiver;
    private IntentFilter filter1 = new IntentFilter(AudioManager.RINGER_MODE_CHANGED_ACTION);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.textView);

        batteryReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
                boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                        status == BatteryManager.BATTERY_STATUS_FULL;

                if (isCharging) {
                    textView.setText("Telefon jest w trakcie ładowania...");
                } else {
                    textView.setText("Telefon nie jest podłączony do ładowarki...");
                }
            }
        };

        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryReceiver, filter);
    }

    private BroadcastReceiver ringerReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            int ringerMode = audioManager.getRingerMode();
            if (ringerMode == AudioManager.RINGER_MODE_SILENT) {
                Log.d("BroadcastReceiver", "Telefon jest wyciszony");
            } else if (ringerMode == AudioManager.RINGER_MODE_VIBRATE){
                Log.d("BroadcastReceiver", "Telefon jest w trybie wibracji");
            }
            else {
                Log.d("BroadcastReceiver", "Telefon nie jest wyciszony");
            }
           }
    };

    @Override
    public void onResume() {
        super.onResume();
        registerReceiver(ringerReceiver, filter1);
    }

    @Override
    public void onPause() {
        unregisterReceiver(batteryReceiver);
        unregisterReceiver(ringerReceiver);
        super.onPause();
    }
}
