package com.example.recyclerviewjson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements KittenAdapter.OnItemClickListener {

    //Constants for intent
    public static final String EXTRA_URL = "imageUrl";
    public static final String EXTRA_NAME = "kittenName";
    public static final String EXTRA_LIKES = "likeCount";

    private RecyclerView recyclerView;
    private KittenAdapter kittenAdapter;
    private ArrayList<KittenItem> kittenList;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        kittenList = new ArrayList<>();

        requestQueue = Volley.newRequestQueue(this);
        parseJSON();



    }


    private void parseJSON() {

        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("hits");

                            for(int i = 0; i < jsonArray.length(); i++){

                                JSONObject hit = jsonArray.getJSONObject(i);

                                String kittenName = hit.getString("user");
                                String imageUrl = hit.getString("webformatURL");
                                int kittenLikes = hit.getInt("likes");

                                kittenList.add(new KittenItem(imageUrl, kittenName, kittenLikes));

                            }

                            kittenAdapter = new KittenAdapter(getApplicationContext(), kittenList);
                            recyclerView.setAdapter(kittenAdapter);
                            kittenAdapter.setOnItemClickListener(MainActivity.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        requestQueue.add(request);

    }

    @Override
    public void onItemClick(int position) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        KittenItem clickedItem = kittenList.get(position);

        detailIntent.putExtra(EXTRA_URL, clickedItem.getImageUrl());
        detailIntent.putExtra(EXTRA_NAME, clickedItem.getKittenName());
        detailIntent.putExtra(EXTRA_LIKES, clickedItem.getKittenLikes());

        startActivity(detailIntent);
    }
}
