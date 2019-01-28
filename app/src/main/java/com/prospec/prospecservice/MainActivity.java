package com.prospec.prospecservice;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.prospec.prospecservice.utility.MyAlert;
import com.prospec.prospecservice.utility.SharedPrefs;
import com.prospec.prospecservice.utility.SynUser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

//class login
public class MainActivity extends AppCompatActivity {

    //       Explicit ประกาศตัวแปร
    private EditText et_email, et_password;
    private Button btn_login;
    private TextView tv_register;
    //    truePassString คือ ตัวแปรที่ใช้เก็บค่า password ที่อ่านได้
    private String uerString, passwordString, truePassString;
    private boolean aBoolean = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Get Event การรับกิจกรรมจาก ตัวแปร (ช่องกรอกข้อมูล) ผูกความสัมพันธ์
        et_email = (EditText) findViewById(R.id.et_email);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        tv_register = (TextView) findViewById(R.id.tv_register);

        //      เมื่อยังไม่ได้ลงทะเบียน กดปุ่มนี้จะไปลงทะเบียน
        tv_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignInActivity.class));
            }
        });

//       เมื่อกดปุ่มนี้จะขึ้นหน้าเมนู ของหน้าถัดไป
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uerString = et_email.getText().toString().trim();
                passwordString = et_password.getText().toString().trim();

                if (uerString.equals("") || passwordString.equals("")) {
                    MyAlert myAlert = new MyAlert(MainActivity.this, "มีช่องว่าง",
                            "กรุณากรอกข้อมูลในช่องว่าง");
                    myAlert.myDialog();
                } else {

                    //No Space ดึงค่าจาก server
                    checkUser();
                }
            }//onClick
        });
    }//Method

    private void checkUser() {
        try {

            SynUser synUser = new SynUser(MainActivity.this);
            synUser.execute();
//            อ่านค่ามันออกมา
            String s = synUser.get();
            Log.d("20JanV1", "s From Json user_app_crm ==> " + s);
            String nameLogin = "";
            JSONArray jsonArray = new JSONArray(s);
//            วบ loop
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
//                ถ้า  user ที่ลูกค้ากรอก มีค่าเท่ากับสิ่งที่อ่านได้จากฐานข้อมูล
                if (uerString.equals(jsonObject.getString("email"))) {
//                    ให้เอาค่าของ aBoolean มีค่า = false
                    aBoolean = false;
                    truePassString = jsonObject.getString("password");
                    nameLogin = jsonObject.getString("name");
                    Log.d("20JanV1", "nameLogin ==> " + nameLogin);
                }
            }//for

//            ดูค่าของ aBoolean ว่ามีค่า = true หรือเปล่า
            if (aBoolean) {
//                ถ้ามีค่า = true ในกรณีที่ใส่ user ผิด
                MyAlert myAlert = new MyAlert(MainActivity.this, "ใส่อีเมล์ผิด",
                        " กรุณาตรวจอีเมล์สอบอีกครั้ง");
                myAlert.myDialog();
            } else if (passwordString.equals(truePassString)) {


//                SharedPrefs.saveSharedSetting(MainActivity.this, "Logout", "false");

                SharedPreferences sharedPreferences = getSharedPreferences("Logout", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("NameLogin", nameLogin);
                editor.putString("Logout", "false");
                editor.commit();

                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
//                ไม่ให้ย้อยกลับมาหน้าเก่า กดปุ่มกลับก็จะออกจากหน้าจอเลย
                finish();
            } else {
//                ถ้าเกิดว่าผิด
                MyAlert myAlert = new MyAlert(MainActivity.this, "ใส่รหัสผ่านไม่ถูกต้อง",
                        "กรุณาตรวจสอบรหัสผ่านอีกครั้ง");
//                แล้วเอาค่าคงตัวมา  myDialog
                myAlert.myDialog();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//Method
}//Class Main