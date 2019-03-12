package com.prospec.prospecservice;

import android.app.Dialog;
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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.prospec.prospecservice.utility.AddUserToServer;
import com.prospec.prospecservice.utility.SharedPrefs;

import java.util.Timer;
import java.util.TimerTask;

//class หน้าเมนูหลัก
public class MenuActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private ImageView assessment, corporate, status, message, service, vedio;
    ViewFlipper imageShow;
    private TextView  tv_name;
    private Button btn_logout;
    private String nameLogin;
    //    แสดงข้อความตแจ้งเตือน Edupro
    Dialog myDialog;

    // คลาสที่ Android มีมาให้เพื่อเซฟและอ่านข้อมูล โดยข้อมูลจะเก็บเป็นแบบ key-value สามารถใช้ SharedPreferences
    // เก็บข้อมูลลงไปได้ ทั้ง boolean, float, int, long, String ข้อมูลที่เซฟจะอยู่แม้ว่าเราจะปิดแอพแล้วก็ตาม แต่ข้อมูลจะหายไป หากเราทำการ uninstall แอพพลิเคชัน
    // private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //        ส่วนของการแสดงรูปภาพ
        myDialog = new Dialog(this);

//        Find Who Login ?
        SharedPreferences sharedPreferences = getSharedPreferences("Logout", MODE_PRIVATE);
        nameLogin = sharedPreferences.getString("NameLogin", "");
        Log.d("20JanV1", "nameLogin Receive in MenuActivity ==> " + nameLogin);


//        เรียกตัวแปรมาใช้งาน รูปที่ slider หน้าเมนู
        imageShow = findViewById(R.id.imageShow);
        int images[] = {R.drawable.photo1, R.drawable.photo2, R.drawable.photo3,
                R.drawable.photo4, R.drawable.photo5, R.drawable.photo6, R.drawable.photo7};

//        วนลูป เมื่อรันถึงรูปสุดท้ายแล้วกลับมารันรูปแรกใหม่
        for (int image : images) {
            flipperImages(image);
        }
    }   // Main Method

    //    Create Banner
    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        imageShow.addView(imageView);
        imageShow.setFlipInterval(9000); //9วิ
        imageShow.setAutoStart(true);

//        ภาพเคลื่อนไหว
        imageShow.setInAnimation(this, android.R.anim.slide_in_left);
        imageShow.setInAnimation(this, android.R.anim.slide_out_right);

//       ปุ่มกดไปหน้าต่างๆ
        status = (ImageView) findViewById(R.id.status);
        assessment = (ImageView) findViewById(R.id.assessment);
        message = (ImageView) findViewById(R.id.message);
        vedio = (ImageView) findViewById(R.id.vedio);
        service = (ImageView) findViewById(R.id.service);
        tv_name = (TextView) findViewById(R.id.tv_name);
        btn_logout = (Button) findViewById(R.id.btn_logout);
        corporate = (ImageView)findViewById(R.id.corporate);

        tv_name.setText("ยินดีต้อนรับ "+nameLogin.trim());

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

    //    Class Create SharePerferance Sataus Login
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
        corporate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, AssessmentActivity.class));

            }
        });


        //Get Event From Click Status
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, StatusActivity.class));

            }
        });

//            Get Event From Click Menu Message
//        เลือกรายการว่าจะกรอกข้อมูลแบบ ละเอียด, ย่อ
        assessment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu message = new PopupMenu(MenuActivity.this, assessment);
                message.getMenuInflater().inflate(R.menu.message, message.getMenu());
                message.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.message1:
                                startActivity(new Intent(MenuActivity.this, CustomDialogActivity.class));
                                return true;
                            case R.id.message2:
                                startActivity(new Intent(MenuActivity.this, MenuAssetActivity.class));
                                return true;
                        }
                        return true;
                    }
                });
                message.show();
            }
        });

        //        ติดต่อ line email call
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu button = new PopupMenu(MenuActivity.this, service);
                button.getMenuInflater().inflate(R.menu.button, button.getMenu());
                button.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.butT1:
                                startActivity(new Intent(MenuActivity.this, EmailActivity.class));
                                return true;
                            case R.id.butT2:
                                startActivity(new Intent(MenuActivity.this, LineActivity.class));
                                return true;
                            case R.id.butT3:
                                startActivity(new Intent(MenuActivity.this, CallActivity.class));
                                return true;
                        }
                        return true;
                    }
                });
                button.show();
            }
        });


        //Get Event From Click Message Facebook
        message.setOnClickListener(new View.OnClickListener() {
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

    public void ShowPopup(View v) {
        TextView txtclose;

        myDialog.setContentView(R.layout.popup_edupro);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");

        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();

            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }


}//Class Main