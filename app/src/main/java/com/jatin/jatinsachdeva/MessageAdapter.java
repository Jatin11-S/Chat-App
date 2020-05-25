package com.jatin.jatinsachdeva;

import android.app.VoiceInteractor;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {
    static final int isSender = 0;
    static final int isReceiver = 1;
    String data[];
    Context context;
    Boolean active = true;

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView Smess;
        public TextView Rmess;


        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            Smess = itemView.findViewById(R.id.SenderText);
            Rmess = itemView.findViewById(R.id.RecieverText);
        }

    }

    public MessageAdapter(Context con,String mess[]) {
        context = con;
        data = mess;
    }

    @Override
    public int getItemViewType(int position) {
        if(position%2 == 0){
            return isSender;
        }
        else
            return isReceiver;
    }

    @Override
    public MessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view;
        if(getItemViewType(viewType) == isSender) {
            view = inflater.inflate(R.layout.sender_chat, parent, false);
            return new ViewHolder(view);
        }
        else if(getItemViewType(viewType) == isReceiver) {
            view = inflater.inflate(R.layout.reciever_chat, parent, false);
            return new ViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull final MessageAdapter.ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(holder.getItemViewType()){
                    case isSender:
                        holder.Smess.setText(data[position]);
                        holder.Smess.setVisibility(View.VISIBLE);
                        break;
                    case isReceiver:
                        holder.Rmess.setText(data[position]);
                        holder.Rmess.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return (data.length);
    }



}
