package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhConfig;
import java.util.List;

/**
 * 配置信息Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-08
 */
public interface ZhConfigMapper 
{
    /**
     * 查询配置信息
     * 
     * @param id 配置信息ID
     * @return 配置信息
     */
    public ZhConfig selectZhConfigById(Long id);

    /**
     * 查询配置信息列表
     * 
     * @param zhConfig 配置信息
     * @return 配置信息集合
     */
    public List<ZhConfig> selectZhConfigList(ZhConfig zhConfig);

    /**
     * 新增配置信息
     * 
     * @param zhConfig 配置信息
     * @return 结果
     */
    public int insertZhConfig(ZhConfig zhConfig);

    /**
     * 修改配置信息
     * 
     * @param zhConfig 配置信息
     * @return 结果
     */
    public int updateZhConfig(ZhConfig zhConfig);

    /**
     * 删除配置信息
     * 
     * @param id 配置信息ID
     * @return 结果
     */
    public int deleteZhConfigById(Long id);

    /**
     * 批量删除配置信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhConfigByIds(Long[] ids);
}
