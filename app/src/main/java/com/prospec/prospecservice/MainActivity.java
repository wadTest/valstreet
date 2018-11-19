package com.prospec.prospecservice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//       Explicit ประกาศตัวแปร
    private EditText editText1, editText2, editText3, editText4;
    private Button buttonSave;
    private TextView textSignin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Get Event การรับกิจกรรมจาก ตัวแปร (ช่องกรอกข้อมูล)
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        EditText editText3 = (EditText) findViewById(R.id.editText3);
        EditText editText4 = (EditText) findViewById(R.id.editText4);
//        (กดบันทึก กดลงทะเบียน)
        Button buttonSave = (Button) findViewById(R.id.buttonSave);
        TextView textSignin = (TextView) findViewById(R.id.textSignin);

    //    Get Event From Click Sign in
        textSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent textSigninIntent = new Intent(MainActivity.this, SignInActivity.class);
                MainActivity.this.startActivity(textSigninIntent);
            }
        });


        }//Method
    }//Class Main


