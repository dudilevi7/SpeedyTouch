package com.example.user.speedytouch;

public class User {
    private static User instance;
    private String mName;
    private int mCuntFalseChoosNum = 0;
    private int mScore = 0;


    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public int getmCuntFalseChoosNum() {
        return mCuntFalseChoosNum;
    }


    public int getmScore() {
        return mScore;
    }

    public void addToScore(int x)
    {
        mScore+=x;
    }


    private User() {
        this.mCuntFalseChoosNum = 0;
        this.mScore = 0;
        this.mName = null;
    }

    public static User getInstance(){
        if (instance == null)
        {
            instance = new User();
        }
        return instance;
    }
    public void resetUser()
    {
        mName = null;
        mCuntFalseChoosNum = 0;
        mScore = 0;
    }
    public void addOneToCuntFalseChoosNum()
    {
        mCuntFalseChoosNum++;
    }
}
