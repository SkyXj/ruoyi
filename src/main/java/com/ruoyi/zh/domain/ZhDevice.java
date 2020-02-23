package com.ruoyi.zh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;
import java.util.Date;

/**
 * 走航对象 zh_device
 * 
 * @author ruoyi
 * @date 2020-02-23
 */
public class ZhDevice extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 设备id */
    private Long id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String name;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String code;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String company;

    /** 公司地址 */
    @Excel(name = "公司地址")
    private String address;

    /** 公司图片 */
    @Excel(name = "公司图片")
    private String img;

    /** 采集状态:0 未开始,1 开始 */
    @Excel(name = "采集状态:0 未开始,1 开始")
    private Integer status;

    /** 校正状态:0 未开始,1 开始 */
    @Excel(name = "校正状态:0 未开始,1 开始")
    private Integer correctStatus;

    /** 天气状态:0 未开始,1 开始 */
    @Excel(name = "天气状态:0 未开始,1 开始")
    private Integer weatherStatus;

    /** 定位状态:0 未开始,1 开始 */
    @Excel(name = "定位状态:0 未开始,1 开始")
    private Integer gpsStatus;

    /** 创建时间 */
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdDate;

    /** 修改时间 */
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedDate;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setCompany(String company) 
    {
        this.company = company;
    }

    public String getCompany() 
    {
        return company;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }
    public void setCorrectStatus(Integer correctStatus) 
    {
        this.correctStatus = correctStatus;
    }

    public Integer getCorrectStatus() 
    {
        return correctStatus;
    }
    public void setWeatherStatus(Integer weatherStatus) 
    {
        this.weatherStatus = weatherStatus;
    }

    public Integer getWeatherStatus() 
    {
        return weatherStatus;
    }
    public void setGpsStatus(Integer gpsStatus) 
    {
        this.gpsStatus = gpsStatus;
    }

    public Integer getGpsStatus() 
    {
        return gpsStatus;
    }
    public void setCreatedDate(Date createdDate) 
    {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate() 
    {
        return createdDate;
    }
    public void setUpdatedDate(Date updatedDate) 
    {
        this.updatedDate = updatedDate;
    }

    public Date getUpdatedDate() 
    {
        return updatedDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("code", getCode())
            .append("company", getCompany())
            .append("address", getAddress())
            .append("img", getImg())
            .append("status", getStatus())
            .append("correctStatus", getCorrectStatus())
            .append("weatherStatus", getWeatherStatus())
            .append("gpsStatus", getGpsStatus())
            .append("createdDate", getCreatedDate())
            .append("updatedDate", getUpdatedDate())
            .toString();
    }
}
