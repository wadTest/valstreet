package com.prospec.prospecservice.building;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AddBuilding extends AsyncTask<Void, Void, String> {

    //Explicit ประกาศตัวแปร
    private Context context;
    //ประกาศตัวแปรที่เป็นค่าคงที่ ไม่สารถแก้ไขได้
    private static final String urlBuilding = "http://119.59.103.121/app_mobile/assessment/buildings.php";
    private String editT1String, editT2String, editT3String, editT4String, editT5String, editT6String, editT7String, editT8String, editT9String, editT10String,
            editT11String, editT12String, editT13String, editT14String, editT15String, editT16String, editT17String, editT18String, editT19String, editT20String;

    public AddBuilding(Context context, String editT1String, String editT2String, String editT3String,
                       String editT4String, String editT5String, String editT6String, String editT7String,
                       String editT8String, String editT9String, String editT10String, String editT11String,
                       String editT12String, String editT13String, String editT14String, String editT15String,
                       String editT16String, String editT17String, String editT18String, String editT19String, String editT20String) {
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
        this.editT14String = editT14String;
        this.editT15String = editT15String;
        this.editT16String = editT16String;
        this.editT17String = editT17String;
        this.editT18String = editT18String;
        this.editT19String = editT19String;
        this.editT20String = editT20String;
    }


    //    doInBackground คือ Method ที่ทำงานอยู่เบื้องหลัง
    @Override
    protected String doInBackground(Void... voids) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
//            requestBody การฝูกเป็นช่องเดียวกัน
            RequestBody requestBody = new FormEncodingBuilder()

                    .add("isAdd", "true")
                    .add("asset_id", editT1String)
                    .add("asset_type", editT2String)
                    .add("land_no", editT3String)
                    .add("land_sum", editT4String)
                    .add("land_all", editT5String)
                    .add("province_th", editT6String)
                    .add("amphur_th", editT7String)
                    .add("tambon_th", editT8String)
                    .add("road", editT9String)
                    .add("alley", editT10String)
                    .add("project", editT11String)
                    .add("building_all", editT12String)
                    .add("constituent", editT13String)
                    .add("category", editT14String)
                    .add("structure_n", editT15String)
                    .add("building_id", editT16String)
                    .add("building_age", editT17String)
                    .add("area", editT18String)
                    .add("total_all", editT19String)
                    .add("t_ownership", editT20String)
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlBuilding).post(requestBody).build();
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