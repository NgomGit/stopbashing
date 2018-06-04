package com.ngomb.stopbashing.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.ngomb.stopbashing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity {

    @BindView(R.id.et_first_name)
    EditText etFirstName;

    @BindView(R.id.et_last_name)
    EditText etLastNamme;

    @BindView(R.id.et_email)
    EditText   etEmail;

    @BindView(R.id.et_number)
    EditText etNumber;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.btn_create_account)
    Button btnCreateAccount;

    @BindView(R.id.create_account_tollbar)
    Toolbar createAccountToolbar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ButterKnife.bind(this);

//        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        createAccountToolbar.setTitle(R.string.creer_votre_famille);
        createAccountToolbar.setNavigationIcon(R.drawable.back_icon_header);
        setSupportActionBar(createAccountToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);





    }
}
