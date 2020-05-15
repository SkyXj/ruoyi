package com.ruoyi.zh.dto;

import java.util.List;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/5/11 16:20
 * @Version 1.0
 */
public class Range {
    private Integer type;
    private List<Integer> indexs;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public List<Integer> getIndexs() {
        return indexs;
    }

    public void setIndexs(List<Integer> indexs) {
        this.indexs = indexs;
    }
}
