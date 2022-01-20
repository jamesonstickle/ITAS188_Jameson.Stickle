package itas.jameson.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNumbers(View view) {

        Log.d("cats2", "Running the showNumbers() method");

        TextView textView = findViewById(R.id.textView);

        String numbers = "";

        int i = 0;
        int num = 0;

        for (i = 1; i <= 100; i++) {
            int counter = 0;
            for (num = i; num >= 1; num--) {
                if (i % num == 0) {
                    counter = counter + 1;
                }
            }
            if (counter == 2) {
                //Appended the Prime number to the String
                numbers = numbers + i + " ";
            }
        }
        textView.setText(numbers);
    }

    public void makeNoise(View view) {
        Log.d("cats2", "Running the makeNoise() method");
        try {

            // Use the Snackbar to show the user a message
            //Snackbar.make(view, "Playing music!", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show();
            String url = "https://www.wavsource.com/snds_2020-10-01_3728627494378403/movies/terminator/t1_be_back.wav";

            MediaPlayer mp = new MediaPlayer();

            // DAVE - OLD WAY
            // mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

            // apparently this is the newer way to use the MediaPlayer
            mp.setAudioAttributes(new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            );

            mp.setDataSource(url);
            mp.prepare();
            mp.start();

            // Use Toast to show the user a message
            Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            // cats22 is the tag I am using to filter the error log for messages
            Log.e("cats22", "MediaPlayer failed", e);
            // Use Toast to show the user a message
            Toast.makeText(getApplicationContext(), "Error playing the sound file", Toast.LENGTH_SHORT).show();

        }
    }

    public void showWeb(View view) {
        Log.d("cats2", "Running the showWeb() method");
        WebView myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.setWebViewClient(new WebViewClient());

        myWebView.loadUrl("https://dev.itas.ca/~jameson.stickle/ITAS191/FinalProject/index.html");
    }

    public void playSongOne(View view) {
        Log.d("cats2", "Running the makeNoise() method");
        try {

            // Use the Snackbar to show the user a message
            //Snackbar.make(view, "Playing music!", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show();
            //String url = "C:\\Users\\ITAS\\ITAS188_Mobile_Development_I\\Lab2\\app\\src\\main\\res\\raw\\tints.mp3";

            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.tints);
            mediaPlayer.start();
            /*
            // DAVE - OLD WAY
            // mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

            // apparently this is the newer way to use the MediaPlayer
            mp.setAudioAttributes(new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            );

            //mp.setDataSource(url);
            mp.setDataSource(R.raw.tints);
            mp.prepare();
            mp.start();

            */

            // Use Toast to show the user a message
            Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            // cats22 is the tag I am using to filter the error log for messages
            Log.e("cats22", "MediaPlayer failed", e);
            // Use Toast to show the user a message
            Toast.makeText(getApplicationContext(), "Error playing the sound file", Toast.LENGTH_SHORT).show();

        }
    }

    public void playSongTwo(View view) {
        Log.d("cats2", "Running the makeNoise() method");
        try {

            // Use the Snackbar to show the user a message
            //Snackbar.make(view, "Playing music!", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show();
            //String url = "C:\\Users\\ITAS\\ITAS188_Mobile_Development_I\\Lab2\\app\\src\\main\\res\\raw\\tints.mp3";

            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.rum);
            mediaPlayer.start();
            /*
            // DAVE - OLD WAY
            // mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

            // apparently this is the newer way to use the MediaPlayer
            mp.setAudioAttributes(new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            );

            //mp.setDataSource(url);
            mp.setDataSource(R.raw.tints);
            mp.prepare();
            mp.start();

            */

            // Use Toast to show the user a message
            Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            // cats22 is the tag I am using to filter the error log for messages
            Log.e("cats22", "MediaPlayer failed", e);
            // Use Toast to show the user a message
            Toast.makeText(getApplicationContext(), "Error playing the sound file", Toast.LENGTH_SHORT).show();

        }
    }

    public void myFace(View view) {
        Log.d("cats2", "Running the makeNoise() method");
        try {

            // Use the Snackbar to show the user a message
            //Snackbar.make(view, "Playing music!", Snackbar.LENGTH_LONG)
            //    .setAction("Action", null).show();
            String url = "https://orangefreesounds.com/wp-content/uploads/2014/10/Jeopardy-theme-song.mp3?_=1";

            MediaPlayer mp = new MediaPlayer();

            // DAVE - OLD WAY
            // mp.setAudioStreamType(AudioManager.STREAM_MUSIC);

            // apparently this is the newer way to use the MediaPlayer
            mp.setAudioAttributes(new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            );

            mp.setDataSource(url);
            mp.prepare();
            mp.start();

            // Use Toast to show the user a message
            Toast.makeText(getApplicationContext(), "Playing", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            // cats22 is the tag I am using to filter the error log for messages
            Log.e("cats22", "MediaPlayer failed", e);
            // Use Toast to show the user a message
            Toast.makeText(getApplicationContext(), "Error playing the sound file", Toast.LENGTH_SHORT).show();

        }
    }

    public void errorMethod(View view) {
        Log.d("dogs22", "Running the fake error method.");
        try {
            throw new RuntimeException("This is a crash... AHHHHH!!!!");
        } catch (Exception e) {
            Log.e("dogs22", "Check it out, I made a fake error");
        }
    }
}