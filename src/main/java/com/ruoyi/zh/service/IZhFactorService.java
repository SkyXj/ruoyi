package com.ruoyi.zh.service;

import com.ruoyi.zh.domain.ZhFactor;
import java.util.List;

/**
 * 因子Service接口
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
public interface IZhFactorService 
{
    /**
     * 查询因子
     * 
     * @param id 因子ID
     * @return 因子
     */
    public ZhFactor selectZhFactorById(Long id);

    /**
     * 查询因子列表
     * 
     * @param zhFactor 因子
     * @return 因子集合
     */
    public List<ZhFactor> selectZhFactorList(ZhFactor zhFactor);

    /**
     * 新增因子
     * 
     * @param zhFactor 因子
     * @return 结果
     */
    public int insertZhFactor(ZhFactor zhFactor);

    /**
     * 修改因子
     * 
     * @param zhFactor 因子
     * @return 结果
     */
    public int updateZhFactor(ZhFactor zhFactor);

    /**
     * 批量删除因子
     * 
     * @param ids 需要删除的因子ID
     * @return 结果
     */
    public int deleteZhFactorByIds(Long[] ids);

    /**
     * 删除因子信息
     * 
     * @param id 因子ID
     * @return 结果
     */
    public int deleteZhFactorById(Long id);
}
