package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhLinkCategoryFactorColor;
import java.util.List;

/**
 * 物质因子颜色关联Mapper接口
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public interface ZhLinkCategoryFactorColorMapper 
{
    /**
     * 查询物质因子颜色关联
     * 
     * @param id 物质因子颜色关联ID
     * @return 物质因子颜色关联
     */
    public ZhLinkCategoryFactorColor selectZhLinkCategoryFactorColorById(Long id);

    /**
     * 查询物质因子颜色关联列表
     * 
     * @param zhLinkCategoryFactorColor 物质因子颜色关联
     * @return 物质因子颜色关联集合
     */
    public List<ZhLinkCategoryFactorColor> selectZhLinkCategoryFactorColorList(ZhLinkCategoryFactorColor zhLinkCategoryFactorColor);

    /**
     * 新增物质因子颜色关联
     * 
     * @param zhLinkCategoryFactorColor 物质因子颜色关联
     * @return 结果
     */
    public int insertZhLinkCategoryFactorColor(ZhLinkCategoryFactorColor zhLinkCategoryFactorColor);

    /**
     * 修改物质因子颜色关联
     * 
     * @param zhLinkCategoryFactorColor 物质因子颜色关联
     * @return 结果
     */
    public int updateZhLinkCategoryFactorColor(ZhLinkCategoryFactorColor zhLinkCategoryFactorColor);

    /**
     * 删除物质因子颜色关联
     * 
     * @param id 物质因子颜色关联ID
     * @return 结果
     */
    public int deleteZhLinkCategoryFactorColorById(Long id);

    /**
     * 批量删除物质因子颜色关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhLinkCategoryFactorColorByIds(Long[] ids);
}
