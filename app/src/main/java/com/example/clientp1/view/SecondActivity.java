package com.example.clientp1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;

import android.widget.Button;


import com.example.clientp1.R;
import com.example.clientp1.comunnication.TCPSingleton;
import com.example.clientp1.events.OnMessageListener;
import com.example.clientp1.model.Colors;
import com.example.clientp1.model.Direction;
import com.google.gson.Gson;

public class SecondActivity extends AppCompatActivity implements OnMessageListener {
    private Button btn_up;
    private Button btn_down;
    private Button btn_right;
    private Button btn_left;
    private Button btn_ChangeColor;
    private TCPSingleton tcp;
    private boolean buttonPressed;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        btn_down = findViewById(R.id.btn_down);
        btn_right = findViewById(R.id.btn_right);
        btn_up = findViewById(R.id.btn_up);
        btn_left = findViewById(R.id.btn_left);
        tcp = TCPSingleton.getInstance();
        buttonPressed = false;
        btn_ChangeColor = findViewById(R.id.btn_ChangeColor);


        btn_ChangeColor.setOnClickListener(
                (v) -> {
                    int r = (int) (Math.random() * 255);
                    int g = (int) (Math.random() * 255);
                    int b = (int) (Math.random() * 255);

                    Colors colors = new Colors(r, g, b);
                    Gson gson = new Gson();
                    String json = gson.toJson(colors);
                    tcp.sendMessage(json);
                }
        );

        btn_left.setOnTouchListener(
                (view,event)->{
                    switch (event.getAction()){

                        case MotionEvent.ACTION_DOWN:
                            buttonPressed = true;
                            new Thread(
                                    ()->{
                                        while(buttonPressed){
                                            Direction direction = new Direction(1);
                                            Gson gson = new Gson();
                                            String obj = gson.toJson(direction);
                                            tcp.sendMessage(obj);
                                            try {
                                                Thread.sleep(90);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                            ).start();

                            break;

                        case MotionEvent.ACTION_UP:
                            buttonPressed = false;
                            break;
                    }

                    return true;
                }

        );

        btn_right.setOnTouchListener(
                (view,event)->{
                    switch (event.getAction()){

                        case MotionEvent.ACTION_DOWN:
                            buttonPressed = true;
                            new Thread(
                                    ()->{
                                        while(buttonPressed){
                                            Direction direction = new Direction(2);
                                            Gson gson = new Gson();
                                            String obj = gson.toJson(direction);
                                            tcp.sendMessage(obj);
                                            try {
                                                Thread.sleep(90);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                            ).start();

                            break;

                        case MotionEvent.ACTION_UP:
                            buttonPressed = false;
                            break;
                    }

                    return true;
                }

        );

        btn_up.setOnTouchListener(
                (view,event)->{
                    switch (event.getAction()){

                        case MotionEvent.ACTION_DOWN:
                            buttonPressed = true;
                            new Thread(
                                    ()->{
                                        while(buttonPressed){
                                            Direction direction = new Direction(4);
                                            Gson gson = new Gson();
                                            String obj = gson.toJson(direction);
                                            tcp.sendMessage(obj);
                                            try {
                                                Thread.sleep(90);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                            ).start();

                            break;

                        case MotionEvent.ACTION_UP:
                            buttonPressed = false;
                            break;
                    }

                    return true;
                }

        );

        btn_down.setOnTouchListener(
                (view,event)->{
                    switch (event.getAction()){

                        case MotionEvent.ACTION_DOWN:
                            buttonPressed = true;
                            new Thread(
                                    ()->{
                                        while(buttonPressed){
                                            Direction direction = new Direction(3);
                                            Gson gson = new Gson();
                                            String obj = gson.toJson(direction);
                                            tcp.sendMessage(obj);
                                            try {
                                                Thread.sleep(90);
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                            ).start();

                            break;

                        case MotionEvent.ACTION_UP:
                            buttonPressed = false;
                            break;
                    }

                    return true;
                }

        );
    }


    @Override
    public void OnMessage(String msg) {

    }


}