package com.example.comeng2024hafta0501;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Toast.makeText(context, "Airplane Mode Changed",Toast.LENGTH_SHORT).show();

    }
}
