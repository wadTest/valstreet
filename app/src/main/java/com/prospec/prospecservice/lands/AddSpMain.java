package com.prospec.prospecservice.lands;

import android.content.Context;
import android.os.AsyncTask;
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class AddSpMain extends AsyncTask<String, Void, String>{

    private Context context;

    public AddSpMain(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {

        try {

            MyConstant myConstant = new MyConstant();
            String[] columnString1 = myConstant.getLands();


            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add(columnString1[0], strings[0])
                    .add(columnString1[1], strings[1])
                    .add(columnString1[2], strings[2])
                    .add(columnString1[3], strings[3])
                    .add(columnString1[4], strings[4])
                    .add(columnString1[5], strings[5])
                    .add(columnString1[6], strings[6])
                    .add(columnString1[7], strings[7])
                    .add(columnString1[8], strings[8])
                    .add(columnString1[9], strings[9])
                    .add(columnString1[10], strings[10])
                    .add(columnString1[11], strings[11])
                    .build();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[12]).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();
            return  response.body().string();



        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }//Method
}//Main Class
