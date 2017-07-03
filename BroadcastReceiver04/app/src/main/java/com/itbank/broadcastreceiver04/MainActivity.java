package com.itbank.broadcastreceiver04;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //버튼 두개와 브로드캐스트 리시버의 객체를 생성
    private Button on;
    private Button off;
    private DynamicReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        on = (Button)findViewById(R.id.on);
        off = (Button)findViewById(R.id.off);
        receiver = new DynamicReceiver();

        on.setEnabled(true);
        off.setEnabled(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        u();
    }

    public void register(View view){
        on.setEnabled(false);
        off.setEnabled(true);
        r();
    }

    public void unRegister(View view){
        on.setEnabled(true);
        off.setEnabled(false);
        u();
    }

    private void r(){
        try{
            IntentFilter filter = new IntentFilter();
            filter.addAction(Intent.ACTION_HEADSET_PLUG);
            registerReceiver(receiver, filter);
        }catch(Exception e){}
    }

    private void u(){
        try{
            unregisterReceiver(receiver);
        }catch(Exception e){}
    }
}
