package com.prospec.prospecservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioGroup;

public class RoomActivity extends AppCompatActivity {

    //    //  Explicit  ประกาศตัวแปร
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

//        //        Bind Widget
//        linear1 = findViewById(R.id.linear1);
//        linear2 = findViewById(R.id.linear2);
//        //        การเปิด ปิด สลับกัน ของRadio Button , เมื่อกด ปุ่มใดปุ่มนึงใน Group
//        RadioGroup onRadioButtonRoom = (RadioGroup) findViewById(R.id.rg_Room_Main);
//        onRadioButtonRoom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
////                    Radio Button ของที่ดิน 1 ห้อง
//                    case R.id.rb_room1:
//                        mostrarParticular(true);
//                        break;
////                        Radio Button ของที่ดิน 1-5 ห้อง
//                    case R.id.rb_room2:
//                        mostrarParticular(false);
//                        break;
//                }
//            }
//        });
//    }
//
//    private void mostrarParticular(boolean b) {
////       มองเห็นได้ --> แล้วไปที่ กรอกข้อมูล 1 ห้อง
//        linear1.setVisibility(b ? View.VISIBLE : View.GONE);
////        ซ้อนไว้ก่อน เมื่อกดก้จะมา
//        linear2.setVisibility(b ? View.GONE : View.VISIBLE);
//    }
//
//    public void onRadioButtonRoom(View view) {
//    }//    ปีกกาปิดของคำสั่ง radio Group
//}//Main Class
