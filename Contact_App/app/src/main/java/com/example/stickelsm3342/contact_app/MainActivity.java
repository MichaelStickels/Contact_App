package com.example.stickelsm3342.contact_app;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDb;
    EditText editName, editMobile, editHome, editSearch;
    Button submitData;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DatabaseHelper(this);

        editName = (EditText) findViewById(R.id.editText_Name);
        editMobile = (EditText) findViewById(R.id.editText_Home);
        editHome = (EditText) findViewById((R.id.editText_Home));
        editSearch = (EditText) findViewById(R.id.editText_search);

    }


    public void addData(View v) {
        boolean isInserted = myDb.insertData(editName.getText().toString(), editMobile.getText().toString(), editHome.getText().toString());

        if(isInserted = true) {
            Log.d("MyContact", "Data Inserted");

            Context context = getApplicationContext();
            CharSequence text = "Contact Added";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } else {
            Context context = getApplicationContext();
            CharSequence text = "Contact Error";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void viewData(View v) {
        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            showMessage("Error", "No data found in database");
            Log.d("Error", "No data found in database");
            return;
        }

        StringBuffer buffer = new StringBuffer();

        res.moveToFirst();

        for(int x = 0; x < res.getCount(); x++) {
            for (int i = 0; i < res.getColumnCount(); i++) {
                buffer.append(res.getString(i));
                buffer.append("\n");
            }
            res.moveToNext();
        }

        showMessage("Data", buffer.toString());
    }

    private void showMessage(String data, String s) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(data);
        builder.setMessage(s);
        builder.show();

    }

    public void searchscreen(View v) {

        Intent intent = new Intent(this, search.class).putExtra("results", myDb.Search(editSearch.getText().toString()));
        startActivity(intent);

    }



}
