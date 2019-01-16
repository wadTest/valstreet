package com.prospec.prospecservice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.prospec.prospecservice.status.LoanOfficerActivity;
import com.prospec.prospecservice.utility.AddUserToServer;
import com.prospec.prospecservice.utility.SharedPrefs;

import java.util.Timer;
import java.util.TimerTask;

//class หน้าเมนูหลัก
public class MenuActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    ViewFlipper imageShow;
    private TextView textStatus, Status, tv_name;
    private Button btn_logout;

    // คลาสที่ Android มีมาให้เพื่อเซฟและอ่านข้อมูล โดยข้อมูลจะเก็บเป็นแบบ key-value สามารถใช้ SharedPreferences
    // เก็บข้อมูลลงไปได้ ทั้ง boolean, float, int, long, String ข้อมูลที่เซฟจะอยู่แม้ว่าเราจะปิดแอพแล้วก็ตาม แต่ข้อมูลจะหายไป หากเราทำการ uninstall แอพพลิเคชัน
   // private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//        เรียกตัวแปรมาใช้งาน รูปที่ slider หน้าเมนู
        imageShow = findViewById(R.id.imageShow);
        int images[] = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3,
                R.drawable.photo4, R.drawable.photo5, R.drawable.photo6, R.drawable.photo7};

//        วนลูป เมื่อรันถึงรูปสุดท้ายแล้วกลับมารันรูปแรกใหม่
        for (int image : images) {
            flipperImages(image);
        }
    }//Method

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        imageShow.addView(imageView);
        imageShow.setFlipInterval(5000); //5วิ
        imageShow.setAutoStart(true);

//        ภาพเคลื่อนไหว
        imageShow.setInAnimation(this, android.R.anim.slide_in_left);
        imageShow.setInAnimation(this, android.R.anim.slide_out_right);

//       ปุ่มกดไปหน้าต่างๆ
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        textStatus = (TextView) findViewById(R.id.textStatus);
        Status = (TextView) findViewById(R.id.Status);
        tv_name = (TextView) findViewById(R.id.tv_name);
        btn_logout = (Button) findViewById(R.id.btn_logout);

//        ปุ่มออกจากระบบ
        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefs.saveSharedSetting(MenuActivity.this, "Logout", "true");
                //และเมื่อคุณคลิกที่ปุ่มออกจากระบบคุณจะตั้งค่าเป็น True AGAIN
                Intent LogOut = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(LogOut);
                finish();
            }
        });

        CekSession();
    }

    public void CekSession() {

        Boolean Check = Boolean.valueOf(SharedPrefs.readSharedSetting(MenuActivity.this, "Logout", "true"));

        Intent introIntent = new Intent(MenuActivity.this, MainActivity.class);
        introIntent.putExtra("Logout", Check);

        //มูลค่าถ้าคุณคลิกที่กิจกรรมเข้าสู่ระบบและตั้งค่าเป็น FALSE และหากเป็นเท็จกิจกรรมจะปรากฏให้เห็น
        if (Check) {
            startActivity(introIntent);
            finish();
        } //ถ้าไม่มีกิจกรรมหลักไม่ทำอะไรเลย


        //Get Event From Click status corporate
        textStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, AssessmentActivity.class));

            }
        });

        //Get Event From Click status เจ้าหน้าที่สินเชื่อ
        Status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, LoanOfficerActivity.class));

            }
        });

        //Get Event From Click E-mail
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, EmailActivity.class));
            }
        });

        //Get Event From Click Line
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, LineActivity.class));
            }
        });

        //Get Event From Click Call
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, CallActivity.class));
            }
        });

        //Get Event From Click Status
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, StatusActivity.class));

            }
        });

        //Get Event From Click Menu Message
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MessageActivity.class));

            }
        });


        //Get Event From Click Message Facebook
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent messageInput = openMessage(MenuActivity.this);
                startActivity(messageInput);

            }
        });
    }// End CekSession

//    intent ไปยัง Message Facebook
    public static Intent openMessage(Context context) {
        try {
            context.getPackageManager()
//                   รับข้อมูลแพ็คเกจ และส่ง URL ด้วย Intent
                    .getPackageInfo("com.facebook.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.messenger.com/t/prospecappraisal"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.messenger.com/t/prospecappraisal"));
        }

    }//End openMessage
}//Class Main