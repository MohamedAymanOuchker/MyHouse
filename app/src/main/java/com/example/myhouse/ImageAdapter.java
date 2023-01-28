//A

package com.example.myhouse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    Context context;
    List<ImageModel> imageModelList;

    public ImageAdapter(Context context, List<ImageModel> imageModelList) {
        this.context = context;
        this.imageModelList = imageModelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_row_for_recycleview,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageModel imageModel = imageModelList.get(position);
        holder.tvFirst.setText("First Name=" + imageModel.getFirstName());
        holder.tvLast.setText("Last Name=" + imageModel.getLastName());

        String imageUri = null;
        imageUri = imageModel.getImage();
        Picasso.get().load(imageUri).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return imageModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView tvFirst, tvLast;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_recyclerview_id);
            tvFirst = itemView.findViewById(R.id.tvfirstname_recyclerview_id);
            tvLast = itemView.findViewById(R.id.tvlastName_recyclerview_id);
        }
    }
}
