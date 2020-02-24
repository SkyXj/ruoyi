package com.ruoyi.zh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhPointMapper;
import com.ruoyi.zh.domain.ZhPoint;
import com.ruoyi.zh.service.IZhPointService;

/**
 * 控点Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@Service
public class ZhPointServiceImpl implements IZhPointService 
{
    @Autowired
    private ZhPointMapper zhPointMapper;

    /**
     * 查询控点
     * 
     * @param id 控点ID
     * @return 控点
     */
    @Override
    public ZhPoint selectZhPointById(Long id)
    {
        return zhPointMapper.selectZhPointById(id);
    }

    /**
     * 查询控点列表
     * 
     * @param zhPoint 控点
     * @return 控点
     */
    @Override
    public List<ZhPoint> selectZhPointList(ZhPoint zhPoint)
    {
        return zhPointMapper.selectZhPointList(zhPoint);
    }

    /**
     * 新增控点
     * 
     * @param zhPoint 控点
     * @return 结果
     */
    @Override
    public int insertZhPoint(ZhPoint zhPoint)
    {
        return zhPointMapper.insertZhPoint(zhPoint);
    }

    /**
     * 修改控点
     * 
     * @param zhPoint 控点
     * @return 结果
     */
    @Override
    public int updateZhPoint(ZhPoint zhPoint)
    {
        return zhPointMapper.updateZhPoint(zhPoint);
    }

    /**
     * 批量删除控点
     * 
     * @param ids 需要删除的控点ID
     * @return 结果
     */
    @Override
    public int deleteZhPointByIds(Long[] ids)
    {
        return zhPointMapper.deleteZhPointByIds(ids);
    }

    /**
     * 删除控点信息
     * 
     * @param id 控点ID
     * @return 结果
     */
    @Override
    public int deleteZhPointById(Long id)
    {
        return zhPointMapper.deleteZhPointById(id);
    }
}
