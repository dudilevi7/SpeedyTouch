package com.example.user.speedytouch;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends Activity {
    private ImageButton trueButton;
    private TextView winningNumberTv;
    private int mHeightOfScreen, mWidthOfScreen,theImageAddress,whatIsTheLevel;
    private String mWhatIsTheType;
    private ArrayList<TextView> listNumbersLevel1 = new ArrayList<TextView>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        trueButton = findViewById(R.id.theChosenIb);//trueButton set the getting image from previous intent
        winningNumberTv = new TextView(this); //Winning number text view

        theImageAddress = getIntent().getIntExtra("image",0); //or the chosen number value
        whatIsTheLevel = GameMode.getInstance().getM_level(); //getLevel
        mWhatIsTheType = GameMode.getInstance().getM_Type(); //getType


        //define screensize
        RelativeLayout gameLayout = findViewById(R.id.relativeBtns);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mWidthOfScreen = size.x;
        mHeightOfScreen = size.y;


        if (mWhatIsTheType.contains("numbers")) {
            if(whatIsTheLevel==1) {
                initNumbersDisplayOnScreen(30); //Initliaze with 30 numbers on the screen
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
                            Toast.makeText(GameActivity.this, getString(R.string.wrong), Toast.LENGTH_SHORT).show();

                            User.getInstance().setmCuntFalseChoosNum(User.getInstance().getmCuntFalseChoosNum()+1);
                            if (User.getInstance().getmCuntFalseChoosNum() == 3)
                            {
                                User.getInstance().setmCuntFalseChoosNum(0);// if the user losing 3 time set to 0 save his name and score and play again
                                Toast.makeText(GameActivity.this, getString(R.string.gameover), Toast.LENGTH_SHORT).show();
                                gameIsFinished();
                            }
                        }
                    });
                }
                winningNumberTv.setTextSize(27);
                winningNumberTv.setText(""+theImageAddress);
                winningNumberTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { //on click the right number
                        winningNumberTv.setTextSize(50);
                        winningNumberTv.setTextColor(Color.GREEN);
                        User.getInstance().setmScore(User.getInstance().getmScore()+1);//score++ and set it in the User Class
                        SingletonNumbers1.getInstance().getList().remove(winningNumberTv.getText());
                        if ((User.getInstance().getmScore()==10)||SingletonNumbers1.getInstance().getList().size()==0){ //finished in success
                            Toast.makeText(GameActivity.this, getString(R.string.finished_level)+1+"!", Toast.LENGTH_LONG).show();
                            gameIsFinished();
                        }
                        else finish();
                    }
                });
            }
            if(whatIsTheLevel==2){
                initNumbersDisplayOnScreen(50); //initilaze with 50 numbers on screen
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
                            Toast.makeText(GameActivity.this, getString(R.string.wrong), Toast.LENGTH_SHORT).show();

                            User.getInstance().setmCuntFalseChoosNum(User.getInstance().getmCuntFalseChoosNum()+1);
                            if (User.getInstance().getmCuntFalseChoosNum() == 3)
                            {
                                User.getInstance().setmCuntFalseChoosNum(0);// if the user losing 3 time set to 0 save his name and score and play again
                                Toast.makeText(GameActivity.this, getString(R.string.gameover), Toast.LENGTH_SHORT).show();
                                gameIsFinished();
                            }
                        }
                    });
                }
                winningNumberTv.setTextSize(27);
                winningNumberTv.setText(""+theImageAddress);
                winningNumberTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { //on click the right number
                        winningNumberTv.setTextSize(50);
                        winningNumberTv.setTextColor(Color.GREEN);
                        User.getInstance().setmScore(User.getInstance().getmScore()+1);//score++ and set it in the User Class
                        SingletonNumbers1.getInstance().getList().remove(winningNumberTv.getText());
                        if ((User.getInstance().getmScore()==10)||SingletonNumbers1.getInstance().getList().size()==0){ //finished in success
                            Toast.makeText(GameActivity.this, getString(R.string.finished_level)+2+"!", Toast.LENGTH_LONG).show();
                            gameIsFinished();
                        }
                        else finish();
                    }
                });
            }
            if(whatIsTheLevel==3){
                initNumbersDisplayOnScreen(70); //initilaze with 70 numbers on screen
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
                            Toast.makeText(GameActivity.this, getString(R.string.wrong), Toast.LENGTH_SHORT).show();

                            User.getInstance().setmCuntFalseChoosNum(User.getInstance().getmCuntFalseChoosNum()+1);
                            if (User.getInstance().getmCuntFalseChoosNum() == 3)
                            {
                                User.getInstance().setmCuntFalseChoosNum(0);// if the user losing 3 time set to 0 save his name and score and play again
                                Toast.makeText(GameActivity.this, getString(R.string.gameover), Toast.LENGTH_SHORT).show();
                                gameIsFinished();
                            }
                        }
                    });
                }
                winningNumberTv.setTextSize(27);
                winningNumberTv.setText(""+theImageAddress);
                winningNumberTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { //on click the right number
                        winningNumberTv.setTextSize(50);
                        winningNumberTv.setTextColor(Color.GREEN);
                        User.getInstance().setmScore(User.getInstance().getmScore()+1);//score++ and set it in the User Class
                        SingletonNumbers1.getInstance().getList().remove(winningNumberTv.getText());
                        if ((User.getInstance().getmScore()==10)||SingletonNumbers1.getInstance().getList().size()==0){ //finished in success
                            Toast.makeText(GameActivity.this, getString(R.string.finished_level)+3+"!", Toast.LENGTH_LONG).show();
                            gameIsFinished();
                        }
                        else finish();
                    }
                });
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

    private void gameIsFinished() {
        final Dialog thisDialog = new Dialog(GameActivity.this);
        thisDialog.setContentView(R.layout.dialog_save_username);
        Button okBtnDialog = thisDialog.findViewById(R.id.okBtn);

        okBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText usernameEt = thisDialog.findViewById(R.id.usernameEtDialog);
                SharedPreferences sp = getSharedPreferences("PREFS",MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("username",usernameEt.getText().toString());
                editor.putInt("lastScore",User.getInstance().getmScore());
                editor.commit();
                Intent intent = new Intent(GameActivity.this,RecordsActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);//if the activity is exist it will open and dont create another
                startActivity(intent);
            }
        });

        thisDialog.setTitle(R.string.save_username);
        thisDialog.show();
        //finish();
    }

    private void initNumbersDisplayOnScreen(int k) {
        for(int i=0; i < k; i++) // for of the other numbers (looser numbers)
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
