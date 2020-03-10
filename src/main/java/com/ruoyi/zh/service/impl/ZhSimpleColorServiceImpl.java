package com.ruoyi.zh.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhSimpleColorMapper;
import com.ruoyi.zh.domain.ZhSimpleColor;
import com.ruoyi.zh.service.IZhSimpleColorService;

/**
 * 物质因子颜色关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@Service
public class ZhSimpleColorServiceImpl implements IZhSimpleColorService 
{
    @Autowired
    private ZhSimpleColorMapper zhSimpleColorMapper;

    /**
     * 查询物质因子颜色关联
     * 
     * @param id 物质因子颜色关联ID
     * @return 物质因子颜色关联
     */
    @Override
    public ZhSimpleColor selectZhSimpleColorById(Long id)
    {
        return zhSimpleColorMapper.selectZhSimpleColorById(id);
    }

    /**
     * 查询物质因子颜色关联列表
     * 
     * @param zhSimpleColor 物质因子颜色关联
     * @return 物质因子颜色关联
     */
    @Override
    public List<ZhSimpleColor> selectZhSimpleColorList(ZhSimpleColor zhSimpleColor)
    {
        return zhSimpleColorMapper.selectZhSimpleColorList(zhSimpleColor);
    }

    /**
     * 新增物质因子颜色关联
     * 
     * @param zhSimpleColor 物质因子颜色关联
     * @return 结果
     */
    @Override
    public int insertZhSimpleColor(ZhSimpleColor zhSimpleColor)
    {
        zhSimpleColor.setCreateTime(DateUtils.getNowDate());
        return zhSimpleColorMapper.insertZhSimpleColor(zhSimpleColor);
    }

    /**
     * 修改物质因子颜色关联
     * 
     * @param zhSimpleColor 物质因子颜色关联
     * @return 结果
     */
    @Override
    public int updateZhSimpleColor(ZhSimpleColor zhSimpleColor)
    {
        zhSimpleColor.setUpdateTime(DateUtils.getNowDate());
        return zhSimpleColorMapper.updateZhSimpleColor(zhSimpleColor);
    }

    /**
     * 批量删除物质因子颜色关联
     * 
     * @param ids 需要删除的物质因子颜色关联ID
     * @return 结果
     */
    @Override
    public int deleteZhSimpleColorByIds(Long[] ids)
    {
        return zhSimpleColorMapper.deleteZhSimpleColorByIds(ids);
    }

    /**
     * 删除物质因子颜色关联信息
     * 
     * @param id 物质因子颜色关联ID
     * @return 结果
     */
    @Override
    public int deleteZhSimpleColorById(Long id)
    {
        return zhSimpleColorMapper.deleteZhSimpleColorById(id);
    }
}
