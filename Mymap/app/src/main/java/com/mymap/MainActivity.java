package com.mymap;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.amap.api.maps2d.AMap;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.MyLocationStyle;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private long mExitTime = System.currentTimeMillis();  //为当前系统时间，单位：毫秒
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView lvLeftMenu;
    private String[] lvs = {"普通计算器", "基金计算器", "地图", "天气","微博"};
    private ArrayAdapter arrayAdapter;
    private ImageView ivRunningMan;
    private AnimationDrawable mAnimationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews(); //获取控件
        //京东RunningMan动画效果，和本次Toolbar无关
        toolbar.setTitle("测试");
        toolbar.setTitleTextColor(Color.parseColor("#4169E1")); //设置标题颜色
        toolbar.setBackgroundColor(Color.parseColor("#ffffff"));
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dl_left);
        drawer.setScrimColor(Color.TRANSPARENT);//背景透明
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
    }
    private void findViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.dl_left);
        lvLeftMenu = (ListView) findViewById(R.id.lv_left_menu);
        onDrawerItemSelected();
    }
   /*public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == 0)
        {
            mDrawerLayout.openDrawer(GravityCompat.START);//打开侧滑菜单
            return true ;
        }else if (id == 2)
        {
            Intent itent=new Intent();
            itent.setClass(MainActivity.this, map_activity.class);
            startActivity(itent);
            MainActivity.this.finish();
        }

        return super.onOptionsItemSelected(item);
    }*/
    public boolean onDrawerItemSelected( ){
      lvLeftMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              if(position == 2)
              {
                  Intent itent=new Intent();
                  itent.setClass(MainActivity.this, map_activity.class);
                  startActivity(itent);
                  MainActivity.this.finish();
              }else if (position == 3)
              {
                  Intent itent=new Intent();
                  itent.setClass(MainActivity.this, weather_activity.class);
                  startActivity(itent);
                  MainActivity.this.finish();
              }else if (position == 4)
              {
                  Intent itent=new Intent();
                  itent.setClass(MainActivity.this, getweibo_activity.class);
                  startActivity(itent);
                  MainActivity.this.finish();
              }
          }
      });
        return true;
    }
    public void onBackPressed() {
        if(System.currentTimeMillis() - mExitTime < 800) {
            MainActivity.this.finish();   //关闭本活动页面
        }
        else{
            MyTools.Tools.showToast(this,"再按返回键退出",800);
            mExitTime = System.currentTimeMillis();   //这里赋值最关键，别忘记
        }
    }
}
