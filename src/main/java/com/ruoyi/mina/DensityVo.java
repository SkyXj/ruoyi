package com.ruoyi.mina;

import lombok.Data;

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

    @Override
    public int compareTo(DensityVo o) {
        return this.time.compareTo(o.getTime());
    }

    @Data
    public class KV{
        private String name;
        private Double value;
    }
}
