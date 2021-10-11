package com.example.myapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText userName = (EditText) findViewById(R.id.etNewName);
        final EditText number = (EditText) findViewById(R.id.etNewNumber);
        final EditText email = (EditText) findViewById(R.id.etNewEmail);
        final EditText password = (EditText) findViewById(R.id.etNewPassword);
        final EditText repassword = (EditText) findViewById(R.id.etNewRePassword);
        Button btnRegister = (Button) findViewById(R.id.Register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String newUser = userName.getText().toString();
                String newNumber = number.getText().toString();
                String newEmail = email.getText().toString();
                String newPassword = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(newUser,newUser);
                editor.commit();
                editor.putString(newNumber,newNumber);
                editor.commit();
                editor.putString(newEmail,newEmail);
                editor.commit();
                editor.putString(newPassword,newPassword);
                editor.commit();

                Intent loginScreen = new Intent(Register.this, HomeActivity.class);
                startActivity(loginScreen);
            }
        });
    }
}
