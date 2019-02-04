package com.example.user.speedytouch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    private List<User> usersList;
    private Context m_Context;
    private TextView usernameTv;
    private TextView scoreTv;

    public UserAdapter(List<User> usersList, Context m_Context) {
        this.usersList = usersList;
        this.m_Context = m_Context;
    }

    @Override
    public int getCount() {
        return usersList.size();
    }

    @Override
    public Object getItem(int position) {
        return usersList.get(position);
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

        User user= usersList.get(position);

        usernameTv = row.findViewById(R.id.usernameTvUd);
        scoreTv =  row.findViewById(R.id.userScoreTv);
        ImageButton prodcut_Img_btn = row.findViewById(R.id.imageBtnUd);


        usernameTv .setText(user.getmName());
        scoreTv.setText(user.getmScore());

        //prodcut_Img_btn.setImageBitmap(user.getM_bitmap());

        return row;
    }
}
