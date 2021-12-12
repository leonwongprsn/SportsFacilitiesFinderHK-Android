package com.example.sportsfacilitiesfinderhk;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.utils.LottieValueAnimator;

public class SplashScreen extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        lottieAnimationView = findViewById(R.id.lottie_splash_ani_view);
        lottieAnimationView.setSpeed(2.0f);
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }
}