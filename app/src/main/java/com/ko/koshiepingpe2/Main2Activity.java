package com.ko.koshiepingpe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {
    TextView[] output = new TextView[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setTitle("CONFIRMATION");

        output[0] = findViewById(R.id.textView5);
        output[1] = findViewById(R.id.textView7);

        FileInputStream reader = null;
        FileInputStream reader2 = null;
        String events = "";
        String comments = "";
        try {
            reader = openFileInput("data1.txt");
            reader2 = openFileInput("comments.txt");
            int token;

            while((token = reader.read()) != -1) {
                events += (char)token;
            }

            while((token = reader2.read()) != -1) {
                comments += (char)token;
            }


        } catch(FileNotFoundException ex) {
            Log.d("error", "file not found...");
        } catch(IOException ex) {
            Log.d("error", "IO error...");
        }

        output[0].setText(events);
        output[1].setText(comments);

    }
    public void previousPage(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void send (View v){
        Toast.makeText(this, "Registration Sent", Toast.LENGTH_LONG).show();
    }
}
