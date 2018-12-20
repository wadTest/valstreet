package com.prospec.prospecservice;
//
//
//
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//public class StatusActivity extends AppCompatActivity {
//
//    private WebView webview;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_status);
//
//        webview = (WebView) findViewById(R.id.webview);
//        WebSettings webSettings = webview.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webview.loadUrl("http://119.59.103.121/crm");
//
//        //http://119.59.103.121/crm
//
//    }
//}

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class StatusActivity extends AppCompatActivity {

    private WebView webBrowser;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

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
