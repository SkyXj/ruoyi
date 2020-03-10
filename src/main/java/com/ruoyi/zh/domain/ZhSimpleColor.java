package com.ruoyi.zh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 物质因子颜色关联对象 zh_simple_color
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public class ZhSimpleColor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 开始值 */
    @Excel(name = "开始值")
    private Long startValue;

    /** 结束值 */
    @Excel(name = "结束值")
    private Long endValue;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStartValue(Long startValue) 
    {
        this.startValue = startValue;
    }

    public Long getStartValue() 
    {
        return startValue;
    }
    public void setEndValue(Long endValue) 
    {
        this.endValue = endValue;
    }

    public Long getEndValue() 
    {
        return endValue;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("startValue", getStartValue())
            .append("endValue", getEndValue())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
