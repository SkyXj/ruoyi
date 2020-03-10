package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhLinkCategoryFactorSimpleColor;
import java.util.List;

/**
 * 物质因子颜色关联Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public interface ZhLinkCategoryFactorSimpleColorMapper 
{
    /**
     * 查询物质因子颜色关联
     * 
     * @param id 物质因子颜色关联ID
     * @return 物质因子颜色关联
     */
    public ZhLinkCategoryFactorSimpleColor selectZhLinkCategoryFactorSimpleColorById(Long id);

    /**
     * 查询物质因子颜色关联列表
     * 
     * @param zhLinkCategoryFactorSimpleColor 物质因子颜色关联
     * @return 物质因子颜色关联集合
     */
    public List<ZhLinkCategoryFactorSimpleColor> selectZhLinkCategoryFactorSimpleColorList(ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor);

    /**
     * 新增物质因子颜色关联
     * 
     * @param zhLinkCategoryFactorSimpleColor 物质因子颜色关联
     * @return 结果
     */
    public int insertZhLinkCategoryFactorSimpleColor(ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor);

    /**
     * 修改物质因子颜色关联
     * 
     * @param zhLinkCategoryFactorSimpleColor 物质因子颜色关联
     * @return 结果
     */
    public int updateZhLinkCategoryFactorSimpleColor(ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor);

    /**
     * 删除物质因子颜色关联
     * 
     * @param id 物质因子颜色关联ID
     * @return 结果
     */
    public int deleteZhLinkCategoryFactorSimpleColorById(Long id);

    /**
     * 批量删除物质因子颜色关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhLinkCategoryFactorSimpleColorByIds(Long[] ids);
}
