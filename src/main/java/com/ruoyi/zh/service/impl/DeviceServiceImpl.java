package com.ruoyi.zh.service.impl;

import java.util.List;

import com.ruoyi.zh.tool.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.DeviceMapper;
import com.ruoyi.zh.domain.ZhDevice;
import com.ruoyi.zh.service.IDeviceService;

/**
 * 走航Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-23
 */
@Service
public class DeviceServiceImpl implements IDeviceService 
{
    @Autowired
    private DeviceMapper deviceMapper;

    /**
     * 查询走航
     * 
     * @param id 走航ID
     * @return 走航
     */
    @Override
    public ZhDevice selectDeviceById(Long id)
    {
        return deviceMapper.selectDeviceById(id);
    }

    /**
     * 查询走航列表
     * 
     * @param zhDevice 走航
     * @return 走航
     */
    @Override
    public List<ZhDevice> selectDeviceList(ZhDevice zhDevice)
    {
        zhDevice.setCreateBy(UserInfoUtil.getUserName());
        return deviceMapper.selectDeviceList(zhDevice);
    }

    /**
     * 新增走航
     * 
     * @param zhDevice 走航
     * @return 结果
     */
    @Override
    public int insertDevice(ZhDevice zhDevice)
    {
        zhDevice.setCreateBy(UserInfoUtil.getUserName());
        return deviceMapper.insertDevice(zhDevice);
    }

    /**
     * 修改走航
     * 
     * @param zhDevice 走航
     * @return 结果
     */
    @Override
    public int updateDevice(ZhDevice zhDevice)
    {
        zhDevice.setUpdateBy(UserInfoUtil.getUserName());
        return deviceMapper.updateDevice(zhDevice);
    }

    /**
     * 批量删除走航
     * 
     * @param ids 需要删除的走航ID
     * @return 结果
     */
    @Override
    public int deleteDeviceByIds(Long[] ids)
    {
        return deviceMapper.deleteDeviceByIds(ids);
    }

    /**
     * 删除走航信息
     * 
     * @param id 走航ID
     * @return 结果
     */
    @Override
    public int deleteDeviceById(Long id)
    {
        return deviceMapper.deleteDeviceById(id);
    }
}
