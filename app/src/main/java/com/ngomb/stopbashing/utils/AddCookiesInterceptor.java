package com.ngomb.stopbashing.utils;

import android.util.Log;

import com.ngomb.stopbashing.applications.MyApplication;

import java.io.IOException;
import java.util.HashSet;
import java.util.prefs.Preferences;
import java.util.zip.Inflater;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by ngomb on 03/06/2018.
 */


    public class AddCookiesInterceptor implements Interceptor {

        MyApplication application = new MyApplication();

        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request.Builder builder = chain.request().newBuilder();
            HashSet<String> preferences = Methods.getCookies(application.getContext());
            for (String cookie : preferences) {
                builder.addHeader("Cookie", cookie);
                Log.v("OkHttp", "Adding Header: " + cookie); // This is done so I know which headers are being added; this interceptor is used after the normal logging of OkHttp
            }
            return chain.proceed(builder.build());
        }
    }



