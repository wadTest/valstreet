package com.prospec.prospecservice.lands;

public class MyConstant {

    //    URL
    private String urlAddsp_mainString = "http://119.59.103.121/app_mobile/assessment/lands.php";

    //    Array ตัวแปรที่นำมาจาก php
    private String[] lands = new String[]{
            "number",
            "t_deed",
            "field_num",
            "rawang",
            "field_area",
            "cul_name_1",
            "cul_name_2",
            "cul_name_3",
            "cul_name_4",
            "cul_name_5",
            "cul_name_6",
            "cul_name_7"
    };
    private String[] spinner1 = new String[]{
            "เลือกเอกสารสิทธิ์",
            "โฉนดที่ดิน",
            "นส.3ก",
            "นส.3"
    };
    private String[] spinner2 = new String[]{
            "เลือกประเภท",
            "ไร่-งาน-ตารางวา",
            "ตารางวา",
            "ตารางเมตร"
    };
    private String[] spinner3 = new String[]{
            "เลือกประเภทกรรมสิทธิ์",
            "กรรมสิทธิ์สมบูรณ์(ซื้อขายขาด)",
            "ได้รับสิทธิการเช่ามา",
            "ไม่ทราบ"
    };
    private String[] spinner4 = new String[]{
            "เลือกการเบราซ์",
            "เบราซ์เพื่อส่งเอกสาร",
            "เบราซ์เพื่อส่งภาพถ่าย",
            "เบราซ์เพื่อส่งพิกัดแผนที่"
    };

    //    Getter
    public String[] getLands() {
        return lands;
    }

    public String[] getSpinner1() {
        return spinner1;
    }
    public String[] getSpinner2() {
        return spinner2;
    }
    public String[] getSpinner3() {
        return spinner3;
    }
    public String[] getSpinner4() {
        return spinner4;
    }
    public String getUrlAddsp_mainString() {
        return urlAddsp_mainString;
    }


}//Main Class
