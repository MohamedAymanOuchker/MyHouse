package com.example.myhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Signup_su(View view) {
        Intent t = new Intent(this,MainActivity4.class);
        startActivity(t);
    }

    public void Login_su(View view) {
        Intent t = new Intent(this,MainActivity2.class);
        startActivity(t);
    }
}