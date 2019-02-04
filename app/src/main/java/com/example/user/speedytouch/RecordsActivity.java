package com.example.user.speedytouch;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import static com.example.user.speedytouch.UserRecords.userRecordsComparator;

public class RecordsActivity extends Activity {

    private ListView mUserListView;
    private UserAdapter userListAdapter;
    private ArrayList<UserRecords> usersListRecords = new ArrayList<UserRecords>();
    private UserRecords userRecords;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        mUserListView = findViewById(R.id.userListView);


        //mScoreTv = findViewById(R.id.scoreTvRecAct);
        //mUsername = findViewById(R.id.usernameTvRecAct);
//load old scores
        SharedPreferences sp = getSharedPreferences("PREFS",MODE_PRIVATE);

        Map<String,?> keys = sp.getAll();

        for(Map.Entry<String,?> entry : keys.entrySet()){
//            userRecords = new UserRecords(entry.getKey(),entry.getValue().toString());
            usersListRecords.add(new UserRecords(entry.getKey(),entry.getValue().toString()));
        }
        Collections.sort(usersListRecords,userRecords.userRecordsComparator);
        userListAdapter = new UserAdapter(usersListRecords,this);
        mUserListView.setAdapter(userListAdapter);
        userListAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
