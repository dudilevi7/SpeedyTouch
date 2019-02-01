package com.example.user.speedytouch;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends Activity {
    private ImageButton trueButton;
    private TextView winningNumberTv;
    private int mHeightOfScreen, mWidthOfScreen,theImageAddress,whatIsTheLevel,mCuntFalseChoosNum = 0;
    private String mWhatIsTheType;
    private ArrayList<TextView> listNumbersLevel1 = new ArrayList<TextView>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        trueButton = findViewById(R.id.theChosenIb);//trueButton set the getting image from previous intent
        winningNumberTv = new TextView(this); //Winning number text view

        theImageAddress = getIntent().getIntExtra("image",0); //or the chosen number value
        whatIsTheLevel = getIntent().getIntExtra("level",0);
        mWhatIsTheType = getIntent().getStringExtra("type");

        for(int i=0; i < 30; i++) // for of the other numbers (looser numbers)
        {
            if (i!=theImageAddress) { //i! = winning number
                TextView numbersTv = new TextView(this);
                numbersTv.setId(i);
                numbersTv.setText("" + i);
                numbersTv.setTextSize(27);
                numbersTv.setBackgroundColor(Color.TRANSPARENT);
                listNumbersLevel1.add(numbersTv);
            }
        }
        //define screensize
        RelativeLayout gameLayout = findViewById(R.id.relativeBtns);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mWidthOfScreen = size.x;
        mHeightOfScreen = size.y;


        if (mWhatIsTheType.contains("numbers")) {
            if(whatIsTheLevel==1) {
                trueButton.setVisibility(View.INVISIBLE); //hide the trueButton(type of fc/countries/random)
                winningNumberTvPlace(winningNumberTv); //Positioning of the winning number
                int xWinningTv = (int)winningNumberTv.getX()+winningNumberTv.getWidth()/2; // X of winning number
                int yWinningTv = (int)winningNumberTv.getY()+winningNumberTv.getHeight()/2; // Y " "  " " "" " "
                gameLayout.addView(winningNumberTv,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                //^^ adding the winning number to screen
                for (final TextView numbersDisplayOnScreenTv : listNumbersLevel1){
                        numbersPlace(numbersDisplayOnScreenTv,xWinningTv,yWinningTv); //Positioning of other numbers
                        gameLayout.addView(numbersDisplayOnScreenTv,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                        numbersDisplayOnScreenTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                numbersDisplayOnScreenTv.setTextSize(50);
                                numbersDisplayOnScreenTv.setTextColor(Color.RED);
                                Toast.makeText(GameActivity.this, "~Wrong~", Toast.LENGTH_SHORT).show();
                                mCuntFalseChoosNum++;
                                if (mCuntFalseChoosNum == 3)
                                {
                                    Toast.makeText(GameActivity.this, "!!Game Over!!", Toast.LENGTH_SHORT).show();
                                    //need to do records =    Table
                                    finish();
                                }
                            }
                        });
                }
                winningNumberTv.setTextSize(27);
                winningNumberTv.setText(""+theImageAddress);
                winningNumberTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        winningNumberTv.setTextSize(50);
                        winningNumberTv.setTextColor(Color.GREEN);

                        if (SingletonNumbers1.getInstance().getList().size() != 0)
                        {
                            SingletonNumbers1.getInstance().getList().remove(winningNumberTv.getText());
                            finish();
                        }
                        else{
                            //the user finish the level he found all the numbers, we need a animation here
                            }
                    }
                });
            }
            if(whatIsTheLevel==2){

            }
            if(whatIsTheLevel==3){

            }
        }
        if (mWhatIsTheType.contains("fc")) {
            imageButtonsPlace(trueButton);
            if(whatIsTheLevel==1) {
                trueButton.setBackground(getResources().getDrawable(theImageAddress));
                trueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
            }
            if(whatIsTheLevel==2){

            }
            if(whatIsTheLevel==3){

            }
        }
        if (mWhatIsTheType.contains("countries")) {
            imageButtonsPlace(trueButton);
            if(whatIsTheLevel==1) {
                trueButton.setBackground(getResources().getDrawable(theImageAddress));
                trueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
            }
            if(whatIsTheLevel==2){

            }
            if(whatIsTheLevel==3){

            }
        }
        if (mWhatIsTheType.contains("random")) {
            imageButtonsPlace(trueButton);
            if(whatIsTheLevel==1) {
                trueButton.setBackground(getResources().getDrawable(theImageAddress));
                trueButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
            }
            if(whatIsTheLevel==2){

            }
            if(whatIsTheLevel==3){

            }
        }

    }
    private void winningNumberTvPlace(TextView winningNumberTv) {
            Random tvPlace = new Random();
            int x = tvPlace.nextInt(mWidthOfScreen -250);
            int y = tvPlace.nextInt(mHeightOfScreen -600);
            winningNumberTv.setX((float) x);
            winningNumberTv.setY((float) y);
    }
    private void imageButtonsPlace(ImageButton imageButton) {
            Random buttonPlace = new Random();
            int x = buttonPlace.nextInt(mWidthOfScreen);
            int y = buttonPlace.nextInt(mHeightOfScreen);
            imageButton.setX(x);
            imageButton.setY(y);
    }
    private void numbersPlace(TextView numbersTv, int xWinningTv, int yWinningTv)
    {
            Random numbersPlace = new Random();
            int x = numbersPlace.nextInt(mWidthOfScreen - 250);
            int y = numbersPlace.nextInt(mHeightOfScreen - 600);
            if ((x<xWinningTv-30 || x>xWinningTv+30)&&(y<yWinningTv-30 || y>yWinningTv+30)) {
                numbersTv.setX((float)x);
                numbersTv.setY((float)y);
            } else numbersPlace(numbersTv,xWinningTv,yWinningTv);
    }
}
