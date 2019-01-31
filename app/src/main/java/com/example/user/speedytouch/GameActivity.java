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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameActivity extends Activity {
    ImageButton trueButton;
    TextView winningNumberTv;
    Button endBtn;
    int height,width ,theImageAddress,whatIsTheLevel;
    String whatIsTheType;
    ArrayList<TextView> numbersLevel1 = new ArrayList<TextView>(20);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        //trueButton set the getting image from previous intent
        endBtn = findViewById(R.id.endBtn);
        trueButton = findViewById(R.id.theChosenIb);
        winningNumberTv = new TextView(this); //Winning number text view

        theImageAddress = getIntent().getIntExtra("image",0); //or the chosen number value
        whatIsTheLevel = getIntent().getIntExtra("level",0);
        whatIsTheType = getIntent().getStringExtra("type");

        for(int i=0; i < 30; i++) // for of the other numbers (looser numbers)
        {
            if (i!=theImageAddress) { //i! = winning number
                TextView numbersTv = new TextView(this);
                numbersTv.setId(i);
                numbersTv.setText("" + i);
                numbersTv.setTextSize(27);
                numbersTv.setBackgroundColor(Color.TRANSPARENT);
                numbersLevel1.add(numbersTv);
            }
        }
        //define screensize
        RelativeLayout gameLayout = findViewById(R.id.relativeBtns);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = size.x;
        height = size.y;


        if (whatIsTheType.contains("numbers")) {
            if(whatIsTheLevel==1) {
                trueButton.setVisibility(View.INVISIBLE); //hide the trueButton(type of fc/countries/random)
                winningNumberTvPlace(winningNumberTv); //Positioning of the winning number
                int xWinningTv = (int)winningNumberTv.getX()+winningNumberTv.getWidth()/2; // X of winning number
                int yWinningTv = (int)winningNumberTv.getY()+winningNumberTv.getHeight()/2; // Y " "  " " "" " "
                gameLayout.addView(winningNumberTv,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                //^^ adding the winning number to screen
                for (final TextView numbersTv :numbersLevel1){
                        numbersPlace(numbersTv,xWinningTv,yWinningTv); //Positioning of other numbers
                        gameLayout.addView(numbersTv,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                        numbersTv.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                numbersTv.setTextSize(50);
                                numbersTv.setTextColor(Color.RED);
                                endBtn.setText("Looooserr!!!");
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
                        endBtn.setText("Champion!!!"); //need other code -> count points+ return to previous intent

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
    private void winningNumberTvPlace(TextView winningNumberTv) {
            Random tvPlace = new Random();
            int x = tvPlace.nextInt(width-250);
            int y = tvPlace.nextInt(height-600);
            winningNumberTv.setX((float) x);
            winningNumberTv.setY((float) y);
    }
    private void imageButtonsPlace(ImageButton imageButton) {
            Random buttonPlace = new Random();
            int x = buttonPlace.nextInt(width);
            int y = buttonPlace.nextInt(height);
            imageButton.setX(x);
            imageButton.setY(y);
    }
    private void numbersPlace(TextView numbersTv, int xWinningTv, int yWinningTv)
    {
            Random numbersPlace = new Random();
            int x = numbersPlace.nextInt(width - 250);
            int y = numbersPlace.nextInt(height - 600);
            if ((x<xWinningTv-30 || x>xWinningTv+30)&&(y<yWinningTv-30 || y>yWinningTv+30)) {
                numbersTv.setX((float)x);
                numbersTv.setY((float)y);
            } else numbersPlace(numbersTv,xWinningTv,yWinningTv);
    }
}
