package com.codewithhamad.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView ivSplash;
    TextView fText, sText;
    Button startButton;
    Animation ivSplashAnim, textAnim, btnAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing views
        initViews();

        // loading and setting animations
        setAnim();

        // changing fonts
        changeFonts();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, StopWatchActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }

    private void changeFonts() {
        // import font
        Typeface mLight= Typeface.createFromAsset(getAssets(), "MLight.ttf");
        Typeface mMedium= Typeface.createFromAsset(getAssets(), "MMedium.ttf");
        Typeface mRegular= Typeface.createFromAsset(getAssets(), "MRegular.ttf");

//        // customizing fonts
        fText.setTypeface(mRegular);
        sText.setTypeface(mLight);
        startButton.setTypeface(mMedium);
    }

    private void setAnim() {
        // loading animation
        ivSplashAnim= AnimationUtils.loadAnimation(this, R.anim.ivsplashanim);
        textAnim= AnimationUtils.loadAnimation(this, R.anim.textanim);
        btnAnim= AnimationUtils.loadAnimation(this, R.anim.btnanim);

        // setting animation to the views
        ivSplash.startAnimation(ivSplashAnim);
        fText.startAnimation(textAnim);
        sText.startAnimation(textAnim);
        startButton.startAnimation(btnAnim);
    }

    private void initViews() {
        ivSplash= findViewById(R.id.ivSplash);
        fText= findViewById(R.id.firstTextView);
        sText= findViewById(R.id.secondTextView);
        startButton= findViewById(R.id.startBtn);
    }
}