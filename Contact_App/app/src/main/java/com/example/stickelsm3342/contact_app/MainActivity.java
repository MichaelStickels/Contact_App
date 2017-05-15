package com.example.stickelsm3342.contact_app;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName;
    Button submitData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_Name);

    }


    public void addData(View v) {
        boolean isInserted = myDb.insertData(editName.getText().toString());

        if(isInserted = true) {
            Log.d("MyContact", "Data Inserted");
            //create toast message
        } else {
            //toast error message
        }

    }

}
