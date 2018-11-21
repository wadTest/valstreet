package com.prospec.prospecservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class LandBuildingActivity extends AppCompatActivity {

    //  Explicit  ประกาศตัวแปร
    private View linear1, linear2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_building);

        //        Bind Widget
        linear1 = findViewById(R.id.linear1);
        linear2 = findViewById(R.id.linear2);

//        การเปิด ปิด สลับกัน ของRadio Button , เมื่อกด ปุ่มใดปุ่มนึงใน Group
        RadioGroup onRadioButtonLand = (RadioGroup) findViewById(R.id.rg_Land_Main);
        onRadioButtonLand.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
//                    Radio Button ของที่ดิน 1 แปลง
                    case R.id.rb_land1:
                        mostrarParticular(true);
                        break;
//                        Radio Button ของที่ดิน 2 แปลง
                    case R.id.rb_land2:
                        mostrarParticular(false);
                        break;
                }
            }
        });
    }

    private void mostrarParticular(boolean b) {
//       มองเห็นได้ --> แล้วไปที่ กรอกข้อมูล 1 แปลง
        linear1.setVisibility(b ? View.VISIBLE : View.GONE);
//        ซ้อนไว้ก่อน เมื่อกดก้จะมา
        linear2.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    public void onRadioButtonLand(View view) {
    }//    ปีกกาปิดของคำสั่ง radio Group
    }//Main Class

