package com.prospec.prospecservice;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class CallActivity extends AppCompatActivity {

    //   Explicit ประกาศตัวแปร
    private Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12, button13;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ติดต่อสายตรง");
        toolbar.setSubtitle("เลือกเมนูทางในการติดต่อ");
        toolbar.setLogo(R.drawable.logo_prospec);

//        Get Event การรับกิจกรรมจาก ตัวแปร กดปุ่ม 1-13
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);

//        เมื่อกดปุ่มนี้ จะโทรไปยังเบอร์สำนักงานใหญ่
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:025590678"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาเชียงใหม่
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:053240216"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาเชียงราย
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:053718391"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาลำปาง
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:054222879"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาพิษณุโลก
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:055211243"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาอยุธยา
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:035243242"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาราชบุรี
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:032321934"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาเพชรบูรณ์
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:056721980"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขากำแพงเพชร
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:055714806"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาสระบุรี
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:036670695"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาแพร่
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:054531220"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขานครศรีธรรมราช
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:07-5322331"));
                startActivity(intent);
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาประจวบคีรีขันธ์
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //              โทรไปยังเบอร์
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:032602286"));
                startActivity(intent);
            }
        });

    }//Method
}//Class Main