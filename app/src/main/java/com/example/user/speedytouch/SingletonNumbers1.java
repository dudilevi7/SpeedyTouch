package com.example.user.speedytouch;

import java.util.ArrayList;
import java.util.Random;

public class SingletonNumbers1 {
    private static SingletonNumbers1 instance;
    private Integer currentPlayingNumber;
    private ArrayList<Integer> list;

    private ArrayList<Integer> chosenNumbers;

    private SingletonNumbers1(){
        list = new ArrayList<Integer>();
        chosenNumbers = new ArrayList<Integer>();
        this.initNumberArrayList();
    }

    private void chooseNumber(Integer number){
        if(this.chosenNumbers.indexOf(number) < 0 ){
            this.chosenNumbers.add(number);
        }
    }

    public Integer getNewNumberToPlay()
    {
        Integer numberToPlay;
        ArrayList<Integer> availableNumbers = new ArrayList<Integer>();

        for(int i = 0; i<list.size(); i++){
            if(chosenNumbers.indexOf(i) < 0){
                availableNumbers.add(i);
            }
        }
        if(availableNumbers.size() == 0){
            return -1;
        }
        Random rand = new Random();
        int index = rand.nextInt(availableNumbers.size());
        numberToPlay = availableNumbers.get(index);
        this.chooseNumber(numberToPlay);
        this.setCurrentPlayingNumber(numberToPlay);
        return numberToPlay;
    }
    private void setCurrentPlayingNumber(Integer i){
        this.currentPlayingNumber = i;
    }
    public Integer getCurrentPlayingNumber() {
        return currentPlayingNumber;
    }

    public ArrayList<Integer> getList(){
        return list;
    }

    public static SingletonNumbers1 getInstance(){
        if (instance == null)
        {
            instance = new SingletonNumbers1();
        }
        return instance;
    }

    private void initNumberArrayList()
    {
        for(int i=0; i < 30; i++) // where x is the size of the list containing your alphabet.
            list.add(i);
    }
}
