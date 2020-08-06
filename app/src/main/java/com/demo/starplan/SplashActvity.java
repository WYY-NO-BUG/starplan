package com.demo.starplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.demo.starplan.home.MainActivity;


/**
 * 启用一个线程来进行跳转
 * 达到延时的效果
 * */

public class SplashActvity extends AppCompatActivity {

    private Button btnSkip;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            toMainActivity();
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
                toMainActivity();
            }
        });

        //延迟4秒
        handler.postDelayed(runnable,4000);

    }

    public void init(){
        btnSkip = findViewById(R.id.skip_btn);
    }

    private void toMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //防止内存泄漏
        handler.removeCallbacks(runnable);
    }
}
