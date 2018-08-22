package com.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class thirdActivity extends AppCompatActivity {
    private List<GroupItem> groupItemList = new ArrayList<GroupItem>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initGroup();
        GroupAdpter adapter = new GroupAdpter(thirdActivity.this,R.layout.group_item, groupItemList);
        ListView listView = (ListView) findViewById(R.id.list_view_third);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    GroupItem group = groupItemList.get(position);
                Toast.makeText(thirdActivity.this,group.getName(),Toast.LENGTH_SHORT).show();
            }
        });//设置按键监听
    }
    private void initGroup(){
        GroupItem one = new GroupItem("one",R.drawable.one);
        groupItemList.add(one);
    }
}
