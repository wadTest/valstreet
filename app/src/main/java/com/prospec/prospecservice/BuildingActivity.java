package com.prospec.prospecservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;

// class ที่ดินพร้อมสิ่งปลูกสร้าง
public class BuildingActivity extends AppCompatActivity {

//    //  Explicit  ประกาศตัวแปร
//    private View linear1, linear2, linear3, linear4;
private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);

        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ที่ดินพร้อมสิ่งปลูกสร้าง");
        toolbar.setSubtitle("โปรดกรอกรายละเอียดให้ครบถ้วน");
        toolbar.setLogo(R.drawable.logo_prospec);

    }//Method
}//Class Main
