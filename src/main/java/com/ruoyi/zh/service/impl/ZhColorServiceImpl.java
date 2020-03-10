package com.ruoyi.zh.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhColorMapper;
import com.ruoyi.zh.domain.ZhColor;
import com.ruoyi.zh.service.IZhColorService;

/**
 * 颜色Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@Service
public class ZhColorServiceImpl implements IZhColorService 
{
    @Autowired
    private ZhColorMapper zhColorMapper;

    /**
     * 查询颜色
     * 
     * @param id 颜色ID
     * @return 颜色
     */
    @Override
    public ZhColor selectZhColorById(Long id)
    {
        return zhColorMapper.selectZhColorById(id);
    }

    /**
     * 查询颜色列表
     * 
     * @param zhColor 颜色
     * @return 颜色
     */
    @Override
    public List<ZhColor> selectZhColorList(ZhColor zhColor)
    {
        return zhColorMapper.selectZhColorList(zhColor);
    }

    /**
     * 新增颜色
     * 
     * @param zhColor 颜色
     * @return 结果
     */
    @Override
    public int insertZhColor(ZhColor zhColor)
    {
        zhColor.setCreateTime(DateUtils.getNowDate());
        return zhColorMapper.insertZhColor(zhColor);
    }

    /**
     * 修改颜色
     * 
     * @param zhColor 颜色
     * @return 结果
     */
    @Override
    public int updateZhColor(ZhColor zhColor)
    {
        zhColor.setUpdateTime(DateUtils.getNowDate());
        return zhColorMapper.updateZhColor(zhColor);
    }

    /**
     * 批量删除颜色
     * 
     * @param ids 需要删除的颜色ID
     * @return 结果
     */
    @Override
    public int deleteZhColorByIds(Long[] ids)
    {
        return zhColorMapper.deleteZhColorByIds(ids);
    }

    /**
     * 删除颜色信息
     * 
     * @param id 颜色ID
     * @return 结果
     */
    @Override
    public int deleteZhColorById(Long id)
    {
        return zhColorMapper.deleteZhColorById(id);
    }
}
