package com.example.user.speedytouch;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class RecordsActivity extends Activity {

    private TextView mScoreTv;
    private TextView mUsername;
    private int mLastScore;
    private String mLastName;

    private int mBestScore1,mBestScore2,mBestScore3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        mScoreTv = findViewById(R.id.scoreTvRecAct);
        mUsername = findViewById(R.id.usernameTvRecAct);
//load old scores
        SharedPreferences sp = getSharedPreferences("PREFS",MODE_PRIVATE);

        mLastScore = sp.getInt("lastScore",0);

        mLastName= sp.getString("username",null);
        mBestScore1 = sp.getInt("mBestScore1",0);
        mBestScore2 = sp.getInt("mBestScore2",0);
        mBestScore3 = sp.getInt("mBestScore3",0);
//replace if there is high score
        if (mLastScore > mBestScore3)
        {
            mBestScore3 = mLastScore;
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("Best3",mBestScore3);
            editor.apply();
        }
        if (mLastScore > mBestScore2)
        {
            int temp = mBestScore2;
            mBestScore2 = mLastScore;
            mBestScore3 = temp;
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("Best3",mBestScore3);
            editor.putInt("Best2",mBestScore2);
            editor.apply();
        }
        if (mLastScore > mBestScore1)
        {
            int temp = mBestScore1;
            mBestScore1 = mLastScore;
            mBestScore2 = temp;
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("Best2",mBestScore2);
            editor.putInt("Best1",mBestScore1);
            editor.apply();
        }
//display scores
        mScoreTv.setText("Name "+ mLastName+ "Last Score " + mLastScore + "\n" +
                "Best1: "+ mBestScore1 + "\n"+
                "Best2: "+ mBestScore2 + "\n"+
                "Best3: "+ mBestScore3 + "\n"
        );
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(intent);
        finish();
    }
}
