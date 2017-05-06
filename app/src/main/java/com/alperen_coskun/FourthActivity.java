package com.alperen_coskun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class FourthActivity extends Activity {

    private CardView CAfirstcard, CAsecondcard, CAthirdcard;
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
        CAfirstcard     =   (CardView)findViewById(R.id.card0);
        CAsecondcard    =   (CardView)findViewById(R.id.card1);
        CAthirdcard     =   (CardView)findViewById(R.id.card2);

        CAfirstdata     =   (TextView)findViewById(R.id.ilksayfa);
        CAseconddata    =   (TextView)findViewById(R.id.ikincisayfa);
        CAthirddata     =   (TextView)findViewById(R.id.ucuncusayfa);

        CAfirstpage     =   (ImageView)findViewById(R.id.imageView);
        CAsecondpage    =   (ImageView)findViewById(R.id.imageView2);
        CAthirdpage     =   (ImageView)findViewById(R.id.imageView3);

        ResizeAnimation CAanim  =   new ResizeAnimation(CAfirstcard, 330, 100);
        ResizeAnimation CAanim2 =   new ResizeAnimation(CAsecondcard, 120, 100);
        ResizeAnimation CAanim3 =   new ResizeAnimation(CAthirdcard, 780, 100);

        CAanim.setDuration(1000);
        CAanim2.setDuration(1000);
        CAanim3.setDuration(1000);

        CAfirstcard.startAnimation(CAanim);
        CAsecondcard.startAnimation(CAanim2);
        CAthirdcard.startAnimation(CAanim3);

        //check db

        CAfirstdata.setText("\n "+ CAsharedPref.loadFName()+" "+ CAsharedPref.loadLName()+"\n\n "+ CAsharedPref.loadNumber()+" \n");
        CAseconddata.setText("\n"+CAsharedPref.loadGender()+"\n");
        CAthirddata.setText(CAsharedPref.loadLangs());

        //scroll method for long lang list

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
