package com.example.birdgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView volume;
    private Button buttonStart;
    private MediaPlayer mediaPlayer;

    boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bird = findViewById(R.id.bird);
        ImageView enemy1 = findViewById(R.id.enemy1);
        ImageView enemy2 = findViewById(R.id.enemy2);
        ImageView enemy3 = findViewById(R.id.enemy3);
        ImageView coin = findViewById(R.id.coin);

        volume = findViewById(R.id.volume);
        buttonStart = findViewById(R.id.buttonStart);

        Animation animation = AnimationUtils.loadAnimation(
                MainActivity.this,
                R.anim.scale_animation);

        bird.setAnimation(animation);
        enemy1.setAnimation(animation);
        enemy2.setAnimation(animation);
        enemy3.setAnimation(animation);
        coin.setAnimation(animation);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.audio_for_game);
        mediaPlayer.start();

        volume.setOnClickListener(v -> {
            if (!status) {
                mediaPlayer.setVolume(0, 0);
                volume.setImageResource(R.drawable.volume_off);
                status = true;
            } else {
                mediaPlayer.setVolume(1, 1);
                volume.setImageResource(R.drawable.volume_up);
                status = false;
            }
        });

        buttonStart.setOnClickListener(v -> {
            mediaPlayer.reset();
            volume.setImageResource(R.drawable.volume_up);

            Intent intent = new Intent(MainActivity.this, GameActivity.class);
            startActivity(intent);
        });
    }
}