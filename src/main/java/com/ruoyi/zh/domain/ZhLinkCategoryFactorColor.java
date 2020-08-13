package com.ruoyi.zh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 物质因子颜色关联对象 zh_link_category_factor_color
 * 
 * @author ruoyi
 * @date 2020-08-10
 */
public class ZhLinkCategoryFactorColor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 标准编号 */
    @Excel(name = "标准编号")
    private Long categoryId;

    /** 因子名称 */
    @Excel(name = "因子名称")
    private String factorName;

    /** 颜色字符串 */
    @Excel(name = "颜色字符串")
    private String colorStr;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }
    public void setFactorName(String factorName) 
    {
        this.factorName = factorName;
    }

    public String getFactorName() 
    {
        return factorName;
    }
    public void setColorStr(String colorStr) 
    {
        this.colorStr = colorStr;
    }

    public String getColorStr() 
    {
        return colorStr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("factorName", getFactorName())
            .append("colorStr", getColorStr())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
