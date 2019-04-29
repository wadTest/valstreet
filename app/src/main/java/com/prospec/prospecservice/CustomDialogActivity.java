package com.prospec.prospecservice;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.prospec.prospecservice.utility.Add_Message;
import com.prospec.prospecservice.utility.MyAlert;

//class รายละเอียดสินทรัพย์
public class CustomDialogActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private EditText editText;
    private Button buttonMessage;
    private String editTextString;
    private Toolbar toolbar;
//    share name title
    private String nameLogin, titleLogin;
    private TextView tv_name, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);
//
//        share();
//        toolBar();
//        getEvent();
//        click();
//
//    }//Method
//
//    private void share() {
////        share name and title to DB.
//        SharedPreferences sharedPreferences = getSharedPreferences("Logout", MODE_PRIVATE);
//        titleLogin = sharedPreferences.getString("titleLogin", "");
//        nameLogin = sharedPreferences.getString("NameLogin", "");
//        Log.d("share title, name", "get name message" + titleLogin + nameLogin);
//    }//end share
//
//    private void toolBar() {
////        ADD Toolbar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("รายละเอียดสินทรัพย์");
//        toolbar.setSubtitle("โปรดกรอกรายละเอียดสินทรัพย์");
//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                finish();
//            }
//        });
//    }//end toolbar
//
//    private void getEvent() {
//        editText = (EditText) findViewById(R.id.editText);
//        buttonMessage = (Button) findViewById(R.id.buttonMessage);
////        ชื่อคนที่login
//        tv_name = (TextView) findViewById(R.id.tv_name);
//        tv_name.setText(nameLogin.trim());
////        title TB :uers_app_crm ไปดูใน MySQL
//        title = (TextView) findViewById(R.id.title);
//        title.setText(titleLogin.trim());
//    }//end event
//
//    private void click() {
//
//        //             alert confirm
//        final AlertDialog.Builder adb = new AlertDialog.Builder(CustomDialogActivity.this);
//
//        buttonMessage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                editTextString = editText.getText().toString().trim();
////                  check ความว่างเปล่า
//                if (editTextString.equals("")) {
//
////                    ถ้าไม่กรอกจะขึ้นแจ้งเตือน
//                    MyAlert myAlert = new MyAlert(CustomDialogActivity.this, "มีช่องว่าง", "กรุณากรอกข้อมูลในช่องว่าง");
//                    myAlert.myDialog();
//                        } else {
////                    upload ข้อมูลที่กรอกไปเก็บไว้ใน MySQL
//                    uploadString();
//
//                }
//            }//onClick
//
//            private void uploadString() {
//
//                try {
//
////                    File เชื่อมต่อ DB. หน้านี้ Add_Message
//                    Add_Message add_message = new Add_Message(CustomDialogActivity.this, editTextString, nameLogin, titleLogin);
//                    add_message.execute();
//
////                    adb.setIcon(R.drawable.ic_action_alert);
////                    adb.setTitle(R.string.title_alert);
////                    adb.setMessage(getString(R.string.title) + "\n\n" + editTextString);
////                    adb.setNegativeButton("ยกเลิก", null);
////                    adb.setPositiveButton("ตกลง", new AlertDialog.OnClickListener() {
////                        public void onClick(DialogInterface dialog, int arg1) {
////
//                            Toast.makeText(CustomDialogActivity.this,"อัพโหลดข้อมูลสำเร็จ" , Toast.LENGTH_LONG).show();
//                            finish();
////                        }
////                    });
////                    adb.show();
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
    }
}//Main Class