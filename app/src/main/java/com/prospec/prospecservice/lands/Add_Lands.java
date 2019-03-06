package com.prospec.prospecservice.lands;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class Add_Lands extends AsyncTask<Void, Void, String> {

    //Explicit ประกาศตัวแปร
    private Context context;
    //ประกาศตัวแปรที่เป็นค่าคงที่ ไม่สารถแก้ไขได้
    private static final String urlLands= "http://119.59.103.121/app_mobile/assessment/lands.php";
    private String editT1String, editT2String, editT3String, editT4String, editT5String, editT6String, editT7String, editT8String, editT9String, editT10String;

    public Add_Lands(Context context, String editT1String, String editT2String,
                     String editT3String, String editT4String, String editT5String,
                     String editT6String, String editT7String, String editT8String,
                     String editT9String, String editT10String) {
        this.context = context;
        this.editT1String = editT1String;
        this.editT2String = editT2String;
        this.editT3String = editT3String;
        this.editT4String = editT4String;
        this.editT5String = editT5String;
        this.editT6String = editT6String;
        this.editT7String = editT7String;
        this.editT8String = editT8String;
        this.editT9String = editT9String;
        this.editT10String = editT10String;
    }

    //    doInBackground คือ Method ที่ทำงานอยู่เบื้องหลัง
    @Override
    protected String doInBackground(Void... voids) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
//            requestBody การฝูกเป็นช่องเดียวกัน
            RequestBody requestBody = new FormEncodingBuilder()

                    .add("isAdd", "true")
                    .add("convert_id", editT1String)
                    .add("land_no", editT2String)
                    .add("land_sum", editT3String)
                    .add("total_all", editT4String)
                    .add("road", editT5String)
                    .add("alley", editT6String)
                    .add("project", editT7String)
                    .add("name", editT8String)
                    .add("address", editT9String)
                    .add("telephone", editT10String)
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlLands).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
//            ถ้าทำงานสำเร็จให้ return ค่า
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
//            ทำงานไม่สำเร็จ
            return null;
        }

    }//Method
}//Main Class