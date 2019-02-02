package com.example.user.speedytouch;

public class GameMode {
    private static GameMode instance;
    private String m_Type;
    private int m_Level;

    public String getM_Type() {
        return m_Type;
    }
    public void setM_Type(String m_Type){
        this.m_Type = m_Type;
    }
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
}
