package com.test.sux.myandroidcleint;

import android.util.Log;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Vector;

/**
 * Created by Sux on 2016/12/19.
 */


public class sendMsg extends Thread {
    private String IpAddress;
    private Integer Port;
    private Vector<String> Msgs1;
    private clientThread clientThread;
    public sendMsg(String IpAddress,Integer Port){
        this.Msgs1 = new Vector<>();
        this.IpAddress = IpAddress;
        this.Port = Port;

    }



    @Override
    public void run() {
       if(!IpAddress.equals("")&&!Port.equals("")){
        try {
             Socket client = new Socket(IpAddress, Port);
            new clientThread(client).start();
            PrintStream ps = new PrintStream(client.getOutputStream(),true,"Big5" );

            while(true){
                if(client.isConnected()){

                if(Msgs1.size()>0){
                    Log.e("MsgsSize",String.valueOf(Msgs1.size()));
                    ps.println(Msgs1.elementAt(0));
                    Log.e("send",Msgs1.elementAt(0));
                    ps.flush();
                   // ps.close();
                    Msgs1.remove(0);
                }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}




    }
    public void sendMsg(String ...Msgs){

       for( String Msg : Msgs) {
           Log.e("Msgs",Msgs[0]);
           Log.e("Msg",Msg);
           this.Msgs1.add(Msg);
       }

    }
}
