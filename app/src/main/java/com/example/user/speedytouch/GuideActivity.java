package com.example.user.speedytouch;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
        showSkipButton(false);
    }
    @Override
    public void onBackPressed() {
        finishReadingGuide();
    }

    @Override
    public void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finishReadingGuide();
    }
    public void finishReadingGuide()
    {
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
