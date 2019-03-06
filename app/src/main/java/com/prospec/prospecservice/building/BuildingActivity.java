package com.prospec.prospecservice.building;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.prospec.prospecservice.R;
import com.prospec.prospecservice.utility.MyAlert;

public class BuildingActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private EditText editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10,
            editT11, editT12, editT13, editT14, editT15, editT16, editT17, editT18, editT19, editT20;
    private String editT1String, editT2String, editT3String, editT4String, editT5String, editT6String, editT7String, editT8String, editT9String, editT10String,
            editT11String, editT12String, editT13String, editT14String, editT15String, editT16String, editT17String, editT18String, editT19String, editT20String;
    //    private Spinner spinner1, spinner2, spinner3, spinner4;
    private Toolbar toolbar;

    private Button Save;
    //   private ImageButton plus;
//    private CheckBox checkbox1, checkbox2, checkbox3, checkbox4, checkbox5, checkbox6;
    //    private Button buttonB, buttonS;
//    private CardView card1, card2;
//    private LinearLayout parentLinearLayout, parentLinearLayout1;
    //    ส่วนของการget ชื่อ มาแสดง
//    private TextView tv_name;
//    private String nameLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_building);


        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ที่ดินพร้อมสิ่งปลูกสร้าง");
        toolbar.setSubtitle("โปรดกรอกรายละเอียดในช่องว่าง");
        // toolbar.setLogo(R.drawable.logo_prospec);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
        editT11 = (EditText) findViewById(R.id.editT11);
        editT12 = (EditText) findViewById(R.id.editT12);
        editT13 = (EditText) findViewById(R.id.editT13);
        editT14 = (EditText) findViewById(R.id.editT14);
        editT15 = (EditText) findViewById(R.id.editT15);
        editT16 = (EditText) findViewById(R.id.editT16);
        editT17 = (EditText) findViewById(R.id.editT17);
        editT18 = (EditText) findViewById(R.id.editT18);
        editT19 = (EditText) findViewById(R.id.editT19);
        editT20 = (EditText) findViewById(R.id.editT20);

        Save = (Button) findViewById(R.id.Save);

        Save.setOnClickListener(new View.OnClickListener() {
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
                editT11String = editT11.getText().toString().trim();
                editT12String = editT12.getText().toString().trim();
                editT13String = editT13.getText().toString().trim();
                editT14String = editT14.getText().toString().trim();
                editT15String = editT15.getText().toString().trim();
                editT16String = editT16.getText().toString().trim();
                editT17String = editT17.getText().toString().trim();
                editT18String = editT18.getText().toString().trim();
                editT19String = editT19.getText().toString().trim();
                editT20String = editT20.getText().toString().trim();


                if (editT1String.equals("") || editT2String.equals("") || editT3String.equals("") || editT4String.equals("")
                        || editT5String.equals("") || editT6String.equals("") || editT7String.equals("") || editT8String.equals("")
                        || editT9String.equals("") || editT10String.equals("") || editT11String.equals("") || editT12String.equals("")
                        ) {

                    MyAlert myAlert = new MyAlert(BuildingActivity.this, "มีช่องว่าง", "กรุณากรอกข้อมูลในช่องว่าง");
                    myAlert.myDialog();

                } else {
//                    upload ข้อมูลที่กรอกไปเก็บไว้ใน my sql
                    uploadString();
                }
            }//onClick

            private void uploadString() {
                try {
                    AddBuilding addBuilding = new AddBuilding(BuildingActivity.this, editT1String, editT2String,
                            editT3String, editT4String, editT5String, editT6String, editT7String, editT8String, editT9String, editT10String,
                            editT11String, editT12String, editT13String, editT14String, editT15String,
                            editT16String, editT17String, editT18String, editT19String, editT20String);
                    addBuilding.execute();

                    Toast.makeText(BuildingActivity.this, "อัพโหลดข้อมูลสำเร็จ", Toast.LENGTH_SHORT).show();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }//Method
}//Main Class