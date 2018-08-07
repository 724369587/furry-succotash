package com.example.juphoon.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.juphoon.myapplication.Caculator;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import MyTools.Tools;
import MyTools.SharedPrefsUtil;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnTouchListener,OnLongClickListener{

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

    public static final String DATABSE = "Database";


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }

    public void onButtonClickHandler(View v) {

        int id = v.getId();
        switch (id){
            case R.id.bt_pingcang:
                if ("0".equals(et_chicangfene.getHint().toString())  || "0".equals(et_chushizonge.getHint().toString())  || "0".equals(et_chicangjingzhi.getHint().toString()) )
                    Tools.showToast(MainActivity.this,"请先计算持仓数值和初始金额",50);
                else {
                    CEPosition();
                }
                break;
            case R.id.bt_jiacang:
                if ("0".equals(et_chicangfene.getHint().toString())  || "0".equals(et_chushizonge.getHint().toString())  || "0".equals(et_chicangjingzhi.getHint().toString()) )
                    Tools.showToast(MainActivity.this,"请先计算持仓数值和初始金额",50);
                else if ("0".equals(et_jiacangzonge.getHint().toString())  || "0".equals(et_jiacangjingzhi.getHint().toString()) )
                    Tools.showToast(MainActivity.this,"请输入加仓总额和净值",50);
                else {
                    Map<String, Double> map_ov= new HashMap<String, Double>();
                    map_ov = Caculator.OVErweight(et_jiacangzonge.getText().toString(), et_jiacangjingzhi.getText().toString(),et_chicangzonge.getText().toString(),et_chicangfene.getText().toString(), et_chushizonge.getText().toString());
                    et_jiacangchengben.setText(map_ov.get("rochengben").toString());
                    et_jiacangfene.setText(map_ov.get("rofene").toString());
                    et_jiacangyingkui.setText(map_ov.get("royingkui").toString());
                    map_ov.clear();
                }
                break;
            case R.id.bt_jiacangok:
                Double tmp_jinge = Double.parseDouble(et_chushizonge.getText().toString());
                Double tmp_addjinge = Double.parseDouble(et_jiacangzonge.getText().toString());
                Double tmp1 = tmp_addjinge + tmp_jinge;
                if ( tmp_jinge < 0)
                    Tools.showToast(MainActivity.this,"加仓失败",50);
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
                break;
            case R.id.bt_jiancang:
             if ("0".equals(et_chicangfene.getHint().toString())  || "0".equals(et_chushizonge.getHint().toString())  || "0".equals(et_chicangjingzhi.getHint().toString()) )
                Tools.showToast(MainActivity.this,"请先计算持仓数值和初始金额",50);
            else if ("0".equals(et_jiancangfene.getHint().toString())  || "0".equals(et_jiancangjingzhi.getHint().toString()) )
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
                Double tmp_jinge1 = Double.parseDouble(et_chushizonge.getText().toString());
                Double tmp_jianjinge = Double.parseDouble(et_jiancangzonge.getText().toString());
                Double tmp11 =  tmp_jinge1 - tmp_jianjinge;
                if ( tmp11 < 0)
                    Tools.showToast(MainActivity.this,"减仓失败",50);
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
                break;
            case R.id.bt_set:
                Set();
                break;
            case R.id.bt_get:
                Get();
                break;
            default:
                break;

        }
    }
    public void CEPosition() {
        Map<String, Double> map_ce = new HashMap<String, Double>();
        map_ce = Caculator.CEPosition(et_chicangfene.getText().toString(), et_chicangjingzhi.getText().toString(), et_chushizonge.getText().toString());
        et_chicangzonge.setText(map_ce.get("rczonge").toString());
        et_chicangyingkui.setText(map_ce.get("rcyingkui").toString());
        et_chicangchengben.setText(map_ce.get("rcchengben").toString());
        map_ce.clear();
    }
    public void Set(){
        SharedPrefsUtil.putString(MainActivity.this,"et_chushizonge" ,et_chushizonge.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_chicangfene" ,et_chicangfene.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_chicangzonge" ,et_chicangzonge.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_chicangjingzhi" ,et_chicangjingzhi.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_chicangyingkui" ,et_chicangyingkui.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_chicangchengben" ,et_chicangchengben.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiacangfene" ,et_jiacangfene.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiacangzonge" ,et_jiacangzonge.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiacangjingzhi" ,et_jiacangjingzhi.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiacangyingkui" ,et_jiacangyingkui.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiacangchengben" ,et_jiacangchengben.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiancangfene" ,et_jiancangfene.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiancangzonge" ,et_jiancangzonge.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiancangjingzhi" ,et_jiancangjingzhi.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiancangyingkui" ,et_jiancangyingkui.getText().toString());
        SharedPrefsUtil.putString(MainActivity.this,"et_jiancangchengben" ,et_jiancangchengben.getText().toString());
        Tools.showToast(MainActivity.this,"保存成功",50);
    }

    public  void Get(){
        et_chushizonge.setText(SharedPrefsUtil.getString(MainActivity.this,"et_chushizonge"));
        et_chicangyingkui.setText(SharedPrefsUtil.getString(MainActivity.this,"et_chicangyingkui"));
        et_chicangchengben.setText(SharedPrefsUtil.getString(MainActivity.this,"et_chicangchengben"));
        et_chicangfene.setText(SharedPrefsUtil.getString(MainActivity.this,"et_chicangfene"));
        et_chicangzonge.setText(SharedPrefsUtil.getString(MainActivity.this,"et_chicangzonge"));
        et_chicangjingzhi.setText(SharedPrefsUtil.getString(MainActivity.this,"et_chicangjingzhi"));
        et_jiacangyingkui.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiacangyingkui"));
        et_jiacangchengben.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiacangchengben"));
        et_jiacangfene.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiacangfene"));
        et_jiacangzonge.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiacangzonge"));
        et_jiancangjingzhi.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiacangjingzhi"));
        et_jiancangyingkui.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiancangyingkui"));
        et_jiancangchengben.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiancangchengben"));
        et_jiancangfene.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiancangfene"));
        et_jiancangzonge.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiancangzonge"));
        et_jiancangjingzhi.setText(SharedPrefsUtil.getString(MainActivity.this,"et_jiancangjingzhi"));
        Tools.showToast(MainActivity.this,"获取成功",50);
    }

    @Override
    public boolean onLongClick(View arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // TODO 自动生成的方法存根
        return false;
    }


}