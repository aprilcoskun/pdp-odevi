package com.alperen_coskun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class FourthActivity extends Activity {

    private TextView CAfirstdata, CAseconddata, CAthirddata;
    private ImageView CAfirstpage, CAsecondpage, CAthirdpage;
    private SharedPref CAsharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        CAsharedPref = new SharedPref(getApplicationContext());

        //ui setup

        setTitle(R.string.lastpage);
        CAfirstdata = (TextView)findViewById(R.id.ilksayfa);
        CAseconddata = (TextView)findViewById(R.id.ikincisayfa);
        CAthirddata = (TextView)findViewById(R.id.ucuncusayfa);

        CAfirstpage = (ImageView)findViewById(R.id.imageView);
        CAsecondpage = (ImageView)findViewById(R.id.imageView2);
        CAthirdpage = (ImageView)findViewById(R.id.imageView3);

        CAfirstdata.setText("\n "+ CAsharedPref.loadFName()+" "+ CAsharedPref.loadLName()+"\n\n "+ CAsharedPref.loadNumber()+" \n");
        CAseconddata.setText("\n"+CAsharedPref.loadGender()+"\n");
        CAthirddata.setText(CAsharedPref.loadLangs());

        //hepsini secerse kaydir
        CAthirddata.setMovementMethod(new ScrollingMovementMethod());


        //listeners

        CAfirstpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });

        CAsecondpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        CAthirdpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });


    }
}
