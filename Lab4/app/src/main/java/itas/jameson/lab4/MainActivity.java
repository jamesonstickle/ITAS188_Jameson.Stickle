package itas.jameson.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.HashMap;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleButton;
    private CameraManager mCameraManager;
    private String mCameraId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        StringBuffer sb = new StringBuffer();
        sb.append("B");
        sb.append("u");
        sb.append("i");
        sb.append("l");
        sb.append("d");
        sb.append("e");
        sb.append("r");
        sb.append(".com");
        System.out.println(sb.toString());

        // PHP:
        //$array = array("evil" => "cat", "war" => "party");
        // Java:
        HashMap<String, String> wordMap;
        wordMap = new HashMap<String, String>();

        // we put key and value pairs into this map (or maybe call it dictionary)
        wordMap.put("evil", "cat");
        wordMap.put("war", "party");
        wordMap.put("good", "dogs");
        wordMap.put("Islam", "animals");
        wordMap.put("Muslim", "furry");
        // TODO: add the other words to the dictionary (wordMap)

        // some quote from George Bush
        String paragraph1 = "We're taking action against evil people. Because this great nation of many religions understands, our war is not against Islam, or against faith practiced by the Muslim people. Our war is a war against evil. This is clearly a case of good versus evil, and make no mistake about it - good will prevail.";

        // create a new buffer to store the translated paragraph (the one with the words swapped out)
        StringBuffer paragraph2 = new StringBuffer();

         StringTokenizer tokens = new StringTokenizer(paragraph1, " ,.;", true);
        // croftd: try using split instead of StringTokenizer class
        //String words2[] = paragraph1.split("([.,!?:;'\\\"-]|\\\\s)+");

        // loop through all the tokens or the array
        //for (String word : words) {
        while(tokens.hasMoreTokens()) {
            String word = tokens.nextToken();
//            word = word.trim();
            String value = wordMap.get(word);
            if (value != null) {
                paragraph2.append(value);
            } else {
                paragraph2.append(word);
            }
        }


        // TODO: show this paragraph2 content in a TextView that you added to your activity_main.xml

        final TextView helloTextView = (TextView) findViewById(R.id.textView);
        helloTextView.setText(paragraph2.toString());

        // HOW Can we support punctuation? e.g. words such as 'evil.' that have the period at the end, so they don't get translated


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


        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //called when the button status is changed

                //we will call this method to switch the flash
                switchFlashLight(isChecked);

            }
        });
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

}