package com.example.user.speedytouch;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends Activity {
    int SPLASH_TIME_OUT = 1500;
    ImageView imageLogo;
    Animation smallToBig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        smallToBig = AnimationUtils.loadAnimation(this,R.anim.small_to_big);


        imageLogo = findViewById(R.id.logo);

        imageLogo.startAnimation(smallToBig);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,MenuActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }

}
