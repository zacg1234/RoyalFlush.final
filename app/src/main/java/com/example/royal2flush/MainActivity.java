package com.example.royal2flush;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        final ImageView introLogo = findViewById(R.id.introLogo);
        final TextView openingText = findViewById(R.id.openingText);

        introLogo.animate()
                .scaleYBy(3)
                .scaleXBy(3)
                .setDuration(200);

        final ObjectAnimator logoShrinkX = ObjectAnimator.ofFloat(
                introLogo, "scaleX", 3f, 1f).setDuration(850);
        final ObjectAnimator logoShrinkY = ObjectAnimator.ofFloat(
                introLogo, "scaleY", 3f, 1f).setDuration(950);
        logoShrinkX.setInterpolator(new BounceInterpolator());
        logoShrinkY.setInterpolator(new BounceInterpolator());

        final ObjectAnimator slideInText = ObjectAnimator.ofFloat(
                openingText, "translationX", -2000f, 0f).setDuration(950);
        slideInText.setInterpolator(new OvershootInterpolator());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                openingText.setVisibility(View.VISIBLE);
               slideInText.start();
            }
        }, 1500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                logoShrinkX.start();
                logoShrinkY.start();
            }
        }, 200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginScreenTransition();
            }
        }, 3000);
    }

    private void loginScreenTransition() {
       Intent loginScreenTransition = new Intent(MainActivity.this, CoreFunctionality.class);
        startActivity(loginScreenTransition);

    }

}
