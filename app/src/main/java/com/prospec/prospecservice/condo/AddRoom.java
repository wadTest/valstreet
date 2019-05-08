package com.prospec.prospecservice.condo;

import android.content.Context;
import android.os.AsyncTask;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AddRoom  extends AsyncTask<Void, Void, String> {

    //Explicit ประกาศตัวแปร
    private Context context;
    //ประกาศตัวแปรที่เป็นค่าคงที่ ไม่สารถแก้ไขได้
    private static final String urlCondo = "http://119.59.103.121/app_mobile/crm_condos.php";
    private String editT1String, editT2String, editT3String, editT4String, editT5String, editT6String, editT7String,
            editT8String, editT9String, editT10String, editT11String, editT12String, editT13String;

    public AddRoom(Context context, String editT1String, String editT2String, String editT3String, String editT4String,
                   String editT5String, String editT6String, String editT7String, String editT8String, String editT9String,
                   String editT10String, String editT11String, String editT12String, String editT13String) {

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
        this.editT11String = editT11String;
        this.editT12String = editT12String;
        this.editT13String = editT13String;
    }

    //    doInBackground คือ Method ที่ทำงานอยู่เบื้องหลัง
    @Override
    protected String doInBackground(Void... voids) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
//            requestBody การฝูกเป็นช่องเดียวกัน
            RequestBody requestBody = new FormEncodingBuilder()

                    .add("isAdd", "true")
                    .add("room_id", editT1String)
                    .add("bulding_number", editT2String)
                    .add("room_no", editT3String)
                    .add("floor", editT4String)
                    .add("room_sum", editT5String)
                    .add("room_all", editT6String)
                    .add("province_th", editT7String)
                    .add("amphur_th", editT8String)
                    .add("tambon_th", editT9String)
                    .add("road", editT10String)
                    .add("alley", editT11String)
                    .add("project", editT12String)
                    .add("t_ownership", editT13String)
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlCondo).post(requestBody).build();
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