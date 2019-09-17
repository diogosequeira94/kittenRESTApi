package com.example.recyclerviewjson;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class KittenAdapter extends RecyclerView.Adapter<KittenAdapter.KittenViewHolder> {

    private Context context;
    private ArrayList<KittenItem> kittenList;

    public KittenAdapter(Context context, ArrayList<KittenItem> kittenList){
        this.context = context;
        this.kittenList = kittenList;
    }

    @NonNull
    @Override
    public KittenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.kitten_item, parent, false);

        return new KittenViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull KittenViewHolder holder, int position) {

        // Current item of our ArrayList

        KittenItem currentKitten = kittenList.get(position);

        String imageUrl = currentKitten.getImageUrl();
        String kittenName = currentKitten.getKittenName();
        int kittenLikes = currentKitten.getKittenLikes();

        //Setting the views properties to the cards

        holder.kittenName.setText(kittenName);
        holder.kittenLikes.setText("" + kittenLikes);
        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return kittenList.size();
    }


    public class KittenViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView kittenName;
        public TextView kittenLikes;

        public KittenViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            kittenLikes = itemView.findViewById(R.id.text_likes);
            kittenName = itemView.findViewById(R.id.text_kitten_name);

        }
    }
}
