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
 * @date 2020-04-28
 */
public class ZhCollectRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

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

    /** 控点名称 */
    @Excel(name = "控点名称")
    private String pointName;

    /** 因子个数 */
    @Excel(name = "因子个数")
    private Integer factorCount;

    /** 记录类型,1是实时走航 */
    @Excel(name = "记录类型,1是实时走航")
    private Integer type;

    private Boolean show;

    public Boolean getShow() {
        return true;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

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
    public void setFactorCount(Integer factorCount)
    {
        this.factorCount = factorCount;
    }

    public Integer getFactorCount()
    {
        return factorCount;
    }
    public void setType(Integer type)
    {
        this.type = type;
    }

    public Integer getType()
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("deviceCode", getDeviceCode())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("pointName", getPointName())
                .append("factorCount", getFactorCount())
                .append("type", getType())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
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
        this.setCreateBy(zhCollectRecordDto.getCreateBy());
        this.setCreateTime(zhCollectRecordDto.getCreateTime());
        this.setUpdateBy(zhCollectRecordDto.getUpdateBy());
        this.setUpdateTime(zhCollectRecordDto.getUpdateTime());
        this.setRemark(zhCollectRecordDto.getRemark());
        this.type=zhCollectRecordDto.getType();

    }
}
