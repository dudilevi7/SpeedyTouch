package com.example.user.speedytouch;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;


public class GuideActivity extends AppIntro2 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //slide 1
        addSlide(AppIntroFragment.newInstance("Slide 1","This is the first slide",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.Gold)));
        //slide 2
        addSlide(AppIntroFragment.newInstance("Slide 2","This is the second slide",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.green)));
        //slide 3
        addSlide(AppIntroFragment.newInstance("Slide 3","This is the third slide",
                R.mipmap.ic_launcher,ContextCompat.getColor(getApplicationContext(),R.color.lightRed)));


   /*     // OPTIONAL METHODS
        // Override bar/separator color.
        setBarColor(Color.parseColor("#3F51B5"));
        setSeparatorColor(Color.parseColor("#2196F3"));

        // Hide Skip/Done button.
        showSkipButton(false);
        setProgressButtonEnabled(false);

        // Turn vibration on and set intensity.
        // NOTE: you will probably need to ask VIBRATE permission in Manifest.
        setVibrate(true);
        setVibrateIntensity(30);*/
    }
}
