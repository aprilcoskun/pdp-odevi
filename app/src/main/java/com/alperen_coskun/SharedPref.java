package com.alperen_coskun;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Alp on 27.03.2017.
 */

public class SharedPref {

    private SharedPreferences CAsharedPreferences;
    private SharedPreferences.Editor CAeditor;

    //constructor

    public SharedPref(Context context){
        CAsharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        CAeditor = CAsharedPreferences.edit();
    }

    //load  data

     String loadFName() {
            return CAsharedPreferences.getString("fname","");
    }

     String loadLName() {
            return CAsharedPreferences.getString("lname","");
    }

     String loadGender() {
        return CAsharedPreferences.getString("gender","");
    }

     int loadNumber() {
            return CAsharedPreferences.getInt("number",0);
    }

     String loadLangs() {
        return CAsharedPreferences.getString("langs","");
    }

    //save data

     void saveFName(String ACfname) {
        CAeditor.putString("fname", ACfname);
        CAeditor.apply();
    }

     void saveLName(String AClname) {
        CAeditor.putString("lname", AClname);
        CAeditor.apply();
    }

     void saveNumber(int ACnumber) {
        CAeditor.putInt("number", ACnumber);
        CAeditor.apply();
    }

     void saveGender(String ACgender) {
        CAeditor.putString("gender", ACgender);
        CAeditor.apply();
    }

     void saveLangs(String AClangs) {
        CAeditor.putString("langs",AClangs);
        CAeditor.apply();
    }
}
