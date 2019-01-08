package com.prospec.prospecservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;

//class ห้องชุด
public class RoomActivity extends AppCompatActivity {

    //  Explicit  ประกาศตัวแปร
//    private View linear1, linear2;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ห้องชุด");
        toolbar.setSubtitle("โปรดกรอกรายละเอียดห้องชุด");
        toolbar.setLogo(R.drawable.logo_prospec);

    }//Method
}//Main Class