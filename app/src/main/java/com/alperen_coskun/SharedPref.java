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

     void saveFName(String AC_fname) {
        CAeditor.putString("fname", AC_fname);
        CAeditor.apply();
    }

     void saveLName(String AC_lname) {
        CAeditor.putString("lname", AC_lname);
        CAeditor.apply();
    }

     void saveNumber(int AC_number) {
        CAeditor.putInt("number", AC_number);
        CAeditor.apply();
    }

     void saveGender(String AC_gender) {
        CAeditor.putString("gender", AC_gender);
        CAeditor.apply();
    }

     void saveLangs(String AClangs) {
        CAeditor.putString("langs",AClangs);
        CAeditor.apply();
    }

    //Ilk calistirmada deger ata

      void firstRun(){
        if(CAsharedPreferences.getBoolean("firstrun",true)){
            CAeditor.putString("fname", "default");
            CAeditor.putString("lname", "default");
            CAeditor.putString("gender","default");
            CAeditor.putString("langs", "Hiçbir dil bilmiyorsunuz!");
            CAeditor.putInt("number", 0);
            CAeditor.putBoolean("firstrun",false);
        }
        CAeditor.apply();
    }
}
