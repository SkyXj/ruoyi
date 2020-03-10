package com.ruoyi.zh.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhLinkCategoryFactorSimpleColorMapper;
import com.ruoyi.zh.domain.ZhLinkCategoryFactorSimpleColor;
import com.ruoyi.zh.service.IZhLinkCategoryFactorSimpleColorService;

/**
 * 物质因子颜色关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@Service
public class ZhLinkCategoryFactorSimpleColorServiceImpl implements IZhLinkCategoryFactorSimpleColorService 
{
    @Autowired
    private ZhLinkCategoryFactorSimpleColorMapper zhLinkCategoryFactorSimpleColorMapper;

    /**
     * 查询物质因子颜色关联
     * 
     * @param id 物质因子颜色关联ID
     * @return 物质因子颜色关联
     */
    @Override
    public ZhLinkCategoryFactorSimpleColor selectZhLinkCategoryFactorSimpleColorById(Long id)
    {
        return zhLinkCategoryFactorSimpleColorMapper.selectZhLinkCategoryFactorSimpleColorById(id);
    }

    /**
     * 查询物质因子颜色关联列表
     * 
     * @param zhLinkCategoryFactorSimpleColor 物质因子颜色关联
     * @return 物质因子颜色关联
     */
    @Override
    public List<ZhLinkCategoryFactorSimpleColor> selectZhLinkCategoryFactorSimpleColorList(ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor)
    {
        return zhLinkCategoryFactorSimpleColorMapper.selectZhLinkCategoryFactorSimpleColorList(zhLinkCategoryFactorSimpleColor);
    }

    /**
     * 新增物质因子颜色关联
     * 
     * @param zhLinkCategoryFactorSimpleColor 物质因子颜色关联
     * @return 结果
     */
    @Override
    public int insertZhLinkCategoryFactorSimpleColor(ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor)
    {
        zhLinkCategoryFactorSimpleColor.setCreateTime(DateUtils.getNowDate());
        return zhLinkCategoryFactorSimpleColorMapper.insertZhLinkCategoryFactorSimpleColor(zhLinkCategoryFactorSimpleColor);
    }

    /**
     * 修改物质因子颜色关联
     * 
     * @param zhLinkCategoryFactorSimpleColor 物质因子颜色关联
     * @return 结果
     */
    @Override
    public int updateZhLinkCategoryFactorSimpleColor(ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor)
    {
        zhLinkCategoryFactorSimpleColor.setUpdateTime(DateUtils.getNowDate());
        return zhLinkCategoryFactorSimpleColorMapper.updateZhLinkCategoryFactorSimpleColor(zhLinkCategoryFactorSimpleColor);
    }

    /**
     * 批量删除物质因子颜色关联
     * 
     * @param ids 需要删除的物质因子颜色关联ID
     * @return 结果
     */
    @Override
    public int deleteZhLinkCategoryFactorSimpleColorByIds(Long[] ids)
    {
        return zhLinkCategoryFactorSimpleColorMapper.deleteZhLinkCategoryFactorSimpleColorByIds(ids);
    }

    /**
     * 删除物质因子颜色关联信息
     * 
     * @param id 物质因子颜色关联ID
     * @return 结果
     */
    @Override
    public int deleteZhLinkCategoryFactorSimpleColorById(Long id)
    {
        return zhLinkCategoryFactorSimpleColorMapper.deleteZhLinkCategoryFactorSimpleColorById(id);
    }
}
