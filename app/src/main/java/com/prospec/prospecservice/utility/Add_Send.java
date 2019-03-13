package com.prospec.prospecservice.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class Add_Send extends AsyncTask<Void, Void, String> {

    //Explicit ประกาศตัวแปร
    private Context context;
    //ประกาศตัวแปรที่เป็นค่าคงที่ ไม่สารถแก้ไขได้
    private static final String urlSendAss= "http://119.59.103.121/app_mobile/send_ass.php";
    private String ed1String, ed2String, ed3String, ed4String, ed5String, ed6String, ed7String;


    public Add_Send(Context context, String ed1String, String ed2String, String ed3String,
                    String ed4String, String ed5String, String ed6String, String ed7String) {
        this.context = context;
        this.ed1String = ed1String;
        this.ed2String = ed2String;
        this.ed3String = ed3String;
        this.ed4String = ed4String;
        this.ed5String = ed5String;
        this.ed6String = ed6String;
        this.ed7String = ed7String;
    }

    //    doInBackground คือ Method ที่ทำงานอยู่เบื้องหลัง
    @Override
    protected String doInBackground(Void... voids) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
//            requestBody การฝูกเป็นช่องเดียวกัน
            RequestBody requestBody = new FormEncodingBuilder()

                    .add("isAdd", "true")
                    .add("Assign_Date", ed1String)
                    .add("objective", ed2String)
                    .add("Apply", ed3String)
                    .add("Value_Price", ed4String)
                    .add("evaluation_company", ed5String)
                    .add("Asset_name", ed6String)
                    .add("sender", ed7String)
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlSendAss).post(requestBody).build();
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

