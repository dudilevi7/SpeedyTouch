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
    private String whatIsTheType; //type of the game
    private int whatIsTheLevel,theChoosenImage,theImageIndex;
    private ImageView imageView;
    private TextView numberView;
    private Button startBtn ;
    private SingletonNumbers1 NumbersGameManager = SingletonNumbers1.getInstance();
    //array of fc -> level 1 (1-20)
    private ArrayList<Integer> fcLevel1 = new ArrayList<Integer>(
            Arrays.<Integer>asList(R.drawable.barak,R.drawable.ic_launcher_background,R.drawable.speedytouchlogo));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_game);
        imageView = findViewById(R.id.findImageIb);
        startBtn = findViewById(R.id.startBtn);
        numberView = findViewById(R.id.findNumberImageTv);

        whatIsTheType = GameMode.getInstance().getM_Type();
        whatIsTheLevel = GameMode.getInstance().getM_level();

        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                if(whatIsTheType.contains("numbers")){ //If the game is numbers
                    GameMode.getInstance().setM_Type("numbers"); //set the type
                    if (whatIsTheLevel == 1) {//level 1 of numbers game
                        GameMode.getInstance().setM_level(1); //set the level;
                        if(NumbersGameManager.getList().size()==0){ //Level has been finished !
                            Toast.makeText(getApplicationContext(),"The level is done!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            //theImageIndex = rand.nextInt(NumbersGameManager.getList().size()); //randomize the image index
                            theImageIndex = NumbersGameManager.getNewNumberToPlay();
                            theChoosenImage = NumbersGameManager.getList().get(theImageIndex); //getting the image address
                            numberView.setText(""+theChoosenImage); //setting the image
                            startNewActivity(theChoosenImage);
                            //   NumbersGameManager.remove(theImageIndex); //(we have to fix it)
                        }

                    }
                    if (whatIsTheLevel == 2){ //level 2 of numbers
                        GameMode.getInstance().setM_level(2); //set the level;
                        if(NumbersGameManager.getList().size()==0){ //Level has been finished !
                            Toast.makeText(getApplicationContext(),"The level is done!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            //theImageIndex = rand.nextInt(NumbersGameManager.getList().size()); //randomize the image index
                            theImageIndex = NumbersGameManager.getNewNumberToPlay();
                            theChoosenImage = NumbersGameManager.getList().get(theImageIndex); //getting the image address
                            numberView.setText(""+theChoosenImage); //setting the image
                            startNewActivity(theChoosenImage);
                            //   NumbersGameManager.remove(theImageIndex); //(we have to fix it)
                        }
                    }
                    if (whatIsTheLevel == 3){ //level 3 of numbers
                        GameMode.getInstance().setM_level(3); //set the level;
                        if(NumbersGameManager.getList().size()==0){ //Level has been finished !
                            Toast.makeText(getApplicationContext(),"The level is done!",Toast.LENGTH_SHORT).show();
                        }
                        else {
                            //theImageIndex = rand.nextInt(NumbersGameManager.getList().size()); //randomize the image index
                            theImageIndex = NumbersGameManager.getNewNumberToPlay();
                            theChoosenImage = NumbersGameManager.getList().get(theImageIndex); //getting the image address
                            numberView.setText(""+theChoosenImage); //setting the image
                            startNewActivity(theChoosenImage);
                            //   NumbersGameManager.remove(theImageIndex); //(we have to fix it)
                        }
                    }
                }
                if(whatIsTheType.contains("fc")) {
                    if (whatIsTheLevel == 1) {//level 1 of numbers game
                        if (NumbersGameManager.getList().size() == 0) { //Level has been finished !
                            // Toast.makeText(getApplicationContext(),"The level is done!",Toast.LENGTH_SHORT).show();
                        } else {
                            theImageIndex = rand.nextInt(NumbersGameManager.getList().size()); //randomize the image index
                            theChoosenImage = NumbersGameManager.getList().get(theImageIndex); //getting the image address
                            imageView.setImageResource(theChoosenImage); //setting the image
                            startNewActivity(theChoosenImage);
                            //   NumbersGameManager.remove(theImageIndex); //(we have to fix it)
                        }
                    }
                }
                if(whatIsTheType.contains("countries")){

                }
                if(whatIsTheType.contains("random")){

                }
            }
        });
    }
    private void startNewActivity (int theChoosenImage){
        Intent intent = new Intent(PreGameActivity.this,GameActivity.class);
        intent.putExtra("image",theChoosenImage);
        startActivity(intent);
    }
}

