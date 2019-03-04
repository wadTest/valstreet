package com.prospec.prospecservice.utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.prospec.prospecservice.R;

//ทำหน้าที่ในการโวยวาย หรือ Alert
public class MyAlert {

    //    Explicit
    private Context context;
    private String titleString, messageString;

    public MyAlert(Context context, String titleString, String messageString) {
        this.context = context;
        this.titleString = titleString;
        this.messageString = messageString;
    }
    //   public =  Method ที่ใช้ภายนอก , void = ไม่มีการรีเทรนค่ากลับ
    public  void myDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        เมื่อไหร่ก็ตามถ้า pop up มันโพ่ขึ้นมา user จะไม่สารมารถกดปุ่ม undo ได้ ชั่วคราว
        builder.setCancelable(false);
        builder.setTitle(titleString);
        builder.setMessage(messageString);
        builder.setIcon(R.drawable.alert);
        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//                เมื่อไหร่ก็ตามเมื่อคลิกปุ่ม ให้ที่แจ้งเตือนนั้นหายไป
                dialog.dismiss();
            }
        });
        builder.show();
    }

//    Alert เมื่อไม่ได้กรอกข้อมุล (ส่งงานประเเมิน)


    public MyAlert(Context context) {
        this.context = context;
    }
    public void normalDialog(String titleSting, String messageString) {

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(context);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setTitle(titleSting);
        builder.setMessage(messageString);
        builder.setPositiveButton("ตกลง", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }
}//Main Class
