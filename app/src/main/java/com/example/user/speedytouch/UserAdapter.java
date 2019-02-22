package com.example.user.speedytouch;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    private List<UserRecords> mUsersRecordsList;
    private Context m_Context;
    private TextView usernameTv;
    private TextView scoreTv;
    private TextView placeTv;
    private int place;

    public UserAdapter(List<UserRecords> usersRecordsList, Context m_Context) {
        this.mUsersRecordsList = usersRecordsList;
        this.m_Context = m_Context;
    }

    @Override
    public int getCount() {
        return mUsersRecordsList.size();
    }

    @Override
    public Object getItem(int position) {
        return mUsersRecordsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {

        View row = convertView;
        if(row == null){
            LayoutInflater inflater = (LayoutInflater)m_Context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.user_details,parent,false);
        }

        UserRecords userRecords= mUsersRecordsList.get(position);
        place = userRecords.getmPlaceUR();

        usernameTv = row.findViewById(R.id.usernameTvUd);
        scoreTv =  row.findViewById(R.id.userScoreTv);
        placeTv = row.findViewById(R.id.placeTv);

        placeTv.setText(""+place);
        usernameTv.setText(userRecords.getmNameUR());
        scoreTv.setText(userRecords.getmScoreUR());
        if (place==1)
            row.setBackgroundColor(ContextCompat.getColor(m_Context,R.color.Gold));
        if (place==2)
            row.setBackgroundColor(ContextCompat.getColor(m_Context,R.color.Silver));
        if (place==3)
            row.setBackgroundColor(ContextCompat.getColor(m_Context,R.color.Bronze));
        if (place!=1 && place!=2 && place!=3){
            row.setBackgroundColor(ContextCompat.getColor(m_Context,R.color.Blue));
        }

        return row;
    }
}
