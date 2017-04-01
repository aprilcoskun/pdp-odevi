package com.alperen_coskun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Alperen Coskun: AC for variables, CA for Objects

public class FirstActivity extends Activity {

    private EditText CAfname, CAlname, CAnumber;
    private Button CAsecondpage;
    private SharedPref CAsharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        CAsharedPref = new SharedPref(getApplicationContext());
        CAsharedPref.firstRun();

        //ui setup

        setTitle(R.string.firstpage);
        CAfname     =   (EditText)findViewById(R.id.fnameEdit);
        CAlname     =   (EditText)findViewById(R.id.lnameEdit);
        CAnumber    =   (EditText)findViewById(R.id.numberEdit);
        CAsecondpage =   (Button)findViewById(R.id.button);

        //check db

        if(!CAsharedPref.loadFName().equals("default"))
            CAfname.setText(CAsharedPref.loadFName());

        if(!CAsharedPref.loadLName().equals("default"))
            CAlname.setText(CAsharedPref.loadLName());

        if(!(CAsharedPref.loadNumber()==0))
            CAnumber.setText(String.valueOf(CAsharedPref.loadNumber()));

        //listeners

        CAsecondpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CAfname.getText().toString().equals("") || CAlname.getText().toString().equals("") || CAnumber.getText().toString().equals("")){
                    Toast toast = Toast.makeText(FirstActivity.this,"Lütfen tüm alanları doldurunuz!",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    CAsharedPref.saveFName(CAfname.getText().toString());
                    CAsharedPref.saveLName(CAlname.getText().toString());
                    CAsharedPref.saveNumber(Integer.parseInt(CAnumber.getText().toString()));
                    //String AC_veriler = CAfname.getText().toString()+" "+ CAlname.getText().toString()+"\n"+ CAnumber.getText().toString();
                    //Toast.makeText(FirstActivity.this,AC_veriler,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                    //intent.putExtra("veriler",AC_veriler);
                    startActivity(intent);
                }
            }
        });
    }


}
