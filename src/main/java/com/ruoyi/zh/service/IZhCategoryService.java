package com.ruoyi.zh.service;

import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.zh.domain.ZhCategory;
import com.ruoyi.zh.dto.ZhCategoryDto;
import org.springframework.web.multipart.MultipartFile;

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

    public AjaxResult exportByIds(Long[] ids);
    /**
     * 查询颜色标准列表
     * 
     * @param zhCategory 颜色标准
     * @return 颜色标准集合
     */
    public List<ZhCategory> selectZhCategoryList(ZhCategory zhCategory);

    public List<ZhCategoryDto> getAll(ZhCategory zhCategory);

    public AjaxResult importData(List<MultipartFile> files);

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

    public List<ZhCategory> getCategoryByIds(Long[] ids);

    /**
     * 删除颜色标准信息
     * 
     * @param id 颜色标准ID
     * @return 结果
     */
    public int deleteZhCategoryById(Long id);

    public ZhCategoryDto getCategoryFactors(Long id);
}
