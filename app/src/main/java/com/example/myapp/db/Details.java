package com.example.myapp.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapp.R;

public class Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        final EditText Name = findViewById(R.id.Name);
        final EditText mother_name = findViewById(R.id.mother_name);
        final EditText father_name = findViewById(R.id.father_name);
        final EditText address = findViewById(R.id.address);
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = Name.getText().toString();
                String mName = mother_name.getText().toString();
                String fName = father_name.getText().toString();
                String add = address.getText().toString();

            }
        });
    }

    private void saveNewUser(String name, String mName, String fName, String add) {
        AppDataBase db = AppDataBase.getDbInstance(this.getApplicationContext());
        User user = new User();
        user.mothername = mName;
        user.fathername = fName;
        user.address = add;

        db.userDao().insertUser();
        finish();

    }
}