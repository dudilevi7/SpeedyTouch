package com.example.user.speedytouch;

import java.util.Collections;
import java.util.Comparator;

public class UserRecords
{
    private String mNameUR;
    private String  mScoreUR;


    public UserRecords(String mNameUR, String mScoreUR) {
        this.mNameUR = mNameUR;
        this.mScoreUR = mScoreUR;
    }

    public String getmNameUR() {
        return mNameUR;
    }

    public String getmScoreUR() {
        return mScoreUR;
    }

    public void setmNameUR(String mNameUR) {
        this.mNameUR = mNameUR;

    }

    public void setmScoreUR(String mScoreUR) {
        this.mScoreUR = mScoreUR;
    }

    public static Comparator<UserRecords> userRecordsComparator = new Comparator<UserRecords>()
    {

        @Override
        public int compare(UserRecords o1, UserRecords o2) {
            try{
                int score1 = Integer.parseInt(o1.getmScoreUR());
                int score2 = Integer.parseInt(o2.getmScoreUR());
                return score2-score1;
            }
            catch(Exception e){
                return 0;
            }

        }
    };

}
