package com.ruoyi.mina;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2019/11/6 14:38
 * @Version 1.0
 */
@Data
public class DensityVo implements Comparable<DensityVo>{
    private String time;
    private String areaname;
    private String sitename;
    private String lng;
    private String lat;
    private Double tvoc;
    private List<KV> values;
    private boolean isException;
    private Long exceptionid;
    private String name;
    private Long collectId;
    private List<String> datas;

    @Override
    public int compareTo(DensityVo o) {
        return this.time.compareTo(o.getTime());
    }

    @Data
    public class KV{
        private String name;
        private Double value;
    }

    public void setThisDatas(){
        datas=new ArrayList<>();
        List<DensityVo.KV> values = this.values;
        //名字
        StringBuilder name=new StringBuilder();
        name.append("时间;经度;纬度");
        //浓度值
        StringBuilder mics=new StringBuilder();
        mics.append(this.time+";"+this.lng+";"+this.lat);
        for (DensityVo.KV value: values) {
            name.append(";"+value.getName());
            mics.append(";"+value.getValue());
        }
        datas.add(name.toString());
        datas.add(mics.toString());
    }
}
