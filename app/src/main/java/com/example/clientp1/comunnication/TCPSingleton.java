package com.example.clientp1.comunnication;

import com.example.clientp1.events.OnMessageListener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPSingleton extends Thread{

    private static TCPSingleton instace;

    private TCPSingleton() {}

    public static TCPSingleton getInstance() {
        if(instace == null) {
            instace = new TCPSingleton();
            instace.start();
        }
        return instace;
    }

    private Socket socket;
    private BufferedWriter writer;
    private OnMessageListener observer;

    public void run() {

        try {
            socket = new Socket("192.168.0.6",5000);
            socket.setTcpNoDelay(true);

            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);

            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            writer = new BufferedWriter(osw);

            //Gson gson = new Gson();

            while (true) {
                String line = reader.readLine();
                System.out.println("Recibido: " + line);
                observer.OnMessage(line);

            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        new Thread(() -> {
            try {
                writer.write(msg + "\n");
                writer.flush();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }).start();
    }

}
