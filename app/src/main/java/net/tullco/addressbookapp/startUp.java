package net.tullco.addressbookapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class startUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        SharedPreferences prefs = getPreferences(Context.MODE_PRIVATE);
        if (!prefs.contains("api_key")){
            Intent newIntent = new Intent(this,LoginActivity.class);
            startActivity(newIntent);
        }
    }
}
