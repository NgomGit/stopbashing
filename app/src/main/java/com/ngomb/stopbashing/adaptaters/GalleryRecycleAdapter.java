package com.ngomb.stopbashing.adaptaters;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngomb.stopbashing.R;
import com.ngomb.stopbashing.models.Post;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.http.POST;

/**
 * Created by ngomb on 25/05/2018.
 */

public class GalleryRecycleAdapter  extends RecyclerView.Adapter<GalleryRecycleAdapter.MyViewHolder>{

    List<Post>  postList = new ArrayList<>();
    Context context = new Application().getApplicationContext();

    public  GalleryRecycleAdapter(List<Post> postList){

        this.postList=postList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        View view = inflater.inflate(R.layout.list_gallery,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



           holder.displayGallery(postList.get(position));

    }

    @Override
    public int getItemCount() {
        return postList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_appreciation)
                TextView tvAppreciation;
        @BindView(R.id.tv_author)
                TextView tvAuthor;
        @BindView(R.id.iv_gallery)
                ImageView ivGallery;

        private Post cuurentPostModel;
        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }


        public void displayGallery(Post post){
            cuurentPostModel = post;

            int appreciation = post.getReview();
            String messageAppreciation="";

            switch (appreciation){

                case 0: messageAppreciation="En attent d'appreciation"; break;
                case 1: messageAppreciation="Pas grave !!!";break;
                case 2: messageAppreciation="Attention";break;

            }


            tvAppreciation.setText(messageAppreciation);
            tvAuthor.setText(post.getAuthorFirstName());

            Picasso.with(context).load("http://i.imgur.com/DvpvklR.png").into(ivGallery);

        }
    }
}
