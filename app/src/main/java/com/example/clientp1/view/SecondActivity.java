package com.example.clientp1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.clientp1.R;
import com.example.clientp1.events.OnMessageListener;

public class SecondActivity extends AppCompatActivity implements OnMessageListener {
    private Button btn_up,btn_down,btn_right,btn_left, btn_ChangeColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }



    @Override
    public void OnMessage(String msg) {

    }
}