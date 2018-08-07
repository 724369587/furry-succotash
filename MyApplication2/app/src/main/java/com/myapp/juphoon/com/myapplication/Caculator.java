package com.myapp.juphoon.com.myapplication;


import android.content.Context;
import android.widget.EditText;

import java.util.HashMap;
import java.util.Map;

import MyTools.SharedPrefsUtil;
import MyTools.XArith;

/**
 * Created by Juphoon on 2018/3/15.
 */

public class Caculator {

    private static  Double d_chushizonge = 0.0;
    private static Double d_chicangjingzhi = 0.0;
    private static Double d_chicangfene = 0.0;
    private static Double d_chicangzonge = 0.0;
    private static Double d_chicangchengben = 0.0;
    private static Double d_chicangyingkui = 0.0;
    private static Double d_jiacangzonge = 0.0;
    private static Double d_jiacangjingzhi = 0.0;
    private static Double d_jiacangchengben = 0.0;
    private static Double d_jiacangyingkui = 0.0;
    private static Double d_jiacangfene = 0.0;
    private static Double d_jiancangzonge = 0.0;
    private static Double d_jiancangjingzhi = 0.0;
    private static Double d_jiancangfene = 0.0;
    private static Double d_jiancangchengben = 0.0;
    private static Double d_jiancangyingkui = 0.0;


    public  static  void  CEPosition ( double cfene, double cjingzhi, double zonge,double rczonge, double rcchengben, double rcyingkui ,double rzonge  ) //平仓
    {
            d_chicangjingzhi = cjingzhi;
            d_chicangfene = cfene;
            d_chushizonge = zonge;
            d_chicangzonge = Double.parseDouble(XArith.mul(d_chicangfene, d_chicangjingzhi));
            d_chicangchengben = Double.parseDouble(XArith.div(d_chushizonge,d_chicangjingzhi));
            d_chicangyingkui = Double.parseDouble(XArith.div((d_chicangjingzhi - d_chicangchengben),d_chicangchengben));
            rczonge = d_chicangzonge;
            rzonge = d_chushizonge;
            rcchengben = d_chicangchengben;
            rcyingkui = d_chicangyingkui;
    }

    public  static Map<String, Double> CEPosition (String cfene, String cjingzhi, String zonge ) //平仓
    {
        d_chicangjingzhi = Double.parseDouble(cjingzhi);
        d_chicangfene =  Double.parseDouble(cfene);
        d_chushizonge =  Double.parseDouble(zonge);
        d_chicangzonge = Double.parseDouble(XArith.mul(d_chicangfene, d_chicangjingzhi));
        d_chicangchengben = Double.parseDouble(XArith.div(d_chushizonge,d_chicangfene));
        d_chicangyingkui = Double.parseDouble(XArith.div((d_chicangjingzhi - d_chicangchengben),d_chicangchengben));
        Map<String, Double> map_ce = new HashMap<String, Double>();
        map_ce.put("rczonge",d_chicangzonge);
        map_ce.put("rcchengben",d_chicangchengben);
        map_ce.put("rcyingkui",d_chicangyingkui);
        return  map_ce;
    }

    public static void OVErweight ( double ozonge, double ojingzhi,double zonge, double fene,double rofene, double rochengben, double royingkui, double rzonge) //加仓
    {
        d_jiacangzonge = ozonge;
        d_jiacangjingzhi = ojingzhi;
        d_chushizonge = zonge;

        d_jiacangfene = Double.parseDouble(XArith.div(d_jiacangzonge,d_jiacangjingzhi));
        d_jiacangchengben = Double.parseDouble(XArith.div((d_chushizonge + d_chicangzonge),(d_chicangfene + d_jiacangfene)));
        d_jiacangyingkui = Double.parseDouble(XArith.div((d_chicangjingzhi - d_jiacangjingzhi),d_jiacangchengben));
        rochengben = d_jiacangchengben;
        rofene = d_jiacangfene;
        royingkui =  d_jiacangyingkui;
        rzonge = d_jiacangzonge + d_chushizonge;
    }

    public static Map<String, Double> OVErweight ( String ozonge, String ojingzhi, String czonge, String cfene,String zonge ) //加仓
    {
        d_chicangzonge = Double.parseDouble(czonge);
        d_chicangfene = Double.parseDouble(cfene);
        d_jiacangzonge = Double.parseDouble(ozonge);
        d_jiacangjingzhi = Double.parseDouble(ojingzhi);
        d_chushizonge = Double.parseDouble(zonge);
        d_jiacangfene = Double.parseDouble(XArith.div(d_jiacangzonge,d_jiacangjingzhi));
        d_jiacangchengben = Double.parseDouble(XArith.div((d_chushizonge + d_chicangzonge),(d_chicangfene + d_jiacangfene)));
        d_jiacangyingkui = Double.parseDouble(XArith.div((d_chicangjingzhi - d_jiacangjingzhi),d_jiacangchengben));
        Map<String, Double> map_ov = new HashMap<String, Double>();
        map_ov.put("rochengben",d_jiacangchengben);
        map_ov.put("rofene",d_jiacangfene);
        map_ov.put("royingkui",d_jiacangyingkui);

        return  map_ov;
    }

    public static void UNDerweight ( double uzonge, double ujingzhi, double zonge ,double rufene, double ruchengben, double ruyingkui, double rzonge) //减仓
    {
        d_jiancangzonge = uzonge;
        d_jiancangjingzhi = ujingzhi;
        d_chushizonge = zonge;
        if (d_jiancangzonge >= d_chushizonge)
            d_jiancangzonge = d_chushizonge-1;
        d_jiancangfene = Double.parseDouble(XArith.div(d_jiancangfene,d_jiancangjingzhi));
        d_jiancangchengben = Double.parseDouble(XArith.div((d_chushizonge - d_jiancangzonge),(d_chicangfene - d_jiancangfene )));
        d_jiancangyingkui = Double.parseDouble(XArith.div((d_chicangchengben - d_jiancangchengben),d_jiancangchengben));
        rufene = d_jiancangchengben;
        ruchengben = d_jiancangchengben;
        ruyingkui = d_jiancangyingkui;
        rzonge = d_chushizonge - d_jiancangzonge;
    }
    public static Map<String, Double>  UNDerweight ( String ufene, String ujingzhi,String cfene,String cchengben, String zonge) //减仓
    {
        d_chicangfene = Double.parseDouble(cfene);
        d_chicangchengben = Double.parseDouble(cchengben);
        d_jiancangfene = Double.parseDouble(ufene);
        d_jiancangjingzhi = Double.parseDouble(ujingzhi);
        d_chushizonge = Double.parseDouble(zonge);
        if (d_jiancangfene >= d_chicangfene)
            d_jiancangfene = d_chicangfene;
        d_jiancangzonge = Double.parseDouble(XArith.mul(d_jiancangfene,d_jiancangjingzhi));
        d_jiancangchengben = Double.parseDouble(XArith.div((d_chushizonge - d_jiancangzonge),(d_chicangfene - d_jiancangfene )));
        d_jiancangyingkui = Double.parseDouble(XArith.div((d_chicangchengben - d_jiancangchengben),d_jiancangchengben));
        Map<String, Double> map_un = new HashMap<String, Double>();
        map_un.put("ruzonge",d_jiancangzonge);
        map_un.put("ruchengben",d_jiancangchengben);
        map_un.put("ruyingkui",d_jiancangyingkui);
        return map_un;
    }



}
