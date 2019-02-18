package com.example.user.speedytouch;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import br.com.simplepass.loading_button_lib.customViews.CircularProgressButton;

public class MenuActivity extends Activity {
    CircularProgressButton numBtn;
    Button leadboardBtn;
    Button countriesBtn;
    Button randBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageView logoApp = findViewById(R.id.logo);
        numBtn = findViewById(R.id.nums_btn);
        leadboardBtn = findViewById(R.id.football_btn);
        countriesBtn = findViewById(R.id.countries_btn);
        randBtn = findViewById(R.id.random_btn);
        //Animation -> buttons get down + logo
        logoApp.animate().translationY(50).setDuration(1000);
        leadboardBtn.animate().translationY(300).setDuration(1000);
        countriesBtn.animate().translationY(600).setDuration(1000);
        randBtn.animate().translationY(900).setDuration(1000);

        numBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //case for numbers
                @SuppressLint("StaticFieldLeak") AsyncTask<String, String, String> demoLogin = new AsyncTask<String, String, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return "done";
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        if (s.equals("done"))
                        {
                            Intent intent = new Intent(MenuActivity.this,LevelActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };
                numBtn.startAnimation();
                demoLogin.execute();
            }
        });
        leadboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //case for fc logos
                ObjectAnimator animator = ObjectAnimator.ofFloat(leadboardBtn,"rotation", 360).setDuration(750);
                animator.start();
                animator.addListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Intent intent = new Intent(MenuActivity.this,RecordsActivity.class);

                        startActivity(intent);
                    }
                });
            }
        });
        countriesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //case for countries & flags
                ObjectAnimator animator = ObjectAnimator.ofFloat(countriesBtn,"rotation", 360).setDuration(750);
                animator.start();
                animator.addListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Intent intent = new Intent(MenuActivity.this,LevelActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        randBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //case for random logos
                ObjectAnimator animator = ObjectAnimator.ofFloat(randBtn,"rotation", 360).setDuration(750);
                animator.start();
                animator.addListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Intent intent = new Intent(MenuActivity.this,LevelActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
