package com.ngomb.stopbashing.utils;

import com.ngomb.stopbashing.applications.MyApplication;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by ngomb on 04/06/2018.
 */

public class ReceivedCookiesInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response originalResponse = chain.proceed(chain.request());
        if (!originalResponse.headers("Set-Cookie").isEmpty()) {
            HashSet<String> cookies = new HashSet<>();
            for (String header : originalResponse.headers("Set-Cookie")) {
                cookies.add(header);
            }

            MyApplication application = new MyApplication();
            Methods.setCookies(application.getContext(), cookies);
        }
        return originalResponse;

    }
    }
