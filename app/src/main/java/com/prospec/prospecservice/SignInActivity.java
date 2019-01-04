package com.prospec.prospecservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.prospec.prospecservice.utility.AddUserToServer;
import com.prospec.prospecservice.utility.MyAlert;

public class SignInActivity extends AppCompatActivity {

    private EditText et_name, et_phone, et_email, et_password;
    private Button btn_register;
    //, et_lastString
    private String et_nameString, et_phoneString, et_emailString, et_passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        et_name = (EditText) findViewById(R.id.et_name);
      //  et_last = (EditText) findViewById(R.id.et_last);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_register = (Button) findViewById(R.id.btn_register);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                et_nameString = et_name.getText().toString();
              //  et_lastString = et_last.getText().toString().trim();
                et_phoneString = et_phone.getText().toString().trim();
                et_emailString = et_email.getText().toString().trim();
                et_passwordString = et_password.getText().toString().trim();

                //et_lastString.equals("") ||
                if (et_nameString.equals("") ||  et_phoneString.equals("") || et_emailString.equals("") || et_passwordString.equals("")) {

                    MyAlert myAlert = new MyAlert(SignInActivity.this, "มีช่องว่าง",
                            "กรุณากรอกข้อมูลในช่องว่าง");
                    myAlert.myDialog();

                } else {
//                    upload ข้อมูลที่กรอกไปเก็บไว้ใน my sql
                    uploadString();

                    //No Space ดึงค่าจาก server
                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                    startActivity(intent);
//                ไม่ให้ย้อยกลับมาหน้าเก่า กดปุ่มกลับก็จะออกจากหน้าจอเลย
                    finish();
                }
            }//onClick

            private void uploadString() {
                try {
                    // et_lastString,
                    AddUserToServer addUserToServer = new AddUserToServer(SignInActivity.this,
                            et_nameString, et_phoneString, et_emailString, et_passwordString);
                    addUserToServer.execute();

//            เมื่อไหร่ก็ตามถ้ามีค่าเป็น true ให้ทำ finish โดยการกลับไปที่หน้าแรก
                    if (Boolean.parseBoolean(addUserToServer.get())) {
                        finish();
                        Toast.makeText(SignInActivity.this, "อัพโหลดข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();

//                แต่ถ้าไม่ใช่ ให้ แสดงข้อความ ไม่สามารถอัพโหลดได้ ขึ้นมาเป็นเวลา 4 วิ
                    } else {
                        Toast.makeText(SignInActivity.this, "อัพโหลดข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }//Method
}//Main Class



//package com.prospec.prospecservice;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.RadioGroup;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.prospec.prospecservice.utility.AddUserToServer;
//import com.prospec.prospecservice.utility.MyAlert;
//
//public class SignInActivity extends AppCompatActivity {
//
//    private EditText et_name, et_last, et_phone, et_email, et_password;
//    private Button btn_register;
//    private String et_nameString, et_lastString, et_phoneString, et_emailString, et_passwordString;
//    private RadioGroup genderRadioGroup;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_signin);
//
//        et_name = (EditText) findViewById(R.id.et_name);
//        et_last = (EditText) findViewById(R.id.et_last);
//        et_phone = (EditText) findViewById(R.id.et_phone);
//        et_email = (EditText) findViewById(R.id.et_email);
//        et_password = (EditText) findViewById(R.id.et_password);
//        btn_register = (Button) findViewById(R.id.btn_register);
//        genderRadioGroup = (RadioGroup) findViewById(R.id.gender_radio_group);
//
//        btn_register.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
////                เรียกตัวแปรมาใช้
//                et_nameString = et_name.getText().toString().trim();
//                et_lastString = et_last.getText().toString().trim();
//                et_phoneString = et_phone.getText().toString().trim();
//                et_emailString = et_email.getText().toString().trim();
//                et_passwordString = et_password.getText().toString().trim();
//
//
//                if (et_nameString.equals("") || et_lastString.equals("") || et_phoneString.equals("") || et_emailString.equals("") || et_passwordString.equals("")) {
//
//                    MyAlert myAlert = new MyAlert(SignInActivity.this, "มีช่องว่าง",
//                            "กรุณากรอกข้อมูลในช่องว่าง");
//                    myAlert.myDialog();
//
//                } else {
////                  upload ข้อมูลที่กรอกไปเก็บไว้ใน my sql
//                    uploadString();
////                  เลือกระหว่างลูกค้า กับผู้ส่งงาน
//                    choice();
//
//                    //No Space ดึงค่าจาก server
//                    Intent intent = new Intent(SignInActivity.this, MainActivity.class);
//                    startActivity(intent);
////                  ไม่ให้ย้อยกลับมาหน้าเก่า กดปุ่มกลับก็จะออกจากหน้าจอเลย
//                    finish();
//                }
//            }//onClick
//
//            private void uploadString() {
//                try {
//                    AddUserToServer addUserToServer = new AddUserToServer(SignInActivity.this,
//                            et_nameString, et_lastString, et_phoneString, et_emailString, et_passwordString);
//                    addUserToServer.execute();
//
////                  เมื่อไหร่ก็ตามถ้ามีค่าเป็น true ให้ทำ finish โดยการกลับไปที่หน้าแรก
//                    if (Boolean.parseBoolean(addUserToServer.get())) {
//                        finish();
//                        Toast.makeText(SignInActivity.this, "อัพโหลดข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
//
////                แต่ถ้าไม่ใช่ ให้ แสดงข้อความ ไม่สามารถอัพโหลดได้ ขึ้นมาเป็นเวลา 4 วิ
//                    } else {
//                        Toast.makeText(SignInActivity.this, "ไม่สามารถอัพโหลดได้", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//
//    }//Method
//
//    private void choice() {
//
//        int selectedId = genderRadioGroup.getCheckedRadioButtonId();
//        String choice;
//        if (selectedId == R.id.radio_btn2)
//            choice = "ผู้ส่งงาน";
//        else
//            choice = "ลูกค้า";
//
//    }
//}//Main Class
