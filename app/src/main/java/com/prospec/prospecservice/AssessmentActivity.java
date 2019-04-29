package com.prospec.prospecservice;

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
        String url = "http://119.59.103.121/app_mobile/status_corporate.php";
        try {
            JSONArray data = new JSONArray(getJSONUrl(url));
            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;
            for(int i = 0; i < data.length(); i++){
                JSONObject c = data.getJSONObject(i);
                map = new HashMap<String, String>();
//                ชื่อ column ในตาราง db_corp ของ mysql
                map.put("name_asset", c.getString("name_asset"));
                map.put("convert_id", c.getString("convert_id"));
                map.put("land_no", c.getString("land_no"));
//                map.put("Value_Price", c.getString("Value_Price"));
//                map.put("Asset_name", c.getString("Asset_name"));
                MyArrList.add(map);

            }
//           เรียก layout activity_column_ass เพื่อเชื่อมต่อกับ database
            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(AssessmentActivity.this, MyArrList, R.layout.activity_column_ass,
//                    , "Value_Price", "Asset_name"
                    new String[] {"name_asset", "convert_id", "land_no"},
//                    R.id.Col,, R.id.Col4
                    new int[] {R.id.Col1, R.id.Col2, R.id.Col3});
            lisView1.setAdapter(sAdap);

            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);

//            OnClick Item
            lisView1.setOnItemClickListener(new OnItemClickListener() {

                public void onItemClick(AdapterView<?> myAdapter, View myView,
                                        int position, long mylng) {

                    String name_asset= MyArrList.get(position).get("name_asset").toString();
                    String convert_id = MyArrList.get(position).get("convert_id").toString();
                    String land_no = MyArrList.get(position).get("land_no").toString();
//                    String Value_Price = MyArrList.get(position).get("Value_Price").toString();
//                    String Asset_name = MyArrList.get(position).get("Asset_name").toString();
//                  กรณีคลิกที่ตัวใดตัวนึง จะขึ้น popup รายละเอียด Corporate นั้นๆ
                    viewDetail.setIcon(android.R.drawable.btn_star_big_on);
                    viewDetail.setTitle("รายละเอียด Corporate");
                    viewDetail.setMessage("ชื่อทรัพย์: " + name_asset + "\n\n"
                            + "เอกสารสิทธิ์จำนวน(แปลง) : " + convert_id + "\n\n"
//                            + "เอกสารสิทธิ์จำนวน(แปลง) : " + Assign_Date + "\n\n"
//                            + "เนื้อที่ : " + Value_Price + "\n\n"
                            + "เนื้อที่ : " + land_no);
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