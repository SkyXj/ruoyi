package com.ruoyi.zh.service;

import com.ruoyi.zh.domain.ZhCategory;
import java.util.List;

/**
 * 颜色标准Service接口
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public interface IZhCategoryService 
{
    /**
     * 查询颜色标准
     * 
     * @param id 颜色标准ID
     * @return 颜色标准
     */
    public ZhCategory selectZhCategoryById(Long id);

    /**
     * 查询颜色标准列表
     * 
     * @param zhCategory 颜色标准
     * @return 颜色标准集合
     */
    public List<ZhCategory> selectZhCategoryList(ZhCategory zhCategory);

    /**
     * 新增颜色标准
     * 
     * @param zhCategory 颜色标准
     * @return 结果
     */
    public int insertZhCategory(ZhCategory zhCategory);

    /**
     * 修改颜色标准
     * 
     * @param zhCategory 颜色标准
     * @return 结果
     */
    public int updateZhCategory(ZhCategory zhCategory);

    /**
     * 批量删除颜色标准
     * 
     * @param ids 需要删除的颜色标准ID
     * @return 结果
     */
    public int deleteZhCategoryByIds(Long[] ids);

    /**
     * 删除颜色标准信息
     * 
     * @param id 颜色标准ID
     * @return 结果
     */
    public int deleteZhCategoryById(Long id);
}