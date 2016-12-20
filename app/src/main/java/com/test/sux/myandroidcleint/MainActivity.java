package com.test.sux.myandroidcleint;


import android.os.Handler;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class MainActivity extends AppCompatActivity {
    public static  Handler handler;
    private static List<String> Msgs = new ArrayList<>();
    private ListView listView;
    private MyAdapter myAdapter;
    private sendMsg sendMsg;
    private  Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.listview);
        String IpAddress = getIntent().getStringExtra("IP");
        String Port = getIntent().getStringExtra("PORT");
        UIUpdate();
        myAdapter = new MyAdapter(Msgs);
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(myAdapter);

        button = (Button)findViewById(R.id.MsgSend);
        final EditText editText =(EditText) findViewById(R.id.editText2);
          sendMsg = new sendMsg(IpAddress,Integer.valueOf(Port));
        sendMsg.start();
        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
            sendMsg.sendMsg(editText.getText().toString());
                editText.setText("");
            }
        });


    }

    /**
     *
     * @param msg
     */
    public static void MsgsAdd(String msg){
        Msgs.add(msg);
        Log.e("MessageSize",String.valueOf(Msgs.size()));
    }

    /**
     * Update ListView
     */
    private void UIUpdate(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count=0;
                while(true){

                    if(count< Msgs.size()){
                        Log.d("inServer",String.valueOf(Msgs.size()));
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                myAdapter.setMsg(Msgs);
                                myAdapter.notifyDataSetChanged();

                            }
                        });

                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();
    }


}
