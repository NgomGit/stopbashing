package com.ngomb.stopbashing.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.ngomb.stopbashing.R;
import com.ngomb.stopbashing.applications.MyApplication;
import com.ngomb.stopbashing.models.Post;
import com.ngomb.stopbashing.models.User;

import com.ngomb.stopbashing.services.ServiceGenerator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Cookie;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class LoginActivity extends AppCompatActivity {

    ServiceGenerator serviceGenerator;

@BindView(R.id.btn_create_account)
    Button createAccountButton;
@BindView(R.id.already_have_account)
    Button alreadyHaveAccount ;

@BindView(R.id.btn_join_my_familly)
    Button btnJoinMyFamilly;

@BindView(R.id.et_phone_number)
    EditText etPhoneNumber;

@BindView(R.id.et_family_code) 
    EditText etFamily_code;

@BindView(R.id.getRelatives) Button
        btnGetRelatives ;

SharedPreferences prefs;

MyApplication application;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        updatePreferenes();

        ButterKnife.bind(this);

        serviceGenerator = new ServiceGenerator();

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent createAccountIntent = new Intent(LoginActivity.this,CreateAccountActivity.class);

                startActivity(createAccountIntent);
            }
        });

        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent parentOrFriendIntent = new Intent(LoginActivity.this,ParentOrFriendActivity.class);

                startActivity(parentOrFriendIntent);
            }
        });


        btnJoinMyFamilly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sendUserToMainActivity();

            }
        });

        btnGetRelatives.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                getRelatives(190);
            }
        });
    }

    private void updatePreferenes() {

      application  = new MyApplication(getApplicationContext());




    }

    private void sendUserToMainActivity() {

        final Parcelable[] parcelablesUsers;
        Parcelable[] parcelablesPosts;

        String phoneNumber = etPhoneNumber.getText().toString();
        
        String familyCode = etFamily_code.getText().toString();
        
        if(TextUtils.isEmpty(familyCode)){

            Toast.makeText(this, "Veuillez enter un mot de passe", Toast.LENGTH_SHORT).show();
            
            
        }else{
            User user = new User();

            user.setPhoneNumber(phoneNumber);
            user.setFamilyCode(familyCode);

            Call<User> call = serviceGenerator.apiServiceCreator().isUserExist(user);


            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if(response.isSuccessful()){

                        int idUser = response.body().getId();

                        Toast.makeText(LoginActivity.this, "Logiin successfully"+idUser, Toast.LENGTH_SHORT).show();

                        getRelatives(idUser);

//                        getRelatives(idUser); getRelatives(idUser);

                    }else{

                        Toast.makeText(LoginActivity.this, "User does'nt exist", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                    t.printStackTrace();
                    Log.e("Faiure","getUsers");

                }
            });




         }

    }

    public void getRelatives(int idUser) {
        
        Call<List<User>> callUserRelatives = serviceGenerator.apiServiceCreator().getUserRelatives(idUser);
        
        callUserRelatives.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){

                    Toast.makeText(LoginActivity.this, "La recuperation s'est bien passé ", Toast.LENGTH_SHORT).show();
                }else{

                    Toast.makeText(LoginActivity.this, "Je n'arrive pas encore à tirer des informations sur le serveur ", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }
        });


    }




}
