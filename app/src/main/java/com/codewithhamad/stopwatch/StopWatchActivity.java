package com.codewithhamad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopWatchActivity extends AppCompatActivity {

    Button startStopwatchBtn, pauseStopwatchBtn, stopStartwatchBtn;
    ImageView slidePin;
    Animation roundAnim, pauseAnim;
    Chronometer timer;
    boolean isRunning=false;
    long pauseOffSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        // Init Views
        startStopwatchBtn= findViewById(R.id.startStopwatchBtn);
        slidePin= findViewById(R.id.roundPin);
        stopStartwatchBtn= findViewById(R.id.stopStopwatchBtn);
        pauseStopwatchBtn= findViewById(R.id.pauseStopwatchBtn);
        timer= findViewById(R.id.timer);

        // creating optional anim
        stopStartwatchBtn.setAlpha(0);
        pauseStopwatchBtn.setAlpha(0);


        // load anim
        roundAnim= AnimationUtils.loadAnimation(this, R.anim.roundingpin);
        pauseAnim= AnimationUtils.loadAnimation(this, R.anim.pausepin);


        // setting fonts to the button
        Typeface mMedium= Typeface.createFromAsset(getAssets(), "MMedium.ttf");
        startStopwatchBtn.setTypeface(mMedium);
        stopStartwatchBtn.setTypeface(mMedium);

        startStopwatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // passing anim
                slidePin.startAnimation(roundAnim);

                pauseStopwatchBtn.animate().alpha(1).translationY(-80).setDuration(300).start();
                stopStartwatchBtn.animate().alpha(1).translationY(-80).setDuration(300).start();
                startStopwatchBtn.animate().alpha(0).translationY(-80).setDuration(300).start();
//                startStopwatchBtn.setVisibility(View.GONE);

                // start stopwatch timer
                if(!isRunning){
                    isRunning= true;
                    timer.setBase(SystemClock.elapsedRealtime());
                    timer.start();
                }
            }
        });

        stopStartwatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRunning){
                    startStopwatchBtn.setText("Start Again");
                    startStopwatchBtn.setVisibility(View.VISIBLE);
                    pauseStopwatchBtn.animate().alpha(0).translationY(80).setDuration(300).start();
                    stopStartwatchBtn.animate().alpha(0).translationY(80).setDuration(300).start();
                    startStopwatchBtn.animate().alpha(1).translationY(80).setDuration(300).start();
                    timer.stop();
                    slidePin.setAnimation(pauseAnim);
                    isRunning= false;
                }
            }
        });

        // TODO: 2/8/2021 pauseStopwatchBtn() tobe implemented
    }
}