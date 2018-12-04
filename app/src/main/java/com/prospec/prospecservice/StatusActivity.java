package com.prospec.prospecservice;

//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.widget.ArrayAdapter;
//import android.widget.AutoCompleteTextView;
//import android.widget.EditText;



//import android.graphics.Bitmap;
//import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import com.asksira.webviewsuite.WebViewSuite;
//import android.webkit.WebView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class StatusActivity extends AppCompatActivity {

    private WebView webview;


//    //  Explicit  ประกาศตัวแปร
//    private EditText editName, editLast;

//    WebViewSuite webViewSuite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status);

        webview = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("http://www.prospec.co.th/prospec/Valuation-Purposes");

    }
}
//
//
//        webViewSuite = (WebViewSuite) findViewById(R.id.webViewSuite);
//
//        // webViewSuite.refresh(); to refresh a webview
//
//        webViewSuite.customizeClient(new WebViewSuite.WebViewSuiteCallback() {
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                //Do your own stuffs. These will be executed after default onPageStarted().
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                //Do your own stuffs. These will be executed after default onPageFinished().
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //Override those URLs you need and return true.
//                //Return false if you don't need to override that URL.
//
//                return false;
//            }
//        });
//    }
//
//    @Override
//    public void onBackPressed() {
//        if (!webViewSuite.goBackIfPossible()) {
//            super.onBackPressed();
//        }
//    }
//}
//
//        //        Bind Widget
//        editName = (EditText) findViewById(R.id.editName);
//        editLast = (EditText) findViewById(R.id.editLast);
//
//        //        ข้อความขึ้นอัตโนมัติ รายชื่อธนาคาร
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
//                android.R.layout.simple_dropdown_item_1line, CATEGORIES);
//        AutoCompleteTextView nameTV = (AutoCompleteTextView)
//                findViewById(R.id.editBank);
//
//        nameTV.setAdapter(adapter1);
//    }//Method Main
//    private static final String[] CATEGORIES = new String[]{
//            " ธนาคารพัฒนาวิสาหกิจขนาดกลางและขนาดย่อมแห่งประเทศไทย",
//            " ธนาคารเพื่อการเกษตรและสหกรณ์การเกษตร",
//            "ธนาคารเพื่อการส่งออก และนำเข้าแห่งประเทศไทย",
//            "ธนาคารออมสิน",
//            "ธนาคารอาคารสงเคราะห์",
//            "ธนาคารอิสลามแห่งประเทศไทย",
//            "ธนาคารกรุงไทย จำกัดมหาชน",
//            "ธนาคารทหารไทย จำกัดมหาชน",
//            "ธนาคารกรุงเทพ จำกัดมหาชน",
//            "ธนาคารกรุงศรีอยุธยา จำกัดมหาชน",
//            "ธนาคารกสิกรไทย จำกัดมหาชน",
//            "ธนาคารเกียรตินาคิน จำกัดมหาชน",
//            "ธนาคารซิตี้แบงก์",
//            "ธนาคารทิสโก้ จำกัดมหาชน",
//            "ธนาคารซีไอเอ็มบี ไทย จำกัด มหาชน",
//            "ธนาคารไทยพาณิชย์ จำกัดมหาชน",
//            "ธนาคารธนชาต จำกัดมหาชน",
//            "ธนาคารนครหลวงไทย จำกัดมหาชน",
//            "ธนาคารยูโอบี จำกัดมหาชน",
//            "ธนาคารสแตนดาร์ดชาร์เตอร์ดไทย จำกัดมหาชน",
//            "ธนาคารสินเอเซีย จำกัดมหาชน",
//            "ธนาคารจีอี มันนี่ เพื่อรายย่อย จำกัด",
//            "ธนาคารแลนด์ แอนด์ เฮ้าส์ เพื่อรายย่อย",
//            "ธนาคารไทยเครดิต เพื่อรายย่อย",
//            "ธนาคารไอซีบีซี ไทย จำกัด มหาชน",
//            "ธนาคารแห่งประเทศจีนไทย จำกัด มหาชน",
//            "ธนาคารแห่งประเทศไทย",
//            "ธนาคารไทยธนาคาร จำกัด มหาชน",
//            "ธนาคาร อาร์ เอช บี จำกัด"};
//    }//Class Main