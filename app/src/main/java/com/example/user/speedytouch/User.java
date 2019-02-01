package com.example.user.speedytouch;

public class User {
    private static User instance;
    private String m_Name;
    private int mCuntFalseChoosNum = 0;
    private int mScore = 0;


    public String getM_Name() {
        return m_Name;
    }

    public void setM_Name(String m_Name) {
        this.m_Name = m_Name;
    }

    public int getmCuntFalseChoosNum() {
        return mCuntFalseChoosNum;
    }

    public void setmCuntFalseChoosNum(int mCuntFalseChoosNum) {
        this.mCuntFalseChoosNum = mCuntFalseChoosNum;
    }

    public int getmScore() {
        return mScore;
    }

    public void setmScore(int mScore) {
        this.mScore = mScore;
    }

    public static User getInstance(){
        if (instance == null)
        {
            instance = new User();
        }
        return instance;
    }
}
