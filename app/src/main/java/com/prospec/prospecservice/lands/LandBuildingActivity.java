package com.prospec.prospecservice.lands;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.prospec.prospecservice.R;
import com.prospec.prospecservice.utility.MyAlert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

//class ที่ดินเปล่า
public class LandBuildingActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private EditText editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10;
    private String editT1String, editT2String, editT3String, editT4String, editT5String, editT6String, editT7String, editT8String, editT9String, editT10String;
    private Spinner spinner1, spinner2, spinner3, spinner4;

    private Button buttonSave;
    //   private ImageButton plus;
    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;
    //    private Button buttonB, buttonS;
    private CardView card1, card2;
    private LinearLayout parentLinearLayout;
    //    ส่วนของการget ชื่อ มาแสดง
    private TextView tv_name;
    private String nameLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_building);

        SharedPreferences sharedPreferences = getSharedPreferences("Logout", MODE_PRIVATE);
        nameLogin = sharedPreferences.getString("NameLogin", "");
        Log.d("20JanV1", "nameLogin Receive in MenuActivity ==> " + nameLogin);

        toolbar();

        getevent();

        addremove();

        address();

        savedata();


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

    //    ส่วนของการกดบวก ลบ
    private void addremove() {
        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
    }

    //    เมื่อกดบวก
    public void onAddField(View v) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = inflater.inflate(R.layout.field, null);
        // เป็นการเพิ่มแถวใหม่ก่อนปุ่มเพิ่มฟิลด์
        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
    }

    //    เมื่อกดลบ
    public void onDelete(View v) {
        parentLinearLayout.removeView((View) v.getParent());
    }

    //    get DB. sql มาแสดงในส่วนของที่อยู่
    private void address() {

        // Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

//        getevent autoAddress
        final AutoCompleteTextView autoAddress = (AutoCompleteTextView) findViewById(R.id.address);

//        url php
        String url = "http://119.59.103.121/app_mobile/get%20spinner.php";

        try {

            JSONArray data = new JSONArray(getJSONUrl(url));

            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                map = new HashMap<String, String>();
                map.put("tambon_th", c.getString("tambon_th") + "\n");
                map.put("amphur_th", c.getString("amphur_th") + "\n");
                map.put("province_th", c.getString("province_th"));
                MyArrList.add(map);
            }

            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(LandBuildingActivity.this, MyArrList, R.layout.activity_column,
                    new String[]{"tambon_th", "amphur_th", "province_th"},
                    new int[]{R.id.ColMemberID, R.id.ColName, R.id.ColTel});
            autoAddress.setAdapter(sAdap);

            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }


    public String getJSONUrl(String url) {
        StringBuilder str = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200) { // Download OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null) {
                    str.append(line);
                }
            } else {
                Log.e("Log", "Failed to download result..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();

    }

    private void getevent() {
//        กรอกข้อมูล
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
        buttonSave = (Button) findViewById(R.id.buttonSave);

////        เบราซ์รูปภาพ
//       plus = (ImageButton) findViewById(R.id.plus);
//        เลือกประเภทกรรมสิทธิ์
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
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
//        แสดงชื่อในกรณี click checkbox ตรงตามชื่อก่อนหน้า
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setText("ชื่อก่อนหน้า : " + nameLogin.trim());
    }//end get event


    public void checkboxName(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox1:
                if (!checked)
                    tv_name.setVisibility(View.GONE);
                else
                    tv_name.setVisibility(View.VISIBLE);
                break;
        }
    }//end ไม่ทราบชื่อบุคคลอื่น

    public void checkboxMenu(View view) {
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

    public void checkboxMenu1(View view) {
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

    //    เก็บข้อมูลที่กรอกไปยัง Server
    private void savedata() {
        buttonSave.setOnClickListener(new View.OnClickListener() {
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

                if (editT1String.equals("") || editT2String.equals("") || editT3String.equals("") || editT4String.equals("")
                        || editT5String.equals("") || editT6String.equals("") || editT7String.equals("")) {

                    MyAlert myAlert = new MyAlert(LandBuildingActivity.this, "มีช่องว่าง", "กรุณากรอกข้อมูลในช่องว่าง");
                    myAlert.myDialog();

                } else {
//                    upload ข้อมูลที่กรอกไปเก็บไว้ใน my sql
                    uploadString();
                }
            }//onClick

            private void uploadString() {
                try {
                    Add_Lands add_lands = new Add_Lands(LandBuildingActivity.this, editT1String, editT2String,
                            editT3String, editT4String, editT5String, editT6String, editT7String, editT8String, editT9String, editT10String);
                    add_lands.execute();

                    Toast.makeText(LandBuildingActivity.this, "อัพโหลดข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}//Main Class