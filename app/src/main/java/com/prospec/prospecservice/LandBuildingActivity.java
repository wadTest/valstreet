package com.prospec.prospecservice;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

//class ที่ดินเปล่า
public class LandBuildingActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
//    private EditText editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10, editT11, editT12;
//   private ImageButton plus;
//    private Spinner spinnerP;
    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;
//    private Button buttonB, buttonS;
    private CardView card1, card2;
    private LinearLayout parentLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_building);

        toolbar();

        getevent();

        addremove();

    }//Method




    private void toolbar() {
        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ที่ดินเปล่า");
        toolbar.setSubtitle("โปรดกรอกรายละเอียดที่ดินเปล่า");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }//end toolbar

    private void addremove() {
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
    }

    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // Add the new row before the add field button.
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }

    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
    }

    private void getevent() {
//        กรอกข้อมูล
//        editT1 = (EditText) findViewById(R.id.editT1);
//        editT2 = (EditText) findViewById(R.id.editT2);
//        editT3 = (EditText) findViewById(R.id.editT3);
//        editT4 = (EditText) findViewById(R.id.editT4);
//        editT5 = (EditText) findViewById(R.id.editT5);
//        editT6 = (EditText) findViewById(R.id.editT6);
//        editT7 = (EditText) findViewById(R.id.editT7);
//        editT8 = (EditText) findViewById(R.id.editT8);
//        editT9 = (EditText) findViewById(R.id.editT9);
//        editT10 = (EditText) findViewById(R.id.editT10);
//        editT11 = (EditText) findViewById(R.id.editT11);
//        editT12 = (EditText) findViewById(R.id.editT12);
////        เบราซ์รูปภาพ
//       plus = (ImageButton) findViewById(R.id.plus);
//        เลือกประเภทกรรมสิทธิ์
//        spinnerP = (Spinner) findViewById(R.id.spinnerP);
//        checkbox ให้เลือก
        checkbox1 = (CheckBox) findViewById(R.id.checkbox1);
        checkbox2 = (CheckBox) findViewById(R.id.checkbox2);
        checkbox3 = (CheckBox) findViewById(R.id.checkbox3);
        checkbox4 = (CheckBox) findViewById(R.id.checkbox4);
        checkbox5 = (CheckBox) findViewById(R.id.checkbox5);
        checkbox6 = (CheckBox) findViewById(R.id.checkbox6);
//        ปุ่มเบราซ์ รูปภาพเข้า
//        buttonB = (Button) findViewById(R.id.buttonB);
//        buttonS = (Button) findViewById(R.id.buttonS);
//        checkbox เมนูที่เลือก
        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
    }//end get event


    public void checkboxMenu (View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox2:
                if (!checked)
                    card1.setVisibility(View.GONE);
                else
                    card1.setVisibility(View.VISIBLE);
                break;
        }
        }//end ไม่ทราบชื่อบุคคลอื่น

    public void checkboxMenu1 (View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox4:
                if (!checked)
                    card2.setVisibility(View.GONE);
                else
                    card2.setVisibility(View.VISIBLE);
                break;
        }
    }//end นิติบุคคล
}//Main Class