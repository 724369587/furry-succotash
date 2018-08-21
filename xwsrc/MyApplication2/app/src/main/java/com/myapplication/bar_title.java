package com.myapplication;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Juphoon on 2018/8/21.
 */

public class bar_title extends LinearLayout {

    public bar_title(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title,this);
        Button title_back = (Button) findViewById(R.id.title_back);
        Button title_edit = (Button) findViewById(R.id.title_edit);
        title_back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) getContext()).finish();
            }
        });
        title_edit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "you clicked Edit Button",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
