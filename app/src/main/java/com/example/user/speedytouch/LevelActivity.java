package com.example.user.speedytouch;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;

public class LevelActivity extends Activity {
    Button level1Btn,level2Btn,level3Btn;
    String whatIsTheType;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level);
        level1Btn = findViewById(R.id.level_1);
        level2Btn = findViewById(R.id.level_2);
        level3Btn = findViewById(R.id.level_3);
        User.getInstance().setmScore(0);
        User.getInstance().setmCuntFalseChoosNum(0);

     //   whatIsTheType = getIntent().getStringExtra("name");
        whatIsTheType = GameMode.getInstance().getM_Type();
        level1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(whatIsTheType,1);
            }
        });
        level2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(whatIsTheType,2);
            }
        });
        level3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newActivity(whatIsTheType,3);
            }
        });
        animatorBtn(level1Btn);
        animatorBtn(level2Btn);
        animatorBtn(level3Btn);

    }
    private void newActivity(String type,int level){ //start new Activity with the type&level
        Intent intent = new Intent(LevelActivity.this,PreGameActivity.class);
      //  intent.putExtra("type",type);
      //  intent.putExtra("level",level);
        GameMode.getInstance().setM_level(level);
        startActivity(intent);
        finish();
    }
    private void animatorBtn(Button btn) { //animation of the level buttons
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(btn,"scaleY", 0.85f).setDuration(2000);
        ObjectAnimator animator = ObjectAnimator.ofFloat(btn,"scaleX", 0.85f).setDuration(2000);
        animator.setRepeatCount(Animation.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        animator1.setRepeatCount(Animation.INFINITE);
        animator1.setRepeatMode(ValueAnimator.REVERSE);
        animator1.start();
        animator.start();
    }
}
