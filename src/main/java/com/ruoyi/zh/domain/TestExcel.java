package com.ruoyi.zh.domain;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.mina.DensityVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TestExcel {
    @Excel(name = "时间")
    private String time;

    @Excel(name = "经度")
    private String lng;

    @Excel(name = "纬度")
    private String lat;

    @Excel(name = "1,1,2,2,-四氯乙烷")
    private String field0;

    @Excel(name = "1,1-二氯乙烯")
    private String field1;

    @Excel(name = "1,2,4-三氯苯")
    private String field2;

    @Excel(name = "1,2-二溴乙烷")
    private String field3;

    @Excel(name = "1,3-丁二烯")
    private String field4;

    @Excel(name = "1,3-二氯丙烯")
    private String field5;

    @Excel(name = "TVOC")
    private String field6;

    @Excel(name = "丁烯")
    private String field7;

    @Excel(name = "三乙胺")
    private String field8;

    @Excel(name = "三氯乙烯")
    private String field9;

    @Excel(name = "三氯乙烷")
    private String field10;

    @Excel(name = "三甲苯、乙基甲苯、丙苯")
    private String field11;

    @Excel(name = "丙酮、丁烷")
    private String field12;

    @Excel(name = "乙硫醚、丁硫醇")
    private String field13;

    @Excel(name = "乙酸正丁酯")
    private String field14;

    @Excel(name = "乙酸正丙酯")
    private String field15;

    @Excel(name = "二乙基苯")
    private String field16;

    @Excel(name = "二乙基苯胺")
    private String field17;

    @Excel(name = "二亚乙基三胺")
    private String field18;

    @Excel(name = "二氯苯")
    private String field19;

    @Excel(name = "二溴甲烷")
    private String field20;

    @Excel(name = "二甲基二硫醚")
    private String field21;

    @Excel(name = "二甲基甲酰胺")
    private String field22;

    @Excel(name = "二甲苯、乙苯")
    private String field23;

    @Excel(name = "二甲苯酚")
    private String field24;

    @Excel(name = "二硫化碳、丙硫醇")
    private String field25;

    @Excel(name = "六氯-1，3-丁二烯")
    private String field26;

    @Excel(name = "十一烷")
    private String field27;

    @Excel(name = "四氯乙烯")
    private String field28;

    @Excel(name = "壬烷")
    private String field29;

    @Excel(name = "己烯、甲基环戊烷")
    private String field30;

    @Excel(name = "己硫醇")
    private String field31;

    @Excel(name = "异戊二烯")
    private String field32;

    @Excel(name = "戊烯")
    private String field33;

    @Excel(name = "戊烷、异戊烷")
    private String field34;

    @Excel(name = "正丙醇")
    private String field35;

    @Excel(name = "正十三烷")
    private String field36;

    @Excel(name = "正十二烷")
    private String field37;

    @Excel(name = "正己烷、二甲基丁烷")
    private String field38;

    @Excel(name = "正庚烷")
    private String field39;

    @Excel(name = "正癸醇")
    private String field40;

    @Excel(name = "正葵烷")
    private String field41;

    @Excel(name = "正辛烷")
    private String field42;

    @Excel(name = "氯乙烷")
    private String field43;

    @Excel(name = "氯苯、1,2-二氯丙烷")
    private String field44;

    @Excel(name = "环己烯")
    private String field45;

    @Excel(name = "甲基叔丁基醚")
    private String field46;

    @Excel(name = "甲基环己烷")
    private String field47;

    @Excel(name = "甲硫醇")
    private String field48;

    @Excel(name = "甲硫醚、乙硫醇")
    private String field49;

    @Excel(name = "甲苯")
    private String field50;

    @Excel(name = "甲酸乙酯")
    private String field51;

    @Excel(name = "磷酸三甲酯")
    private String field52;

    @Excel(name = "苯")
    private String field53;

//    @Excel(name = "苯乙烯")
//    private String field54;

//    @Excel(name = "苯甲酸甲酯")
//    private String field55;
//
//    @Excel(name = "苯胺")
//    private String field56;

    public TestExcel(DensityVo densityVo){
        this.time=densityVo.getTime();
        this.lng=densityVo.getLng();
        this.lat=densityVo.getLat();
        this.field0=densityVo.getValues().get(0).getValue().toString();
        this.field1=densityVo.getValues().get(1).getValue().toString();
        this.field2=densityVo.getValues().get(2).getValue().toString();
        this.field3=densityVo.getValues().get(3).getValue().toString();
        this.field4=densityVo.getValues().get(4).getValue().toString();
        this.field5=densityVo.getValues().get(5).getValue().toString();
        this.field6=densityVo.getValues().get(6).getValue().toString();
        this.field7=densityVo.getValues().get(7).getValue().toString();
        this.field8=densityVo.getValues().get(8).getValue().toString();
        this.field9=densityVo.getValues().get(9).getValue().toString();
        this.field10=densityVo.getValues().get(10).getValue().toString();
        this.field11=densityVo.getValues().get(11).getValue().toString();
        this.field12=densityVo.getValues().get(12).getValue().toString();
        this.field13=densityVo.getValues().get(13).getValue().toString();
        this.field14=densityVo.getValues().get(14).getValue().toString();
        this.field15=densityVo.getValues().get(15).getValue().toString();
        this.field16=densityVo.getValues().get(16).getValue().toString();
        this.field17=densityVo.getValues().get(17).getValue().toString();
        this.field18=densityVo.getValues().get(18).getValue().toString();
        this.field19=densityVo.getValues().get(19).getValue().toString();
        this.field20=densityVo.getValues().get(20).getValue().toString();
        this.field21=densityVo.getValues().get(21).getValue().toString();
        this.field22=densityVo.getValues().get(22).getValue().toString();
        this.field23=densityVo.getValues().get(23).getValue().toString();
        this.field24=densityVo.getValues().get(24).getValue().toString();
        this.field25=densityVo.getValues().get(25).getValue().toString();
        this.field26=densityVo.getValues().get(26).getValue().toString();
        this.field27=densityVo.getValues().get(27).getValue().toString();
        this.field28=densityVo.getValues().get(28).getValue().toString();
        this.field29=densityVo.getValues().get(29).getValue().toString();
        this.field30=densityVo.getValues().get(30).getValue().toString();
        this.field31=densityVo.getValues().get(31).getValue().toString();
        this.field32=densityVo.getValues().get(32).getValue().toString();
        this.field33=densityVo.getValues().get(33).getValue().toString();
        this.field34=densityVo.getValues().get(34).getValue().toString();
        this.field35=densityVo.getValues().get(35).getValue().toString();
        this.field36=densityVo.getValues().get(36).getValue().toString();
        this.field37=densityVo.getValues().get(37).getValue().toString();
        this.field38=densityVo.getValues().get(38).getValue().toString();
        this.field39=densityVo.getValues().get(39).getValue().toString();
        this.field40=densityVo.getValues().get(40).getValue().toString();
        this.field41=densityVo.getValues().get(41).getValue().toString();
        this.field42=densityVo.getValues().get(42).getValue().toString();
        this.field43=densityVo.getValues().get(43).getValue().toString();
        this.field44=densityVo.getValues().get(44).getValue().toString();
        this.field45=densityVo.getValues().get(45).getValue().toString();
        this.field46=densityVo.getValues().get(46).getValue().toString();
        this.field47=densityVo.getValues().get(47).getValue().toString();
        this.field48=densityVo.getValues().get(48).getValue().toString();
        this.field49=densityVo.getValues().get(49).getValue().toString();
        this.field50=densityVo.getValues().get(50).getValue().toString();
        this.field51=densityVo.getValues().get(51).getValue().toString();
        this.field52=densityVo.getValues().get(52).getValue().toString();
        this.field53=densityVo.getValues().get(53).getValue().toString();
//        this.field54=densityVo.getValues().get(54).getValue().toString();
//        this.field55=densityVo.getValues().get(55).getValue().toString();
//        this.field56=densityVo.getValues().get(56).getValue().toString();
    }

    public static List<TestExcel> getList(List<DensityVo> densityVos){
        List<TestExcel> list=new ArrayList<>();
        for (DensityVo densityVo:densityVos ) {
            TestExcel testExcel=new TestExcel(densityVo);
            list.add(testExcel);
        }
        return list;
    }

}
