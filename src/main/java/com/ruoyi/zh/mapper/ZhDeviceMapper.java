package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhDevice;
import java.util.List;

/**
 * 走航Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-23
 */
public interface ZhDeviceMapper 
{
    /**
     * 查询走航
     * 
     * @param id 走航ID
     * @return 走航
     */
    public ZhDevice selectZhDeviceById(Long id);

    /**
     * 查询走航列表
     * 
     * @param zhDevice 走航
     * @return 走航集合
     */
    public List<ZhDevice> selectZhDeviceList(ZhDevice zhDevice);

    /**
     * 新增走航
     * 
     * @param zhDevice 走航
     * @return 结果
     */
    public int insertZhDevice(ZhDevice zhDevice);

    /**
     * 修改走航
     * 
     * @param zhDevice 走航
     * @return 结果
     */
    public int updateZhDevice(ZhDevice zhDevice);

    /**
     * 删除走航
     * 
     * @param id 走航ID
     * @return 结果
     */
    public int deleteZhDeviceById(Long id);

    /**
     * 批量删除走航
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhDeviceByIds(Long[] ids);
}
