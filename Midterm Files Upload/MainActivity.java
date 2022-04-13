package itas.jameson.jamesonstickle_itas188_midtermquiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private TextToSpeech tts;
    private CameraManager mCameraManager;
    private String mCameraId;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.imageButton2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listen();
            }
        });

        boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isFlashAvailable) {
            showNoFlashError();
        }

        //getting the camera manager and camera id
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            mCameraId = mCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }

        toggleButton = findViewById(R.id.toggleButton2);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //called when the button status is changed
                if (isChecked) {
                    // The toggle is enabled
                    switchFlashLight(true);
                } else {
                    // The toggle is disabled
                    switchFlashLight(false);
                }
            }
        });

        //sound toggle
        Switch mute = (Switch) findViewById(R.id.switch1);
        mute.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                AudioManager amanager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
                if (isChecked) {
                    // The toggle is enabled
                    amanager.adjustVolume(AudioManager.ADJUST_MUTE, AudioManager.FLAG_SHOW_UI);
                    Log.d("JAMTAG", "sound muted");
                    Toast.makeText(MainActivity.this, "MUTED", Toast.LENGTH_SHORT).show();
                } else {
                    // The toggle is disabled
                    amanager.adjustVolume(AudioManager.ADJUST_UNMUTE, AudioManager.FLAG_SHOW_UI);
                    Log.d("JAMTAG", "sound unmuted");
                    Toast.makeText(MainActivity.this, "UNMUTED", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //listen button

    }

    private void listen() {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something");

        try {
            startActivityForResult(i, 100);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(MainActivity.this, "Your device doesn't support Speech Recognition", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK && null != data) {
                ArrayList<String> res = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                String inSpeech = res.get(0);
                recognition(inSpeech);
            }
        }
    }

    private void recognition(String text) {
        Log.e("Speech", "" + text);
        final EditText translatedSpeech = (EditText) findViewById(R.id.englishText);
        translatedSpeech.setText(text);
    }

    public void showNoFlashError() {
        AlertDialog alert = new AlertDialog.Builder(this)
                .create();
        alert.setTitle("Oops!");
        alert.setMessage("Flash not available in this device...");
        alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }

    public void switchFlashLight(boolean status) {
        try {
            mCameraManager.setTorchMode(mCameraId, status);
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }
    }

    //dictionary
    public void translate(View view) {
        HashMap<String, String> words;
        words = new HashMap<String, String>();
        words.put("Hello", "Ahoyyy");
        words.put("Hi", "Ahoy");
        words.put("yes", "Ai");
        words.put("ok", "Ai");
        words.put("no", "Nai");
        words.put("Treasure", "Booty");
        words.put("money", "Loot");
        words.put("cash", "gold");
        words.put("everyone", "all hands");
        words.put("friend", "bucko");
        words.put("rob", "pillage");
        words.put("sea", "chuck");
        words.put("see", "spie");
        words.put("beer", "groog");
        words.put("friends", "me hearties");
        words.put("jerk", "scallywag");
        words.put("pirate", "buccaneer");
        words.put("bag", "duffle");
        words.put("your", "yer");
        words.put("me", "my");
        words.put("telescope", "spyglass");
        words.put("kitchen", "galley");
        words.put("boy", "lad");
        words.put("girl", "lass");
        words.put("clean", "swab");
        words.put("wow", "blimey");
        words.put("room", "cabin");
        words.put("quickly", "smartly");
        words.put("bed", "cot");
        words.put("surprise", "sink me");
        words.put("food", "grub");
        words.put("cheat", "hornswaggle");
        words.put("sailor", "Jack Tar");
        words.put("the", "thee");
        words.put("store", "market");
        words.put("I", "eye");
        words.put("hungry", "starvin");
        words.put("bad", "vile");
        words.put("hit", "skewer");
        words.put("wind", "blow");
        words.put("windy", "good blow");

        //BONUS MARKS AREA?
        // none of this did anything but I tried really hard
//        if (words.containsKey("pirate") && words.containsKey("flag")) {
//            words.put("pirate flag", "Jolly Roger");
//        }
//        if (words.containsKey("I") && words.containsKey("am")) {
//            words.put("I am", "I be");
//        }
//        if (words.containsKey("where") && words.containsKey("is")) {
//            words.put("where is", "where be");
//        }
//        words.put("pirate flag", "Jolly Roger");
//        words.put("I am", "I be");
//        words.put("where is", "where be");

        EditText englishText = (EditText) findViewById(R.id.englishText);
        String paragraph1 = String.valueOf(englishText.getText());
        StringBuffer paragraph2 = new StringBuffer();
        String[] addWordStart = {"", "Yar! ", "Blimey ", "Yo ho ho ", "Shiver me timber "};
        String startWords = addWordStart[(int) (Math.random() * addWordStart.length)];
        String[] addWordEnd = {" ye son of a biscuit eater", " ye sea dog", " ye salty sea bass"};
        String endWords = addWordEnd[(int) (Math.random() * addWordEnd.length)];
        paragraph2.insert(0, startWords);
        StringTokenizer tokens = new StringTokenizer(paragraph1, " ,.;", true);

        while (tokens.hasMoreTokens()) {
            String word = tokens.nextToken();
            String value = words.get(word);
            //attempt #2 at bonus marks
            //nope
//            if (word == ("pirate flag")) {
//                String jollyRoger = "Jolly Roger";
//                paragraph2.append(jollyRoger);
//            }
//            if (word == ("I am")) {
//                String iBe = "I be";
//                paragraph2.append(iBe);
//            }
//            if (word == ("where is")) {
//                String whereBe = "where be";
//                paragraph2.append(whereBe);
//            }
            if (word.equalsIgnoreCase("you")) {
                String[] yous = {"ye", "ye filthy", "ye yellow bellied"};
                String youP = yous[(int) (Math.random() * yous.length)];
                paragraph2.append(youP);
            } else {
                if (value != null) {
                    paragraph2.append(value);
                } else {
                    paragraph2.append(word);
                }
            }
        }
        paragraph2.append(endWords);
        final TextView translatedText = (TextView) findViewById(R.id.translatedText);
        translatedText.setText(paragraph2.toString());
        Log.d("JAMTAG", "translate() method called");
        Toast.makeText(MainActivity.this, "translate() method called", Toast.LENGTH_SHORT).show();


        //text to speech code
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = tts.setLanguage(Locale.US);
                    if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "This Language is not supported");
                    }
                    speak(paragraph2.toString());
                    Log.d("JAMTAG", "TextToSpeech is working!");
                    Toast.makeText(MainActivity.this, "TextToSpeech working", Toast.LENGTH_SHORT).show();
                } else {
                    Log.e("TTS", "Initilization Failed!");
                }
            }
        });
    }

    //speech code
    private void speak(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    //code if app is stopped
    @Override
    public void onDestroy() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}

