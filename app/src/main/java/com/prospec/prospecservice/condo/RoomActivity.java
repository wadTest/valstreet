package com.prospec.prospecservice.condo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.prospec.prospecservice.CustomDialogActivity;
import com.prospec.prospecservice.R;
import com.prospec.prospecservice.utility.Add_Message;
import com.prospec.prospecservice.utility.MyAlert;

//class ห้องชุด
public class RoomActivity extends AppCompatActivity {

    //  Explicit  ประกาศตัวแปร
    private EditText editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10, editT11, editT12, editT13;
    private String editT1String, editT2String, editT3String, editT4String, editT5String, editT6String, editT7String,
            editT8String, editT9String, editT10String, editT11String, editT12String, editT13String;
    private Button Save;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        //        ADD Toolbar
        toolBar();

        getevent();

        savedata();

    }//Method


    private void toolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ห้องชุด");
        toolbar.setSubtitle("โปรดกรอกรายละเอียดห้องชุด");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }//end toolbar

    private void getevent() {

        editT1 = (EditText) findViewById(R.id.editT1);
        editT2 = (EditText) findViewById(R.id.editT2);
        editT3 = (EditText) findViewById(R.id.editT3);
        editT4 = (EditText) findViewById(R.id.editT4);
        editT5 = (EditText) findViewById(R.id.editT5);
        editT6 = (EditText) findViewById(R.id.editT6);
        editT7 = (EditText) findViewById(R.id.editT7);
        editT8 = (EditText) findViewById(R.id.editT8);
        editT9 = (EditText) findViewById(R.id.editT9);
        editT10 = (EditText) findViewById(R.id.editT10);
        editT11 = (EditText) findViewById(R.id.editT11);
        editT12 = (EditText) findViewById(R.id.editT12);
        editT13 = (EditText) findViewById(R.id.editT13);
        Save = (Button) findViewById(R.id.Save);
    }//end get event

    private void savedata() {
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editT1String = editT1.getText().toString().trim();
                editT2String = editT2.getText().toString().trim();
                editT3String = editT3.getText().toString().trim();
                editT4String = editT4.getText().toString().trim();
                editT5String = editT5.getText().toString().trim();
                editT6String = editT6.getText().toString().trim();
                editT7String = editT7.getText().toString().trim();
                editT8String = editT8.getText().toString().trim();
                editT9String = editT9.getText().toString().trim();
                editT10String = editT10.getText().toString().trim();
                editT11String = editT11.getText().toString().trim();
                editT12String = editT12.getText().toString().trim();
                editT13String = editT13.getText().toString().trim();

                if (editT1String.equals("") || editT2String.equals("") || editT3String.equals("") || editT4String.equals("") ||
                        editT5String.equals("") || editT6String.equals("") || editT7String.equals("") || editT8String.equals("") ||
                        editT9String.equals("") || editT10String.equals("")) {

                    MyAlert myAlert = new MyAlert(RoomActivity.this, "มีช่องว่าง", "กรุณากรอกข้อมูลในช่องว่าง");
                    myAlert.myDialog();

                } else {
//                    upload ข้อมูลที่กรอกไปเก็บไว้ใน my sql
                    uploadString();
                }
            }//onClick

            private void uploadString() {
                try {
                    AddRoom addRoom = new AddRoom(RoomActivity.this, editT1String, editT2String, editT3String,  editT4String, editT5String,
                            editT6String, editT7String, editT8String, editT9String, editT10String, editT11String, editT12String, editT13String);
                    addRoom.execute();

                    Toast.makeText(RoomActivity.this, "อัพโหลดข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}//Main Class