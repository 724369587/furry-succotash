package com.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String[] data = {"Apple" , "Banana" , "3" ,"4", "5" ,"6","7","8","9","10"};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionbar = getSupportActionBar();
        if (actionbar != null){
            actionbar.hide();
        }
        Button button1 = (Button) findViewById(R.id.BT_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("second_ACTION_START");
                startActivity(intent);
            }
        });
       // ArrayAdapter<String> adapter;
        //adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.listview,data);
       // ListView listView = (ListView) findViewById(list_view);
        //listView.setAdapter(adapter);
    }
}
