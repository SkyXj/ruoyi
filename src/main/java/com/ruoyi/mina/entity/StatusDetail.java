package com.ruoyi.mina.entity;

import lombok.Data;

@Data
public class StatusDetail {
    //是否开始
    private boolean status;
    //有效性
    private boolean availability;

    public StatusDetail(){
        this.status=false;
        this.availability=false;
    }

    public StatusDetail(boolean status,boolean availability){
        this.status=status;
        this.availability=availability;
    }
}
