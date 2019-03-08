package com.prospec.prospecservice.lands;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
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
    private TextInputEditText edit1, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9, edit10, edit11;
    private Spinner spin1, spin2, spin3, spin4, spin5, spin6;
    private CheckBox check1, check2, check3, check4, check5, check6;
    private Button Add;

    //    ตัวแปร + - จำนวนแปลง
    private LinearLayout parentLinearLayout;
    //    ตัวแปรในส่วนของการทำให้ โชว์ ซ้อน
    private CardView card1, card2;
    //    ส่วนของการget ชื่อ มาแสดง
    private TextView tv_name;
    private String nameLogin;

    private View LinearOne, LinearTwo, LinearThree,  LinearFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_building);

        SharedPreferences sharedPreferences = getSharedPreferences("Logout", MODE_PRIVATE);
        nameLogin = sharedPreferences.getString("NameLogin", "");
        Log.d("20JanV1", "nameLogin Receive in MenuActivity ==> " + nameLogin);

        this.toolbar();

        this.getevent();

        this.addremove();

        this.address();

        savedata();

//        redioGruup();

        spinner1();
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

//        getevent autoAddress (AutoComplete)
//        final AutoCompleteTextView autoAddress = (AutoCompleteTextView) findViewById(R.id.address);
//
////        url php
//        String url = "http://119.59.103.121/app_mobile/get%20spinner.php";
//
//        try {
//
//            JSONArray data = new JSONArray(getJSONUrl(url));
//
//            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
//            HashMap<String, String> map;
//
//            for (int i = 0; i < data.length(); i++) {
//                JSONObject c = data.getJSONObject(i);
//
//                map = new HashMap<String, String>();
//                map.put("tambon_th", c.getString("tambon_th") + "\n");
//                map.put("amphur_th", c.getString("amphur_th") + "\n");
//                map.put("province_th", c.getString("province_th"));
//                MyArrList.add(map);
//            }
//
//            SimpleAdapter sAdap;
//            sAdap = new SimpleAdapter(LandBuildingActivity.this, MyArrList, R.layout.activity_column,
//                    new String[]{"tambon_th", "amphur_th", "province_th"},
//                    new int[]{R.id.ColMemberID, R.id.ColName, R.id.ColTel});
//            autoAddress.setAdapter(sAdap);
//
//            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);
//
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//    public String getJSONUrl(String url) {
//        StringBuilder str = new StringBuilder();
//        HttpClient client = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(url);
//        try {
//            HttpResponse response = client.execute(httpGet);
//            StatusLine statusLine = response.getStatusLine();
//            int statusCode = statusLine.getStatusCode();
//            if (statusCode == 200) { // Download OK
//                HttpEntity entity = response.getEntity();
//                InputStream content = entity.getContent();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    str.append(line);
//                }
//            } else {
//                Log.e("Log", "Failed to download result..");
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return str.toString();

    }

    private void getevent() {
//        กรอกข้อมูล
        edit1 = (TextInputEditText) findViewById(R.id.editT1);
        edit2 = (TextInputEditText) findViewById(R.id.editT2);
        edit3 = (TextInputEditText) findViewById(R.id.editT3);
        edit4 = (TextInputEditText) findViewById(R.id.editT4);
        edit5 = (TextInputEditText) findViewById(R.id.editT5);
        edit6 = (TextInputEditText) findViewById(R.id.editT6);
        edit7 = (TextInputEditText) findViewById(R.id.editT7);
        edit8 = (TextInputEditText) findViewById(R.id.editT8);
        edit9 = (TextInputEditText) findViewById(R.id.editT9);
        edit10 = (TextInputEditText) findViewById(R.id.editT10);
        edit11 = (TextInputEditText) findViewById(R.id.editT11);
        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);
        check3 = (CheckBox) findViewById(R.id.checkBox3);
        check4 = (CheckBox) findViewById(R.id.checkBox4);
        check5 = (CheckBox) findViewById(R.id.checkBox5);
        check6 = (CheckBox) findViewById(R.id.checkBox6);
        Add = (Button) findViewById(R.id.buttonSave);
        spin1 = (Spinner) findViewById(R.id.spinner1);
        spin2 = (Spinner) findViewById(R.id.spinner2);
        spin3 = (Spinner) findViewById(R.id.spinner3);
        spin4 = (Spinner) findViewById(R.id.spinner4);
        spin5 = (Spinner) findViewById(R.id.spinner5);
        spin6 = (Spinner) findViewById(R.id.spinner6);

        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
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

    private void savedata() {

        //    เก็บข้อมูลที่กรอกไปยัง Server
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //GET VALUES
                String editText1 = edit1.getText().toString().trim();
                String editText2 = edit2.getText().toString().trim();
                String editText3 = edit3.getText().toString().trim();
                String editText4 = edit4.getText().toString().trim();
                String editText5 = edit5.getText().toString().trim();
                String editText6 = edit6.getText().toString().trim();
                String editText7 = edit7.getText().toString().trim();
                String editText8 = edit8.getText().toString().trim();
                String editText9 = edit9.getText().toString().trim();
                String editText10 = edit10.getText().toString().trim();
                String editText11 = edit11.getText().toString().trim();

                String spinner1 = spin1.getSelectedItem().toString();
                String spinner2 = spin2.getSelectedItem().toString();
                String spinner3 = spin3.getSelectedItem().toString();
                String spinner4 = spin4.getSelectedItem().toString();
                String spinner5 = spin5.getSelectedItem().toString();
                String spinner6 = spin6.getSelectedItem().toString();

                Boolean checkbox1 = check1.isChecked();
                Boolean checkbox2 = check2.isChecked();
                Boolean checkbox3 = check3.isChecked();
                Boolean checkbox4 = check4.isChecked();
                Boolean checkbox5 = check5.isChecked();
                Boolean checkbox6 = check6.isChecked();

                //BASIC CLIENT SIDE VALIDATION
                if ((editText1.length() < 1 || editText2.length() < 1 || editText3.length() < 1 || editText4.length() < 1 || editText5.length() < 1
                        || editText6.length() < 1 || editText7.length() < 1 || editText8.length() < 1 || editText9.length() < 1 || editText10.length() < 1 || editText11.length() < 1
                        || spinner1.length() < 1 || spinner2.length() < 1 || spinner3.length() < 1 || spinner4.length() < 1 || spinner5.length() < 1 || spinner6.length() < 1)) {

                    Toast.makeText(LandBuildingActivity.this, "กรุณากรอกทุกช่อง", Toast.LENGTH_SHORT).show();

                } else {
                    //SAVE

                    Lands s = new Lands();
                    s.setEd1(editText1);
                    s.setEd2(editText2);
                    s.setEd3(editText3);
                    s.setEd4(editText4);
                    s.setEd5(editText5);
                    s.setEd6(editText6);
                    s.setEd7(editText7);
                    s.setEd8(editText8);
                    s.setEd9(editText9);
                    s.setEd10(editText10);
                    s.setEd11(editText11);
                    s.setSp1(spinner1);
                    s.setSp2(spinner2);
                    s.setSp3(spinner3);
                    s.setSp4(spinner4);
                    s.setSp5(spinner5);
                    s.setSp6(spinner6);
                    s.setCb1(checkbox1 ? 1 : 0);
                    s.setCb2(checkbox2 ? 1 : 0);
                    s.setCb3(checkbox3 ? 1 : 0);
                    s.setCb4(checkbox4 ? 1 : 0);
                    s.setCb5(checkbox5 ? 1 : 0);
                    s.setCb6(checkbox6 ? 1 : 0);


                    new Add_Lands(LandBuildingActivity.this).add(s,edit1, edit2, edit3, edit4, edit5, edit6,
                            edit7, edit7, edit8, edit9, edit10, edit11, spin1, spin2, spin3, spin4, spin5, spin6);
                }
            }
        });

    }//end save data

//    private void redioGruup() {
//        //    กลุ่มย่อยของ Redio Button ที่1
//        LinearOne = findViewById(R.id.LinearOne);
//        LinearTwo = findViewById(R.id.LinearTwo);
//
//        RadioGroup redioGroup1 = (RadioGroup) findViewById(R.id.redioGroup1);
//        redioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.checkBox1:
//                        select(true);
//                        break;
//                    case R.id.checkBox2:
//                        select(false);
//                        break;
//                    case R.id.checkBox6:
//                        select(false);
//                        break;
//
//
//                }
//            }
//        });
//    }
//
//
//    private void select(boolean b) {
//        tv_name.setVisibility(b ? View.GONE : View.VISIBLE);
//        LinearTwo.setVisibility(b ? View.GONE : View.VISIBLE);
//    }//end Redio Button

    private void spinner1() {

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item);

        adapter.add("เลือกเอกสารสิทธิ์");
        adapter.add("โฉนดที่ดิน");
        adapter.add("นส.3ก");
        adapter.add("นส.3");

        spin1.setAdapter(adapter);
        spin1.setSelection(0);

    }

}//Main Class
