package com.example.mvvmdemo.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mvvmdemo.R;
import com.example.mvvmdemo.model.NicePlaces;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
        Context mContext;
        private List<NicePlaces> NicePlace;

    public RecyclerAdapter(Context mContext, List<NicePlaces> nicePlace) {
        this.mContext = mContext;
        NicePlace = nicePlace;
    }

    @NonNull
        @Override
        public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.list, parent, false);
            return new RecyclerAdapter.ViewHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {
          holder.textView.setText(NicePlace.get(position).getTitle());
            Glide.with(mContext).load(NicePlace.get(position).getImageurl()).into(holder.imageView);
        }

        @Override
        public int getItemCount() {
            return NicePlace.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;
            public TextView textView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                imageView=itemView.findViewById(R.id.image);
                textView=itemView.findViewById(R.id.text);
        }
    }

}
