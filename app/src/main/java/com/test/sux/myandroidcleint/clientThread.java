package com.test.sux.myandroidcleint;

import android.os.Handler;
import android.os.Message;
import android.util.Log;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by Sux on 2016/12/15.
 */

/**
 * catch Server Message
 */

public class clientThread extends Thread {

    private Socket client;
    private BufferedReader br;

    /**
     *
     * @param client
     *
     */
    public clientThread(Socket client){

        this.client = client;

            setDaemon(true);


    }

    @Override

    public void run() {

        while(true){
            Log.i("service","running");
        if(client != null){
            try {
                br = new BufferedReader(new InputStreamReader(client.getInputStream(),"Big5"));
                String Msg;
                if((Msg = br.readLine()) != null){
                    Log.i("service",Msg);
                  MainActivity.MsgsAdd(Msg);
                }
            } catch (IOException e) {
                Log.d("err","連線問題");
                e.printStackTrace();
            }
        }
    }
    }
}
