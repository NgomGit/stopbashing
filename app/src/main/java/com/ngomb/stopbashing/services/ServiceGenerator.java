package com.ngomb.stopbashing.services;


import android.content.SharedPreferences;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ngomb.stopbashing.applications.MyApplication;
import com.ngomb.stopbashing.utils.AddCookiesInterceptor;
import com.ngomb.stopbashing.utils.Const;
import com.ngomb.stopbashing.utils.ReceivedCookiesInterceptor;



import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ngomb on 31/05/2018.
 */

public class ServiceGenerator {

    public static  final String URLPOINT = Const.API_URL_TEST;



    private static HttpLoggingInterceptor loggingInterceptor =
            new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);


     OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES);



  public  StopBashingApiCall apiServiceCreator(){

      httpClient.interceptors().add(new AddCookiesInterceptor());
      httpClient.interceptors().add(new ReceivedCookiesInterceptor());
        Gson gson = new GsonBuilder().create();
        Retrofit.Builder  retrofitBuilder = new Retrofit.Builder()
                .baseUrl(URLPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson));
        if(!httpClient.interceptors().contains(loggingInterceptor)){
            httpClient.addInterceptor(loggingInterceptor);
            retrofitBuilder.client(httpClient.build());


        }

        return retrofitBuilder.build().create(StopBashingApiCall.class);
    }



}
