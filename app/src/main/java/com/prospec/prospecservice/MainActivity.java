package com.prospec.prospecservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //       Explicit ประกาศตัวแปร
    private EditText editTextNamna, editText1, editText2, editText3, editText4;
    private Button buttonSave;
    private TextView textSignin;
    private String editT, editT1, editT2, editT3, editT4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Get Event การรับกิจกรรมจาก ตัวแปร (ช่องกรอกข้อมูล)
        editTextNamna = (EditText) findViewById(R.id.editTextNamna);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);

        buttonSave = (Button) findViewById(R.id.buttonSave);

        //        ปุ่มบันทึก
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//        Get Value From Edit Text (trim คือ ลบเว้นวรรค หน้าหลัง)
                editT = editTextNamna.getText().toString().trim();
                editT1 = editText1.getText().toString().trim();
                editT2 = editText2.getText().toString().trim();
                editT3 = editText3.getText().toString().trim();
                editT4 = editText4.getText().toString().trim();

//                Check Space เมื่อไไหร่ก้ตาม ถ้า editT1..มัน equals กับความว่างเปล่า blool จะเป็น True (|| ไบร์ย  t or t =t , t or f = t, f or t = t, f or f =f)
                if (editT.equals("") || editT1.equals("") || editT2.equals("") || editT3.equals("") || editT4.equals("")) {
                    //Have Space เมื่อกรอกจะเตือน
                    MyAlert myAlert = new MyAlert(MainActivity.this, "มีพื้นที่ว่าง", "โปรดกรอกข้อมูลทั้งหมดในช่องว่าง");
                    myAlert.myDialog();
                }
            }//onClick
        });//End buttonSave

////        (กดบันทึก กดลงทะเบียน)
//        Button buttonSave = (Button) findViewById(R.id.buttonSave);


//        //    Get Event From Click Menu
//        buttonSave.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent textSigninIntent = new Intent(MainActivity.this, MenuActivity.class);
//                MainActivity.this.startActivity(textSigninIntent);
//            }
//        });

//        Get Event การรับกิจกรรมจาก ตัวแปร (กดเพื่อลงทะเบียน)
        TextView textSignin = (TextView) findViewById(R.id.textSignin);
        //    Get Event From Click Sign in
        textSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent textSigninIntent = new Intent(MainActivity.this, SignInActivity.class);
                MainActivity.this.startActivity(textSigninIntent);
            }
        });//End textSign in


//        ข้อความขึ้นอัตโนมัติ
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, CATEGORIES);
        AutoCompleteTextView nameTV = (AutoCompleteTextView)
                findViewById(R.id.editTextNamna);

        nameTV.setAdapter(adapter);
    }

    private static final String[] CATEGORIES = new String[]{"นาย", "นาง", "นางสาว"};
   }//Class Main


