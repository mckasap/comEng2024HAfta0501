package com.example.comeng2024hafta0501;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyReceiver mr;
    TextView tv;
    IntentFilter intentFilter;
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(mr);
        SharedPreferences pref= getSharedPreferences("MyPref", this.MODE_PRIVATE);
        SharedPreferences.Editor edit= pref.edit();
        edit.putString("etValue",et.getText().toString());
        edit.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mr,intentFilter);


        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        boolean ilkCB= pref.getBoolean("check_box_preference_1",false);
        boolean ikinciCB= pref.getBoolean("check_box_preference_2",false);
        boolean SW= pref.getBoolean("switch_preference_1",false);
        String metin= pref.getString("edit_text_preference_1","");
        tv.setText(ilkCB+" \n"+ ikinciCB+ "\n" + SW+ "\n"+metin);


    }
    EditText et;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.editTextText);
        mr= new MyReceiver();
        tv=(TextView) findViewById(R.id.textView);
         intentFilter= new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        SharedPreferences pref= getSharedPreferences("MyPref", this.MODE_PRIVATE);
        et.setText(pref.getString("etValue",""));

    }

    public void Settings(View v){
        Intent myint= new Intent(this,MyPreference.class);
        startActivity(myint);
    }
}