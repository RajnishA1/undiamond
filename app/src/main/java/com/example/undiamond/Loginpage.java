package com.example.undiamond;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


public class Loginpage extends AppCompatActivity {
  private EditText emailedittext , passwordexittext;

 private Button submitbutton;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        emailedittext = findViewById(R.id.emailedittext);
         passwordexittext = findViewById(R.id.passwordedittext);
        submitbutton = findViewById(R.id.submitbutton);
        submitbutton.setEnabled(true);
        // Write a message to the database


        passwordexittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!passwordexittext.getText().toString().isEmpty()){
                    submitbutton.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

                if(passwordexittext.getText().toString().isEmpty()){
                    submitbutton.setEnabled(false);
               }
            }
        });
        emailedittext.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

           }

           @Override
           public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
             if(emailedittext.getText().toString().trim().endsWith("gmail.com")){
               submitbutton.setEnabled(true);
             }
           }

           @Override
           public void afterTextChanged(Editable editable) {

               if(emailedittext.getText().toString().trim().endsWith("gmail.com" ) || passwordexittext.getText().toString().trim().isEmpty()){
                   submitbutton.setEnabled(false);


               }
           }
       });

    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public void video(View view ) {
           if (emailedittext.getText().toString().endsWith("gmail.com")) {

               Map<String, String> user = new HashMap<>();
               user.put("email", emailedittext.getText().toString());
               user.put("password",  passwordexittext.getText().toString());

               FirebaseDatabase database = FirebaseDatabase.getInstance();
               DatabaseReference myRef = database.getReference().child("users");

               myRef.push().setValue(user);
               Intent intent1 = new Intent(this, VideoPage.class);
               startActivity(intent1);
           }
           else {
               Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show();

           }
        }

    }

