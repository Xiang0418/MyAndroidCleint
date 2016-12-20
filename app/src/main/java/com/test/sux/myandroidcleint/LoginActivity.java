package com.test.sux.myandroidcleint;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sux on 2016/12/18.
 * Login  Please enter IPAddress and Port
 */

public class LoginActivity extends Activity {
    private  Intent intent;
    private String IpAddress;
    private String Port;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText IpText = (EditText)findViewById(R.id.IPText);
        final EditText PortText = (EditText)findViewById(R.id.PortText);
        Button button = (Button) findViewById(R.id.sendBt);


          intent = new Intent(this.getBaseContext(),MainActivity.class);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IpAddress=IpText.getText().toString();
                Port=  PortText.getText().toString();
                if(!IpAddress.equals("") && !Port.equals("")) {

                    intent.putExtra("IP", IpAddress);
                    intent.putExtra("PORT", Port);
                    startActivity(intent);
                }else {
                    Toast.makeText(v.getContext(),"IPAddress or  Port  can't   null",Toast.LENGTH_LONG).show();
                }
            }
        });





    }
}
