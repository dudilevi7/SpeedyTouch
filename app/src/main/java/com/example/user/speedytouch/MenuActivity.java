package com.example.user.speedytouch;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MenuActivity extends Activity {
    Button numBtn;
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
                ObjectAnimator animator = ObjectAnimator.ofFloat(numBtn,"rotation", 360).setDuration(750);
                animator.start();
                animator.addListener(new AnimatorListenerAdapter() {

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        Intent intent = new Intent(MenuActivity.this,LevelActivity.class);
                      //  intent.putExtra("name","numbers");

                        startActivity(intent);
                    }
                });

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
                     //   intent.putExtra("name","fc");

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
                     //   intent.putExtra("name","countries");
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
                  //      intent.putExtra("name","random");
                        startActivity(intent);
                    }
                });
            }
        });
    }
}
