package com.prospec.prospecservice;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

//class ติดต่อสายตรง
public class CallActivity extends AppCompatActivity {

    //   Explicit ประกาศตัวแปร
    private Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12, button13;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call);

        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ติดต่อสายตรง");
        toolbar.setSubtitle("เลือกเมนูทางในการติดต่อ");
        toolbar.setLogo(R.drawable.logo_prospec);

//        Get Event การรับกิจกรรมจาก ตัวแปร กดปุ่ม 1-13
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);

        //        เมื่อกดปุ่มนี้ จะโทรไปยังเบอร์สำนักงานใหญ่
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu headquarters = new PopupMenu(CallActivity.this, button1);
                headquarters.getMenuInflater().inflate(R.menu.headquarters, headquarters.getMenu());
                headquarters.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.headquarters1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:025590678"));
                                startActivity(c1);
                                return true;
                            case R.id.headquarters2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0892301694"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                headquarters.show();
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาเชียงใหม่
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu ChiangMai = new PopupMenu(CallActivity.this, button2);
                ChiangMai.getMenuInflater().inflate(R.menu.chiangmai, ChiangMai.getMenu());
                ChiangMai.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.ChiangMai1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:053240216"));
                                startActivity(c1);
                                return true;
                            case R.id.ChiangMai2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0805001919"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                ChiangMai.show();
            }
        });


        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาเชียงราย
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu ChiangRai = new PopupMenu(CallActivity.this, button3);
                ChiangRai.getMenuInflater().inflate(R.menu.chiangrai, ChiangRai.getMenu());
                ChiangRai.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.ChiangRai1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:053718391"));
                                startActivity(c1);
                                return true;
                            case R.id.ChiangRai2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0814997113"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                ChiangRai.show();
            }
        });


        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาลำปาง
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu Lampang = new PopupMenu(CallActivity.this, button4);
                Lampang.getMenuInflater().inflate(R.menu.lampang, Lampang.getMenu());
                Lampang.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Lampang1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:054222879"));
                                startActivity(c1);
                                return true;
                            case R.id.Lampang2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0831544009"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                Lampang.show();
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาพิษณุโลก
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu Phitsanulok = new PopupMenu(CallActivity.this, button5);
                Phitsanulok.getMenuInflater().inflate(R.menu.phitsanulok, Phitsanulok.getMenu());
                Phitsanulok.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Phitsanulok1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:055211243"));
                                startActivity(c1);
                                return true;
                            case R.id.Phitsanulok2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0864468657"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                Phitsanulok.show();
            }
        });


        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาอยุธยา
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu Ayutthaya = new PopupMenu(CallActivity.this, button6);
                Ayutthaya.getMenuInflater().inflate(R.menu.ayutthaya, Ayutthaya.getMenu());
                Ayutthaya.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Ayutthaya1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:035243242"));
                                startActivity(c1);
                                return true;
                            case R.id.Ayutthaya2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0863455113"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                Ayutthaya.show();
            }
        });


        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาราชบุรี
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu Ratchaburi = new PopupMenu(CallActivity.this, button7);
                Ratchaburi.getMenuInflater().inflate(R.menu.ratchaburi, Ratchaburi.getMenu());
                Ratchaburi.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Ratchaburi1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:032321934"));
                                startActivity(c1);
                                return true;
                            case R.id.Ratchaburi2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0830755016"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                Ratchaburi.show();
            }
        });


        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาเพชรบูรณ์
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu Phetchabun = new PopupMenu(CallActivity.this, button8);
                Phetchabun.getMenuInflater().inflate(R.menu.phetchabun, Phetchabun.getMenu());
                Phetchabun.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Phetchabun1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:056721980"));
                                startActivity(c1);
                                return true;
                            case R.id.Phetchabun2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0864902705"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                Phetchabun.show();
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขากำแพงเพชร
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu KamphaengPhet = new PopupMenu(CallActivity.this, button9);
                KamphaengPhet.getMenuInflater().inflate(R.menu.kamphaengphet, KamphaengPhet.getMenu());
                KamphaengPhet.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.KamphaengPhet1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:055714806"));
                                startActivity(c1);
                                return true;
                            case R.id.KamphaengPhet2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0882785668"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                KamphaengPhet.show();
            }
        });

        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาสระบุรี
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu Saraburi = new PopupMenu(CallActivity.this, button10);
                Saraburi.getMenuInflater().inflate(R.menu.saraburi, Saraburi.getMenu());
                Saraburi.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Saraburi1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:036670268"));
                                startActivity(c1);
                                return true;
                            case R.id.Saraburi2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0864902701"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                Saraburi.show();
            }
        });


        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาแพร่
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu Phrae = new PopupMenu(CallActivity.this, button11);
                Phrae.getMenuInflater().inflate(R.menu.phrae, Phrae.getMenu());
                Phrae.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.Phrae1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:054531220"));
                                startActivity(c1);
                                return true;
                            case R.id.Phrae2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0864308864"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                Phrae.show();
            }
        });


        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขานครศรีธรรมราช
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu NakhonSiThammarat = new PopupMenu(CallActivity.this, button12);
                NakhonSiThammarat.getMenuInflater().inflate(R.menu.nakhonsithammarat, NakhonSiThammarat.getMenu());
                NakhonSiThammarat.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.NakhonSiThammarat1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:075322331"));
                                startActivity(c1);
                                return true;
                            case R.id.NakhonSiThammarat2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0954230309"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                NakhonSiThammarat.show();
            }
        });


        //        เมื่อกดปุ่มนี้ จะโทรไปยัง สาขาประจวบคีรีขันธ์
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final PopupMenu PrachuapKhiriKhan = new PopupMenu(CallActivity.this, button13);
                PrachuapKhiriKhan.getMenuInflater().inflate(R.menu.prachuapkhirikhan, PrachuapKhiriKhan.getMenu());
                PrachuapKhiriKhan.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.PrachuapKhiriKhan1:
                                Intent c1 = new Intent(Intent.ACTION_DIAL);
                                c1.setData(Uri.parse("tel:032602286"));
                                startActivity(c1);
                                return true;
                            case R.id.PrachuapKhiriKhan2:
                                Intent c2 = new Intent(Intent.ACTION_DIAL);
                                c2.setData(Uri.parse("tel:0810178172"));
                                startActivity(c2);
                                return true;
                        }
                        return true;
                    }
                });
                PrachuapKhiriKhan.show();
            }
        });

    }//Method
}//Class Main