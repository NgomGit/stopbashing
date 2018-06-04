package com.ngomb.stopbashing.services;

import com.ngomb.stopbashing.models.Post;
import com.ngomb.stopbashing.models.User;
;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by ngomb on 31/05/2018.
 */

public interface StopBashingApiCall {

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })

    @POST("login")
   Call<User> isUserExist(@Body User userLogin);


    @GET("users/{id}/relatives")
    Call<List<User>> getUserRelatives (@Path("id") int idUser);

    @Headers({
            "Accept: application/json",
            "Content-Type: application/json"
    })


    @GET("users/{idUser}/posts")
    Call<List<Post>> getUserPosts(@Path("idUser") int idUser);



}
