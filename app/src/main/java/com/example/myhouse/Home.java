package com.example.myhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void addPost(View view) {
        Intent t = new Intent(this,Post.class);
        startActivity(t);
    }

    public void explore(View view) {
        Intent t = new Intent(this, RetrieveData.class);
        startActivity(t);
    }

    public void wishlist(View view) {
        Intent t = new Intent(this,WishList.class);
        startActivity(t);
    }

    public void inbox(View view) {
//        Intent t = new Intent(this,Inbox.class);
//        startActivity(t);
    }

    public void profil(View view) {
        Intent t = new Intent(this,Profile.class);
        startActivity(t);
    }
}