package com.ruoyi.zh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 因子对象 zh_factor
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public class ZhFactor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 因子名称 */
    @Excel(name = "因子名称")
    private String name;

    /** 英文名称 */
    @Excel(name = "英文名称")
    private String ename;

    /** 分子式 */
    @Excel(name = "分子式")
    private String formula;

    /** 分子量 */
    @Excel(name = "分子量")
    private Double weight;

    /** 气味 */
    @Excel(name = "气味")
    private String smell;

    /** 预警值 */
    @Excel(name = "预警值")
    private Double warning;

    /** 报警值 */
    @Excel(name = "报警值")
    private Double danger;

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
    public void setEname(String ename) 
    {
        this.ename = ename;
    }

    public String getEname() 
    {
        return ename;
    }
    public void setFormula(String formula) 
    {
        this.formula = formula;
    }

    public String getFormula() 
    {
        return formula;
    }
    public void setWeight(Double weight) 
    {
        this.weight = weight;
    }

    public Double getWeight() 
    {
        return weight;
    }
    public void setSmell(String smell) 
    {
        this.smell = smell;
    }

    public String getSmell() 
    {
        return smell;
    }
    public void setWarning(Double warning) 
    {
        this.warning = warning;
    }

    public Double getWarning() 
    {
        return warning;
    }
    public void setDanger(Double danger) 
    {
        this.danger = danger;
    }

    public Double getDanger() 
    {
        return danger;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("ename", getEname())
            .append("formula", getFormula())
            .append("weight", getWeight())
            .append("smell", getSmell())
            .append("warning", getWarning())
            .append("danger", getDanger())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
