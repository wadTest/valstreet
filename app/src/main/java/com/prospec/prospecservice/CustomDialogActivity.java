package com.prospec.prospecservice;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

//        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("รายละเอียดสินทรัพย์");
        toolbar.setSubtitle("โปรดกรอกรายละเอียดสินทรัพย์ที่จะประเมิน พร้อมที่ตั้งทรัพย์สิน");
        toolbar.setLogo(R.drawable.logo_prospec);

        editText = (EditText) findViewById(R.id.editText);
        buttonMessage = (Button) findViewById(R.id.buttonMessage);

        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTextString = editText.getText().toString().trim();

                if (editTextString.equals("")) {

                    MyAlert myAlert = new MyAlert(CustomDialogActivity.this, "มีช่องว่าง", "กรุณากรอกข้อมูลในช่องว่าง");
                    myAlert.myDialog();

                } else {
//                    upload ข้อมูลที่กรอกไปเก็บไว้ใน my sql
                    uploadString();
                }
            }//onClick

            private void uploadString() {
                try {
                    Add_Message add_message = new Add_Message(CustomDialogActivity.this, editTextString);
                    add_message.execute();

                        Toast.makeText(CustomDialogActivity.this, "อัพโหลดข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }//Method
}//Main Class
