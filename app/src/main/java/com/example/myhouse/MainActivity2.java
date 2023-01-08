package com.example.myhouse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {
    EditText email,epassword;
    Button esingin;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        email=findViewById(R.id.email);
        epassword=findViewById(R.id.password);
        firebaseAuth=FirebaseAuth.getInstance();

    }



    public void Login_li(View view) {


        String mail=email.getText().toString().trim();
        String password=epassword.getText().toString().trim();
        if(!mail.isEmpty() && !password.isEmpty()){
            firebaseAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
               public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()){
                       Toast.makeText(MainActivity2.this,("welcom"),Toast.LENGTH_SHORT).show();
                       Intent t = new Intent(MainActivity2.this,MainActivity3.class);
                        startActivity(t);}
                }
           });

     }


   }
   public void Signup_li(View view) {
        Intent t = new Intent(this,MainActivity.class);
        startActivity(t);
    }
}
class scrollv extends ScrollView {
    public scrollv(Context context) {
        super(context);




    }



}
