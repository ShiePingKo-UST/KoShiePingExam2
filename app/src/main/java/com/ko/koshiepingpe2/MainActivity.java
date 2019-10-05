package com.ko.koshiepingpe2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    CheckBox[] events = new CheckBox[8];
    EditText comments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        events[0] = findViewById(R.id.checkBox1);
        events[1] = findViewById(R.id.checkBox2);
        events[2] = findViewById(R.id.checkBox3);
        events[3] = findViewById(R.id.checkBox4);
        events[4] = findViewById(R.id.checkBox5);
        events[5] = findViewById(R.id.checkBox6);
        events[6] = findViewById(R.id.checkBox7);
        events[7] = findViewById(R.id.checkBox8);

        comments = findViewById(R.id.editText2);
    }

    public void nextPage(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
    }

    public void saveEvents (View v){
        String data = "";
        String comment = "";

        comment = comments.getText().toString();

        for(int i = 0; i < events.length; i++) {
            if(events[i].isChecked()){
                data += events[i].getText().toString() + "\n";
            }
        }
        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);
            writer.write(data.getBytes());

            writer = openFileOutput("comments.txt", MODE_PRIVATE);
            writer.write(comment.getBytes());


        } catch(FileNotFoundException ex) {
            Log.d("error", "File not found...");
        } catch(IOException ex) {
            Log.d("error", "IO error...");
        } finally {
            try {
                writer.close();
            } catch(IOException ex) {
                Log.d("error", "file not found...");
            }
        }

        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }
}
