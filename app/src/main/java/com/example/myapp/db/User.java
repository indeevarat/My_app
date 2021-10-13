package com.example.myapp.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "user_name")
    public String username;

    @ColumnInfo(name = "mother_name")
    public String mothername;
    @ColumnInfo(name = "father_name")
    public String fathername;
    @ColumnInfo(name = "address")
    public String address;

}
