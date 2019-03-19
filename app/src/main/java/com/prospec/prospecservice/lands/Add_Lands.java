package com.prospec.prospecservice.lands;

import android.content.Context;
import android.os.AsyncTask;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;

public class Add_Lands  {

    //    บันทึก/รับ URL ใหม่
        private static final String DATA_INSERT_URL = "http://119.59.103.121/app_mobile/assessment/lands.php";
//    private static final String DATA_INSERT_URL = "http://119.59.103.121/app_mobile/assessment/lands%20-%20Copy.php";

        //INSTANCE FIELDS
        private final Context c;

        public Add_Lands(Context c) {
            this.c = c;
        }
        //    SAVE/INSERT URL
        public void add(Lands s, final View... inputViews) {
            if (s == null) {
                Toast.makeText(c, "ไม่มีข้อมูลที่จะบันทึก", Toast.LENGTH_SHORT).show();
            } else {
                AndroidNetworking.post(DATA_INSERT_URL)
                        .addBodyParameter("action", "save")
                        .addBodyParameter("name_asset", s.getEd1())// รับ EditText
                        .addBodyParameter("name_login", s.getTw1())// รับ TextView
                        .addBodyParameter("title", s.gettTitle())// รับ TextView
                        .addBodyParameter("convert_id", s.getTnumber())// รับ TextView
                        .addBodyParameter("land_no", s.getEd2())// รับ EditText
                        .addBodyParameter("land_size", s.getEd3())// รับ EditText
                        .addBodyParameter("total_all", s.getEd4())// รับ EditText
                        .addBodyParameter("tambon_th", s.getEd5())// รับ EditText
                        .addBodyParameter("road", s.getEd6())// รับ EditText
                        .addBodyParameter("alley", s.getEd7())// รับ EditText
                        .addBodyParameter("project", s.getEd8())// รับ EditText
                        .addBodyParameter("name", s.getEd9())// รับ EditText
                        .addBodyParameter("address", s.getEd10())// รับ EditText
                        .addBodyParameter("telephone", s.getEd11())// รับ EditText

                        .addBodyParameter("land_type", s.getSp1())// รับ Spinner
                        .addBodyParameter("unit", s.getSp2())// รับ Spinner
                        .addBodyParameter("province_th", s.getSp3())// รับ Spinner
                        .addBodyParameter("amphur_th", s.getSp4())// รับ Spinner
                        .addBodyParameter("t_ownership", s.getSp5())// รับ Spinner
                        .addBodyParameter("urlImage", s.getSp6())// รับ Spinner

                        .addBodyParameter("straight", String.valueOf(s.getCb1()))// รับ Checkbox
                        .addBodyParameter("another_person", String.valueOf(s.getCb2()))// รับ Checkbox
                        .addBodyParameter("not", String.valueOf(s.getCb3()))// รับ Checkbox
                        .addBodyParameter("legal_entity", String.valueOf(s.getCb4()))// รับ Checkbox
                        .addBodyParameter("natural_person", String.valueOf(s.getCb6()))// รับ Checkbox
                        .setTag("TAG_ADD")
                        .build()
                        .getAsJSONArray(new JSONArrayRequestListener() {
                            @Override
                            public void onResponse(JSONArray response) {

                                if (response != null)
                                    try {
                                        //SHOW RESPONSE FROM SERVER
                                        String responseString = response.get(0).toString();
                                        Toast.makeText(c, "การตอบสนองของเซิร์ฟเวอร์ PHP : " + responseString, Toast.LENGTH_SHORT).show();

                                        if (responseString.equalsIgnoreCase("Success")) {
                                            //RESET VIEWS
                                            EditText nameTxt = (EditText) inputViews[0];
                                            Spinner spPropellant = (Spinner) inputViews[1];

                                            nameTxt.setText("");
                                            spPropellant.setSelection(0);
                                        } else {
                                            Toast.makeText(c, "PHP ไม่ประสบความสำเร็จ : ", Toast.LENGTH_SHORT).show();

                                        }

                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                        Toast.makeText(c, "การตอบสนองที่ดี แต่ JAVA ไม่สามารถแยก JSON มันได้รับ : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                            }

                            //ERROR
                            @Override
                            public void onError(ANError anError) {
                                //  Toast.makeText(c, "ไม่สำเร็จ: ข้อผิดพลาดคือ : " + anError.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                        });
            }
        }

}//Main Class