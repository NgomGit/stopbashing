package com.ngomb.stopbashing.applications;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by ngomb on 03/06/2018.
 */

public class MyApplication extends Application {


     static Context context ;

     public MyApplication(){



     }

    public MyApplication(Context context){

        setContext(context);
        prefs = context.getSharedPreferences("cookies",MODE_PRIVATE);
        editor = prefs.edit();
    }


    public  Context getContext() {
        return context;
    }

    public void setContext(Context context) {

        this.context =context;
    }

    SharedPreferences prefs;



    public SharedPreferences.Editor getEditor() {
        return editor;

    }

    public void setEditor(SharedPreferences.Editor editor) {
        this.editor = editor;
    }

    private  SharedPreferences.Editor editor;

    public SharedPreferences getPrefs() {
        return prefs;
    }

    public void setPrefs(SharedPreferences prefs) {
        this.prefs = prefs;
    }


}
