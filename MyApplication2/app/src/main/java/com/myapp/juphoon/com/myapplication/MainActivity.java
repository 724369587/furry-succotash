package com.myapp.juphoon.com.myapplication;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import java.util.HashMap;
import java.util.Map;

import MyTools.SharedPrefsUtil;
import MyTools.Tools;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnLongClickListener, View.OnTouchListener {
    private Toolbar toolbar;
    private String NewTitle =  "";
    private EditText et_chicangjingzhi;
    private EditText et_chicangfene;
    private EditText et_chicangzonge;
    private EditText et_jiancangjingzhi;
    private EditText et_jiancangfene;
    private EditText et_jiancangzonge;
    private EditText et_jiacangjingzhi;
    private EditText et_jiacangfene;
    private EditText et_jiacangzonge;
    private EditText et_chicangchengben;
    private EditText et_jiancangchengben;
    private EditText et_jiacangchengben;
    private EditText et_chicangyingkui;
    private EditText et_jiancangyingkui;
    private EditText et_jiacangyingkui;
    private EditText et_chushizonge;
    private EditText et_newtitle;
    Double tmp_addjinge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(" My App - 基金计算器");
        toolbar.setSubtitle(" 白酒");
        setSupportActionBar(toolbar);

        et_chicangjingzhi = (EditText) findViewById(R.id.et_chicangjingzhi);
        et_chicangfene = (EditText) findViewById(R.id.et_chicangfene);
        et_chicangzonge = (EditText) findViewById(R.id.et_chicangzonge);
        et_jiacangfene = (EditText) findViewById(R.id.et_jiacangfene);
        et_jiancangfene = (EditText) findViewById(R.id.et_jiancangfene);
        et_chicangchengben = (EditText) findViewById(R.id.et_chicangchengben);
        et_jiacangchengben = (EditText) findViewById(R.id.et_jiacangchengben);
        et_jiancangchengben = (EditText) findViewById(R.id.et_jiancangchengben);
        et_chicangyingkui = (EditText) findViewById(R.id.et_chicangyingkui);
        et_jiacangyingkui = (EditText) findViewById(R.id.et_jiacangyingkui);
        et_jiancangyingkui = (EditText) findViewById(R.id.et_jiancangyingkui);
        et_jiacangzonge = (EditText) findViewById(R.id.et_jiacangzonge);
        et_jiacangjingzhi = (EditText) findViewById(R.id.et_jiacangjingzhi);
        et_jiancangzonge = (EditText) findViewById(R.id.et_jiancangzonge);
        et_jiancangjingzhi = (EditText) findViewById(R.id.et_jiancangjingzhi);
        et_chushizonge = (EditText) findViewById(R.id.et_zuizhongzonge);

        Button btpingcang = (Button) findViewById(R.id.bt_pingcang);
        Button btjiacang = (Button) findViewById(R.id.bt_jiacang);
        Button btjiancang = (Button) findViewById(R.id.bt_jiancang);
        Button btjiacangok = (Button) findViewById(R.id.bt_jiacangok);
        Button btjiancangok = (Button) findViewById(R.id.bt_jiancangok);
        btpingcang.setOnLongClickListener(this);
        btjiacang.setOnLongClickListener(this);
        btjiancang.setOnLongClickListener(this);
        btjiacangok.setOnLongClickListener(this);
        btjiancangok.setOnLongClickListener(this);
        et_chicangzonge.setOnTouchListener(this);
        et_jiacangfene.setOnTouchListener(this);
        et_jiancangzonge.setOnTouchListener(this);
        et_chicangchengben.setOnTouchListener(this);
        et_jiacangchengben.setOnTouchListener(this);
        et_jiancangchengben.setOnTouchListener(this);
        et_chicangyingkui.setOnTouchListener(this);
        et_jiacangyingkui.setOnTouchListener(this);
        et_jiancangyingkui.setOnTouchListener(this);
        et_chushizonge.setOnTouchListener(this);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onButtonClickHandler(View v) {
        int id = v.getId();
        switch (id){
            case R.id.bt_pingcang:
                    String q = et_chicangzonge.toString();
              if ("".equals(et_chicangfene.getText().toString())  || "".equals(et_chushizonge.getText().toString())  || "".equals(et_chicangjingzhi.getText().toString()))
                   Tools.showToast(MainActivity.this,"请先计算持仓数值和初始金额",50);
              else {
                    CEPosition();
                }
                break;
            case R.id.bt_jiacang:
                if ("".equals(et_chicangfene.getText().toString())  || "".equals(et_chushizonge.getText().toString())  || "".equals(et_chicangjingzhi.getText().toString()) )
                    Tools.showToast(MainActivity.this,"请先计算持仓数值和初始金额",50);
                else if ("".equals(et_jiacangzonge.getText().toString())  || "".equals(et_jiacangjingzhi.getText().toString()) )
                    Tools.showToast(MainActivity.this,"请输入加仓总额和净值",50);
                else {
                    OVErweight();
                }
                break;
            case R.id.bt_jiacangok:
                if ("".equals(et_chicangfene.getText().toString())  || "".equals(et_chushizonge.getText().toString())  || "".equals(et_chicangjingzhi.getText().toString()) )
                    Tools.showToast(MainActivity.this,"请先计算持仓数值和初始金额",50);
                else if ("".equals(et_jiacangzonge.getText().toString())  || "".equals(et_jiacangjingzhi.getText().toString()) )
                    Tools.showToast(MainActivity.this,"请输入加仓总额和净值",50);
                else {
                    Double tmp_jinge = Double.parseDouble(et_chushizonge.getText().toString());
                    Double tmp_addjinge1 = Double.parseDouble(et_jiacangzonge.getText().toString());
                    if (tmp_addjinge != tmp_addjinge1)
                        OVErweight();
                    Double tmp1 = tmp_addjinge1 + tmp_jinge;
                    if (tmp_jinge < 0)
                        Tools.showToast(MainActivity.this, "加仓失败", 50);
                    else {
                        Double tmp_fene = Double.parseDouble(et_chicangfene.getText().toString());
                        Double tmp_addfene = Double.parseDouble(et_jiacangfene.getText().toString());
                        Double tmp2 = tmp_addfene + tmp_fene;
                        et_chushizonge.setText(tmp1.toString());
                        et_chicangfene.setText(tmp2.toString());
                        et_chicangjingzhi.setText(et_jiacangchengben.getText().toString());
                        CEPosition();
                        Tools.showToast(MainActivity.this, "加仓成功", 50);
                    }
                }
                break;
            case R.id.bt_jiancang:
                if ("".equals(et_chicangfene.getText().toString())  || "".equals(et_chushizonge.getText().toString())  || "".equals(et_chicangjingzhi.getText().toString()) )
                    Tools.showToast(MainActivity.this,"请先计算持仓数值和初始金额",50);
                else if ("".equals(et_jiancangfene.getText().toString())  || "".equals(et_jiancangjingzhi.getText().toString()) )
                    Tools.showToast(MainActivity.this,"请输入减仓份额和净值",50);
                else {
                    Map<String, Double> map_un= new HashMap<String, Double>();
                    map_un = Caculator.UNDerweight(et_jiancangfene.getText().toString(), et_jiancangjingzhi.getText().toString(),et_chicangfene.getText().toString(),et_chicangchengben.getText().toString(), et_chushizonge.getText().toString());
                    et_jiancangchengben.setText(map_un.get("ruchengben").toString());
                    et_jiancangyingkui.setText(map_un.get("ruyingkui").toString());
                    et_jiancangzonge.setText(map_un.get("ruzonge").toString());
                    map_un.clear();
                }
                break;
            case R.id.bt_jiancangok:
                if ("".equals(et_chicangfene.getText().toString())  || "".equals(et_chushizonge.getText().toString())  || "".equals(et_chicangjingzhi.getText().toString()) )
                    Tools.showToast(MainActivity.this,"请先计算持仓数值和初始金额",50);
                else if ("".equals(et_jiancangfene.getText().toString())  || "".equals(et_jiancangjingzhi.getText().toString()) )
                    Tools.showToast(MainActivity.this,"请输入减仓份额和净值",50);
                else {
                    Double tmp_jinge1 = Double.parseDouble(et_chushizonge.getText().toString());
                    Double tmp_jianjinge = Double.parseDouble(et_jiancangzonge.getText().toString());
                    Double tmp11 = tmp_jinge1 - tmp_jianjinge;
                    if (tmp11 < 0)
                        Tools.showToast(MainActivity.this, "减仓失败", 50);
                    else {
                        Double tmp_fene1 = Double.parseDouble(et_chicangfene.getText().toString());
                        Double tmp_jianfene = Double.parseDouble(et_jiancangfene.getText().toString());
                        Double tmp21 = tmp_fene1 - tmp_jianfene;
                        et_chushizonge.setText(tmp11.toString());
                        et_chicangfene.setText(tmp21.toString());
                        et_chicangjingzhi.setText(et_jiancangchengben.getText().toString());
                        CEPosition();
                        Tools.showToast(MainActivity.this, "减仓成功", 50);
                    }
                }
                break;
            default :
                break;
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        LayoutInflater inflater = getLayoutInflater();
        switch (id){
            case( R.id.action_set):
                Set();
                break;
            case( R.id.action_get):
                String DataBase = toolbar.getSubtitle().toString();
                Get(DataBase);
                break;
            case( R.id.action_add):
               final View layout = inflater.inflate(R.layout.alertdialog,null);
                AlertDialog.Builder alert =  new AlertDialog.Builder(this);
                alert.setTitle("新建").setView(layout);
                alert.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        et_newtitle =(EditText) layout.findViewById(R.id.etname);
                        NewTitle = et_newtitle.getText().toString();
                        AddTitle(NewTitle);
                    }
                });
                alert.setNegativeButton("取消", null);
                alert.create();
                alert.show();
                break;
            case( R.id.action_change):
                break;
            case( R.id.action_remove):
                View layout2 = inflater.inflate(R.layout.alertdialog_clean,null);
                AlertDialog.Builder alert2 =  new AlertDialog.Builder(this);
                alert2.setTitle("警告").setView(layout2);
                alert2.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int i) {
                        RemovePag();
                    }
                });
                alert2.setNegativeButton("取消", null);
                alert2.create();
                alert2.show();
                break;
            case( R.id.action_clean):
                View layout3 = inflater.inflate(R.layout.alertdialog_clean,null);
                AlertDialog.Builder alert3 =  new AlertDialog.Builder(this);
                alert3.setTitle("警告").setView(layout3);
                alert3.setPositiveButton("确定",new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int i) {
                    CleanMyPag();
                }
                });
                alert3.setNegativeButton("取消", null);
                alert3.create();
                alert3.show();
                break;
            case( R.id.action_out):
                GetDataBase();
                break;
            default :
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Intent itent=new Intent();
            itent.setClass(MainActivity.this, activity_calculator.class);
            startActivity(itent);
            MainActivity.this.finish();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void init( )
    {
        et_chicangjingzhi = (EditText) findViewById(R.id.et_chicangjingzhi);
        et_chicangfene = (EditText) findViewById(R.id.et_chicangfene);
        et_chicangzonge = (EditText) findViewById(R.id.et_chicangzonge);
        et_jiacangfene = (EditText) findViewById(R.id.et_jiacangfene);
        et_jiancangfene = (EditText) findViewById(R.id.et_jiancangfene);
        et_chicangchengben = (EditText) findViewById(R.id.et_chicangchengben);
        et_jiacangchengben = (EditText) findViewById(R.id.et_jiacangchengben);
        et_jiancangchengben = (EditText) findViewById(R.id.et_jiancangchengben);
        et_chicangyingkui = (EditText) findViewById(R.id.et_chicangyingkui);
        et_jiacangyingkui = (EditText) findViewById(R.id.et_jiacangyingkui);
        et_jiancangyingkui = (EditText) findViewById(R.id.et_jiancangyingkui);
        et_jiacangzonge = (EditText) findViewById(R.id.et_jiacangzonge);
        et_jiacangjingzhi = (EditText) findViewById(R.id.et_jiacangjingzhi);
        et_jiancangzonge = (EditText) findViewById(R.id.et_jiancangzonge);
        et_jiancangjingzhi = (EditText) findViewById(R.id.et_jiancangjingzhi);
        et_chushizonge = (EditText) findViewById(R.id.et_zuizhongzonge);

        Button btpingcang = (Button) findViewById(R.id.bt_pingcang);
        Button btjiacang = (Button) findViewById(R.id.bt_jiacang);
        Button btjiancang = (Button) findViewById(R.id.bt_jiancang);
        Button btjiacangok = (Button) findViewById(R.id.bt_jiacangok);
        Button btjiancangok = (Button) findViewById(R.id.bt_jiancangok);
        btpingcang.setOnLongClickListener((View.OnLongClickListener) MainActivity.this);
        btjiacang.setOnLongClickListener((View.OnLongClickListener) MainActivity.this);
        btjiancang.setOnLongClickListener((View.OnLongClickListener) MainActivity.this);
        btjiacangok.setOnLongClickListener((View.OnLongClickListener) MainActivity.this);
        btjiancangok.setOnLongClickListener((View.OnLongClickListener) MainActivity.this);
        et_chicangzonge.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_jiacangfene.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_jiancangzonge.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_chicangchengben.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_jiacangchengben.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_jiancangchengben.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_chicangyingkui.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_jiacangyingkui.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_jiancangyingkui.setOnTouchListener((View.OnTouchListener) MainActivity.this);
        et_chushizonge.setOnTouchListener((View.OnTouchListener) MainActivity.this);
    }

    public void CEPosition() {
        Map<String, Double> map_ce = new HashMap<String, Double>();
        map_ce = Caculator.CEPosition(et_chicangfene.getText().toString(), et_chicangjingzhi.getText().toString(), et_chushizonge.getText().toString());
        et_chicangzonge.setText(map_ce.get("rczonge").toString());
        et_chicangyingkui.setText(map_ce.get("rcyingkui").toString());
        et_chicangchengben.setText(map_ce.get("rcchengben").toString());
        map_ce.clear();
    }


    public void OVErweight(){
        Map<String, Double> map_ov= new HashMap<String, Double>();
        tmp_addjinge = Double.parseDouble(et_jiacangzonge.getText().toString());
        map_ov = Caculator.OVErweight(et_jiacangzonge.getText().toString(), et_jiacangjingzhi.getText().toString(),et_chicangzonge.getText().toString(),et_chicangfene.getText().toString(), et_chushizonge.getText().toString());
        et_jiacangchengben.setText(map_ov.get("rochengben").toString());
        et_jiacangfene.setText(map_ov.get("rofene").toString());
        et_jiacangyingkui.setText(map_ov.get("royingkui").toString());
        map_ov.clear();

    }

    public void Set(){
        String DataBase = toolbar.getSubtitle().toString();
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_chushizonge" ,et_chushizonge.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_chicangfene" ,et_chicangfene.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_chicangzonge" ,et_chicangzonge.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_chicangjingzhi" ,et_chicangjingzhi.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_chicangyingkui" ,et_chicangyingkui.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_chicangchengben" ,et_chicangchengben.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiacangfene" ,et_jiacangfene.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiacangzonge" ,et_jiacangzonge.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiacangjingzhi" ,et_jiacangjingzhi.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiacangyingkui" ,et_jiacangyingkui.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiacangchengben" ,et_jiacangchengben.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiancangfene" ,et_jiancangfene.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiancangzonge" ,et_jiancangzonge.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiancangjingzhi" ,et_jiancangjingzhi.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiancangyingkui" ,et_jiancangyingkui.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,DataBase,"et_jiancangchengben" ,et_jiancangchengben.getText().toString());
        Tools.showToast(MainActivity.this,"保存成功",50);
    }

    public  void Get(String DataBase){

        et_chushizonge.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_chushizonge"));
        et_chicangyingkui.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_chicangyingkui"));
        et_chicangchengben.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_chicangchengben"));
        et_chicangfene.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_chicangfene"));
        et_chicangzonge.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_chicangzonge"));
        et_chicangjingzhi.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_chicangjingzhi"));
        et_jiacangyingkui.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiacangyingkui"));
        et_jiacangchengben.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiacangchengben"));
        et_jiacangfene.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiacangfene"));
        et_jiacangzonge.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiacangzonge"));
        et_jiacangjingzhi.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiacangjingzhi"));
        et_jiancangyingkui.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiancangyingkui"));
        et_jiancangchengben.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiancangchengben"));
        et_jiancangfene.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiancangfene"));
        et_jiancangzonge.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiancangzonge"));
        et_jiancangjingzhi.setText(SharedPrefsUtil.getString(MainActivity.this,DataBase,"et_jiancangjingzhi"));
        Tools.showToast(MainActivity.this,"获取成功",50);
    }

    public void AddTitle(String Title)
    {
        Set(); //保存当前页面数据
        toolbar.setSubtitle(Title);
        CleanMyPag();
        Tools.showToast(MainActivity.this,"新建成功",50);
    }

    public void RemovePag()
    {
       String title =  toolbar.getSubtitle().toString();
       SharedPrefsUtil.removeString(MainActivity.this,title);
        Tools.showToast(MainActivity.this,"删除成功",50);
    }
    public void CleanMyPag()
    {
        et_chushizonge.setText("");
        et_chicangfene.setText("");
        et_chicangzonge.setText("");
        et_chicangjingzhi.setText("");
        et_chicangyingkui.setText("");
        et_chicangchengben.setText("");
        et_jiacangfene.setText("");
        et_jiacangzonge.setText("");
        et_jiacangjingzhi.setText("");
        et_jiacangyingkui.setText("");
        et_jiacangchengben.setText("");
        et_jiancangfene.setText("");
        et_jiancangzonge.setText("");
        et_jiancangjingzhi.setText("");
        et_jiancangyingkui.setText("");
        et_jiancangchengben.setText("");
    }

    public  void  GetDataBase()
    {
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}
