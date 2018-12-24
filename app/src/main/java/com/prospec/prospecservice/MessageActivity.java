package com.prospec.prospecservice;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.prospec.prospecservice.utility.AddUserToServer;

public class MessageActivity extends AppCompatActivity {

    private Button button1, button2;

    private String editTextMessage;
    final Context c = this;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);



//        //Get Event From Click Text
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MessageActivity.this, Message1Activity.class));
//
//            }
//        });

        //Get Event From Click Menu Asset
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MessageActivity.this, MenuAssetActivity.class));

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.custom_dialog, null);
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);


                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("ส่งข้อความ", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {

//                                editText = (EditText) findViewById(R.id.editText);
//                                editTextMessage = editText.getText().toString().trim();
//                                if (editTextMessage.equals((""))) {
//                                }
//                                editText.setError("โปรดกรอกข้อมูลในช่องว่าง!");

                                // สิ่งที่ต้องทำเพื่อให้ได้ข้อมูลของผู้ใช้ที่นี่
                            }
                        })

                        .setNegativeButton("ยกเลิก",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });
    }

}
