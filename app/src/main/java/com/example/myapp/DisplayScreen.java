package com.example.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);
        Button btnLogout = (Button) findViewById(R.id.button);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutScreen = new Intent(DisplayScreen.this,HomeActivity.class);
                startActivity(logoutScreen);
            }
        });

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display","");

        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
        displayInfo.setText(display);
    }
}
