package itas.croftd.lab3_dave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Snackbar snackbar = Snackbar.make(findViewById(R.id.textView2),
                "Started the second activity",Snackbar.LENGTH_SHORT);
        snackbar.show();

        String data = getIntent().getExtras().getString("keyName");
        Log.d("JAMTAG", "Running second activity, here is the value passed: " + data);

        TextView textView = findViewById(R.id.textView2);
        textView.setText("Here is the data passed from MainActivity: " + data);
    }
}