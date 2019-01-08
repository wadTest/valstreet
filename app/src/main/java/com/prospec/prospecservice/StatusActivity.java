package com.prospec.prospecservice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import com.prospec.prospecservice.status.LoanOfficerActivity;

public class StatusActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private WebView webBrowser;
    private Toolbar toolbar;
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

//        เรียกตัวแปรมาใช้
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        //Get Event From Click สถานะประเมิน
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StatusActivity.this, LoanOfficerActivity.class));
            }
        });


        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("สถานะงาน");
        toolbar.setSubtitle("กรอกรหัสงานเพื่อตรวจสอบสถานะ");
        toolbar.setLogo(R.drawable.logo_prospec);

        //เรียกตัวแปรมาใช้
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
}