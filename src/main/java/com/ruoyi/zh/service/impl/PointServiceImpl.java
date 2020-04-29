package com.ruoyi.zh.service.impl;

import java.util.List;

import com.ruoyi.zh.tool.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.PointMapper;
import com.ruoyi.zh.domain.ZhPoint;
import com.ruoyi.zh.service.IPointService;

/**
 * 控点Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@Service
public class PointServiceImpl implements IPointService 
{
    @Autowired
    private PointMapper pointMapper;

    /**
     * 查询控点
     * 
     * @param id 控点ID
     * @return 控点
     */
    @Override
    public ZhPoint selectPointById(Long id)
    {
        return pointMapper.selectPointById(id);
    }

    /**
     * 查询控点列表
     * 
     * @param zhPoint 控点
     * @return 控点
     */
    @Override
    public List<ZhPoint> selectPointList(ZhPoint zhPoint)
    {
        zhPoint.setCreateBy(UserInfoUtil.getUserName());
        return pointMapper.selectPointList(zhPoint);
    }

    /**
     * 新增控点
     * 
     * @param zhPoint 控点
     * @return 结果
     */
    @Override
    public int insertPoint(ZhPoint zhPoint)
    {
        zhPoint.setCreateBy(UserInfoUtil.getUserName());
        return pointMapper.insertPoint(zhPoint);
    }

    /**
     * 修改控点
     * 
     * @param zhPoint 控点
     * @return 结果
     */
    @Override
    public int updatePoint(ZhPoint zhPoint)
    {
        zhPoint.setUpdateBy(UserInfoUtil.getUserName());
        return pointMapper.updatePoint(zhPoint);
    }

    /**
     * 批量删除控点
     * 
     * @param ids 需要删除的控点ID
     * @return 结果
     */
    @Override
    public int deletePointByIds(Long[] ids)
    {
        return pointMapper.deletePointByIds(ids);
    }

    /**
     * 删除控点信息
     * 
     * @param id 控点ID
     * @return 结果
     */
    @Override
    public int deletePointById(Long id)
    {
        return pointMapper.deletePointById(id);
    }
}
