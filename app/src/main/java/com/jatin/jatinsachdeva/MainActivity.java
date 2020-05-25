package com.jatin.jatinsachdeva;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MessageAdapter messageAdapter;
    ArrayList<String> messageList;
    String s[];

    public void addMessage(View view){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean connected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            connected = true;

        }
        else{
            connected = false;

        }

        if(connected){
            Toast.makeText(this, "Internet is available", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Connectivity Error", Toast.LENGTH_SHORT).show();
        }

        s = getResources().getStringArray(R.array.Messages);
        recyclerView = findViewById(R.id.conversations);
        messageAdapter = new MessageAdapter(this,s);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(messageAdapter);

    }

}
