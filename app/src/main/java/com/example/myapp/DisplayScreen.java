package com.example.myapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapp.db.AppDataBase;
import com.example.myapp.db.Details;
import com.example.myapp.db.User;

import java.util.List;

public class DisplayScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_info);
        Button btnLogout = (Button) findViewById(R.id.button);
        Button btnAddDetails = (Button) findViewById(R.id.button5);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent logoutScreen = new Intent(DisplayScreen.this,HomeActivity.class);
                startActivity(logoutScreen);
            }
        });

        btnAddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(DisplayScreen.this,Details.class), 100);
            }
        });
        initRecyclerView();

        SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
        String display = preferences.getString("display","");

        TextView displayInfo = (TextView) findViewById(R.id.textViewName);
        displayInfo.setText(display);
    }



    private void loadUserList() {
        AppDataBase db = AppDataBase.getDbInstance(this.getApplicationContext());
        List<User> userList = db.userDao().getAllUsers();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @androidx.annotation.Nullable Intent data) {
        if(requestCode == 100){

        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
