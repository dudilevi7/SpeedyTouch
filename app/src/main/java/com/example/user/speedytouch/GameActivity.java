package com.example.user.speedytouch;

import android.animation.ObjectAnimator;
import android.app.Activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class GameActivity extends Activity {
    private TextView winningNumberTv,catchItTv;
    private int mHeightOfScreen, mWidthOfScreen,theWinningNumber,whatIsTheLevel;
    private ArrayList<TextView> listNumbersOfTheLevel = new ArrayList<TextView>();
    private CountDownTimer countDownTimer; //timer for every level
    private MediaPlayer correctAnswerMp;
    private MediaPlayer wrongAnswerMp;
    private MediaPlayer finishedLevelMp;
    private boolean isAlreadtTouchTv = false;
    private KonfettiView viewKonfetti;
    private ImageView likeAndDisLikeImageView;
    private Animation smallToBig;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        wrongAnswerMp = MediaPlayer.create(this,R.raw.wah_wah_wah_fail_sound_effect);
        correctAnswerMp = MediaPlayer.create(this,R.raw.correct_answer_sound_effect);
        finishedLevelMp = MediaPlayer.create(this,R.raw.finishedlevel);
        viewKonfetti = findViewById(R.id.viewKonfetti);


        smallToBig = AnimationUtils.loadAnimation(this,R.anim.small_to_big);
        likeAndDisLikeImageView = findViewById(R.id.LikeAndDisLikeImageView);
        likeAndDisLikeImageView.setVisibility(View.INVISIBLE);

        winningNumberTv = new TextView(this); //Winning number text view
        winningNumberTv.setTextColor(getResources().getColor(R.color.White));
        catchItTv = findViewById(R.id.catchItTv); //the title of the activity


        theWinningNumber = getIntent().getIntExtra("number",0); //or the chosen number value
        whatIsTheLevel = GameMode.getInstance().getM_level(); //getLevel


        //define screensize
        RelativeLayout gameLayout = findViewById(R.id.relativeBtns);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mWidthOfScreen = size.x;
        mHeightOfScreen = size.y;

        gameByLevel(whatIsTheLevel,gameLayout);

    }
    private void gameByLevel(final int theLevel, RelativeLayout gameLayout){
        initNumbersDisplayOnScreen(GameMode.getInstance().getLengthOfNumberDisplayOnScreen()); //Initliaze with 30/50/70 numbers (lev 1/2/3)
        winningNumberTvPlace(winningNumberTv); //Positioning of the winning number
        int xWinningTv = (int)winningNumberTv.getX()+winningNumberTv.getWidth()/2; // X of winning number
        int yWinningTv = (int)winningNumberTv.getY()+winningNumberTv.getHeight()/2; // Y " "  " " "" " "
        gameLayout.addView(winningNumberTv,ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        //^^ adding the winning number to screen
        for (final TextView numbersDisplayOnScreenTv : listNumbersOfTheLevel) {
            numbersPlace(numbersDisplayOnScreenTv, xWinningTv, yWinningTv); //Positioning of other numbers
            gameLayout.addView(numbersDisplayOnScreenTv, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        countDownTimer = new CountDownTimer(GameMode.getInstance().getMillisByLevel(),1000) { //7 seconds for each screen in level 1
            @Override
            public void onTick(long millisUntilFinished) {
                if (millisUntilFinished<GameMode.getInstance().getMillisByLevel()-1000)
                    catchItTv.setText(getString(R.string.timeEndsIn)+" "+millisUntilFinished/1000); //the title change to the time remaining

                for (final TextView numbersDisplayOnScreenTv : listNumbersOfTheLevel)
                {
                    numbersDisplayOnScreenTv.setOnClickListener(new View.OnClickListener()
                    {
                        @Override
                        public void onClick(View v) {
                            if (!isAlreadtTouchTv)
                            {
                                ObjectAnimator animator = ObjectAnimator.ofFloat(winningNumberTv,"ScaleX",2.5f).setDuration(1000);
                                ObjectAnimator animator1 = ObjectAnimator.ofFloat(winningNumberTv,"ScaleY",2.5f).setDuration(1000);
                                winningNumberTv.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.RedPink));
                                wrongAnswerMp.start();
                                animator.start();
                                animator1.start();
                                likeAndDisLikeImageView.setImageResource(R.drawable.dislike);
                                likeAndDisLikeImageView.setVisibility(View.VISIBLE);
                                likeAndDisLikeImageView.bringToFront();
                                likeAndDisLikeImageView.startAnimation(smallToBig);

                                Toast.makeText(GameActivity.this, getString(R.string.wrong), Toast.LENGTH_SHORT).show();
                                User.getInstance().addOneToCuntFalseChoosNum(); //falseCount++
                                if (User.getInstance().getmCuntFalseChoosNum() == 3) {
                                    // if the user losing 3 time set to 0
                                    Toast.makeText(GameActivity.this, getString(R.string.gameover), Toast.LENGTH_SHORT).show();
                                    gameIsFinished(); //function of gameover that open dialog for saving details
                                    countDownTimer.cancel(); // cancel the timer when 3 faults
                                } else { //falseCount < 3
                                    countDownTimer.cancel(); //cancel the timer
                                    new Handler().postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            Intent intent = new Intent(GameActivity.this,PreGameActivity.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                            startActivity(intent);
                                            finish();
                                        }
                                    },2500); //back the pre activity for find new number
                                }
                                isAlreadtTouchTv = true;
                            }
                        }
                    });
                }
                winningNumberTv.setTextSize(27);
                winningNumberTv.setText("" + theWinningNumber);
                winningNumberTv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) { //on click the right number
                        if (!isAlreadtTouchTv)
                        {
                            ObjectAnimator animator = ObjectAnimator.ofFloat(winningNumberTv,"ScaleX",2.5f).setDuration(1000);
                            ObjectAnimator animator1 = ObjectAnimator.ofFloat(winningNumberTv,"ScaleY",2.5f).setDuration(1000);
                            winningNumberTv.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.Green));
                            correctAnswerMp.start();
                            animator.start();
                            animator1.start();
                            likeAndDisLikeImageView.setImageResource(R.drawable.success);
                            likeAndDisLikeImageView.setVisibility(View.VISIBLE);
                            likeAndDisLikeImageView.bringToFront();
                            likeAndDisLikeImageView.startAnimation(smallToBig);

                            User.getInstance().addToScore(GameMode.getInstance().getM_level());//score++ and set it in the User Class
                            SingletonNumbers1.getInstance().getList().remove(winningNumberTv.getText());
                            if ((User.getInstance().getmScore() == 10*whatIsTheLevel)) { //finished in success
                                correctAnswerMp.stop();
                                finishedLevelMp.start();
                                viewKonfetti.build()
                                        .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                                        .setDirection(0.0, 359.0)
                                        .setSpeed(1f, 5f)
                                        .setFadeOutEnabled(true)
                                        .setTimeToLive(2000L)
                                        .addShapes(Shape.RECT, Shape.CIRCLE)
                                        .addSizes(new Size(12, 5))
                                        .setPosition(-50f, viewKonfetti.getWidth() + 50f, -50f, -50f)
                                        .streamFor(300, 5000L);
                                Toast.makeText(GameActivity.this, getString(R.string.finished_level) +" "+ theLevel + "!", Toast.LENGTH_LONG).show();
                                countDownTimer.cancel();
                                gameIsFinished(); //function of open dialog for saving details
                            } else { //scoreCont < 10;
                                countDownTimer.cancel(); //cancel the timer
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Intent intent = new Intent(GameActivity.this,PreGameActivity.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                        startActivity(intent);
                                        finish();
                                    }
                                },1500); //back the pre activity for find new number
                            }
                            isAlreadtTouchTv = true;
                        }
                    }
                });

            }

            @Override
            public void onFinish() { //On finish the timer!!!
                isAlreadtTouchTv = true;
                ObjectAnimator animator = ObjectAnimator.ofFloat(winningNumberTv,"ScaleX",2.5f).setDuration(1000);
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(winningNumberTv,"ScaleY",2.5f).setDuration(1000);
                winningNumberTv.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.RedPink));
                wrongAnswerMp.start();
                animator.start();
                animator1.start();
                likeAndDisLikeImageView.setImageResource(R.drawable.dislike);
                likeAndDisLikeImageView.setVisibility(View.VISIBLE);
                likeAndDisLikeImageView.bringToFront();
                likeAndDisLikeImageView.startAnimation(smallToBig);

                Toast.makeText(getApplicationContext(),getString(R.string.time_is_over),Toast.LENGTH_LONG).show(); //Msg : "time is over +1 fault"
                User.getInstance().addOneToCuntFalseChoosNum(); //falseCount++
                if (User.getInstance().getmCuntFalseChoosNum() == 3) {
                    // if the user losing 3 time set to 0 save his name and score and play again
                    Toast.makeText(GameActivity.this, getString(R.string.gameover), Toast.LENGTH_SHORT).show();
                    gameIsFinished(); //function of open dialog for saving details
                }else
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(GameActivity.this,PreGameActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            finish();
                        }
                    },2500); //when falseCount<3 -> back to pre activity for find new number
            }
        }.start();
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

                editor.putInt(usernameEt.getText().toString(),User.getInstance().getmScore());
                editor.commit();

                User.getInstance().resetUser();
                Intent intent = new Intent(GameActivity.this,RecordsActivity.class);

                startActivity(intent);
            }
        });

        thisDialog.setTitle(R.string.save_username);
        thisDialog.show();
        thisDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                User.getInstance().resetUser();
                Intent intent = new Intent(GameActivity.this,MenuActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    private void initNumbersDisplayOnScreen(int k) {
        for(int i=0; i < k; i++) // for of the other numbers (looser numbers)
        {
            if (i!=theWinningNumber) { //i! = winning number
                TextView numbersTv = new TextView(this);
                numbersTv.setId(i);
                numbersTv.setText("" + i);
                numbersTv.setTextSize(27);
                numbersTv.setBackgroundColor(Color.TRANSPARENT);
                numbersTv.setTextColor(getResources().getColor(R.color.White));
                listNumbersOfTheLevel.add(numbersTv);
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
    public void onBackPressed() {
        countDownTimer.cancel();
        User.getInstance().resetUser();
        Intent intent = new Intent(GameActivity.this,MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}