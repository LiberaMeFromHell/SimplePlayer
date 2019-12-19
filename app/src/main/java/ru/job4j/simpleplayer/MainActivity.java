package ru.job4j.simpleplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer media;
    private Spinner spinner;
    private Store soundStore;
    private Uri audioUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if (intent != null) {
            audioUri = intent.getData();
        }

        soundStore = new SoundStore();

        Button play = findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (audioUri != null) {
                        media = MediaPlayer.create(MainActivity.this, audioUri);
                    } else {
                        media = MediaPlayer.create(MainActivity.this, soundStore.getIdByName(spinner.getSelectedItem().toString()));
                    }
                    media.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Button stop = findViewById(R.id.stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    media.pause();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, soundStore.getNames());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        media.release();
        media = null;
    }
}
