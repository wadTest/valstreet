package com.prospec.prospecservice;

//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.NameValuePair;
//import org.apache.http.StatusLine;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.entity.UrlEncodedFormEntity;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.message.BasicNameValuePair;
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import android.os.Bundle;
//import android.os.StrictMode;
//import android.annotation.SuppressLint;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.content.DialogInterface;
//import android.util.Log;
//import android.view.View;
//import android.view.Menu;
//import android.widget.AdapterView;
//import android.widget.AdapterView.OnItemClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.SimpleAdapter;
//
//public class AssessmentActivity extends Activity {

//    @SuppressLint("NewApi")
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_assessment);
//// Permission StrictMode
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
//        final Button btn1 = (Button) findViewById(R.id.button1);
//
//// Perform action on click
//        btn1.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                SearchData();
//            }
//        });
//
//    }
//
//    public void SearchData() {
//// listView1
//        final ListView lisView1 = (ListView) findViewById(R.id.listView1);
//// editText1
//        final EditText inputText = (EditText) findViewById(R.id.editText1);
//        String url = "http://119.59.103.121/app_mobile/crm_status_search.php";
//// Paste Parameters
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("txtKeyword", inputText.getText().toString()));
//        try {
//
//            JSONArray data = new JSONArray(getJSONUrl(url, params));
//            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
//            HashMap<String, String> map;
//
//            for (int i = 0; i < data.length(); i++) {
//
//                JSONObject c = data.getJSONObject(i);
//
//                map = new HashMap<String, String>();
//                map.put("Corporate", c.getString("Corporate"));
//                map.put("Site", c.getString("Site"));
//                map.put("Job_No", c.getString("Job_No"));
//                map.put("Assign_Date", c.getString("Assign_Date"));
//                map.put("Value_Price", c.getString("Value_Price"));
//                map.put("Asset_name", c.getString("Asset_name"));
//                MyArrList.add(map);
//
//            }
//
//            SimpleAdapter sAdap;
//            sAdap = new SimpleAdapter(AssessmentActivity.this, MyArrList, R.layout.activity_column_ass,
//
//                    new String[]{"Corporate","Site", "Job_No", "Assign_Date", "Value_Price", "Asset_name"},
//                    new int[]{R.id.sc, R.id.Col, R.id.Col1, R.id.Col2, R.id.Col3, R.id.Col4});
//            lisView1.setAdapter(sAdap);
//
//            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);
//
//// OnClick Item
//
//            lisView1.setOnItemClickListener(new OnItemClickListener() {
//                public void onItemClick(AdapterView<?> myAdapter, View myView,
//                                        int position, long mylng) {
//
//                    String Corporate = MyArrList.get(position).get("Corporate").toString();
//                    String Site = MyArrList.get(position).get("Site").toString();
//                    String Job_No = MyArrList.get(position).get("Job_No").toString();
//                    String Assign_Date = MyArrList.get(position).get("Assign_Date").toString();
//                    String Value_Price = MyArrList.get(position).get("Value_Price").toString();
//                    String Asset_name = MyArrList.get(position).get("Asset_name").toString();
//
//                    viewDetail.setIcon(android.R.drawable.btn_star_big_on);
//                    viewDetail.setTitle("รายละเอียด Corporate");
//                    viewDetail.setMessage("Corporate : " + Corporate + "\n"
//                            + "Site : " + Site + "\n"
//                            + "รหัสงาน : " + Job_No + "\n"
//                            + "วันที่ : " + Assign_Date + "\n"
//                            + "มูลค่า : " + Value_Price + "\n"
//                            + "ทรัพย์สิน : " + Asset_name );
//                    viewDetail.setPositiveButton("ตกลง",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog,
//                                                    int which) {
//// TODO Auto-generated method stub
//                                    dialog.dismiss();
//                                }
//                            });
//
//                    viewDetail.show();
//                }
//            });
//
//
//        } catch (JSONException e) {
//// TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//
//    public String getJSONUrl(String url, List<NameValuePair> params) {
//        StringBuilder str = new StringBuilder();
//        HttpClient client = new DefaultHttpClient();
//        HttpPost httpPost = new HttpPost(url);
//        try {
//            httpPost.setEntity(new UrlEncodedFormEntity(params));
//            HttpResponse response = client.execute(httpPost);
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
//                Log.e("Log", "ไม่สามารถดาวน์โหลดไฟล์..");
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return str.toString();
//    }//Method
//}//Main Class


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

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

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class AssessmentActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessment);
// Permission StrictMode

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
// listView1 ดึงข้อมูลแบบ JSON array

        final ListView lisView1 = (ListView)findViewById(R.id.listView1);
        String url = "http://119.59.103.121/app_mobile/crm_status_corporate.php";
        try {
            JSONArray data = new JSONArray(getJSONUrl(url));
            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;
            for(int i = 0; i < data.length(); i++){
                JSONObject c = data.getJSONObject(i);
                map = new HashMap<String, String>();
//                ชื่อ column ในตาราง db_corp ของ mysql
                map.put("Site", c.getString("Site"));
                map.put("Job_No", c.getString("Job_No"));
                map.put("Assign_Date", c.getString("Assign_Date"));
                map.put("Value_Price", c.getString("Value_Price"));
                map.put("Asset_name", c.getString("Asset_name"));
                MyArrList.add(map);

            }
//           เรียก layout activity_column_ass เพื่อเชื่อมต่อกับ database
            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(AssessmentActivity.this, MyArrList, R.layout.activity_column_ass,

            new String[] {"Site", "Job_No", "Assign_Date", "Value_Price", "Asset_name"},
                    new int[] {R.id.Col, R.id.Col1, R.id.Col2, R.id.Col3, R.id.Col4});
            lisView1.setAdapter(sAdap);

            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);

//            OnClick Item
            lisView1.setOnItemClickListener(new OnItemClickListener() {

                public void onItemClick(AdapterView<?> myAdapter, View myView,
                                        int position, long mylng) {

                    String Site= MyArrList.get(position).get("Site").toString();
                    String Job_Noe = MyArrList.get(position).get("Job_No").toString();
                    String Assign_Date = MyArrList.get(position).get("Assign_Date").toString();
                    String Value_Price = MyArrList.get(position).get("Value_Price").toString();
                    String Asset_name = MyArrList.get(position).get("Asset_name").toString();
//                  กรณีคลิกที่ตัวใดตัวนึง จะขึ้น popup รายละเอียด Corporate นั้นๆ
                    viewDetail.setIcon(android.R.drawable.btn_star_big_on);
                    viewDetail.setTitle("รายละเอียด Corporate");
                    viewDetail.setMessage("Site: " + Site + "\n"
                            + "รหัสงาน : " + Job_Noe + "\n"
                            + "วันที่ : " + Assign_Date + "\n"
                            + "มูลค่า : " + Value_Price + "\n"
                            + "ทรัพย์สิน : " + Asset_name);
                    viewDetail.setPositiveButton("ตกลง",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,
                                            int which) {

// TODO Auto-generated method stub
                            dialog.dismiss();
                        }
                    });
                    viewDetail.show();
                }
            });
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
                Log.e("Log", "ดาวน์โหลดผลลัพธ์ไม่สำเร็จ..");
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }//Method
}//Main Class