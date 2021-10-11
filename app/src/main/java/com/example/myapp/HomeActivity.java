package com.example.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final EditText etEmail = (EditText) findViewById(R.id.editTextTextEmailAddress2);
        final EditText etPassword = (EditText) findViewById(R.id.editTextTextPassword3);
        Button btnRegister = (Button) findViewById(R.id.button2);
        Button btnForgot = (Button) findViewById(R.id.button3);
        Button btnLogin = (Button) findViewById(R.id.button4);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);


                String userDetails = preferences.getString(email + password + "data","No information on that user.");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display",userDetails);
                editor.commit();

                Intent displayScreen = new Intent(HomeActivity.this, DisplayScreen.class);
                startActivity(displayScreen);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registerScreen = new Intent(HomeActivity.this, Register.class);
                startActivity(registerScreen);
            }
        });
    }
    public void displayToast(View v)
    {
        Toast.makeText(HomeActivity.this,"Password Display",Toast.LENGTH_SHORT).show();
    }
}