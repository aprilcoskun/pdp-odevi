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
        CAsharedPref =   new SharedPref(getApplicationContext());
        CAcheckedlangs =   new ArrayList<>();
        //ui setup

        setTitle("Üçüncü Sayfa");
        CAlanglist =   (ListView)findViewById(R.id.langs);
        CAlastpage =   (Button)findViewById(R.id.button3);


        //list setup
        String[] AClangs =   getResources().getStringArray(R.array.diller);
        ArrayAdapter<String> CA_adapter = new ArrayAdapter<String>(this, R.layout.listlayout,R.id.row, AClangs);
        CAlanglist.setAdapter(CA_adapter);

        //listeners

        CAlanglist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String AC_secilidil =((TextView)view).getText().toString();
                if(CAcheckedlangs.contains(AC_secilidil)){
                    CAcheckedlangs.remove(AC_secilidil);
                }
                else {
                    CAcheckedlangs.add(AC_secilidil);
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
                //String AC_veriler = getIntent().getStringExtra("veriler")+"\n"+AC_items;
                //Toast.makeText(ThirdActivity.this, AC_veriler, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ThirdActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });

    }
}
