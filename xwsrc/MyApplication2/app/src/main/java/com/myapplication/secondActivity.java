package com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;



public class secondActivity extends AppCompatActivity {

    private List msgList = new ArrayList<>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final MsgAdapter[] adapter = new MsgAdapter[1];
        final EditText inputText = (EditText) findViewById(R.id.input_text);
        Button send = (Button) findViewById(R.id.send);
        final RecyclerView msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recyler_view);
        msgRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                msgList.add(content);
                msgRecyclerView.setAdapter(  new MsgAdapter() );
                inputText.setText("");
            }
        });

    }

    class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {
        @Override
        public MsgAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item, parent, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(MsgAdapter.ViewHolder holder, int position) {
            holder.tv.setText((Integer) msgList.get(position));
        }

        @Override
        public int getItemCount() {
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView tv;
            public ViewHolder(View itemView) {
                super(itemView);
                tv = (TextView)  itemView.findViewById(R.id.msg);
            }
        }
    }
}
