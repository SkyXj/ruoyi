package com.ruoyi.zh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 物质因子颜色关联对象 zh_link_category_factor_color
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public class ZhLinkCategoryFactorColor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 标准编号 */
    @Excel(name = "标准编号")
    private Long categoryId;

    /** 因子编号 */
    @Excel(name = "因子编号")
    private Long factorId;

    /** 颜色编号 */
    @Excel(name = "颜色编号")
    private Long colorId;

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
    public void setFactorId(Long factorId) 
    {
        this.factorId = factorId;
    }

    public Long getFactorId() 
    {
        return factorId;
    }
    public void setColorId(Long colorId) 
    {
        this.colorId = colorId;
    }

    public Long getColorId() 
    {
        return colorId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("categoryId", getCategoryId())
            .append("factorId", getFactorId())
            .append("colorId", getColorId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
