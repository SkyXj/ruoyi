package com.ruoyi.zh.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhCategoryMapper;
import com.ruoyi.zh.domain.ZhCategory;
import com.ruoyi.zh.service.IZhCategoryService;

/**
 * 颜色标准Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@Service
public class ZhCategoryServiceImpl implements IZhCategoryService 
{
    @Autowired
    private ZhCategoryMapper zhCategoryMapper;

    /**
     * 查询颜色标准
     * 
     * @param id 颜色标准ID
     * @return 颜色标准
     */
    @Override
    public ZhCategory selectZhCategoryById(Long id)
    {
        return zhCategoryMapper.selectZhCategoryById(id);
    }

    /**
     * 查询颜色标准列表
     * 
     * @param zhCategory 颜色标准
     * @return 颜色标准
     */
    @Override
    public List<ZhCategory> selectZhCategoryList(ZhCategory zhCategory)
    {
        return zhCategoryMapper.selectZhCategoryList(zhCategory);
    }

    /**
     * 新增颜色标准
     * 
     * @param zhCategory 颜色标准
     * @return 结果
     */
    @Override
    public int insertZhCategory(ZhCategory zhCategory)
    {
        zhCategory.setCreateTime(DateUtils.getNowDate());
        return zhCategoryMapper.insertZhCategory(zhCategory);
    }

    /**
     * 修改颜色标准
     * 
     * @param zhCategory 颜色标准
     * @return 结果
     */
    @Override
    public int updateZhCategory(ZhCategory zhCategory)
    {
        zhCategory.setUpdateTime(DateUtils.getNowDate());
        return zhCategoryMapper.updateZhCategory(zhCategory);
    }

    /**
     * 批量删除颜色标准
     * 
     * @param ids 需要删除的颜色标准ID
     * @return 结果
     */
    @Override
    public int deleteZhCategoryByIds(Long[] ids)
    {
        return zhCategoryMapper.deleteZhCategoryByIds(ids);
    }

    /**
     * 删除颜色标准信息
     * 
     * @param id 颜色标准ID
     * @return 结果
     */
    @Override
    public int deleteZhCategoryById(Long id)
    {
        return zhCategoryMapper.deleteZhCategoryById(id);
    }
}
