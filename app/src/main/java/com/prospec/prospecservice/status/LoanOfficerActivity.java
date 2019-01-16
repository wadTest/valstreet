package com.prospec.prospecservice.status;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import com.prospec.prospecservice.R;
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

// หน้านี้เป็นการดึงข้อมูลจาก LoanOfficer1,2,3 มาแสดง
public class LoanOfficerActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loan_officer);

// Permission StrictMode
        if (android.os.Build.VERSION.SDK_INT > 9) {
//            อนุญาต กำหนด policy
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

// listView1 ดึงข้อมูลแบบ JSON array
        final ListView lisView1 = (ListView) findViewById(R.id.listView1);
        String url = "http://119.59.103.121/app_mobile/crm_status_button1.php";
        try {
//            รับ JSON Url ในรูปแบบ Array ชื่อurl
            JSONArray data = new JSONArray(getJSONUrl(url));
            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);
                map = new HashMap<String, String>();
//                ชื่อ column ในตาราง db1 ของ mysql
                map.put("job_no", c.getString("job_no"));
                map.put("job_event", c.getString("job_event"));
                map.put("customer_name", c.getString("customer_name"));
                map.put("marketing", c.getString("marketing"));
                MyArrList.add(map);

            }
//           เรียก layout activity_column_loan เพื่อเชื่อมต่อกับ database
            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(LoanOfficerActivity.this, MyArrList, R.layout.activity_column_loan,
//                    เชื่อมต่อตัวแปร mysql กับ layout  ด้วย id
                    new String[]{"job_no", "customer_name", "job_event", "marketing"},
                    new int[]{R.id.Col, R.id.Col1, R.id.Col2, R.id.Col3});
            lisView1.setAdapter(sAdap);

            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);

//            OnClick Item
            lisView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> myAdapter, View myView,
                                        int position, long mylng) {
//                    job_no แรกคือเป็นการกำหนดstring ,job_no สองคือชื่อคอลัมที่นำมาจากdatabase mysql จาก table da1
                    String job_no = MyArrList.get(position).get("job_no").toString();
                    String customer_name = MyArrList.get(position).get("customer_name").toString();
                    String job_event = MyArrList.get(position).get("job_event").toString();
                    String marketing = MyArrList.get(position).get("marketing").toString();
//                  กรณีคลิกที่ตัวใดตัวนึง จะขึ้น popup รายละเอียด เจ้าหน้าที่สินเชื่อ นั้นๆ
                    viewDetail.setIcon(android.R.drawable.btn_star_big_on);
                    viewDetail.setTitle("รายละเอียดเจ้าหน้าที่สินเชื่อ");
                    viewDetail.setMessage("รหัสงาน : " + job_no + "\n\n"
                            + "ชื่อลูกค้า : " + customer_name + "\n\n"
                            + "สถานะงาน : " + job_event + "\n\n"
                            + "เจ้าหน้าที่การตลาด : " + marketing);

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

//    รับค่า JSON url
    public String getJSONUrl(String url) {
//        ตัวสร้างสตริง --> str
        StringBuilder str = new StringBuilder();
//        http ไคลเอ็นต์ --> client
        HttpClient client = new DefaultHttpClient();
//        รับ Http --> httpGet
        HttpGet httpGet = new HttpGet(url);
        try {
//            การตอบสนอง HTTP --> response = httpGet
            HttpResponse response = client.execute(httpGet);
//            รับ Line Status
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
//            ถ้า รหัสสถานะ == 200 ให้ getEntity, getContent
            if (statusCode == 200) { // Download OK
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
//                ในขณะที่ line = reader ให้หลีกเลี่ยงการตรวจสอบ
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
}//Main