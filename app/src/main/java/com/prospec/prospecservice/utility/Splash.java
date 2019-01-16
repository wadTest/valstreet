package com.prospec.prospecservice.utility;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import com.prospec.prospecservice.MainActivity;
import com.prospec.prospecservice.R;

public class Splash extends Activity {

//    ประกาศตัวแปร
    Handler handler;
    Runnable runnable;
    long delay_time;
    long time = 2000L;//2 วินาที

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splashscreen);

//        เรียกตัวแปรมาใช้
        handler = new Handler();

        runnable = new Runnable() {
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        };//End Runnable
    }//Method

//    เกี่ยวกับการกำหนดเวลา
    public void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }//End onResume

    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }//End onPause
}//Main Class