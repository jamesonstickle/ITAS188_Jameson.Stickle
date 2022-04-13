package itas.croftd.lab3_dave;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    protected String cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        this.cat = "Fluffy";

        Log.d("ITAS274", "onStart() method running...");
    }

    public void startSecond(View view) {
        // create an Intent to launch the Second Activity
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("keyName","cat");
        intent.putExtra("numberValue", 99);
        startActivity(intent);
    }
}