package com.ngomb.stopbashing.fragments;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngomb.stopbashing.R;
import com.ngomb.stopbashing.adaptaters.GalleryRecycleAdapter;

public class GalerieFragmentActivity extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = (ViewGroup) inflater.inflate(R.layout.activity_galerie_fragment,container,false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_gallery_post_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        recyclerView.setAdapter(new GalleryRecycleAdapter());

        return view;
    }
}
