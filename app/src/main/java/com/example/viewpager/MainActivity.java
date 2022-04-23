package com.example.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // mHandler.sendEmptyMessageDelayed(x,2500);
    }
    /* private static final int x = 0;
private Handler mHandler = new Handler(){
    @Override
    public void handleMessage(@NonNull Message msg) {
        switch (msg.what){
            case x:
                Intent intent = new Intent(MainActivity.this,start.class);
                startActivity(intent);
                finish();
                break;
        }
    }
};*/
    public void skip(View view) {
        Intent intent=new Intent(this,start.class);
        startActivity(intent);
    }

    public void log_in(View view) {
        Intent intent=new Intent(this, log_in.class);
        startActivity(intent);
    }
}