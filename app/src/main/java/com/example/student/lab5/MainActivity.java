package com.example.student.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import database.DBHelper;
import database.UserMaster;

public class MainActivity extends AppCompatActivity {

    TextView username, password;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        dbHelper = new DBHelper(this);
    }

    public void addInfo(View view){

        String uname = username.getText().toString();
        String pword = password.getText().toString();

       // dbHelper.addInfo(uname, pword);

        long rownum = dbHelper.addInfo(uname, pword);

        if(rownum > 0) {
            Toast.makeText(this,"User created successfully",Toast.LENGTH_LONG).show();
        }

        else{

            Toast.makeText(this,"error",Toast.LENGTH_LONG).show();

        }
    }
}
