package com.prospec.prospecservice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MenuActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        imageView6 = (ImageView) findViewById(R.id.imageView6);


        //Get Event From Click E-mail
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, EmailActivity.class));

            }
        });

        //Get Event From Click Call
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, CallActivity.class));

            }
        });

        //Get Event From Click Menu Message
        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, MessageActivity.class));

            }
        });


        //Get Event From Click Message Facebook
        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent messageInput = openMessage(MenuActivity.this);
                startActivity(messageInput);

            }
        });

        //Get Event From Click Line
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine(MenuActivity.this);
                startActivity(lineInput);

            }
        });
    }

    public static Intent openMessage(Context context) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.facebook.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.messenger.com/t/prospecappraisal"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.messenger.com/t/prospecappraisal"));
        }
    }


    public static Intent openLine(Context context) {
        try {
            context.getPackageManager()
                    .getPackageInfo("com.line.prospec",0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/g/tMidMxvIcD"));

        }catch (Exception e){
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/g/tMidMxvIcD"));
        }
    }
}//Class Main