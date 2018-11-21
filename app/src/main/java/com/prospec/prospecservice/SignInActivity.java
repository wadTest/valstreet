package com.prospec.prospecservice;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.security.acl.Group;

public class SignInActivity extends AppCompatActivity {

    //  Explicit  ประกาศตัวแปร
    private View contenedorParticular;
    private View contenedorCorporativo;

    private EditText editText1, editText2, editText3, editText4, editText5, editText6, editText7, editText8, editText9, editText10, editText11,
            editText12, editText13, editText14, editText15, editText16, editText17, editText18, editText19, editText20, editText21;
    private ImageView imageName;
    private Button buttonSignUp, buttonSignUp1;
    //    ทำหน้าที่มนการรับค่าที่เกิดจากการกรอก (เปลี่ยนเป็นสติงก่อน และทำการรับผล)
    private String editT1, editT2, editT3, editT4, editT5, editT6, editT7, editT8, editT9, editT10,
            editT11, editT12, editT13, editT14, editT15, editT16, editT17, editT18, editT19, editT20, editT21, pathImage, nameImage;
    //    ประกาศตัวแปรเกี่ยวกับรูปภาพ
    private Uri uri;
    private String tag = "ProsecImage";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

 //      Province Spinner จังหวัด
        provinceSpinner();



//        Bind Widget
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);
        editText11 = (EditText) findViewById(R.id.editText11);
        editText12 = (EditText) findViewById(R.id.editText12);
        editText13 = (EditText) findViewById(R.id.editText13);
        editText14 = (EditText) findViewById(R.id.editText14);
        editText15 = (EditText) findViewById(R.id.editText15);
        editText16 = (EditText) findViewById(R.id.editText16);
        editText17 = (EditText) findViewById(R.id.editText17);
        editText20 = (EditText) findViewById(R.id.editText20);
        buttonSignUp = (Button) findViewById(R.id.buttonSignUp);
        buttonSignUp1 = (Button) findViewById(R.id.buttonSignUp1);
        imageName = (ImageView) findViewById(R.id.imageName);

//        ปุ่มชองลูกค้า
        buttonSignUp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//        Get Value From Edit Text
                editT1 = editText1.getText().toString().trim();
                editT2 = editText2.getText().toString().trim();
                editT3 = editText3.getText().toString().trim();
                editT4 = editText4.getText().toString().trim();
                editT5 = editText5.getText().toString().trim();
                editT6 = editText6.getText().toString().trim();
                editT7 = editText7.getText().toString().trim();
                editT8 = editText8.getText().toString().trim();
                editT9 = editText9.getText().toString().trim();
                editT10 = editText10.getText().toString().trim();
                editT11 = editText11.getText().toString().trim();

//                Check Space เมื่อไไหร่ก้ตาม ถ้า editT1..มัน equals กับความว่างเปล่า blool จะเป็น True (|| ไบร์ย  t or t =t , t or f = t, f or t = t, f or f =f)
                if (editT1.equals("") || editT2.equals("") || editT3.equals("") || editT4.equals("") || editT5.equals("") || editT6.equals("")
                        || editT7.equals("") || editT8.equals("") || editT9.equals("") || editT10.equals("") || editT11.equals("")) {
                }

            }//onClick
        });

//        ปุ่มของผู้ส่งงาน
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editT12 = editText12.getText().toString().trim();
                editT13 = editText13.getText().toString().trim();
                editT14 = editText14.getText().toString().trim();
                editT15 = editText15.getText().toString().trim();
                editT16 = editText16.getText().toString().trim();
                editT17 = editText17.getText().toString().trim();
                editT18 = editText18.getText().toString().trim();
                editT19 = editText19.getText().toString().trim();
                editT20 = editText20.getText().toString().trim();
                editT21 = editText21.getText().toString().trim();

//                Check Space เมื่อไไหร่ก้ตาม ถ้า editT1..มัน equals กับความว่างเปล่า blool จะเป็น True (|| ไบร์ย  t or t =t , t or f = t, f or t = t, f or f =f)
                if (editT12.equals("") || editT13.equals("") || editT14.equals("") || editT15.equals("") || editT16.equals("") || editT17.equals("") ||
                        editT18.equals("") || editT19.equals("") || editT20.equals("") || editT21.equals("")) {
                    //Have Space เมื่อกรอกจะเตือน
                    MyAlert myAlert1 = new MyAlert(SignInActivity.this, "มีพื้นที่ว่าง", "โปรดกรอกข้อมูลทั้งหมดในช่องว่าง");
                    myAlert1.myDialog();
                }

            }//onClick
        });

//        Image Controller
        imageName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ต้องการใช้ class จากภายนอก ต้อง
//                ACTION_GET_CONTENT ส่งสิ่งนี้ไปยังโปรแกรมอื่น ให้โปรแกรมอื่นทำงานจนเสร็จ พอทำงานเสร็จ จะทำการคืนผลลัพธ์กลับมา
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
//                image/* คือสิ่งที่สามรถเปิดรูปภาพได้ เช่น ต้องการเปิดด้วย แกลอรี่ โฟโต ฯลฯ
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "โปรดเลือกแอพ ที่จะทำการเปิด"), 1);
            }
        });


        contenedorParticular = findViewById(R.id.ll_contenedor_particular);
        contenedorCorporativo = findViewById(R.id.ll_contenedor_corporativo);

//        การเปิด ปิด สลับกัน ของRadio Buuton , เมื่อกด ปุ่มใดปุ่มนึงใน Group
        RadioGroup opcionesCliente = (RadioGroup) findViewById(R.id.rg_tipo_cliente);
        opcionesCliente.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
//                    Radio Button ของลูกค้า
                    case R.id.rb_particular:
                        mostrarParticular(true);
                        break;
//                        Radio Button ของผู้ใช้งาน
                    case R.id.rb_corporativo:
                        mostrarParticular(false);
                        break;
                }
            }
        });
    }

    private void mostrarParticular(boolean b) {
//       มองเห็นได้ --> แล้วไปที่ กรอกข้อมูลลูกค้า
        contenedorParticular.setVisibility(b ? View.VISIBLE : View.GONE);
//        ซ้อนไว้ก่อน เมื่อกดก้จะมา
        contenedorCorporativo.setVisibility(b ? View.GONE : View.VISIBLE);
    }

    public void onRadioButtonClicked(View view) {
    }//    ปีกกาปิดของคำสั่ง radio Group

    //  เกี่ยวกับรูปภาพ
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        เมื่อไหร่ก็ตามที่ทำงานสำเร็จ จะส่งค่าไปโชว์
        if (resultCode == RESULT_OK) {
            uri = data.getData();
            showImage(uri);

////            สร้าง Method จะเอาค่าของตัว uri ไปทำการค้าหา
////            เอาไว้ดู path ของรูปภาพ
//            pathImage = findPathImage(uri);
//            nameImage = pathImage.substring(pathImage.lastIndexOf("/"));
//            Log.d(tag, "path==>" + pathImage);
//            Log.d(tag, "name==>" + nameImage);
        }//if
    }

//    //    เกี่ยวกับ Path
//    private String findPathImage(Uri uri) {
//
//        String result = null;//มีค่าเริ่มต้นเท่ากับความว่างเปล่า
//        String[] strings = new String[]{MediaStore.Images.Media.DATA};
//        Cursor cursor = getContentResolver().query(uri, strings, null, null, null);
//
////        เมื่อไหร่ก็ตามมีข้อมูล ไม่เท่ากับความว่างเปล่า
//        if (cursor !=null) {
////            จะทำการ จะประมวลผลจากบนลงล่าง
//            cursor.moveToFirst();
//            int i = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            result = cursor.getString(i);
//        } else {
//            result = uri.getPath();
//        }
//
//        return result;
//    }

    private void showImage(Uri uri) {
        try {

            Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
            imageName.setImageBitmap(bitmap);

        } catch (Exception e) {
            e.printStackTrace();
        }


        //        ข้อความขึ้นอัตโนมัติ คำนำหน้า
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, CATEGORIES);
        AutoCompleteTextView nameTV = (AutoCompleteTextView)
                findViewById(R.id.editTextNamna);

        nameTV.setAdapter(adapter);
    }
    private static final String[] CATEGORIES = new String[]{"นาย", "นาง", "นางสาว"};

    //  77 จังหวัด
    private void provinceSpinner() {
        Spinner spinner = findViewById(R.id.spinnerProvince);
        String[] strings = new String[]{"เลือกจังหวัด", "กระบี่", "กรุงเทพมหานคร", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี", "ฉะเชิงเทรา", "ชลบุรี"
                , "ชัยนาท", "ชัยภูมิ", "ชุมพร", "ตรัง", "ตราด", "ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช", "นครสวรรค์", "นนทบุรี", "นราธิวาส",
                "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี", "พระนครศรีอยุธยา", "พะเยา", "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "ภูเก็ต", "มหาสารคาม",
                "มุกดาหาร", "ยะลา", "ยโสธร", "ระนอง", "ระยอง", "ราชบุรี", "ร้อยเอ็ด", "ลพบุรี", "ลำปาง", "ลำพูน", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล", "สมุทรปราการ", "สมุทรสงคราม",
                "สมุทรสาคร", "สระบุรี", "สระแก้ว", "สิงห์บุรี", "สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "สุโขทัย", "หนองคาย", "หนองบัวลำภู", "อำนาจเจริญ", "อุดรธานี",
                "อุตรดิตถ์", "อุทัยธานี", "อุบลราชธานี", "อ่างทอง", "เชียงราย", "เชียงใหม่", "เพชรบุรี", "เพชรบูรณ์", "เลย", "แพร่", "แม่ฮ่องสอน", "ประจวบคีรีขันธ์", "ชุมพร"};
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(SignInActivity.this,
                android.R.layout.simple_list_item_1, strings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

        Spinner spinner = findViewById(R.id.spinnerAmper);
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

        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(SignInActivity.this,
                android.R.layout.simple_list_item_1, rowStrings);
        spinner.setAdapter(stringArrayAdapter);


        //        ข้อความขึ้นอัตโนมัติ รายชื่อธนาคาร
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, CATEGORIES1);
        AutoCompleteTextView nameTV = (AutoCompleteTextView)
                findViewById(R.id.editTextBank);

        nameTV.setAdapter(adapter);
    }
    private static final String[] CATEGORIES1 = new String[]{
           " ธนาคารพัฒนาวิสาหกิจขนาดกลางและขนาดย่อมแห่งประเทศไทย",
           " ธนาคารเพื่อการเกษตรและสหกรณ์การเกษตร",
            "ธนาคารเพื่อการส่งออก และนำเข้าแห่งประเทศไทย",
            "ธนาคารออมสิน",
            "ธนาคารอาคารสงเคราะห์",
            "ธนาคารอิสลามแห่งประเทศไทย",
            "ธนาคารกรุงไทย จำกัดมหาชน",
            "ธนาคารทหารไทย จำกัดมหาชน",
            "ธนาคารกรุงเทพ จำกัดมหาชน",
            "ธนาคารกรุงศรีอยุธยา จำกัดมหาชน",
            "ธนาคารกสิกรไทย จำกัดมหาชน",
            "ธนาคารเกียรตินาคิน จำกัดมหาชน",
            "ธนาคารซิตี้แบงก์",
            "ธนาคารทิสโก้ จำกัดมหาชน",
            "ธนาคารซีไอเอ็มบี ไทย จำกัด มหาชน",
            "ธนาคารไทยพาณิชย์ จำกัดมหาชน",
            "ธนาคารธนชาต จำกัดมหาชน",
            "ธนาคารนครหลวงไทย จำกัดมหาชน",
            "ธนาคารยูโอบี จำกัดมหาชน",
            "ธนาคารสแตนดาร์ดชาร์เตอร์ดไทย จำกัดมหาชน",
            "ธนาคารสินเอเซีย จำกัดมหาชน",
            "ธนาคารจีอี มันนี่ เพื่อรายย่อย จำกัด",
            "ธนาคารแลนด์ แอนด์ เฮ้าส์ เพื่อรายย่อย",
            "ธนาคารไทยเครดิต เพื่อรายย่อย",
            "ธนาคารไอซีบีซี ไทย จำกัด มหาชน",
            "ธนาคารแห่งประเทศจีนไทย จำกัด มหาชน",
            "ธนาคารแห่งประเทศไทย",
            "ธนาคารไทยธนาคาร จำกัด มหาชน",
            "ธนาคาร อาร์ เอช บี จำกัด"};

}//Main Class