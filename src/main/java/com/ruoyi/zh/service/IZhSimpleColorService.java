package com.ruoyi.zh.service;

import com.ruoyi.zh.domain.ZhSimpleColor;
import java.util.List;

/**
 * 物质因子颜色关联Service接口
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public interface IZhSimpleColorService 
{
    /**
     * 查询物质因子颜色关联
     * 
     * @param id 物质因子颜色关联ID
     * @return 物质因子颜色关联
     */
    public ZhSimpleColor selectZhSimpleColorById(Long id);

    /**
     * 查询物质因子颜色关联列表
     * 
     * @param zhSimpleColor 物质因子颜色关联
     * @return 物质因子颜色关联集合
     */
    public List<ZhSimpleColor> selectZhSimpleColorList(ZhSimpleColor zhSimpleColor);

    /**
     * 新增物质因子颜色关联
     * 
     * @param zhSimpleColor 物质因子颜色关联
     * @return 结果
     */
    public int insertZhSimpleColor(ZhSimpleColor zhSimpleColor);

    /**
     * 修改物质因子颜色关联
     * 
     * @param zhSimpleColor 物质因子颜色关联
     * @return 结果
     */
    public int updateZhSimpleColor(ZhSimpleColor zhSimpleColor);

    /**
     * 批量删除物质因子颜色关联
     * 
     * @param ids 需要删除的物质因子颜色关联ID
     * @return 结果
     */
    public int deleteZhSimpleColorByIds(Long[] ids);

    /**
     * 删除物质因子颜色关联信息
     * 
     * @param id 物质因子颜色关联ID
     * @return 结果
     */
    public int deleteZhSimpleColorById(Long id);
}
