package com.ngomb.stopbashing.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.ngomb.stopbashing.applications.MyApplication;

import java.util.HashSet;

/**
 * Created by ngomb on 04/06/2018.
 */

public class Methods {

  static   MyApplication application ;

    public static HashSet<String> getCookies(Context context) {

        application = new MyApplication(context);
        SharedPreferences mcpPreferences = application.getPrefs();
        return (HashSet<String>) mcpPreferences.getStringSet("cookies", new HashSet<String>());
    }


    public static boolean setCookies(Context context, HashSet<String> cookies) {
        SharedPreferences mcpPreferences =application.getPrefs();
        SharedPreferences.Editor editor = mcpPreferences.edit();
        return editor.putStringSet("cookies", cookies).commit();
    }

}
