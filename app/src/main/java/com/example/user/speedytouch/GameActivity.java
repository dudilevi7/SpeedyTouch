package com.example.user.speedytouch;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameActivity extends Activity {
    ImageButton trueButton;
    TextView numberTv;
    Button endBtn;
    int HEDEAR_HEIGHT = 50;
    int number,height,width ,theImageAddress,whatIsTheLevel,countPoints;
    String whatIsTheType;
    ArrayList<Button> numbersLevel1 = new ArrayList<Button>(20);
    //array of fc -> level 1 (1-20)
    ArrayList<Integer> fcLevel1 = new ArrayList<Integer>(
            Arrays.<Integer>asList(R.drawable.barak,R.drawable.ic_launcher_background,R.drawable.speedytouchlogo));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //trueButton set the getting image from previous intent
        endBtn = findViewById(R.id.endBtn);
        trueButton = findViewById(R.id.theChosenImage);
        numberTv = findViewById(R.id.theChosenNumber);

        theImageAddress = getIntent().getIntExtra("image",0); //or the chosen number value
        whatIsTheLevel = getIntent().getIntExtra("level",0);
        whatIsTheType = getIntent().getStringExtra("type");
        for(int i=0; i < 20; i++) // where x is the size of the list containing your alphabet.
        {
            Button button = new Button(this);
            button.setId(i);
            button.setText(""+i);
            button.setBackground(getResources().getDrawable(R.color.White));
            numbersLevel1.add(button);
        }
        RelativeLayout gameLayout = findViewById(R.id.relativeBtns);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;
        // width  = gameLayout.getWidth();
        // height = gameLayout.getHeight();



        if (whatIsTheType.contains("numbers")) {
            if(whatIsTheLevel==1) {
                trueButton.setVisibility(View.INVISIBLE);
                numbersPlace();
                for (Button numBtn :numbersLevel1){
                    buttonsPlace(numBtn);
                    gameLayout.addView(numBtn,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                }
                numberTv.setText(""+theImageAddress);
                numberTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        endBtn.setText("champion"); //need other code -> count points+ return to previous intent

                    }
                });
            }
            if(whatIsTheLevel==2){

            }
            if(whatIsTheLevel==3){

            }
        }
        if (whatIsTheType.contains("fc")) {
            imageButtonsPlace(trueButton);
            if(whatIsTheLevel==1) {
                trueButton.setBackground(getResources().getDrawable(theImageAddress));
                trueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        endBtn.setText("champion"); //need other code -> count points+ return to previous intent

                    }
                });
            }
            if(whatIsTheLevel==2){

            }
            if(whatIsTheLevel==3){

            }
        }
        if (whatIsTheType.contains("countries")) {
            imageButtonsPlace(trueButton);
            if(whatIsTheLevel==1) {
                trueButton.setBackground(getResources().getDrawable(theImageAddress));
                trueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        endBtn.setText("champion"); //need other code -> count points+ return to previous intent

                    }
                });
            }
            if(whatIsTheLevel==2){

            }
            if(whatIsTheLevel==3){

            }
        }
        if (whatIsTheType.contains("random")) {
            imageButtonsPlace(trueButton);
            if(whatIsTheLevel==1) {
                trueButton.setBackground(getResources().getDrawable(theImageAddress));
                trueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        endBtn.setText("champion"); //need other code -> count points+ return to previous intent

                    }
                });
            }
            if(whatIsTheLevel==2){

            }
            if(whatIsTheLevel==3){

            }
        }

    }
    private void buttonsPlace(Button button) {
        Random buttonPlace = new Random();
        int x = buttonPlace.nextInt(Math.abs( width));
        int y = buttonPlace.nextInt(Math.abs( height));
        //  int buttonY = buttonPlace.nextInt(480);
        //int buttonX = buttonPlace.nextInt(800);
        button.setX(x/2);
        button.setY(y/2);
    }
    private void imageButtonsPlace(ImageButton imageButton) {
        Random buttonPlace = new Random();
        int x = buttonPlace.nextInt(width);
        int y = buttonPlace.nextInt(height - HEDEAR_HEIGHT);
      //  int buttonY = buttonPlace.nextInt(480);
        //int buttonX = buttonPlace.nextInt(800);
        imageButton.setX(x/2);
        imageButton.setY(y/2);
    }
    private void numbersPlace() {
        Random numbersPlace = new Random();
        int x = numbersPlace.nextInt(width);
        int y = numbersPlace.nextInt(height - HEDEAR_HEIGHT);
       // int buttonY = numbersPlace.nextInt(480);
        //int buttonX = numbersPlace.nextInt(800);
        numberTv.setX(x/2);
        numberTv.setY(y/2);
    }
}
