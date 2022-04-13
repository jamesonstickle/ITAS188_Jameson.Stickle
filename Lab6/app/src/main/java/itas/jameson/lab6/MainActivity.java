package itas.jameson.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private final String NUMBER_KEY = "number_key";
    private final String STRING_KEY = "string_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Code to get a handle to the default SharedPreferences
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);


        // To retrieve the number....
        // NOTE, the second parameter is the default if no value has been
        // stored previously
        int defaultValue = sharedPref.getInt(NUMBER_KEY, 0);
        String defaultString = sharedPref.getString(STRING_KEY, "default");

        // Now put this in the EditText field for number
        EditText textView = (EditText)findViewById(R.id.editTextNumber);
        EditText textView2 = (EditText)findViewById(R.id.editTextTextPersonName);
        // we have to put an empty string at the start to force the number to be converted
        textView.setText("" + defaultValue);
        textView2.setText("" + defaultString);


    }
    public void save(View view) {

        // Code to get a handle to the default SharedPreferences
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        EditText editText = (EditText) findViewById(R.id.editTextNumber);
        EditText editText2 = (EditText) findViewById(R.id.editTextTextPersonName);
        String number = editText.getText().toString();
        String name = editText2.getText().toString();
        int numb = Integer.parseInt(number);

        // Add an Integer value 10 and store this with the key NUMBER_KEY
        editor.putInt(NUMBER_KEY, numb);
        editor.putString(STRING_KEY, name);
        editor.commit();

    }

    public void login(View view) {

        EditText editUser = (EditText) findViewById(R.id.editUser);
        EditText editPassword = (EditText) findViewById(R.id.editPass);
        String user = editUser.getText().toString();
        String pass = editPassword.getText().toString();

        writeToFile(user, pass, this);


    }
    // writes to a textfile with the username, password and date/time. Appends to end of file.
    public void writeToFile(String user, String pass, Context context) {
        Date currentTime = Calendar.getInstance().getTime();
        String login = user + '\t' + '\t' + pass + '\t' + '\t' + currentTime + '\n';

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("login_data.txt", Context.MODE_PRIVATE | Context.MODE_APPEND));
            outputStreamWriter.append(login);
            outputStreamWriter.close();
            ContextWrapper c = new ContextWrapper(this);
            Toast.makeText(this, c.getFilesDir().getPath(), Toast.LENGTH_LONG).show();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
        }
    }

}