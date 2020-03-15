package com.ruoyi.zh.dto;

import com.ruoyi.zh.domain.ZhCategory;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 */
@Data
public class ZhCategoryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private List<ZhFactorDto> factors;

    public ZhCategoryDto(){

    }

    public ZhCategoryDto(ZhCategory zhCategory){
        this.id=zhCategory.getId();
        this.name=zhCategory.getName();
    }
}
