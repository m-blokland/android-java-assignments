package com.example.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {

    private TextView
            textViewFileNameMusic,
            textViewProgress,
            textViewTotalTime;

    private Button buttonPlayPause;

    private SeekBar seekBarVolume, seekBarMusic;

    private MediaPlayer mediaPlayer;

    ArrayList<String> list;

    String title, filePath;

    Runnable runnable;
    Handler handler;

    int totalTime;
    int position;

    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        buttonPlayPause = findViewById(R.id.buttonPlayPause);
        Button buttonNext = findViewById(R.id.buttonNext);
        Button buttonPrevious = findViewById(R.id.buttonPrevious);
        textViewFileNameMusic = findViewById(R.id.textViewFileNameMusic);
        textViewProgress = findViewById(R.id.textViewProgress);
        textViewTotalTime = findViewById(R.id.textViewTotalTime);
        seekBarMusic = findViewById(R.id.musicSeekBar);
        seekBarVolume = findViewById(R.id.volumeSeekBar);

        animation = AnimationUtils.loadAnimation(MusicActivity.this, R.anim.translate_animation);
        textViewFileNameMusic.setAnimation(animation);

        title = getIntent().getStringExtra("title");
        filePath = getIntent().getStringExtra("filepath");
        position = getIntent().getIntExtra("position", 0);
        list = getIntent().getStringArrayListExtra("list");

        textViewFileNameMusic.setText(title);

        mediaPlayer = new MediaPlayer();

        try {
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        buttonPrevious.setOnClickListener(v -> {

            mediaPlayer.reset();

            if (position == 0) position = list.size() - 1;
            else position--;

            String newFilePath = list.get(position);

            try {
                mediaPlayer.setDataSource(newFilePath);
                mediaPlayer.prepare();
                mediaPlayer.start();

                buttonPlayPause.setBackgroundResource(R.drawable.pause);

                String newTitle = newFilePath.substring(newFilePath.lastIndexOf("/") + 1);
                textViewFileNameMusic.setText(newTitle);

                textViewFileNameMusic.clearAnimation();
                textViewFileNameMusic.startAnimation(animation);

            } catch (IOException e) {
                e.printStackTrace();
            }


        });

        buttonPlayPause.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                buttonPlayPause.setBackgroundResource(R.drawable.play);
            } else {
                mediaPlayer.start();
                buttonPlayPause.setBackgroundResource(R.drawable.pause);
            }
        });

        buttonNext.setOnClickListener(v -> {

            mediaPlayer.reset();

            if (position == list.size() - 1) position = 0;
            else position++;

            String newFilePath = list.get(position);

            try {
                mediaPlayer.setDataSource(newFilePath);
                mediaPlayer.prepare();
                mediaPlayer.start();
                buttonPlayPause.setBackgroundResource(R.drawable.pause);

                String newTitle = newFilePath.substring(newFilePath.lastIndexOf("/") + 1);

                textViewFileNameMusic.setText(newTitle);
                textViewFileNameMusic.clearAnimation();
                textViewFileNameMusic.startAnimation(animation);

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    seekBarVolume.setProgress(progress);
                    float volumeLevel = progress / 100f;
                    mediaPlayer.setVolume(volumeLevel, volumeLevel);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarMusic.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                    seekBarMusic.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        handler = new Handler();
        runnable = () -> {

            totalTime = mediaPlayer.getDuration();
            seekBarMusic.setMax(totalTime);

            int currentPosition = mediaPlayer.getCurrentPosition();
            seekBarMusic.setProgress(currentPosition);
            handler.postDelayed(runnable, 1000);

            String elapsedTime = createTimeLabel(currentPosition);
            String lastTime = createTimeLabel(totalTime);

            textViewProgress.setText(elapsedTime);
            textViewTotalTime.setText(lastTime);
        };

        handler.post(runnable);
    }

    public String createTimeLabel(int currentPosition) {
        String timeLabel;
        int minute, second;

        minute = currentPosition / 1000 / 60;
        second = currentPosition / 1000 % 60;

        if (second < 10) timeLabel = minute + ":0" + second;
        else timeLabel = minute + ":" + second;

        return timeLabel;
    }
}