package com.prospec.prospecservice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MenuActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5, imageView6;
    ViewFlipper imageShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        imageShow = findViewById(R.id.imageShow);
        int images[] = {R.drawable.test1, R.drawable.test2, R.drawable.test3};



        for (int image : images){
            flipperImages(image);
        }
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        imageShow.addView(imageView);
        imageShow.setFlipInterval(5000); //3วิ
        imageShow.setAutoStart(true);

//        ภาพเคลื่อนไหว
        imageShow.setInAnimation(this,android.R.anim.slide_in_left);
        imageShow.setInAnimation(this,android.R.anim.slide_out_right);


//       ปุ่มกดไปหน้าต่างๆ
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

        //Get Event From Click Menu Message
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, LineActivity.class));

            }
        });

        //Get Event From Click Call
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, CallActivity.class));

            }
        });

        //Get Event From Click Status
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, StatusActivity.class));

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

//        //Get Event From Click Line
//        imageView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent lineInput = openLine(MenuActivity.this);
//                startActivity(lineInput);
//
//            }
//        });
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


//    public static Intent openLine(Context context) {
//        try {
//            context.getPackageManager()
//                    .getPackageInfo("com.line.prospec",0);
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://line.me/R/ti/p/%40wgm8703w"));
//
//        }catch (Exception e){
//            return new Intent(Intent.ACTION_VIEW,
//                    Uri.parse("https://line.me/R/ti/p/%40wgm8703w"));
//        }
//    }
}//Class Main