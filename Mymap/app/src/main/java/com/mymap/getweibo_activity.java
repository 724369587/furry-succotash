package com.mymap;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

import java.util.List;

/**
 * Created by Juphoon on 2018/3/26.
 */

public class getweibo_activity extends AppCompatActivity  {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getweibo_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#4169E1")); //设置标题颜色
        toolbar.setBackgroundColor(Color.parseColor("#ffffff"));

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置TOOLbar返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // <span style="white-space:pre">    </span>//点击back键finish当前activity
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent itent=new Intent();
                itent.setClass(getweibo_activity.this, MainActivity.class);
                startActivity(itent);
                getweibo_activity.this.finish();
                break;
        }
        return true;
    }
    public void onBackPressed() {
        Intent itent=new Intent();
        itent.setClass(getweibo_activity.this, MainActivity.class);
        startActivity(itent);
        getweibo_activity.this.finish();
    }
}