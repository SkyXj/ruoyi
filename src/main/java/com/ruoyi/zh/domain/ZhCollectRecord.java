package com.ruoyi.zh.domain;

import com.ruoyi.zh.dto.ZhCollectRecordDto;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;

import java.util.Date;

/**
 * 走航记录对象 zh_collect_record
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
public class ZhCollectRecord
{
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

    /** 物质总数 */
    @Excel(name = "物质总数")
    private Integer factorCount;

    private Boolean show;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDeviceCode(String deviceCode) 
    {
        this.deviceCode = deviceCode;
    }

    public String getDeviceCode() 
    {
        return deviceCode;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime()
    {
        return endTime;
    }
    public void setPointName(String pointName) 
    {
        this.pointName = pointName;
    }

    public String getPointName() 
    {
        return pointName;
    }

    public Integer getFactorCount() {
        return factorCount;
    }

    public void setFactorCount(Integer factorCount) {
        this.factorCount = factorCount;
    }

    public Boolean getShow() {
        return true;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceCode", getDeviceCode())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("pointName", getPointName())
            .toString();
    }
    public ZhCollectRecord(){

    }

    public ZhCollectRecord(ZhCollectRecordDto zhCollectRecordDto){
        this.id=zhCollectRecordDto.getId();
        this.deviceCode=zhCollectRecordDto.getDeviceCode();
        this.startTime=zhCollectRecordDto.getStartTime();
        this.endTime=zhCollectRecordDto.getEndTime();
        this.pointName=zhCollectRecordDto.getPointName();
        this.factorCount=zhCollectRecordDto.getFactorCount();
        this.show=zhCollectRecordDto.getShow();
    }
}
