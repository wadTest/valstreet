package com.prospec.prospecservice;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class LineActivity extends AppCompatActivity {

    //   Explicit ประกาศตัวแปร
    private Button button1, button2, button3, button4, button5, button6,
            button7, button8, button9, button10, button11, button12, button13;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line);

        //        ADD Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ติดต่อทาง@line");
        toolbar.setSubtitle("เลือกเมนูในการติดต่อทางไลน์");
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


        //Get Event From Click Line สำนักงานใหญ่
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine1(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line เชียงใหม่
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine2(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line เชียงราย
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine3(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line ลำปาง
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine4(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line พิษณุโลก
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine5(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line อยุธยา
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine6(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line ราชบุรี
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine7(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line เพชรบูรณ์
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine8(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line กำแพงเพรช
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine9(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line สระบุรี
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine10(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line แพร่
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine11(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line นครศรีธรรมราช
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine12(LineActivity.this);
                startActivity(lineInput);

            }
        });

        //Get Event From Click Line ประจวบคีรีขันธ์
        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent lineInput = openLine13(LineActivity.this);
                startActivity(lineInput);

            }
        });
    }

//      https Line สำนักงานใหญ่
    public static Intent openLine1(Context context1) {
        try {
            context1.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40wgm8703w"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40wgm8703w"));
        }
    }

//      https Line สาขา เชียงใหม่
    public static Intent openLine2(Context context2) {
        try {
            context2.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40dok8636r"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40dok8636r"));
        }
    }
    //      https Line สาขา เชียงราย
    public static Intent openLine3(Context context3) {
        try {
            context3.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40uks0426z"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40uks0426z"));
        }
    }
    //      https Line สาขา ลำปาง
    public static Intent openLine4(Context context4) {
        try {
            context4.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40iki2330d"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40iki2330d"));
        }
    }

    //      https Line สาขา พิษณุโลก
    public static Intent openLine5(Context context5) {
        try {
            context5.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40xxe5865m"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40xxe5865m"));
        }
    }

    //      https Line สาขา อยุธยา
    public static Intent openLine6(Context context6) {
        try {
            context6.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40ceg8012v"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40ceg8012v"));
        }
    }

    //      https Line สาขา ราชบุรี
    public static Intent openLine7(Context context7) {
        try {
            context7.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40auu7838u"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40auu7838u"));
        }
    }

    //      https Line สาขา เพชรบูรณ์
    public static Intent openLine8(Context context8) {
        try {
            context8.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40opw4970x"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40opw4970x"));
        }
    }

    //      https Line สาขา กำแพงเพรช
    public static Intent openLine9(Context context9) {
        try {
            context9.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40def7441h"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40def7441h"));
        }
    }

    //      https Line สาขา สระบุรี
    public static Intent openLine10(Context context10) {
        try {
            context10.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40ahh7254a"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40ahh7254a"));
        }
    }

    //      https Line สาขา แพร่
    public static Intent openLine11(Context context11) {
        try {
            context11.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40mxf3548c"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40mxf3548c"));
        }
    }

    //      https Line สาขา นครศรีธรรมราช
    public static Intent openLine12(Context context12) {
        try {
            context12.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40cbr3436q"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40cbr3436q"));
        }
    }


    //      https Line สาขา ประจวบคีรีขันธ์
    public static Intent openLine13(Context context13) {
        try {
            context13.getPackageManager()
                    .getPackageInfo("com.line.prospec", 0);
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40dkx7376e"));

        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://line.me/R/ti/p/%40dkx7376e"));
        }
    }

}//Main Class

