package com.ruoyi.zh.service;

import com.ruoyi.zh.domain.ZhPoint;
import java.util.List;

/**
 * 控点Service接口
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
public interface IPointService 
{
    /**
     * 查询控点
     * 
     * @param id 控点ID
     * @return 控点
     */
    public ZhPoint selectPointById(Long id);

    /**
     * 查询控点列表
     * 
     * @param zhPoint 控点
     * @return 控点集合
     */
    public List<ZhPoint> selectPointList(ZhPoint zhPoint);

    /**
     * 新增控点
     * 
     * @param zhPoint 控点
     * @return 结果
     */
    public int insertPoint(ZhPoint zhPoint);

    /**
     * 修改控点
     * 
     * @param zhPoint 控点
     * @return 结果
     */
    public int updatePoint(ZhPoint zhPoint);

    /**
     * 批量删除控点
     * 
     * @param ids 需要删除的控点ID
     * @return 结果
     */
    public int deletePointByIds(Long[] ids);

    /**
     * 删除控点信息
     * 
     * @param id 控点ID
     * @return 结果
     */
    public int deletePointById(Long id);
}
