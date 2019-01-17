package com.prospec.prospecservice.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.prospec.prospecservice.SignInActivity;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

//สิ่งนี้จะพยายามต่อเน็ตให้ได้
public class AddUserToServer extends AsyncTask<Void, Void, String> {

    //Explicit ประกาศตัวแปร
    private Context c;
    //ประกาศตัวแปรที่เป็นค่าคงที่ ไม่สารถแก้ไขได้
    private static final String urlPHP = "http://119.59.103.121/app_mobile/signup_crm.php";
    private String et_nameString, et_lastString, et_phoneString, et_emailString, et_passwordString;

    public AddUserToServer(Context c, String et_nameString, String et_lastString, String et_phoneString, String et_emailString, String et_passwordString) {
        this.c = c;
        this.et_nameString = et_nameString;
        this.et_lastString = et_lastString;
        this.et_phoneString = et_phoneString;
        this.et_emailString = et_emailString;
        this.et_passwordString = et_passwordString;
    }


    //    doInBackground คือ Method ที่ทำงานอยู่เบื้องหลัง
    @Override
    protected String doInBackground(Void... voids) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
//            requestBody การฝูกเป็นช่องเดียวกัน
            RequestBody requestBody = new FormEncodingBuilder()

                    .add("isAdd", "true")
                    .add("name", et_nameString)
                    .add("last_name", et_lastString)
                    .add("telephone", et_phoneString)
                    .add("email", et_emailString)
                    .add("password", et_passwordString)
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
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