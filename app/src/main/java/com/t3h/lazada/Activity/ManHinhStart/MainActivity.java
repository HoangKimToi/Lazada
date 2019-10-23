package com.t3h.lazada.Activity.ManHinhStart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.t3h.lazada.Activity.TrangChu.TrangChuActivity;
import com.t3h.lazada.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                }catch (Exception ex){

                }finally {
                    Intent isTrangchu = new Intent(MainActivity.this, TrangChuActivity.class);
                    startActivity(isTrangchu);
                    finish();
                }
            }
        });
        thread.start();
    }
}
