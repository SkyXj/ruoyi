package com.ruoyi.zh.domain;

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
    private Long zoom;

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
    private Long lng;

    /** 纬度 */
    @Excel(name = "纬度")
    private Long lat;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setZoom(Long zoom) 
    {
        this.zoom = zoom;
    }

    public Long getZoom() 
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
    public void setLng(Long lng) 
    {
        this.lng = lng;
    }

    public Long getLng() 
    {
        return lng;
    }
    public void setLat(Long lat) 
    {
        this.lat = lat;
    }

    public Long getLat() 
    {
        return lat;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("zoom", getZoom())
            .append("direction", getDirection())
            .append("angle", getAngle())
            .append("distance", getDistance())
            .append("flashtime", getFlashtime())
            .append("shapetype", getShapetype())
            .append("lng", getLng())
            .append("lat", getLat())
            .toString();
    }
}
