package com.alperen_coskun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class SecondActivity extends Activity {

    private RadioGroup CAgender;
    private RadioButton CAselectedgender;
    private Button CAthirdpage;
    private SharedPref CAsharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        CAsharedPref = new SharedPref(getApplicationContext());

        //ui setup

        setTitle("İkinci Sayfa");
        CAgender    =   (RadioGroup)findViewById(R.id.cinsiyet);
        CAthirdpage =   (Button)findViewById(R.id.button2);

        if(CAsharedPref.loadGender().equals("Erkek")) {
            CAgender.check(R.id.erkek);
        } else {
            CAgender.check(R.id.kadin);
        }

        //listeners

        CAthirdpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CAselectedgender = (RadioButton) findViewById(CAgender.getCheckedRadioButtonId());
                CAsharedPref.saveGender("\n "+ CAselectedgender.getText().toString()+" \n");
                //String ACveriler = getIntent().getStringExtra("veriler")+"\n"+ CAsharedPref.Loadgender();
                //Toast.makeText(SecondActivity.this,ACveriler,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                //intent.putExtra("veriler",ACveriler);
                startActivity(intent);
            }
        });


    }
}
