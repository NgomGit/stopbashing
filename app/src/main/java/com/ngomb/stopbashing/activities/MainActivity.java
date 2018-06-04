package com.ngomb.stopbashing.activities;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;


import com.ngomb.stopbashing.R;
import com.ngomb.stopbashing.fragments.CameraFragmentActivity;
import com.ngomb.stopbashing.fragments.GalerieFragmentActivity;
import com.ngomb.stopbashing.fragments.HomeFragmentActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottomNavigationView;



    Fragment fragment,defaultFrament;

   private FragmentManager fragmentManager;

    @BindView(R.id.main_toolbar)
    Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //Toolbar



        //Toolbar --------------
        setSupportActionBar(mainToolbar);

        fragmentManager = getSupportFragmentManager();

        defaultFrament = new HomeFragmentActivity();

        final FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.main_fl_container, defaultFrament).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int position = item.getItemId();

                switch (position) {

                    case R.id.main_menu_home:
                        item.setChecked(true);
                        fragment = new HomeFragmentActivity();
                        break;

                    case R.id.main_menu_gallerry:

                        fragment = new GalerieFragmentActivity();
                        break;

                    case R.id.main_menu_camera:

                        fragment = new CameraFragmentActivity();
                        break;

                }

                final FragmentTransaction transaction = fragmentManager.beginTransaction();

                transaction.replace(R.id.main_fl_container, fragment).commit();
                return true;
            }

        });


    }
}
