package com.prospec.prospecservice.lands;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.prospec.prospecservice.CustomDialogActivity;
import com.prospec.prospecservice.R;
import com.prospec.prospecservice.utility.MyAlert;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;

import static android.view.View.VISIBLE;

//class ที่ดินเปล่า
public class LandBuildingActivity extends AppCompatActivity {

    //    ประกาศตัวแปร
    private TextInputEditText name, edit2, edit3, edit4, edit5, edit6, edit7, edit8, edit9, edit10, edit11;
    private Spinner spin1, spin2, spin3, spin4, spin5, spin6;
    private CheckBox check1, check2, check3, check4, check6;
    private Button Add;

    //    Add number
    private int minteger = 1;

    //    ตัวแปร + - จำนวนแปลง
    private LinearLayout Line1;
    private ImageView increase1;

    //    ตัวแปรในส่วนของการทำให้ โชว์ ซ้อน
    private CardView card1, card2;
    //    ส่วนของการget ชื่อ มาแสดง
    private TextView tv_name, title, number;
    private String nameLogin, titleLogin;

    //    ส่วนชองรูปภาพ
    Button GetImageFromGalleryButton, UploadImageOnServerButton;
    ImageView ShowSelectedImage;
    EditText imageName;
    Bitmap FixBitmap;
    String ImageTag = "image_document";
    String ImageName = "document";
    ProgressDialog progressDialog;
    ByteArrayOutputStream byteArrayOutputStream;
    byte[] byteArray;
    String ConvertImage;
    String GetImageNameFromEditText;
    HttpURLConnection httpURLConnection;
    URL url;
    OutputStream outputStream;
    BufferedWriter bufferedWriter;
    int RC;
    BufferedReader bufferedReader;
    StringBuilder stringBuilder;
    boolean check = true;
    private int GALLERY = 1, CAMERA = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_land_building);

//        share name title ที่ login
        SharedPreferences sharedPreferences = getSharedPreferences("Logout", MODE_PRIVATE);
        titleLogin = sharedPreferences.getString("titleLogin", "");
        nameLogin = sharedPreferences.getString("NameLogin", "");
        Log.d("share title, name", "get name" + titleLogin +nameLogin);

        this.toolbar();
        this.getevent();

//        this.address();

        savedata();

//        redioGruup();

        this.spinner1();
        this.spinner2();
        this.spinner3();
        this.spinner5();
        this.spinner6();
        
//        ส่วนของรูปภาพ
        Image();

//        auto tatal

//        ส่วนของรวมผลลัพธ์อัตโนมัติ
//        calculation();
    }//Method

//    private void calculation() {
//        final EditText arrayEditText = findViewById(R.id.editT3);
//        final EditText showEditText = findViewById(R.id.ed02);
//        final EditText all = findViewById(R.id.ed03);
//        final EditText addFo = findViewById(R.id.ed04);
//        final EditText addFi = findViewById(R.id.ed05);
//        final EditText thbEditText = findViewById(R.id.editT4);
//        final String[] strings = new String[]{"0", "0", "0", "0", "0"};
//
//        //        ช่องที่ 1
//        arrayEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                strings[0] = arrayEditText.getText().toString();
//                if (strings[0].isEmpty()) {
//                    strings[0] = "0";
//                }
////                sum
//                calculate(strings, thbEditText);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
////        ช่องที่ 2
//        showEditText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                strings[1] = showEditText.getText().toString();
//                if (strings[1].isEmpty()) {
//                    strings[1] = "0";
//                }
////                sum
//                calculate(strings, thbEditText);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
////        ช่องที่ 3
//        all.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                strings[2] = all.getText().toString();
//                if (strings[2].isEmpty()) {
//                    strings[2] = "0";
//                }
////                sum
//                calculate(strings, thbEditText);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        //        ช่องที่ 4
//        addFo.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                strings[3] = addFo.getText().toString();
//                if (strings[3].isEmpty()) {
//                    strings[3] = "0";
//                }
////                sum
//                calculate(strings, thbEditText);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        //        ช่องที่ 5
//        addFi.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//                strings[3] = addFi.getText().toString();
//                if (strings[4].isEmpty()) {
//                    strings[4] = "0";
//                }
////                sum
//                calculate(strings, thbEditText);
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//    }
//    private void calculate(String[] strings, EditText showEditText) {
//        int arrayInt = Integer.parseInt(strings[0]);
//        int thbInt = Integer.parseInt(strings[1]);
//        int all = Integer.parseInt(strings[2]);
//        int addFo = Integer.parseInt(strings[3]);
//        int addFi = Integer.parseInt(strings[4]);
//        int answerInt = arrayInt + thbInt + all + addFo + addFi;
//        showEditText.setText(Integer.toString(answerInt));
//    }// calculation

    private void Image() {
        GetImageFromGalleryButton = (Button)findViewById(R.id.buttonSelect);
        UploadImageOnServerButton = (Button)findViewById(R.id.buttonUpload);
        ShowSelectedImage = (ImageView)findViewById(R.id.imageView);
        byteArrayOutputStream = new ByteArrayOutputStream();
        GetImageFromGalleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showPictureDialog();
            }
        });

        UploadImageOnServerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetImageNameFromEditText = imageName.getText().toString();

                UploadImageToServer();
            }
        });
        if (ContextCompat.checkSelfPermission(LandBuildingActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{android.Manifest.permission.CAMERA},
                        5);
            }
        }
    }
    private void showPictureDialog(){
        android.support.v7.app.AlertDialog.Builder pictureDialog = new android.support.v7.app.AlertDialog.Builder(this);
        pictureDialog.setTitle("Select Action");
        String[] pictureDialogItems = {
                "Photo Gallery",
                "Camera" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallary();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }
    public void choosePhotoFromGallary() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

        startActivityForResult(galleryIntent, GALLERY);
    }

    private void takePhotoFromCamera() {
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, CAMERA);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == this.RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    FixBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    // String path = saveImage(bitmap);
                    //Toast.makeText(MainActivity.this, "Image Saved!", Toast.LENGTH_SHORT).show();
                    ShowSelectedImage.setImageBitmap(FixBitmap);
                    UploadImageOnServerButton.setVisibility(View.VISIBLE);

                } catch (IOException e) {
                    e.printStackTrace();
                    Toast.makeText(LandBuildingActivity.this, "ล้มเหลว!", Toast.LENGTH_SHORT).show();
                }
            }

        } else if (requestCode == CAMERA) {
            FixBitmap = (Bitmap) data.getExtras().get("data");
            ShowSelectedImage.setImageBitmap(FixBitmap);
            UploadImageOnServerButton.setVisibility(View.VISIBLE);
            //  saveImage(thumbnail);
            //Toast.makeText(ShadiRegistrationPart5.this, "Image Saved!", Toast.LENGTH_SHORT).show();
        }
    }

    public void UploadImageToServer(){
        FixBitmap.compress(Bitmap.CompressFormat.JPEG, 40, byteArrayOutputStream);
        byteArray = byteArrayOutputStream.toByteArray();
        ConvertImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
        class AsyncTaskUploadClass extends AsyncTask<Void,Void,String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = ProgressDialog.show(LandBuildingActivity.this,"กำลังอัพโหลดรูปภาพ","โปรดรอ",false,false);
            }

            @Override
            protected void onPostExecute(String string1) {

                super.onPostExecute(string1);

                progressDialog.dismiss();

                Toast.makeText(LandBuildingActivity.this,string1,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {

                ImageProcessClass imageProcessClass = new ImageProcessClass();

                HashMap<String,String> HashMapParams = new HashMap<String,String>();

                HashMapParams.put(ImageTag, GetImageNameFromEditText);

                HashMapParams.put(ImageName, ConvertImage);

                String FinalData = imageProcessClass.ImageHttpRequest("http://119.59.103.121/app_mobile/assessment/lands.php", HashMapParams);

                return FinalData;
            }
        }
        AsyncTaskUploadClass AsyncTaskUploadClassOBJ = new AsyncTaskUploadClass();
        AsyncTaskUploadClassOBJ.execute();
    }

    public class ImageProcessClass{

        public String ImageHttpRequest(String requestURL,HashMap<String, String> PData) {

            StringBuilder stringBuilder = new StringBuilder();

            try {
                url = new URL(requestURL);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setReadTimeout(20000);
                httpURLConnection.setConnectTimeout(20000);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                outputStream = httpURLConnection.getOutputStream();
                bufferedWriter = new BufferedWriter(

                        new OutputStreamWriter(outputStream, "UTF-8"));

                bufferedWriter.write(bufferedWriterDataFN(PData));

                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                RC = httpURLConnection.getResponseCode();

                if (RC == HttpsURLConnection.HTTP_OK) {

                    bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                    stringBuilder = new StringBuilder();

                    String RC2;

                    while ((RC2 = bufferedReader.readLine()) != null){

                        stringBuilder.append(RC2);
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return stringBuilder.toString();
        }

        private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {

            stringBuilder = new StringBuilder();

            for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {
                if (check)
                    check = false;
                else
                    stringBuilder.append("&");

                stringBuilder.append(URLEncoder.encode(KEY.getKey(), "UTF-8"));

                stringBuilder.append("=");

                stringBuilder.append(URLEncoder.encode(KEY.getValue(), "UTF-8"));
            }

            return stringBuilder.toString();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 5) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Now user should be able to use camera

            }
            else {

                Toast.makeText(LandBuildingActivity.this, "ไม่สามารถใช้กล้องถ่ายรูปได้โปรดให้เราใช้กล้องถ่ายรูป", Toast.LENGTH_LONG).show();

            }
        }
    }


    //    ส่วนของการกด บวก ลบ
    public void increaseInteger(View view) {
        minteger = minteger + 1;
        display(minteger);
    }

    public void decreaseInteger(View view) {
        minteger = minteger - 1;
        display(minteger);
    }

    private void display(int number) {
        TextView displayInteger = (TextView) findViewById(
                R.id.number);
        displayInteger.setText("" + number);
    }


    private void toolbar() {
        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ที่ดินเปล่า");
        toolbar.setSubtitle("โปรดกรอกรายละเอียดที่ดินเปล่า");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }//end toolbar

//    //    ส่วนของการกดบวก ลบ
//    private void addremove() {
//        parentLinearLayout = (LinearLayout) findViewById(R.id.parent_linear_layout);
//    }
//
//    //    เมื่อกดบวก
//    public void onAddField(View v) {
//        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        final View rowView = inflater.inflate(R.layout.field, null);
//        // เป็นการเพิ่มแถวใหม่ก่อนปุ่มเพิ่มฟิลด์
//        parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 1);
//    }
//
//    //    เมื่อกดลบ
//    public void onDelete(View v) {
//        parentLinearLayout.removeView((View) v.getParent());
//    }
//
//    //    get DB. sql มาแสดงในส่วนของที่อยู่
//    private void address() {
//
//        // Permission StrictMode
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }

//        getevent autoAddress (AutoComplete)
//        final AutoCompleteTextView autoAddress = (AutoCompleteTextView) findViewById(R.id.address);
//
////        url php
//        String url = "http://119.59.103.121/app_mobile/get%20spinner.php";
//
//        try {
//
//            JSONArray data = new JSONArray(getJSONUrl(url));
//
//            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
//            HashMap<String, String> map;
//
//            for (int i = 0; i < data.length(); i++) {
//                JSONObject c = data.getJSONObject(i);
//
//                map = new HashMap<String, String>();
//                map.put("tambon_th", c.getString("tambon_th") + "\n");
//                map.put("amphur_th", c.getString("amphur_th") + "\n");
//                map.put("province_th", c.getString("province_th"));
//                MyArrList.add(map);
//            }
//
//            SimpleAdapter sAdap;
//            sAdap = new SimpleAdapter(LandBuildingActivity.this, MyArrList, R.layout.activity_column,
//                    new String[]{"tambon_th", "amphur_th", "province_th"},
//                    new int[]{R.id.ColMemberID, R.id.ColName, R.id.ColTel});
//            autoAddress.setAdapter(sAdap);
//
//            final AlertDialog.Builder viewDetail = new AlertDialog.Builder(this);
//
//        } catch (JSONException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
//
//    public String getJSONUrl(String url) {
//        StringBuilder str = new StringBuilder();
//        HttpClient client = new DefaultHttpClient();
//        HttpGet httpGet = new HttpGet(url);
//        try {
//            HttpResponse response = client.execute(httpGet);
//            StatusLine statusLine = response.getStatusLine();
//            int statusCode = statusLine.getStatusCode();
//            if (statusCode == 200) { // Download OK
//                HttpEntity entity = response.getEntity();
//                InputStream content = entity.getContent();
//                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    str.append(line);
//                }
//            } else {
//                Log.e("Log", "Failed to download result..");
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return str.toString();

//    }

    private void getevent() {
//        กรอกข้อมูล
        number = (TextView) findViewById(R.id.number);
        name = (TextInputEditText) findViewById(R.id.name);
        edit2 = (TextInputEditText) findViewById(R.id.editT2);
        edit3 = (TextInputEditText) findViewById(R.id.editT3);
        edit4 = (TextInputEditText) findViewById(R.id.editT4);
        edit5 = (TextInputEditText) findViewById(R.id.editT5);
        edit6 = (TextInputEditText) findViewById(R.id.editT6);
        edit7 = (TextInputEditText) findViewById(R.id.editT7);
        edit8 = (TextInputEditText) findViewById(R.id.editT8);
        edit9 = (TextInputEditText) findViewById(R.id.editT9);
        edit10 = (TextInputEditText) findViewById(R.id.editT10);
        edit11 = (TextInputEditText) findViewById(R.id.editT11);
        check1 = (CheckBox) findViewById(R.id.checkBox1);
        check2 = (CheckBox) findViewById(R.id.checkBox2);
        check3 = (CheckBox) findViewById(R.id.checkBox3);
        check4 = (CheckBox) findViewById(R.id.checkBox4);
        check6 = (CheckBox) findViewById(R.id.checkBox6);
        Add = (Button) findViewById(R.id.buttonSave);
        spin1 = (Spinner) findViewById(R.id.spinner1);
        spin2 = (Spinner) findViewById(R.id.spinner2);
        spin3 = (Spinner) findViewById(R.id.spinner3);
        spin4 = (Spinner) findViewById(R.id.spinner4);
        spin5 = (Spinner) findViewById(R.id.spinner5);
        spin6 = (Spinner) findViewById(R.id.spinner6);


        card1 = (CardView) findViewById(R.id.card1);
        card2 = (CardView) findViewById(R.id.card2);
//        ชื่อคนที่login
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_name.setText(nameLogin.trim());
//        title TB :uers_app_crm
        title = (TextView) findViewById(R.id.title);
        title.setText(titleLogin.trim());

//        + -
        increase1 = (ImageView) findViewById(R.id.increase1);
        Line1 = (LinearLayout) findViewById(R.id.Line1);

    }//end get event


    public void checkboxName(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox1:
                if (!checked)
                    tv_name.setVisibility(View.GONE);
                else
                    tv_name.setVisibility(VISIBLE);
                break;
        }
    }//end ไม่ทราบชื่อบุคคลอื่น

    public void checkboxMenu(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox2:
                if (!checked)
                    card1.setVisibility(View.GONE);
                else
                    card1.setVisibility(VISIBLE);
                break;
        }
    }//end ไม่ทราบชื่อบุคคลอื่น

    public void checkboxMenu1(View view) {

        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox4:
                if (!checked)
                    card2.setVisibility(View.GONE);
                else
                    card2.setVisibility(VISIBLE);
                break;
        }
    }//end นิติบุคคล

    private void savedata() {

        //    เก็บข้อมูลที่กรอกไปยัง Server
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //GET VALUES
                String text = tv_name.getText().toString();
                String textTitle = title.getText().toString();
                String tnumber = number.getText().toString().trim();

                String nameS = name.getText().toString().trim();
                String editText2 = edit2.getText().toString().trim();
                String editText3 = edit3.getText().toString().trim();
                String editText4 = edit4.getText().toString().trim();
                String editText5 = edit5.getText().toString().trim();
                String editText6 = edit6.getText().toString().trim();
                String editText7 = edit7.getText().toString().trim();
                String editText8 = edit8.getText().toString().trim();
                String editText9 = edit9.getText().toString().trim();
                String editText10 = edit10.getText().toString().trim();
                String editText11 = edit11.getText().toString().trim();

                String spinner1 = spin1.getSelectedItem().toString();
                String spinner2 = spin2.getSelectedItem().toString();
                String spinner3 = spin3.getSelectedItem().toString();
                String spinner4 = spin4.getSelectedItem().toString();
                String spinner5 = spin5.getSelectedItem().toString();
                String spinner6 = spin6.getSelectedItem().toString();

//                String sp02 = sp2.getSelectedItem().toString();
//                String sp03 = sp3.getSelectedItem().toString();
//                String sp04 = sp4.getSelectedItem().toString();
//                String sp05 = sp5.getSelectedItem().toString();

                Boolean checkbox1 = check1.isChecked();
                Boolean checkbox2 = check2.isChecked();
                Boolean checkbox3 = check3.isChecked();
                Boolean checkbox4 = check4.isChecked();
                Boolean checkbox6 = check6.isChecked();


                //BASIC CLIENT SIDE VALIDATION
                if ((nameS.length()<1 || editText2.length() < 1 || editText3.length() < 1 || editText5.length() < 1
                        || editText6.length() < 1 || editText7.length() < 1 || editText8.length() < 1
                        || spinner1.length() < 1 || spinner2.length() < 1 || spinner3.length() < 1 || spinner4.length() < 1
                        || spinner5.length() < 1 || spinner6.length() < 1)) {

                    MyAlert myAlert = new MyAlert(LandBuildingActivity.this, "มีช่องว่าง", "กรุณากรอกข้อมูลในช่องว่าง");
                    myAlert.myDialog();

                } else {

                    //SAVE
                    Lands s = new Lands();
                    s.setTw1(text);
                    s.settTitle(textTitle);
                    s.setTnumber(tnumber);
                    s.setEd1(nameS);
                    s.setEd2(editText2);
                    s.setEd3(editText3);
                    s.setEd4(editText4);
                    s.setEd5(editText5);
                    s.setEd6(editText6);
                    s.setEd7(editText7);
                    s.setEd8(editText8);
                    s.setEd9(editText9);
                    s.setEd10(editText10);
                    s.setEd11(editText11);
                    s.setSp1(spinner1);
                    s.setSp2(spinner2);
                    s.setSp3(spinner3);
                    s.setSp4(spinner4);
                    s.setSp5(spinner5);
                    s.setSp6(spinner6);
                    s.setCb1(checkbox1 ? 1 : 0);
                    s.setCb2(checkbox2 ? 1 : 0);
                    s.setCb3(checkbox3 ? 1 : 0);
                    s.setCb4(checkbox4 ? 1 : 0);
                    s.setCb6(checkbox6 ? 1 : 0);

                    new Add_Lands(LandBuildingActivity.this).add(s, tv_name, title, number, name, edit2, edit3, edit4, edit5, edit6,
                            edit7, edit7, edit8, edit9, edit10, edit11, spin1, spin2, spin3, spin4, spin5, spin6);
                }
            }
        });

    }//end save data

    private void spinner1() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

        adapter.add("เลือกเอกสารสิทธิ์");
        adapter.add("โฉนดที่ดิน");
        adapter.add("นส.3ก");
        adapter.add("นส.3");

        spin1.setAdapter(adapter);
        spin1.setSelection(0);

    }

    private void spinner2() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

        adapter.add("เลือกประเภท");
        adapter.add("ไร่-งาน-ตารางวา");
        adapter.add("ตารางวา");
        adapter.add("ตารางเมตร");

        spin2.setAdapter(adapter);
        spin2.setSelection(0);

    }

    private void spinner3() {

        String[] strings = new String[]{"เลือกจังหวัด", "กระบี่", "กรุงเทพมหานคร", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี", "ฉะเชิงเทรา", "ชลบุรี"
                , "ชัยนาท", "ชัยภูมิ", "ชุมพร", "ตรัง", "ตราด", "ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช", "นครสวรรค์", "นนทบุรี", "นราธิวาส",
                "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี", "พระนครศรีอยุธยา", "พะเยา", "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "ภูเก็ต", "มหาสารคาม",
                "มุกดาหาร", "ยะลา", "ยโสธร", "ระนอง", "ระยอง", "ราชบุรี", "ร้อยเอ็ด", "ลพบุรี", "ลำปาง", "ลำพูน", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล", "สมุทรปราการ", "สมุทรสงคราม",
                "สมุทรสาคร", "สระบุรี", "สระแก้ว", "สิงห์บุรี", "สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "สุโขทัย", "หนองคาย", "หนองบัวลำภู", "อำนาจเจริญ", "อุดรธานี",
                "อุตรดิตถ์", "อุทัยธานี", "อุบลราชธานี", "อ่างทอง", "เชียงราย", "เชียงใหม่", "เพชรบุรี", "เพชรบูรณ์", "เลย", "แพร่", "แม่ฮ่องสอน", "ประจวบคีรีขันธ์", "ชุมพร"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(LandBuildingActivity.this,
                android.R.layout.simple_list_item_1, strings);
        spin3.setAdapter(stringArrayAdapter);
        stringArrayAdapter.setDropDownViewResource(R.layout.spinner_item);

        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                createSpinnerAmper(position); // เชื่อมต่อมายังอำเภอ createSpinnerAmper
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    //  อำเภอของ 77จังหวัด
    private void createSpinnerAmper(int position) {
        String[] mainAmperStrings = new String[79];
        mainAmperStrings[0] = "เลือกอำเภอ/เขต";
        mainAmperStrings[1] = "เลือกอำเภอ/เขต,คลองท่อม,ปลายพระยา,ลำทับ,อ่าวลึก,เกาะลันตา,เขาพนม,เมืองกระบี่,เหนือคลอง";
        mainAmperStrings[2] = "คลองสาน,คลองสาน,คลองสามวา,คลองเตย,คันนายาว,จตุจักร,จอมทอง,ดอนเมือง,ดินแดง,ดุสิต,ตลิ่งชัน,ทวีวัฒนาทุ่งครุ,ธนบุรี,บางกอกน้อย,บางกอกใหญ่,บางกะปิ,บางขุนเทียน,บางคอแหลม,บางซื่อ,บางบอน,บางพลัด" +
                ",บางรัก,บางเขน,บางแค,บึงกุ่ม,ปทุมวัน,ประเวศ,ป้อมปราบศัตรูพ่าย,พญาไท,พระนคร,พระโขนง,ภาษีเจริญ,มีนบุรี,ยานนาวา,ราชเทวี,ราษฎร์บูรณะ,ลาดกระบัง,ลาดพร้าว,วังทองหลาง,วัฒนา,สวนหลวง,สะพานสูง,สัมพันธวงศ์,สาทร,สายไหม,หนองจอก,หนองแขม,หลักสี่,ห้วยขวาง";
        mainAmperStrings[3] = "ด่านมะขามเตี้ย,ทองผาภูมิ,ท่ามะกา,ท่าม่วง,บ่อพลอย,พนมทวน,ศรีสวัสดิ์,สังขละบุรี,หนองปรือ,ห้วยกระเจา,เมืองกาญจนบุรี,เลาขวัญ,ไทรโยค";
        mainAmperStrings[4] = "กมลาไสย,กุฉินารายณ์,คำม่วง,ฆ้องชัย,ดอนจาน,ท่าคันโท,นาคู,นามน,ยางตลาด,ร่องคำ,สมเด็จ,สหัสขันธ์,สามชัย,หนองกุงศรี,ห้วยผึ้ง,ห้วยเม็ก,เขาวง,เมืองกาฬสินธุ์";
        mainAmperStrings[5] = "ขาณุวรลักษบุรี,คลองขลุง,คลองลาน,ทรายทองวัฒนา,บึงสามัคคี,ปางศิลาทอง,พรานกระต่าย,ลานกระบือ,เมืองกำแพงเพชร,โกสัมพีนคร,ไทรงาม";
        mainAmperStrings[6] = "กระนวน,ชนบท,ชุมแพ,ซำสูง,น้ำพอง,บ้านฝาง,บ้านแฮด,บ้านไผ่,พระยืน,พล,ภูผาม่าน,ภูเวียง,มัญจาคีรี,สีชมพู,หนองนาคำ,หนองสองห้อง,หนองเรือ,อุบลรัตน์,เขาสวนกวาง,เปือยน้อย,เมืองขอนแก่น,แวงน้อย,โคกโพธิ์ไชย,โนนศิลา";
        mainAmperStrings[7] = "ขลุง,ท่าใหม่,นายายอาม,มะขาม,สอยดาว,เขาคิชฌกูฏ,เมืองจันทบุรี,แก่งหางแมว,แหลมสิงห์,โป่งน้ำร้อน";
        mainAmperStrings[8] = "คลองเขื่อน,ท่าตะเกียบ,บางคล้า,บางน้ำเปรี้ยว,บางปะกง,บ้านโพธิ์,พนมสารคาม,ราชสาส์น,สนามชัยเขต,เมืองฉะเชิงเทรา,แปลงยาว";
        mainAmperStrings[9] = "บางละมุง,บ่อทอง,บ้านบึง,พนัสนิคม,พานทอง,ศรีราชา,สัตหีบ,หนองใหญ่,เกาะจันทร์,เกาะสีชัง,เมืองชลบุรี";
        mainAmperStrings[10] = "มโนรมย์,วัดสิงห์,สรรคบุรี,สรรพยา,หนองมะโมง,หันคา,เนินขาม,เมืองชัยนาท";
        mainAmperStrings[11] = "คอนสวรรค์,คอนสาร,จัตุรัส,ซับใหญ่,บำเหน็จณรงค์,บ้านเขว้า,บ้านแท่น,ภักดีชุมพล,ภูเขียว,หนองบัวระเหว,หนองบัวแดง,เกษตรสมบูรณ์,เทพสถิต,เนินสง่า,เมืองชัยภูมิ,แก้งคร้อ";
        mainAmperStrings[12] = "ทุ่งตะโก,ท่าแซะ,ปะทิว,พะโต๊ะ,ละแม,สวี,หลังสวน,เมืองชุมพร";
        mainAmperStrings[13] = "ขุนตาล,ดอยหลวง,ป่าแดด,พญาเม็งราย,พาน,เชียงของ,เชียงแสน,เทิง,เมืองเชียงราย,เวียงชัย,เวียงป่าเป้า,เวียงเชียงรุ้ง,เวียงแก่น,แม่จัน,แม่ฟ้าหลวง,แม่ลาว,แม่สรวย,แม่สาย";
        mainAmperStrings[14] = "กัลยาณิวัฒนา,จอมทอง,ดอยสะเก็ด,ดอยหล่อ,ดอยเต่า,ฝาง,พร้าว,สะเมิง,สันกำแพง,สันทราย,สันป่าตอง,สารภี,หางดง,อมก๋อย,ฮอด,เชียงดาว,เมืองเชียงใหม่,เวียงแหง,แม่ริม,แม่วาง,แม่ออน,แม่อาย,แม่แจ่ม,แม่แตง,ไชยปราการ";
        mainAmperStrings[15] = "กันตัง,นาโยง,ปะเหลียน,ย่านตาขาว,รัษฎา,วังวิเศษ,สิเกา,หาดสำราญ,ห้วยยอด,เมืองตรัง";
        mainAmperStrings[16] = "เกาะกูด,เกาะช้าง,เขาสมิง,คลองใหญ่,บ่อไร่,เมืองตราด,แหลมงอบ";
        mainAmperStrings[17] = "ท่าสองยาง,บ้านตาก,พบพระ,วังเจ้า,สามเงา,อุ้มผาง,เมืองตาก,แม่ระมาด,แม่สอด";
        mainAmperStrings[18] = "บ้านนา,ปากพลี,องครักษ์,เมืองนครนายก";
        mainAmperStrings[19] = "กำแพงแสน,ดอนตูม,นครชัยศรี,บางเลน,พุทธมณฑล,สามพราน,เมืองนครปฐม";
        mainAmperStrings[20] = "ท่าอุเทน,ธาตุพนม,นาทม,นาหว้า,นาแก,บ้านแพง,ปลาปาก,วังยาง,ศรีสงคราม,เมืองนครพนม,เรณูนคร,โพนสวรรค์";
        mainAmperStrings[21] = "ขามทะเลสอ,ขามสะแกแสง,แก้งสนามนาง,คง,ครบุรี,จักราช,ชุมพวง,เฉลิมพระเกียรติ,ด่านขุนทด,บัวลาย,บัวใหญ่,บ้านเหลื่อม,ประทาย,ปักธงชัย,ปากช่อง,พระทองคำ,พิมาย,ลำทะเมนชัย," +
                "วังน้ำเขียว,สีคิ้ว,สีดา,สูงเนิน,หนองบุญมาก,ห้วยแถลง,เทพารักษ์,เมืองนครราชสีมา,เมืองยาง,เสิงสาง,โชคชัย,โนนสูง,โนนแดง,โนนไทย";
        mainAmperStrings[22] = "ขนอม,จุฬาภรณ์,ฉวาง,ชะอวด,ช้างกลาง,ถ้ำพรรณรา,ทุ่งสง,ทุ่งใหญ่,ท่าศาลา,นบพิตำ,นาบอน,บางขัน,ปากพนัง,พรหมคีรี,พิปูน,ร่อนพิบูลย์,ลานสกา,สิชล,หัวไทร,เฉลิมพระเกียรติ,เชียรใหญ่,เมืองนครศรีธรรมราช";
        mainAmperStrings[23] = "ชุมตาบง,ชุมแสง,ตากฟ้า,ตาคลี,ท่าตะโก,บรรพตพิสัย,พยุหะคีรี,ลาดยาว,หนองบัว,เก้าเลี้ยว,เมืองนครสวรรค์,แม่วงก์,โกรกพระ,ไพศาลี";
        mainAmperStrings[24] = "บางกรวย,บางบัวทอง,บางใหญ่,ปากเกร็ด,เมืองนนทบุรี,ไทรน้อย";
        mainAmperStrings[25] = "จะแนะ,ตากใบ,บาเจาะ,ยี่งอ,ระแงะ,รือเสาะ,ศรีสาคร,สุคิริน,สุไหงปาดี,สุไหงโก-ลก,เมืองนราธิวาส,แว้ง";
        mainAmperStrings[26] = "ทุ่งช้าง,ท่าวังผา,นาน้อย,นาหมื่น,บ่อเกลือ,บ้านหลวง,ปัว,ภูเพียง,สองแคว,สันติสุข,เฉลิมพระเกียรติ,เชียงกลาง,เมืองน่าน,เวียงสา,แม่จริม";
        mainAmperStrings[27] = "บึงโขงหลง,บุ่งคล้า,ปากคาด,พรเจริญ,ศรีวิไล,เซกา,เมืองบึงกาฬ,โซ่พิสัย";
        mainAmperStrings[29] = "กระสัง,คูเมือง,ชำนิ,นางรอง,นาโพธิ์,บ้านกรวด,บ้านด่าน,บ้านใหม่ไชยพจน์,ประโคนชัย,ปะคำ,พลับพลาชัย,พุทไธสง,ละหานทราย,ลำปลายมาศ,สตึก,หนองกี่,หนองหงส์,ห้วยราช,เฉลิมพระเกียรติ,เมืองบุรีรัมย์,แคนดง,โนนดินแดง,โนนสุวรรณ";
        mainAmperStrings[30] = "คลองหลวง,ธัญบุรี,ลาดหลุมแก้ว,ลำลูกกา,สามโคก,หนองเสือ,เมืองปทุมธานี";
        mainAmperStrings[31] = "กุยบุรี,ทับสะแก,บางสะพาน,บางสะพานน้อย,ปราณบุรี,สามร้อยยอด,หัวหิน,เมืองประจวบคีรีขันธ์,ปราณบุรี,สามร้อยยอด";
        mainAmperStrings[32] = "กบินทร์บุรี,นาดี,บ้านสร้าง,ประจันตคาม,ศรีมหาโพธิ,ศรีมโหสถ,เมืองปราจีนบุรี";
        mainAmperStrings[33] = "กะพ้อ,ทุ่งยางแดง,ปะนาเระ,มายอ,ยะรัง,ยะหริ่ง,สายบุรี,หนองจิก,เมืองปัตตานี,แม่ลาน,โคกโพธิ์,ไม้แก่น";
        mainAmperStrings[34] = "ท่าเรือ,นครหลวง,บางซ้าย,บางบาล,บางปะหัน,บางปะอิน,บางไทร,บ้านแพรก,ผักไห่,พระนครศรีอยุธยา,ภาชี,มหาราช,ลาดบัวหลวง,วังน้อย,อุทัย,เสนา";
        mainAmperStrings[35] = "จุน,ดอกคำใต้,ปง,ภูกามยาว,ภูซาง,เชียงคำ,เชียงม่วน,เมืองพะเยา,แม่ใจ";
        mainAmperStrings[36] = "กะปง,คุระบุรี,ตะกั่วทุ่ง,ตะกั่วป่า,ทับปุด,ท้ายเหมือง,เกาะยาว,เมืองพังงา";
        mainAmperStrings[37] = "กงหรา,ควนขนุน,ตะโหมด,บางแก้ว,ปากพะยูน,ป่าบอน,ป่าพะยอม,ศรีนครินทร์,ศรีบรรพต,เขาชัยสน,เมืองพัทลุง";
        mainAmperStrings[38] = "ดงเจริญ,ตะพานหิน,ทับคล้อ,บางมูลนาก,บึงนาราง,วังทรายพูน,สากเหล็ก,สามง่าม,เมืองพิจิตร,โพทะเล,โพธิ์ประทับช้าง";
        mainAmperStrings[39] = "ชาติตระการ,นครไทย,บางกระทุ่ม,บางระกำ,พรหมพิราม,วังทอง,วัดโบสถ์,เนินมะปราง,เมืองพิษณุโลก";
        mainAmperStrings[40] = "ชะอำ,ท่ายาง,บ้านลาด,บ้านแหลม,หนองหญ้าปล้อง,เขาย้อย,เมืองเพชรบุรี,แก่งกระจาน";
        mainAmperStrings[41] = "ชนแดน,น้ำหนาว,บึงสามพัน,วังโป่ง,วิเชียรบุรี,ศรีเทพ,หนองไผ่,หล่มสัก,หล่มเก่า,เขาค้อ,เมืองเพชรบูรณ์";
        mainAmperStrings[42] = "ร้องกวาง,ลอง,วังชิ้น,สอง,สูงเม่น,หนองม่วงไข่,เด่นชัย,เมืองแพร่";
        mainAmperStrings[43] = "กะทู้,ถลาง,เมืองภูเก็ต";
        mainAmperStrings[44] = "กันทรวิชัย,กุดรัง,ชื่นชม,นาดูน,นาเชือก,บรบือ,พยัคฆภูมิพิสัย,ยางสีสุราช,วาปีปทุม,เชียงยืน,เมืองมหาสารคาม,แกดำ,โกสุมพิสัย";
        mainAmperStrings[45] = "คำชะอี,ดงหลวง,ดอนตาล,นิคมคำสร้อย,หนองสูง,หว้านใหญ่,เมืองมุกดาหาร";
        mainAmperStrings[46] = "ขุนยวม,ปางมะผ้า,ปาย,สบเมย,เมืองแม่ฮ่องสอน,แม่ลาน้อย,แม่สะเรียง";
        mainAmperStrings[47] = "กุดชุม,คำเขื่อนแก้ว,ค้อวัง,ทรายมูล,ป่าติ้ว,มหาชนะชัย,เมืองยโสธร,เลิงนกทา,ไทยเจริญ";
        mainAmperStrings[48] = "กรงปินัง,กาบัง,ธารโต,บันนังสตา,ยะหา,รามัน,เบตง,เมืองยะลา";
        mainAmperStrings[49] = "จตุรพักตร์พิมาน,จังหาร,ทุ่งเขาหลวง,ธวัชบุรี,ปทุมรัตต์,พนมไพร,ศรีสมเด็จ,สุวรรณภูมิ,หนองพอก,หนองฮี,อาจสามารถ,เกษตรวิสัย,เชียงขวัญ,เมยวดี,เมืองร้อยเอ็ด,เมืองสรวง,เสลภูมิ,โพธิ์ชัย,โพนทราย,โพนทอง";
        mainAmperStrings[50] = "กระบุรี,กะเปอร์,ละอุ่น,สุขสำราญ,เมืองระนอง";
        mainAmperStrings[51] = "นิคมพัฒนา,บ้านค่าย,บ้านฉาง,ปลวกแดง,วังจันทร์,เขาชะเมา,เมืองระยอง,แกลง";
        mainAmperStrings[52] = "จอมบึง,ดำเนินสะดวก,บางแพ,บ้านคา,บ้านโป่ง,ปากท่อ,วัดเพลง,สวนผึ้ง,เมืองราชบุรี,โพธาราม";
        mainAmperStrings[53] = "ชัยบาดาล,ท่าวุ้ง,ท่าหลวง,บ้านหมี่,พัฒนานิคม,ลำสนธิ,สระโบสถ์,หนองม่วง,เมืองลพบุรี,โคกสำโรง,โคกเจริญ";
        mainAmperStrings[54] = "งาว,วังเหนือ,สบปราบ,ห้างฉัตร,เกาะคา,เถิน,เมืองปาน,เมืองลำปาง,เสริมงาม,แจ้ห่ม,แม่ทะ,แม่พริก,แม่เมาะ";
        mainAmperStrings[55] = "ทุ่งหัวช้าง,บ้านธิ,บ้านโฮ่ง,ป่าซาง,ลี้,เมืองลำพูน,เวียงหนองล่อง,แม่ทา";
        mainAmperStrings[56] = "ด่านซ้าย,ท่าลี่,นาด้วง,นาแห้ว,ปากชม,ผาขาว,ภูกระดึง,ภูหลวง,ภูเรือ,วังสะพุง,หนองหิน,เชียงคาน,เมืองเลย,เอราวัณ";
        mainAmperStrings[57] = "กันทรลักษ์,กันทรารมย์,ขุขันธ์,ขุนหาญ,น้ำเกลี้ยง,บึงบูรพ์,ปรางค์กู่,พยุห์,ภูสิงห์,ยางชุมน้อย,ราษีไศล,วังหิน,ศรีรัตนะ,ศิลาลาด,ห้วยทับทัน,อุทุมพรพิสัย,เบญจลักษ์,เมืองศรีสะเกษ,โนนคูณ,โพธิ์ศรีสุวรรณ,ไพรบึง";
        mainAmperStrings[58] = "กุดบาก,กุสุมาลย์,คำตากล้า,นิคมน้ำอูน,บ้านม่วง,พรรณานิคม,พังโคน,ภูพาน,วานรนิวาส,วาริชภูมิ,สว่างแดนดิน,ส่องดาว,อากาศอำนวย,เจริญศิลป์,เต่างอย,เมืองสกลนคร,โคกศรีสุพรรณ,โพนนาแก้ว";
        mainAmperStrings[59] = "กระแสสินธุ์,คลองหอยโข่ง,ควนเนียง,จะนะ,นาทวี,นาหม่อม,บางกล่ำ,ระโนด,รัตภูมิ,สทิงพระ,สะบ้าย้อย,สะเดา,สิงหนคร,หาดใหญ่,เทพา,เมืองสงขลา";
        mainAmperStrings[60] = "ควนกาหลง,ควนโดน,ทุ่งหว้า,ท่าแพ,มะนัง,ละงู,เมืองสตูล";
        mainAmperStrings[61] = "บางบ่อ,บางพลี,บางเสาธง,พระประแดง,พระสมุทรเจดีย์,เมืองสมุทรปราการ";
        mainAmperStrings[62] = "บางคนที,อัมพวา,เมืองสมุทรสงคราม";
        mainAmperStrings[63] = "กระทุ่มแบน,บ้านแพ้ว,เมืองสมุทรสาคร";
        mainAmperStrings[64] = "คลองหาด,ตาพระยา,วังน้ำเย็น,วังสมบูรณ์,วัฒนานคร,อรัญประเทศ,เขาฉกรรจ์,เมืองสระแก้ว,โคกสูง";
        mainAmperStrings[65] = "ดอนพุด,บ้านหมอ,พระพุทธบาท,มวกเหล็ก,วังม่วง,วิหารแดง,หนองแค,หนองแซง,หนองโดน,เฉลิมพระเกียรติ,เมืองสระบุรี,เสาไห้,แก่งคอย";
        mainAmperStrings[66] = "ค่ายบางระจัน,ท่าช้าง,บางระจัน,พรหมบุรี,อินทร์บุรี,เมืองสิงห์บุรี";
        mainAmperStrings[67] = "กงไกรลาศ,คีรีมาศ,ทุ่งเสลี่ยม,บ้านด่านลานหอย,ศรีนคร,ศรีสัชนาลัย,ศรีสำโรง,สวรรคโลก,เมืองสุโขทัย";
        mainAmperStrings[68] = "ดอนเจดีย์,ด่านช้าง,บางปลาม้า,ศรีประจันต์,สองพี่น้อง,สามชุก,หนองหญ้าไซ,อู่ทอง,เดิมบางนางบวช,เมืองสุพรรณบุรี";
        mainAmperStrings[69] = "กาญจนดิษฐ์,คีรีรัฐนิคม,ชัยบุรี,ดอนสัก,ท่าฉาง,ท่าชนะ,บ้านตาขุน,บ้านนาสาร,บ้านนาเดิม,พนม,พระแสง,พุนพิน,วิภาวดี,เกาะพะงัน,เกาะสมุย,เคียนซา,เมืองสุราษฎร์ธานี,เวียงสระ,ไชยา";
        mainAmperStrings[70] = "กาบเชิง,จอมพระ,ชุมพลบุรี,ท่าตูม,บัวเชด,ปราสาท,พนมดงรัก,รัตนบุรี,ลำดวน,ศรีณรงค์,ศีขรภูมิ,สนม,สังขะ,สำโรงทาบ,เขวาสินรินทร์,เมืองสุรินทร์,โนนนารายณ์";
        mainAmperStrings[71] = "ท่าบ่อ,รัตนวาปี,ศรีเชียงใหม่,สระใคร,สังคม,เฝ้าไร่,เมืองหนองคาย,โพธิ์ตาก,โพนพิสัย";
        mainAmperStrings[72] = "นากลาง,นาวัง,ศรีบุญเรือง,สุวรรณคูหา,เมืองหนองบัวลำภู,โนนสัง";
        mainAmperStrings[73] = "ป่าโมก,วิเศษชัยชาญ,สามโก้,เมืองอ่างทอง,แสวงหา,โพธิ์ทอง,ไชโย";
        mainAmperStrings[74] = "ชานุมาน,ปทุมราชวงศา,พนา,ลืออำนาจ,หัวตะพาน,เมืองอำนาจเจริญ,เสนางคนิคม";
        mainAmperStrings[75] = "กุดจับ,กุมภวาปี,กู่แก้ว,ทุ่งฝน,นายูง,น้ำโสม,บ้านดุง,บ้านผือ,ประจักษ์ศิลปาคม,พิบูลย์รักษ์,วังสามหมอ,ศรีธาตุ,สร้างคอม,หนองวัวซอ,หนองหาน,หนองแสง,เพ็ญ,เมืองอุดรธานี,โนนสะอาด,ไชยวาน";
        mainAmperStrings[76] = "ตรอน,ทองแสนขัน,ท่าปลา,น้ำปาด,บ้านโคก,พิชัย,ฟากท่า,ลับแล,เมืองอุตรดิตถ์";
        mainAmperStrings[77] = "ทัพทัน,บ้านไร่,ลานสัก,สว่างอารมณ์,หนองขาหย่าง,หนองฉาง,ห้วยคต,เมืองอุทัยธานี";
        mainAmperStrings[78] = "กุดข้าวปุ้น,ดอนมดแดง,ตระการพืชผล,ตาลสุม,ทุ่งศรีอุดม,นาจะหลวย,นาตาล,นาเยีย,น้ำขุ่น,น้ำยืน,บุณฑริก,พิบูลมังสาหาร,ม่วงสามสิบ,วารินชำราบ,ศรีเมืองใหม่,สว่างวีระวงศ์,สำโรง,สิรินธร,เขมราฐ,เขื่องใน,เดชอุดม,เมืองอุบลราชธานี,เหล่าเสือโก้ก,โขงเจียม,โพธิ์ไทร";

        String[] rowStrings = mainAmperStrings[position].split(",");

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(LandBuildingActivity.this,
                android.R.layout.simple_list_item_1, rowStrings);
        spin4.setAdapter(stringArrayAdapter);
        stringArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
    }

    private void spinner5() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

        adapter.add("เลือกประเภทกรรมสิทธิ์");
        adapter.add("กรรมสิทธิ์สมบูรณ์(ซื้อขายขาด)");
        adapter.add("ได้รับสิทธิการเช่ามา");
        adapter.add("ไม่ทราบ");

        spin5.setAdapter(adapter);
        spin5.setSelection(0);
    }

    private void spinner6() {

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);

        adapter.add("เลือกการเบราซ์");
        adapter.add("เบราซ์เพื่อส่งเอกสาร");
        adapter.add("เบราซ์เพื่อส่งภาพถ่าย");
        adapter.add("เบราซ์เพื่อส่งพิกัดแผนที่");

        spin6.setAdapter(adapter);
        spin6.setSelection(0);
    }

}//Main Class