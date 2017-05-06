package com.alperen_coskun;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThirdActivity extends Activity {

    private Button CAlastpage;
    private ListView CAlanglist;
    private ArrayList<String> CAcheckedlangs;
    private SharedPref CAsharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        CAsharedPref    =   new SharedPref(getApplicationContext());
        CAcheckedlangs  =   new ArrayList<>();

        //ui setup

        setTitle(R.string.thirdpage);
        CAlanglist  =   (ListView)findViewById(R.id.langs);
        CAlastpage  =   (Button)findViewById(R.id.button3);


        //list setup

        String[] AClangs =   getResources().getStringArray(R.array.diller);
        ArrayAdapter<String> CA_adapter = new ArrayAdapter<String>(this, R.layout.itemlayout,R.id.row, AClangs);
        CAlanglist.setAdapter(CA_adapter);


        //check db

        for (String ACitem: AClangs) {
            if(CAsharedPref.loadLangs().contains(ACitem)) {
                CAlanglist.setItemChecked(CA_adapter.getPosition(ACitem),true);
                if (CAcheckedlangs.contains(ACitem)) {
                    CAcheckedlangs.remove(ACitem);
                } else {
                    CAcheckedlangs.add(ACitem);
                }
            }
        }

        //listeners

        CAlanglist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ACselectedlang =((TextView)view).getText().toString();
                if(CAcheckedlangs.contains(ACselectedlang)){
                    CAcheckedlangs.remove(ACselectedlang);
                }
                else {
                    CAcheckedlangs.add(ACselectedlang);
                }
            }
        });

        CAlastpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ACitems="";
                for (String AC_item: CAcheckedlangs) {
                    ACitems+="- "+AC_item+"\n";
                }
                CAsharedPref.saveLangs("\n"+ACitems);

                /*String ACveriler    =   CAsharedPref.loadFName() + "\n" + CAsharedPref.loadLName() + "\n" +
                                        CAsharedPref.loadNumber() + "\n" + CAsharedPref.loadGender() + "\n" + CAsharedPref.loadLangs();
                Toast.makeText(ThirdActivity.this, ACveriler, Toast.LENGTH_SHORT).show();*/

                Intent intent = new Intent(ThirdActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });

    }
}
