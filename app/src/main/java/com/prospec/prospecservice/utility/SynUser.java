package com.prospec.prospecservice.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

//ทำการสืบทอด
public class SynUser extends AsyncTask<Void, Void, String> {
    //    ประกาศตัวแปร
    private Context context;
//    ทำการดึง JSON
    private static final String urlJSON = "http://119.59.103.121/app_mobile/get.data.php";

    public SynUser(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {

            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlJSON).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
//            ถ้าทำงานไม่สำเร็จให้return null
            return null;
        }
    }//Method

}//Main Class
