package com.ngomb.stopbashing.adaptaters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ngomb.stopbashing.R;
import com.ngomb.stopbashing.fragments.CameraFragmentActivity;
import com.ngomb.stopbashing.fragments.GalerieFragmentActivity;
import com.ngomb.stopbashing.fragments.HomeFragmentActivity;

/**
 * Created by ngomb on 23/05/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {


    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case R.id.main_menu_home: return new HomeFragmentActivity();

            case R.id.main_menu_gallerry: return  new GalerieFragmentActivity();

            case  R.id.main_menu_camera : return  new CameraFragmentActivity();

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 0;
    }

    /**
     * Created by ngomb on 03/06/2018.
     */


}
