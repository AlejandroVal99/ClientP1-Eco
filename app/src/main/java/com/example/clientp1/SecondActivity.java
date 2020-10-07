package com.example.clientp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.clientp1.events.OnMessageListener;

public class SecondActivity extends AppCompatActivity implements OnMessageListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void OnMeesage() {

    }
}