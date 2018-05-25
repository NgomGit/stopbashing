package com.ngomb.stopbashing.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ngomb.stopbashing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

@BindView(R.id.btn_create_account)
    Button createAccountButton;
@BindView(R.id.already_have_account)
    Button alreadyHaveAccount ;

@BindView(R.id.btn_join_my_familly)
    Button btnJoinMyFamilly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

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
                Intent mainIntent = new Intent(LoginActivity.this,MainActivity.class);

                startActivity(mainIntent);
            }
        });
    }
}
