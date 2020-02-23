package com.ruoyi.zh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhDeviceMapper;
import com.ruoyi.zh.domain.ZhDevice;
import com.ruoyi.zh.service.IZhDeviceService;

/**
 * 走航Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-23
 */
@Service
public class ZhDeviceServiceImpl implements IZhDeviceService 
{
    @Autowired
    private ZhDeviceMapper zhDeviceMapper;

    /**
     * 查询走航
     * 
     * @param id 走航ID
     * @return 走航
     */
    @Override
    public ZhDevice selectZhDeviceById(Long id)
    {
        return zhDeviceMapper.selectZhDeviceById(id);
    }

    /**
     * 查询走航列表
     * 
     * @param zhDevice 走航
     * @return 走航
     */
    @Override
    public List<ZhDevice> selectZhDeviceList(ZhDevice zhDevice)
    {
        return zhDeviceMapper.selectZhDeviceList(zhDevice);
    }

    /**
     * 新增走航
     * 
     * @param zhDevice 走航
     * @return 结果
     */
    @Override
    public int insertZhDevice(ZhDevice zhDevice)
    {
        return zhDeviceMapper.insertZhDevice(zhDevice);
    }

    /**
     * 修改走航
     * 
     * @param zhDevice 走航
     * @return 结果
     */
    @Override
    public int updateZhDevice(ZhDevice zhDevice)
    {
        return zhDeviceMapper.updateZhDevice(zhDevice);
    }

    /**
     * 批量删除走航
     * 
     * @param ids 需要删除的走航ID
     * @return 结果
     */
    @Override
    public int deleteZhDeviceByIds(Long[] ids)
    {
        return zhDeviceMapper.deleteZhDeviceByIds(ids);
    }

    /**
     * 删除走航信息
     * 
     * @param id 走航ID
     * @return 结果
     */
    @Override
    public int deleteZhDeviceById(Long id)
    {
        return zhDeviceMapper.deleteZhDeviceById(id);
    }
}
