package com.prospec.prospecservice;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.prospec.prospecservice.utility.GetDb2WhereNameLoginThread;
import com.prospec.prospecservice.utility.MyConstant;


public class StatusActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private WebView webBrowser;
    private Toolbar toolbar;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

//        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("สถานะงาน");
        toolbar.setSubtitle("กรอกรหัสงานเพื่อตรวจสอบสถานะ");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

//        รับกิจกรรม
        getEvent();
//        เรียกตัวแปรมาใช้
        init();
//        เรียก web มาใช้
        browse();
    }

    public void init() {
        webBrowser = (WebView) findViewById(R.id.webBrowser1);
        webBrowser.setWebViewClient(new WebViewClient());
    }

    public void browse() {
        WebSettings webSettings = webBrowser.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webBrowser.loadUrl("http://119.59.103.121/crm");
    }

    private void getEvent() {
//               เรียกตัวแปรมาใช้
        button1 = (Button) findViewById(R.id.button1);

        SharedPreferences sharedPreferences = getSharedPreferences("Logout", MODE_PRIVATE);
        String nameLogin = sharedPreferences.getString("NameLogin", "");
        Log.d("20JanV2", "nameLogin ==> " + nameLogin);

        MyConstant myConstant = new MyConstant();

        try {

            GetDb2WhereNameLoginThread getDb2WhereNameLoginThread = new GetDb2WhereNameLoginThread(StatusActivity.this);
            getDb2WhereNameLoginThread.execute(nameLogin.trim(), myConstant.getUrlGetdb1WhereNameLogin());

            final String jsonString = getDb2WhereNameLoginThread.get();
            Log.d("20JanV2", "JSoN ==> " + jsonString);


            //        Get Event From Click สถานะสินเชื่อ
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (jsonString.equals("null")) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(StatusActivity.this);

//                เรียก layout custom_layout มาใช้งาน
                        View view = LayoutInflater.from(StatusActivity.this).inflate(R.layout.custom_layout, null);

//                Get Event ตัวแปรนี้มาจาก layout custom_layout
                        TextView title = (TextView) view.findViewById(R.id.title);
                        ImageButton imageButton = (ImageButton) view.findViewById(R.id.image);

//                หัวข้อ toolbat
                        title.setText("Prospec Appraisal");

//                photo ที่โชว์อยู่ใน dailog (บรรทัดนี้ ยังไม่นำไปใช้งาน)
//                imageButton.setImageResource(R.drawable.logo_prospec); ยังไม่เอาไปใช้งาน

                        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });

//                กรณีที่อยากให้มีคำว่า "ยกเลิก"
                        builder.setNegativeButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });

                        builder.setView(view);
                        builder.show();

                    } else {
                        Intent intent = new Intent(StatusActivity.this, MyStatusActivity.class);
                        intent.putExtra("index", 0);
                        startActivity(intent);
                    }

                }   // onClick
            });// Button สินเชื่อ


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}   //  Main Class