package com.prospec.prospecservice.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.prospec.prospecservice.R;

public class Calulation extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calulation);

        final EditText arrayEditText = findViewById(R.id.edtArray);
        final EditText showEditText = findViewById(R.id.edtShow);
        final EditText all = findViewById(R.id.all);
        final EditText thbEditText = findViewById(R.id.edtTHB);
        final String[] strings = new String[]{"0", "0", "0"};

        //        ช่องที่ 1
        arrayEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                strings[0] = arrayEditText.getText().toString();
                if (strings[0].isEmpty()) {
                    strings[0] = "0";
                }
//                sum
                calculate(strings, showEditText);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        ช่องที่ 2
        thbEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                strings[1] = thbEditText.getText().toString();
                if (strings[1].isEmpty()) {
                    strings[1] = "0";
                }
//                sum
                calculate(strings, showEditText);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        ช่องที่ 3
        all.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                strings[2] = all.getText().toString();
                if (strings[2].isEmpty()) {
                    strings[2] = "0";
                }
//                sum
                calculate(strings, showEditText);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void calculate(String[] strings, EditText showEditText) {
        int arrayInt = Integer.parseInt(strings[0]);
        int thbInt = Integer.parseInt(strings[1]);
        int all = Integer.parseInt(strings[2]);
        int answerInt = arrayInt + thbInt + all;
        showEditText.setText(Integer.toString(answerInt));
    }
}