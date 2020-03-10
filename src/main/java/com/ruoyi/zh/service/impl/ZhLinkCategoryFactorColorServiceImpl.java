package com.ruoyi.zh.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhLinkCategoryFactorColorMapper;
import com.ruoyi.zh.domain.ZhLinkCategoryFactorColor;
import com.ruoyi.zh.service.IZhLinkCategoryFactorColorService;

/**
 * 物质因子颜色关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@Service
public class ZhLinkCategoryFactorColorServiceImpl implements IZhLinkCategoryFactorColorService 
{
    @Autowired
    private ZhLinkCategoryFactorColorMapper zhLinkCategoryFactorColorMapper;

    /**
     * 查询物质因子颜色关联
     * 
     * @param id 物质因子颜色关联ID
     * @return 物质因子颜色关联
     */
    @Override
    public ZhLinkCategoryFactorColor selectZhLinkCategoryFactorColorById(Long id)
    {
        return zhLinkCategoryFactorColorMapper.selectZhLinkCategoryFactorColorById(id);
    }

    /**
     * 查询物质因子颜色关联列表
     * 
     * @param zhLinkCategoryFactorColor 物质因子颜色关联
     * @return 物质因子颜色关联
     */
    @Override
    public List<ZhLinkCategoryFactorColor> selectZhLinkCategoryFactorColorList(ZhLinkCategoryFactorColor zhLinkCategoryFactorColor)
    {
        return zhLinkCategoryFactorColorMapper.selectZhLinkCategoryFactorColorList(zhLinkCategoryFactorColor);
    }

    /**
     * 新增物质因子颜色关联
     * 
     * @param zhLinkCategoryFactorColor 物质因子颜色关联
     * @return 结果
     */
    @Override
    public int insertZhLinkCategoryFactorColor(ZhLinkCategoryFactorColor zhLinkCategoryFactorColor)
    {
        zhLinkCategoryFactorColor.setCreateTime(DateUtils.getNowDate());
        return zhLinkCategoryFactorColorMapper.insertZhLinkCategoryFactorColor(zhLinkCategoryFactorColor);
    }

    /**
     * 修改物质因子颜色关联
     * 
     * @param zhLinkCategoryFactorColor 物质因子颜色关联
     * @return 结果
     */
    @Override
    public int updateZhLinkCategoryFactorColor(ZhLinkCategoryFactorColor zhLinkCategoryFactorColor)
    {
        zhLinkCategoryFactorColor.setUpdateTime(DateUtils.getNowDate());
        return zhLinkCategoryFactorColorMapper.updateZhLinkCategoryFactorColor(zhLinkCategoryFactorColor);
    }

    /**
     * 批量删除物质因子颜色关联
     * 
     * @param ids 需要删除的物质因子颜色关联ID
     * @return 结果
     */
    @Override
    public int deleteZhLinkCategoryFactorColorByIds(Long[] ids)
    {
        return zhLinkCategoryFactorColorMapper.deleteZhLinkCategoryFactorColorByIds(ids);
    }

    /**
     * 删除物质因子颜色关联信息
     * 
     * @param id 物质因子颜色关联ID
     * @return 结果
     */
    @Override
    public int deleteZhLinkCategoryFactorColorById(Long id)
    {
        return zhLinkCategoryFactorColorMapper.deleteZhLinkCategoryFactorColorById(id);
    }
}
