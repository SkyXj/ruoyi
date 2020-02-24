package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhCollectRecord;
import java.util.List;

/**
 * 走航记录Mapper接口
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
public interface ZhCollectRecordMapper 
{
    /**
     * 查询走航记录
     * 
     * @param id 走航记录ID
     * @return 走航记录
     */
    public ZhCollectRecord selectZhCollectRecordById(Long id);

    /**
     * 查询走航记录列表
     * 
     * @param zhCollectRecord 走航记录
     * @return 走航记录集合
     */
    public List<ZhCollectRecord> selectZhCollectRecordList(ZhCollectRecord zhCollectRecord);

    /**
     * 新增走航记录
     * 
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    public int insertZhCollectRecord(ZhCollectRecord zhCollectRecord);

    /**
     * 修改走航记录
     * 
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    public int updateZhCollectRecord(ZhCollectRecord zhCollectRecord);

    /**
     * 删除走航记录
     * 
     * @param id 走航记录ID
     * @return 结果
     */
    public int deleteZhCollectRecordById(Long id);

    /**
     * 批量删除走航记录
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhCollectRecordByIds(Long[] ids);

    public Long getMaxId();
}
