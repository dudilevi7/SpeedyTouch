package com.example.user.speedytouch;

public class GameMode {
    private static GameMode instance;
    private int m_Level;

    public int getM_level(){
        return m_Level;
    }
    public void setM_level(int m_Level){
        this.m_Level = m_Level;
    }
    public static GameMode getInstance(){
        if (instance == null){
            instance = new GameMode();
        }
        return instance;
    }
    public int getLengthOfNumberDisplayOnScreen(){
        if (m_Level==2) return 50;
        if (m_Level==3) return 70;
        return 30;
    }
    public int getMillisByLevel(){
        if(m_Level==2) return 6000;
        if(m_Level==3) return 5000;
        return 7000;
    }
}
