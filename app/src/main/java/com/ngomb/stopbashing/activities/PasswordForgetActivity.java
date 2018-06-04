package com.ngomb.stopbashing.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.ngomb.stopbashing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PasswordForgetActivity extends AppCompatActivity {

    @BindView(R.id.btn_get_link)
    Button btnGetLink;

    @BindView(R.id.password_forget_toolbar)
    Toolbar passwordForgetToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forget);

        ButterKnife.bind(this);

        passwordForgetToolbar.setNavigationIcon(R.drawable.back_icon_header);
        passwordForgetToolbar.setTitle("Mot de passe oublié");
        setSupportActionBar(passwordForgetToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnGetLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newPasswordIntent = new Intent(PasswordForgetActivity.this,NewPasswordActivity.class);

                startActivity(newPasswordIntent);
            }
        });
    }
}
