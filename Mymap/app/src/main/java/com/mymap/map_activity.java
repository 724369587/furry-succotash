package com.mymap;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.AMapOptions;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.CameraPosition;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MyLocationStyle;

/**
 * Created by Juphoon on 2018/3/23.
 */

public class map_activity extends AppCompatActivity {
    private long mExitTime = System.currentTimeMillis();  //为当前系统时间，单位：毫秒
    private Toolbar toolbar;
    MapView mapView;
    AMap aMap;
    private ImageView ivRunningMan;
    private AnimationDrawable mAnimationDrawable;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.parseColor("#4169E1")); //设置标题颜色
        toolbar.setBackgroundColor(Color.parseColor("#ffffff"));

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置TOOLbar返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mapView = (MapView) findViewById(R.id.map);
/*        mapView.onCreate(savedInstanceState);
        LatLng centercsPoint= new LatLng(28.207006,112.977722);
        AMapOptions mapOptions = new AMapOptions();
        mapOptions.camera(new CameraPosition(centercsPoint, 10f, 0, 0));
        mapView = new MapView(this, mapOptions);*/


        mapView.onCreate(savedInstanceState);// 此方法须覆写，虚拟机需要在很多情况下保存地图绘制的当前状态。
        if (aMap == null) {
            aMap = mapView.getMap();
        }
        MyLocationStyle myLocationStyle;
        myLocationStyle = new MyLocationStyle();//初始化定位蓝点样式类myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATION_ROTATE);//连续定位、且将视角移动到地图中心点，定位点依照设备方向旋转，并且会跟随设备移动。（1秒1次定位）如果不设置myLocationType，默认也会执行此种模式。
        myLocationStyle.interval(1000); //设置连续定位模式下的定位间隔，只在连续定位模式下生效，单次定位模式下不会生效。单位为毫秒。
        aMap.setMyLocationStyle(myLocationStyle);//设置定位蓝点的Style
        aMap.setMyLocationEnabled(true);// 设置为true表示启动显示定位蓝点，false表示隐藏定位蓝点并不进行定位，默认是false。
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // <span style="white-space:pre">    </span>//点击back键finish当前activity
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent itent = new Intent();
                itent.setClass(map_activity.this, MainActivity.class);
                startActivity(itent);
                break;
        }
        return true;
    }


    private Toolbar.OnMenuItemClickListener onMenuItemClick = new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            String msg = "";
            switch (menuItem.getItemId()) {
                case R.id.router_bus:
                    msg += "Click edit";
                    break;
                case R.id.router_walk:
                    msg += "Click share";
                    break;
                case R.id.router_busstop:
                    msg += "Click setting";
                    break;
            }
            return true;
        }
    };


    public void onBackPressed() {

        if (System.currentTimeMillis() - mExitTime < 800) {
            Intent itent = new Intent();
            itent.setClass(map_activity.this, MainActivity.class);
            startActivity(itent);
            map_activity.this.finish();
        } else {
            MyTools.Tools.showToast(this, "再按一下返回主页", 800);
            mExitTime = System.currentTimeMillis();   //这里赋值最关键，别忘记
        }
    }
}


