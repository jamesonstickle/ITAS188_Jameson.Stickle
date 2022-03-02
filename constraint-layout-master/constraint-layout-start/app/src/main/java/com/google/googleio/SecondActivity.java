package com.google.googleio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toast toast=Toast.makeText(getApplicationContext(),"Started Second Activity",Toast.LENGTH_SHORT);
        toast.show();

        String data = getIntent().getExtras().getString("keyName");
        Log.d("JAMTAG", "Running second activity, here is the value passed: " + data);

        TextView textView = findViewById(R.id.textView2);
        textView.setText("Here is the data passed from MainActivity: " + data);
    }
}