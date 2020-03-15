package com.ruoyi.zh.service;

import com.ruoyi.zh.domain.ZhLinkCategoryFactorColor;
import java.util.List;

/**
 * 物质因子颜色关联Service接口
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public interface IZhLinkCategoryFactorColorService 
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
     * 批量删除物质因子颜色关联
     * 
     * @param ids 需要删除的物质因子颜色关联ID
     * @return 结果
     */
    public int deleteZhLinkCategoryFactorColorByIds(Long[] ids);

    /**
     * 删除物质因子颜色关联信息
     * 
     * @param id 物质因子颜色关联ID
     * @return 结果
     */
    public int deleteZhLinkCategoryFactorColorById(Long id);

    /**
     * 新增物质因子颜色关联()
     * @param categoryId 标准id
     * @param factorId 因子id
     * @param colortStr 颜色字符串
     * @return
     */
    public int insertOrUpdate(Long categoryId,Long factorId,String colortStr);

    /**
     * 删除
     * @param categoryId 标准id
     * @param factorId 因子id
     * @return
     */
    public int delete(Long categoryId,Long factorId);
}
