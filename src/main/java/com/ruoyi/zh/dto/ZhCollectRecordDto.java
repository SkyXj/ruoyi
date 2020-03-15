package com.ruoyi.zh.dto;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.mina.DensityVo;
import com.ruoyi.zh.domain.ZhCollectRecord;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ZhCollectRecordDto {
    /** id */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String deviceCode;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 敏感点名称 */
    @Excel(name = "敏感点名称")
    private String pointName;

    private List<DensityVo> points;

    public ZhCollectRecordDto(ZhCollectRecord zhCollectRecord){
        this.id=zhCollectRecord.getId();
        this.deviceCode=zhCollectRecord.getDeviceCode();
        this.startTime=zhCollectRecord.getStartTime();
        this.endTime=zhCollectRecord.getEndTime();
        this.pointName=zhCollectRecord.getPointName();
    }

    public ZhCollectRecordDto(){

    }
}
