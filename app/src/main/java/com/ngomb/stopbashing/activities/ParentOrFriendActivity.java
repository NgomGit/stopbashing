package com.ngomb.stopbashing.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.ngomb.stopbashing.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ParentOrFriendActivity extends AppCompatActivity {

    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.et_password)
    EditText etPassord;

    @BindView(R.id.tv_password_forgetten)
    TextView tvPasswordForgetten ;

    @BindView(R.id.parent_or_friend_toolbar)
    Toolbar  parentOrFriendToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_or_friend);

        ButterKnife.bind(this);


        parentOrFriendToolbar.setTitle("Parents ou bon ami");
        parentOrFriendToolbar.setNavigationIcon(R.drawable.back_icon_header);
        setSupportActionBar(parentOrFriendToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


         tvPasswordForgetten.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent passwordForgetIntent = new Intent(ParentOrFriendActivity.this,PasswordForgetActivity.class);
                 startActivity(passwordForgetIntent);

             }
         });
    }
}
