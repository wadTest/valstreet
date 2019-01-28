package com.prospec.prospecservice;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private Toolbar toolbar;
    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8,
            editText9, editText10, editText11, editText12, editText13, editText14, editText15, editText16,
            editText17, editText18, editText19, editText20, editText21, editText22, editText23, editText24,
            editText25, editText26, editText27, editText28, editText29, editText30, editText31, editText32,
            editText33, editText34, editText35, editText36, editText37, editText38, editText39, editText40,
            editText41, editText42, editText43, editText44, editText45;
    //    ช่องให้กรอกแปลงที่...
    private EditText editTextPanng1, editTextPanng2, editTextPanng3, editTextPanng4, editTextPanng5;

    private Button btn_send;
    private static final String URL = "http://119.59.103.121/app_mobile/InsertData.php";
    //    ประกาศเพื่อเก็บข้อมูลที่กรอก
    private String asset_id, land_id, asset_name, land_type, convert_id, province_th, amphur_th,
            tambon_th, road, alley, land_no, land_size, total_all, explanation, day, objective, company, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_building);

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

//        เป็นการ findViewById ทั้งหมดในตัว activity_land_building
        onBindView();

//        กำหนด Event ให้กับตัว button
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                เมื่อ click แล้วจะเรียก Method onEditText
                onEditText();
                onButtonClick();
            }
        });
    }//Method

    private void onBindView() {
//       Get Even
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        editText24 = (EditText) findViewById(R.id.editText24);
        editText25 = (EditText) findViewById(R.id.editText25);

        editTextPanng1 = (EditText) findViewById(R.id.editTextPanng1);



        btn_send = (Button) findViewById(R.id.btn_send);
    }//onBindView

    //    การนำข้อมูลจากช่องที่กรอกทั้งหมดเอามาเก็บไว้ในตัวแปร
    private void onEditText() {
        asset_id = editText1.getText().toString().trim();
        asset_name = editText2.getText().toString().trim();
        convert_id = editText3.getText().toString().trim();
        province_th = editText4.getText().toString().trim();
        amphur_th = editText5.getText().toString().trim();
        tambon_th = editText6.getText().toString().trim();
        road = editText7.getText().toString().trim();
        alley = editText8.getText().toString().trim();
        land_type = editText9.getText().toString().trim();
        land_no = editText10.getText().toString().trim();
        land_size = editText11.getText().toString().trim();
        land_type = editText12.getText().toString().trim();
        land_no = editText13.getText().toString().trim();
        land_size = editText14.getText().toString().trim();
        land_type = editText15.getText().toString().trim();
        land_no = editText16.getText().toString().trim();
        land_size = editText17.getText().toString().trim();
        land_type = editText18.getText().toString().trim();
        land_no = editText19.getText().toString().trim();
        land_size = editText20.getText().toString().trim();
        land_type = editText21.getText().toString().trim();
        land_no = editText22.getText().toString().trim();
        land_size = editText23.getText().toString().trim();
        total_all = editText24.getText().toString().trim();
        explanation = editText25.getText().toString().trim();
        day = editText26.getText().toString().trim();
        objective = editText27.getText().toString().trim();
        company = editText28.getText().toString().trim();
        price = editText29.getText().toString().trim();
        day = editText30.getText().toString().trim();
        objective = editText31.getText().toString().trim();
        company = editText32.getText().toString().trim();
        price = editText33.getText().toString().trim();
        day = editText34.getText().toString().trim();
        objective = editText35.getText().toString().trim();
        company = editText36.getText().toString().trim();
        price = editText37.getText().toString().trim();
        day = editText38.getText().toString().trim();
        objective = editText39.getText().toString().trim();
        company = editText40.getText().toString().trim();
        price = editText41.getText().toString().trim();
        day = editText42.getText().toString().trim();
        objective = editText43.getText().toString().trim();
        company = editText44.getText().toString().trim();
        price = editText45.getText().toString().trim();
        land_id = editTextPanng1.getText().toString().trim();
        land_id = editTextPanng2.getText().toString().trim();
        land_id = editTextPanng3.getText().toString().trim();
        land_id = editTextPanng4.getText().toString().trim();
        land_id = editTextPanng5.getText().toString().trim();

    }//onEditText

    //        Method นี้จะเช็คว่า ข้อมูลจากตัวแปร onEditText
    private void onButtonClick() {
//เป็นการ เช็คว่ามีการกรอกข้อมูลจริงหรือเปล่า
        if (!asset_id.isEmpty() && !land_id.isEmpty() && !asset_name.isEmpty() && !land_type.isEmpty()
                && !convert_id.isEmpty() && !province_th.isEmpty() && !amphur_th.isEmpty() && !tambon_th.isEmpty() && !road.isEmpty()
                && !alley.isEmpty() && !land_no.isEmpty() && !land_size.isEmpty() && !total_all.isEmpty() && !explanation.isEmpty()
                && !day.isEmpty() && !objective.isEmpty() && !company.isEmpty() && !price.isEmpty()) {
            RequestQueue requestQueue = Volley.newRequestQueue(this);
//            การเพิ่มข้อมูลขึ้นไป โดย Method ที่เรียกคือ POST และ URL
            StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
//                Response คือการตอบกลับ ข้อมูลที่เรากรอก
                public void onResponse(String response) {
                    Log.d("onResponse", response);

//                    ถ้าไม่กรอกก็จะไม่ทำการโพสข้อมูลเข้าไป
                    editText1.setText("");
                    editText2.setText("");
                    editText3.setText("");
                    editText4.setText("");
                    editText5.setText("");
                    editText6.setText("");
                    editText7.setText("");
                    editText8.setText("");
                    editText9.setText("");
                    editText10.setText("");
                    editText11.setText("");
                    editText12.setText("");
                    editText13.setText("");
                    editText14.setText("");
                    editText15.setText("");
                    editText16.setText("");
                    editText17.setText("");
                    editText18.setText("");
                    editText19.setText("");
                    editText20.setText("");
                    editText21.setText("");
                    editText22.setText("");
                    editText23.setText("");
                    editText24.setText("");
                    editText25.setText("");
                    editText26.setText("");
                    editText27.setText("");
                    editText28.setText("");
                    editText29.setText("");
                    editText30.setText("");
                    editText31.setText("");
                    editText32.setText("");
                    editText33.setText("");
                    editText34.setText("");
                    editText35.setText("");
                    editText36.setText("");
                    editText37.setText("");
                    editText38.setText("");
                    editText39.setText("");
                    editText40.setText("");
                    editText41.setText("");
                    editText42.setText("");
                    editText43.setText("");
                    editText44.setText("");
                    editText45.setText("");

                    editTextPanng1.setText("");
                    editTextPanng2.setText("");
                    editTextPanng3.setText("");
                    editTextPanng4.setText("");
                    editTextPanng5.setText("");

                    Toast.makeText(LandBuildingActivity.this, "เพิ่มข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.d("onError", error.toString());
                    Toast.makeText(LandBuildingActivity.this, "เกิดข้อผิดพลาดโปรดลองอีกครั้ง", Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
//                กำหนดคีย์และข้อมูลที่เราต้องการอัพขึ้นไป
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<String, String>();
//                    job_id แรกคือมาจาก php , job_id มาจากตัวแปรในหน้า (Method onEditText)
                    params.put("asset_id", asset_id);
                    params.put("asset_name", asset_name);
                    params.put("convert_id", convert_id);
                    params.put("province_th", province_th);
                    params.put("amphur_th", amphur_th);
                    params.put("tambon_th", tambon_th);
                    params.put("road", road);
                    params.put("alley", alley);
                    params.put("land_type", land_type);
                    params.put("land_no", land_no);
                    params.put("land_size", land_size);
                    params.put("total_all", total_all);
                    params.put("explanation", explanation);
                    params.put("day", day);
                    params.put("objective", objective);
                    params.put("company", company);
                    params.put("price", price);
                    params.put("land_id", land_id);

                    return params;
                }
            };
            requestQueue.add(request);
        }

    }//onButtonClick
}//Main Class