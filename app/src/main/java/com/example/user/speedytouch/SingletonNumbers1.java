package com.example.user.speedytouch;

import java.util.ArrayList;

public class SingletonNumbers1 {
    private static SingletonNumbers1 instance;
    private ArrayList<Integer> list;

    private SingletonNumbers1(){
        list = new ArrayList<Integer>();
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

    public void initNumberArrayList()
    {
        for(int i=0; i < 20; i++) // where x is the size of the list containing your alphabet.
            list.add(i);
    }
}
