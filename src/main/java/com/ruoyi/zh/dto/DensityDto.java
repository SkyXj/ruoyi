package com.ruoyi.zh.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
public class DensityDto {

    @ApiModelProperty(value = "开始时间，格式yyyy-MM-dd HH:mm:ss")
    @Getter
    private String startDate;

    @ApiModelProperty(value = "结束时间，格式yyyy-MM-dd HH:mm:ss")
    @Getter
    private String endDate;

    @NotEmpty
    @ApiModelProperty(value = "设备编码", required = false)
    @Getter
    private String code;

}
