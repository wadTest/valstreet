package com.prospec.prospecservice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuAssetActivity extends AppCompatActivity {

    //  Explicit  ประกาศตัวแปร
    private Button button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_asset);

        //        Bind Widget
        button1 = (Button) findViewById(R.id.button1);

        //Get Event From Click Land
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuAssetActivity.this, LandBuildingActivity.class));

            }
        });
    }
}
