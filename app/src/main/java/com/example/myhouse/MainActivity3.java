package com.example.myhouse;




import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
   TextView ewrite , ecommante;
   ImageView images;
   Button Imagess;



 private final int GALLERY_REQ_CODE=1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        images=findViewById(R.id.imageView4);
        ewrite=findViewById(R.id.write);

        ecommante=findViewById(R.id.commante);
    }

    public void wishlist(View view) {
      Intent t= new Intent(this,MainActivity4.class);
      startActivity(t);

    }

    public void Upload(View view) {
        String newrite = ewrite.getText().toString();
        ecommante.setText(newrite);


    }

    public void Images(View view) {

        Intent igallery = new Intent(Intent.ACTION_PICK);
         igallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
      startActivity(igallery);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        images.setImageURI(data.getData());



    }
}