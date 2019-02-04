package com.example.user.speedytouch;

import android.content.Context;
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

        usernameTv = row.findViewById(R.id.usernameTvUd);
        scoreTv =  row.findViewById(R.id.userScoreTv);



        usernameTv .setText(userRecords.getmNameUR());
        scoreTv.setText(userRecords.getmScoreUR());



        return row;
    }
}
