package com.example.stickelsm3342.contact_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class search extends AppCompatActivity {

    EditText editSearch;
    TextView Name, Mobile, Home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Name = (TextView) findViewById(R.id.textView_Name);
        Name.setText("test");
        Mobile = (TextView) findViewById(R.id.textView_Name);
        Mobile.setText("test");
        Home = (TextView) findViewById(R.id.textView_Name);
        Home.setText("test");

    }



}
