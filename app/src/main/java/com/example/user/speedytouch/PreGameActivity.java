package com.example.user.speedytouch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PreGameActivity extends Activity {
    private int whatIsTheLevel,theChoosenNumber,theNumberIndex;
    private ImageView imageView;
    private TextView numberView;
    private Button startBtn ;
    private SingletonNumbers1 NumbersGameManager = SingletonNumbers1.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game);
        imageView = findViewById(R.id.findImageIb);
        startBtn = findViewById(R.id.startBtn);
        numberView = findViewById(R.id.findNumberImageTv);


        whatIsTheLevel = GameMode.getInstance().getM_level();


        Random rand = new Random();
        if(NumbersGameManager.getList().size()==0){ //Level has been finished !
            Toast.makeText(getApplicationContext(),"The level is done!",Toast.LENGTH_SHORT).show();
        }
        else {
            theNumberIndex = NumbersGameManager.getNewNumberToPlay();
            theChoosenNumber = NumbersGameManager.getList().get(theNumberIndex); //getting the image address
            numberView.setText(""+theChoosenNumber); //setting the image
        }
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PreGameActivity.this,GameActivity.class);
                intent.putExtra("number",theChoosenNumber);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onBackPressed() {
        User.getInstance().resetUser();
        Intent intent = new Intent(PreGameActivity.this,MenuActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onCreate(Bundle.EMPTY);
    }
}
