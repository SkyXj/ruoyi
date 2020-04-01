package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.dto.ZhCollectRecordDto;

import javax.annotation.Resource;
import java.util.List;

/**
 * 走航记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
public interface CollectRecordMapper
{
    /**
     * 查询走航记录
     * 
     * @param id 走航记录ID
     * @return 走航记录
     */
    public ZhCollectRecord selectCollectRecordById(Long id);

    public List<ZhCollectRecord> selectCollectRecordByIds(Long[] ids);

    /**
     * 查询走航记录列表
     * 
     * @param zhCollectRecord 走航记录
     * @return 走航记录集合
     */
    public List<ZhCollectRecord> selectCollectRecordList(ZhCollectRecord zhCollectRecord);

    /**
     * 新增走航记录
     * 
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    public int insertCollectRecord(ZhCollectRecord zhCollectRecord);

    /**
     * 修改走航记录
     * 
     * @param collectRecord 走航记录
     * @return 结果
     */
    public int updateCollectRecord(ZhCollectRecord collectRecord);

    /**
     * 删除走航记录
     * 
     * @param id 走航记录ID
     * @return 结果
     */
    public int deleteCollectRecordById(Long id);

    /**
     * 批量删除走航记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCollectRecordByIds(Long[] ids);

    public Long getMaxId();

    public ZhCollectRecord getRecently();
}
