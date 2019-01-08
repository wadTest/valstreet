package com.prospec.prospecservice.utility;

import android.content.Context;
import android.os.AsyncTask;
import android.content.Context;
import android.os.AsyncTask;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class Add_Status extends AsyncTask<Void, Void, String> {

        //Explicit ประกาศตัวแปร
        private Context context1;
        //ประกาศตัวแปรที่เป็นค่าคงที่ ไม่สารถแก้ไขได้
        private static final String urlStatus = "http://119.59.103.121/app_mobile/CRM_status_lo.php";
    private String Text1String, Text2String;


    public Add_Status(Context context1, String text1String, String text2String) {
        this.context1 = context1;
        Text1String = text1String;
        Text2String = text2String;
    }

        //    doInBackground คือ Method ที่ทำงานอยู่เบื้องหลัง
        @Override
        protected String doInBackground(Void... voids) {
            try {

                OkHttpClient okHttpClient = new OkHttpClient();
//            requestBody การฝูกเป็นช่องเดียวกัน
                RequestBody requestBody = new FormEncodingBuilder()

                        .add("email", Text1String)
                        .add("password", Text2String)
                        .build();

                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlStatus).post(requestBody).build();
                Response response = okHttpClient.newCall(request).execute();
//            ถ้าทำงานสำเร็จให้ return ค่า
                return  response.body().string();

            } catch (Exception e) {
                e.printStackTrace();
//            ทำงานไม่สำเร็จ
                return null;
            }

        }//Method
    }//Main Class

