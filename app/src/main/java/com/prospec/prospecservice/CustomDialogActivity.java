package com.prospec.prospecservice;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CustomDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_dialog);

        final Dialog dialog = new Dialog(CustomDialogActivity.this);
        dialog.setTitle("Devahoy");
        dialog.setContentView(R.layout.custom_dialog);

        final TextView tv = (TextView) dialog.findViewById(R.id.textView);
        final EditText et = (EditText) dialog.findViewById(R.id.editText);
        Button buttonCancel = (Button) dialog.findViewById(R.id.button_cancel);
        Button buttonLogin = (Button) dialog.findViewById(R.id.button_login);

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check username password
                if (tv.getText().equals("") &&
                        et.getText().equals("")) {
                    Toast.makeText(getApplicationContext(), "success!",
                            Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                } else {
                    Toast.makeText(getApplicationContext(), "Failed!",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


        dialog.show();
    }
}
