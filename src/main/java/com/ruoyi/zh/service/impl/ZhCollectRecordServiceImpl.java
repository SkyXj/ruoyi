package com.ruoyi.zh.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhCollectRecordMapper;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.service.IZhCollectRecordService;

/**
 * 走航记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@Service
public class ZhCollectRecordServiceImpl implements IZhCollectRecordService
{
    @Autowired
    private ZhCollectRecordMapper zhCollectRecordMapper;

    /**
     * 查询走航记录
     * 
     * @param id 走航记录ID
     * @return 走航记录
     */
    @Override
    public ZhCollectRecord selectZhCollectRecordById(Long id)
    {
        return zhCollectRecordMapper.selectZhCollectRecordById(id);
    }

    /**
     * 查询走航记录列表
     * 
     * @param zhCollectRecord 走航记录
     * @return 走航记录
     */
    @Override
    public List<ZhCollectRecord> selectZhCollectRecordList(ZhCollectRecord zhCollectRecord)
    {
        return zhCollectRecordMapper.selectZhCollectRecordList(zhCollectRecord);
    }

    /**
     * 新增走航记录
     * 
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    @Override
    public int insertZhCollectRecord(ZhCollectRecord zhCollectRecord)
    {
        return zhCollectRecordMapper.insertZhCollectRecord(zhCollectRecord);
    }

    /**
     * 修改走航记录
     * 
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    @Override
    public int updateZhCollectRecord(ZhCollectRecord zhCollectRecord)
    {
        return zhCollectRecordMapper.updateZhCollectRecord(zhCollectRecord);
    }

    /**
     * 批量删除走航记录
     * 
     * @param ids 需要删除的走航记录ID
     * @return 结果
     */
    @Override
    public int deleteZhCollectRecordByIds(Long[] ids)
    {
        return zhCollectRecordMapper.deleteZhCollectRecordByIds(ids);
    }

    /**
     * 删除走航记录信息
     * 
     * @param id 走航记录ID
     * @return 结果
     */
    @Override
    public int deleteZhCollectRecordById(Long id)
    {
        return zhCollectRecordMapper.deleteZhCollectRecordById(id);
    }

    @Override
    public Long getMaxId() {
        return zhCollectRecordMapper.getMaxId();
    }
}
