package com.example.recyclerviewjson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.recyclerviewjson.MainActivity.EXTRA_LIKES;
import static com.example.recyclerviewjson.MainActivity.EXTRA_NAME;
import static com.example.recyclerviewjson.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

      doAllStuff();

    }

    private void doAllStuff(){
        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String kittenName = intent.getStringExtra(EXTRA_NAME);
        int likeCount = intent.getIntExtra(EXTRA_LIKES, 0);

        ImageView imageView = findViewById(R.id.image_view_detail);
        TextView textViewName = findViewById(R.id.text_kitten_detail);
        TextView textViewLikes = findViewById(R.id.text_likes_detail);

        Picasso.with(this).load(imageUrl).fit().centerInside().into(imageView);
        textViewName.setText(kittenName);
        textViewLikes.setText("" + likeCount);

    }
}
