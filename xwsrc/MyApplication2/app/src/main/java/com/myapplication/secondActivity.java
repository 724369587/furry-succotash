package com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;



public class secondActivity extends AppCompatActivity {

    private List<String> datas;
    private RecyclerView recyclerView;
    private GroupRecyclerViewAdapter adapter;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initData();
        final EditText inputText = (EditText) findViewById(R.id.input_text);
        Button add = (Button) findViewById(R.id.add);
        final RecyclerView msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recyler_view);
        msgRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        msgRecyclerView.setAdapter(adapter = new GroupRecyclerViewAdapter(this, datas));
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content = inputText.getText().toString();
                adapter.addData(content);
                inputText.setText("");
            }
        });
    }

    private void initData(){
        datas=new ArrayList<>();
        datas.add("begin");
    }
}
