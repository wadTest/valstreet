package com.prospec.prospecservice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.prospec.prospecservice.building.BuildingActivity;
import com.prospec.prospecservice.condo.RoomActivity;
import com.prospec.prospecservice.lands.LandBuildingActivity;
import com.prospec.prospecservice.lands.LandsFragment;

//class กรอกข้อมูลแบบระเอียด เมนูให้เลือกทั้ง 3 ปุ่ม
public class MenuAssetActivity extends AppCompatActivity {

    //  Explicit  ประกาศตัวแปร
    private Button button1, button2, button3;
    final Context context1 = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_asset);

        //        Bind Widget
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);


        //Get Event From Click Land and Building
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuAssetActivity.this, LandBuildingActivity.class));

            }
        });
        //Get Event From Click Land and Building
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuAssetActivity.this, BuildingActivity.class));

            }
        });

        //Get Event From Click Room
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuAssetActivity.this, RoomActivity.class));

            }
        });

    }
}