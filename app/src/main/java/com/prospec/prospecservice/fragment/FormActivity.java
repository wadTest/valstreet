package com.prospec.prospecservice.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;

import com.prospec.prospecservice.R;


public class FormActivity extends AppCompatActivity {

    //    Explicit
    private int indexAnInt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

//        Get Index
        getIndex();

//        Add Fragment
        if (savedInstanceState == null) {

            switch (indexAnInt) {

                case 0:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.contentFormLandFragment, new LandsFragment())
                            .commit();
                    break;
            }
        }


    }//Main method

    private void getIndex() {
        indexAnInt = getIntent().getIntExtra("Index",0);
        Log.d("check", "index ==>" + indexAnInt);
    }
}//Main Class
