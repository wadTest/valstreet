package com.prospec.prospecservice;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.security.acl.Group;

public class SignInActivity extends AppCompatActivity {

    //  Explicit  ประกาศตัวแปร
    private View contenedorParticular;
    private View contenedorCorporativo;

    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11,
            editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20, editText21;
    private ImageView imageName;
    private Button buttonSignUp, buttonSignUp1;
    //    ทำหน้าที่มนการรับค่าที่เกิดจากการกรอก (เปลี่ยนเป็นสติงก่อน และทำการรับผล)
    private String editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10,
            editT11, editT12, editT13, editT14, editT15, editT16, editT17, editT18, editT19, editT20, editT21;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

//        Bind Widget
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        editText12 = (EditText) findViewById(R.id.editText12);
        editText13 = (EditText) findViewById(R.id.editText13);
        editText14 = (EditText) findViewById(R.id.editText14);
        editText15 = (EditText) findViewById(R.id.editText15);
        editText16 = (EditText) findViewById(R.id.editText16);
        editText17 = (EditText) findViewById(R.id.editText17);
        editText18 = (EditText) findViewById(R.id.editText18);
        editText19 = (EditText) findViewById(R.id.editText19);
        editText20 = (EditText) findViewById(R.id.editText20);
        editText21 = (EditText) findViewById(R.id.editText21);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        buttonSignUp1 = (Button) findViewById(R.id.buttonSignUp1);
        imageName = (ImageView) findViewById(R.id.imageName);

//        ปุ่มชองลูกค้า
        buttonSignUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//        Get Value From Edit Text
                editT1 = editText1.getText().toString().trim();
                editT2 = editText2.getText().toString().trim();
                editT3 = editText3.getText().toString().trim();
                editT4 = editText4.getText().toString().trim();
                editT5 = editText5.getText().toString().trim();
                editT6 = editText6.getText().toString().trim();
                editT7 = editText7.getText().toString().trim();
                editT8 = editText8.getText().toString().trim();
                editT9 = editText9.getText().toString().trim();
                editT10 = editText10.getText().toString().trim();
                editT11 = editText11.getText().toString().trim();

//                Check Space เมื่อไไหร่ก้ตาม ถ้า editT1..มัน equals กับความว่างเปล่า blool จะเป็น True (|| ไบร์ย  t or t =t , t or f = t, f or t = t, f or f =f)
                if (editT1.equals("") || editT2.equals("") || editT3.equals("") || editT4.equals("") || editT5.equals("") || editT6.equals("")
                        || editT7.equals("") || editT8.equals("") || editT9.equals("") || editT10.equals("") || editT11.equals("")) {
                }

            }//onClick
        });

//        ปุ่มของผู้ส่งงาน
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editT12 = editText12.getText().toString().trim();
                editT13 = editText13.getText().toString().trim();
                editT14 = editText14.getText().toString().trim();
                editT15 = editText15.getText().toString().trim();
                editT16 = editText16.getText().toString().trim();
                editT17 = editText17.getText().toString().trim();
                editT18 = editText18.getText().toString().trim();
                editT19 = editText19.getText().toString().trim();
                editT20 = editText20.getText().toString().trim();
                editT21 = editText21.getText().toString().trim();

//                Check Space เมื่อไไหร่ก้ตาม ถ้า editT1..มัน equals กับความว่างเปล่า blool จะเป็น True (|| ไบร์ย  t or t =t , t or f = t, f or t = t, f or f =f)
                if (editT12.equals("") || editT13.equals("") || editT14.equals("") || editT15.equals("") || editT16.equals("") || editT17.equals("") ||
                        editT18.equals("") || editT19.equals("") || editT20.equals("") || editT21.equals("")) {
                    //Have Space เมื่อกรอกจะเตือน
                    MyAlert myAlert1 = new MyAlert(SignInActivity.this, "มีพื้นที่ว่าง", "โปรดกรอกข้อมูลทั้งหมดในช่องว่าง");
                    myAlert1.myDialog();
                }

        }//onClick
    });

//        Image Controller
        imageName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ต้องการใช้ class จากภายนอก ต้อง
//                ACTION_GET_CONTENT ส่งสิ่งนี้ไปยังโปรแกรมอื่น ให้โปรแกรมอื่นทำงานจนเสร็จ พอทำงานเสร็จ จะทำการคืนผลลัพธ์กลับมา
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                image/* คือสิ่งที่สามรถเปิดรูปภาพได้ เช่น ต้องการเปิดด้วย แกลอรี่ โฟโต ฯลฯ
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent,"โปรดเลือกแอพ ที่จะทำการเปิด"),1);
            }
        });


        contenedorParticular = findViewById(R.id.ll_contenedor_particular);
        contenedorCorporativo = findViewById(R.id.ll_contenedor_corporativo);

//        การเปิด ปิด สลับกัน ของRadio Buuton , เมื่อกด ปุ่มใดปุ่มนึงใน Group
        RadioGroup opcionesCliente = (RadioGroup) findViewById(R.id.rg_tipo_cliente);
        opcionesCliente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
//                    Radio Button ของลูกค้า
                    case R.id.rb_particular:
                        mostrarParticular(true);
                        break;
//                        Radio Button ของผู้ใช้งาน
                    case R.id.rb_corporativo:
                        mostrarParticular(false);
                        break;
                }
            }
        });
    }

    private void mostrarParticular(boolean b) {
//       มองเห็นได้ --> แล้วไปที่ กรอกข้อมูลลูกค้า
        contenedorParticular.setVisibility(b ? View.VISIBLE : View.GONE);
//        ซ้อนไว้ก่อน เมื่อกดก้จะมา
        contenedorCorporativo.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    public void onRadioButtonClicked(View view) {
    }//    ปีกกาปิดของคำสั่ง redio Group


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}//Main Class