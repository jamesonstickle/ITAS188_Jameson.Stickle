// Copyright 2016 Google Inc.
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//      http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.googleio;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    private static final int REQUEST_IMAGE_CAPTURE = 1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_done);
        Log.d("JAMTAG", "onCreate() method called");
        Toast.makeText(MainActivity.this, "onCreate() method called", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("JAMTAG", "onStart() method called");
        Toast.makeText(MainActivity.this, "onStart() method called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("JAMTAG", "onRestart() method called");
        Toast.makeText(MainActivity.this, "onRestart() method called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("JAMTAG", "onResume() method called");
        Toast.makeText(MainActivity.this, "onResume() method called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("JAMTAG", "onPause() method called");
        Toast.makeText(MainActivity.this, "onPause() method called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("JAMTAG", "onStop() method called");
        Toast.makeText(MainActivity.this, "onStop() method called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("JAMTAG", "onDestroy() method called");
        Toast.makeText(MainActivity.this, "onDestroy() method called", Toast.LENGTH_SHORT).show();
    }
    public void dialOut(View view) {
        Uri number = Uri.parse("tel:7802216050");
        Intent dial = new Intent(Intent.ACTION_DIAL, number);
        startActivity(dial);
        Log.d("JAMTAG", "dialOut() method called");
    }
    public void capturePhoto(View view) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            Log.d("JAMTAG", "capturePhoto() method called");
        }
    }
    public void startSecond(View view) {
        // create an Intent to launch the Second Activity
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("keyName","cat");
        intent.putExtra("numberValue", 99);
        startActivity(intent);
        finish();
    }
}
