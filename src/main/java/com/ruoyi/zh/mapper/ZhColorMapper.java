package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhColor;
import java.util.List;

/**
 * 颜色Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public interface ZhColorMapper 
{
    /**
     * 查询颜色
     * 
     * @param id 颜色ID
     * @return 颜色
     */
    public ZhColor selectZhColorById(Long id);

    /**
     * 查询颜色列表
     * 
     * @param zhColor 颜色
     * @return 颜色集合
     */
    public List<ZhColor> selectZhColorList(ZhColor zhColor);

    /**
     * 新增颜色
     * 
     * @param zhColor 颜色
     * @return 结果
     */
    public int insertZhColor(ZhColor zhColor);

    /**
     * 修改颜色
     * 
     * @param zhColor 颜色
     * @return 结果
     */
    public int updateZhColor(ZhColor zhColor);

    /**
     * 删除颜色
     * 
     * @param id 颜色ID
     * @return 结果
     */
    public int deleteZhColorById(Long id);

    /**
     * 批量删除颜色
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhColorByIds(Long[] ids);
}
