package com.ruoyi.zh.dto;

import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.zh.domain.ZhColor;
import com.ruoyi.zh.domain.ZhFactor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
public class ZhFactorDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 编号 */
    private Long id;

    /** 因子名称 */
    @Excel(name = "因子名称")
    private String name;

//    /** 英文名称 */
//    @Excel(name = "英文名称")
//    private String ename;

    /** 分子式 */
    @Excel(name = "分子式")
    private String formula;

//    /** 分子量 */
//    @Excel(name = "分子量")
//    private Double weight;
//
//    /** 气味 */
//    @Excel(name = "气味")
//    private String smell;

//    /** 预警值 */
//    @Excel(name = "预警值")
//    private Double warning;
//
//    /** 报警值 */
//    @Excel(name = "报警值")
//    private Double danger;

    private String colorStr;

    public ZhFactorDto(){}

    public ZhFactorDto(ZhFactor zhFactor,ZhColor zhColor){
        this.id=zhFactor.getId();
        this.name=zhFactor.getName();
        this.formula=zhFactor.getFormula();
        this.colorStr=zhColor.getColorStr();
    }


}
