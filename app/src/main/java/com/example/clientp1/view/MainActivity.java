package com.example.clientp1.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.clientp1.R;
import com.example.clientp1.comunnication.TCPSingleton;
import com.example.clientp1.events.OnMessageListener;
import com.example.clientp1.model.Name;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity implements OnMessageListener {

    private EditText et_Nickname;
    private Button btn_goSecond;
    private TCPSingleton tcp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        tcp = TCPSingleton.getInstance();
        et_Nickname = findViewById(R.id.et_Nickname);
        btn_goSecond = findViewById(R.id.btn_goSecond);



         btn_goSecond.setOnClickListener(
                 (v)->{
                     Gson gson = new Gson();
                     boolean isEmpty = et_Nickname.getText().toString().trim().isEmpty() ;

                     if(!isEmpty){
                         String nickname = et_Nickname.getText().toString();
                         Name obj = new Name(nickname);
                         String json = gson.toJson(obj);
                         tcp.sendMessage(json);
                         Intent i = new Intent(this,SecondActivity.class);
                         startActivity(i);

                     }else{
                         String msgNo = "Llena el campo para continuar";
                         Toast toast = Toast.makeText(this, msgNo, Toast.LENGTH_LONG);
                         toast.show();
                     }
                 }
         );
    }

    @Override
    public void OnMessage(String msg) {

    }
}