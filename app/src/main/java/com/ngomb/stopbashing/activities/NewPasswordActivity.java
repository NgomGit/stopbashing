package com.ngomb.stopbashing.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.ngomb.stopbashing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewPasswordActivity extends AppCompatActivity {
    @BindView(R.id.new_password_toolbar)
    Toolbar newPasswordToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        ButterKnife.bind(this);


        newPasswordToolbar.setNavigationIcon(R.drawable.back_icon_header);
        newPasswordToolbar.setTitle("Nouveau mot de passe ");
        setSupportActionBar(newPasswordToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        newPasswordToolbar.setTitle(R.string.nouveau_mot_de_passe);
    }
}
