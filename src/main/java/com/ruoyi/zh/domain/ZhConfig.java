package com.ruoyi.zh.domain;

import io.swagger.models.auth.In;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 配置信息对象 zh_config
 * 
 * @author ruoyi
 * @date 2020-04-08
 */
public class ZhConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 走航放大倍数 */
    @Excel(name = "走航放大倍数")
    private Double zoom;

    /** 方向 */
    @Excel(name = "方向")
    private Integer direction;

    /** 角度 */
    @Excel(name = "角度")
    private Integer angle;

    /** 走航间隔 */
    @Excel(name = "走航间隔")
    private Integer distance;

    /** 动画时间 */
    @Excel(name = "动画时间")
    private Integer flashtime;

    /** 图形类型 */
    @Excel(name = "图形类型")
    private Integer shapetype;

    /** 经度 */
    @Excel(name = "经度")
    private Double lng;

    /** 纬度 */
    @Excel(name = "纬度")
    private Double lat;

    /** IP地址 */
    @Excel(name = "IP地址")
    private String ip;

    /** 端口 */
    @Excel(name = "端口")
    private Integer port;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setZoom(Double zoom)
    {
        this.zoom = zoom;
    }

    public Double getZoom()
    {
        return zoom;
    }
    public void setDirection(Integer direction) 
    {
        this.direction = direction;
    }

    public Integer getDirection() 
    {
        return direction;
    }
    public void setAngle(Integer angle) 
    {
        this.angle = angle;
    }

    public Integer getAngle() 
    {
        return angle;
    }
    public void setDistance(Integer distance) 
    {
        this.distance = distance;
    }

    public Integer getDistance() 
    {
        return distance;
    }
    public void setFlashtime(Integer flashtime) 
    {
        this.flashtime = flashtime;
    }

    public Integer getFlashtime() 
    {
        return flashtime;
    }
    public void setShapetype(Integer shapetype) 
    {
        this.shapetype = shapetype;
    }

    public Integer getShapetype() 
    {
        return shapetype;
    }
    public void setLng(Double lng)
    {
        this.lng = lng;
    }

    public Double getLng()
    {
        return lng;
    }
    public void setLat(Double lat)
    {
        this.lat = lat;
    }

    public Double getLat()
    {
        return lat;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public String toString() {
        String s = new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("zoom", getZoom())
                .append("direction", getDirection())
                .append("angle", getAngle())
                .append("distance", getDistance())
                .append("flashtime", getFlashtime())
                .append("shapetype", getShapetype())
                .append("lng", getLng())
                .append("lat", getLat())
                .append("ip", getIp())
                .append("port", getPort())
                .toString();
        return s;
    }
}
