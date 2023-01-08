package com.example.myhouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText email,efirstname,elastname,epassword,ephone;
    Button esingin;
    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
   DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        efirstname=findViewById(R.id.firstNameInput);
        elastname=findViewById(R.id.lastNameInput);
        email=findViewById(R.id.mailInput);
        epassword=findViewById(R.id.passwordInput);
        ephone=findViewById(R.id.phoneInput);
        firebaseAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");
    }

    public void Signup_su(View view) {

        String firstname= efirstname.getText().toString().trim();
        String lastname= elastname.getText().toString().trim();
        String phone= ephone.getText().toString().trim();
        String mail= email.getText().toString().trim();
        String password= epassword.getText().toString().trim();
        firebaseAuth.createUserWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    firebaseUser=task.getResult().getUser();
                    DatabaseReference newUser=databaseReference.child(firebaseUser.getUid());
                   newUser.child("First Name :") .setValue(firstname);
                   newUser.child("Last Name :").setValue(lastname);
                   newUser.child("phone :").setValue(phone);
                   newUser.child("email :").setValue(mail);
                   newUser.child("Password : ").setValue(password);
                    Intent t = new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(t);
                   Toast.makeText(MainActivity.this,"Registration Successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                }
            }
        });



    }}

//    public void Login_su(View view) {
//        Intent t = new Intent(this,MainActivity3.class);
//        startActivity(t);
//    }
//}