package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhCollectRecord;
import org.apache.ibatis.annotations.Param;

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

    public List<ZhCollectRecord> selectCollectRecordByIds(@Param("ids") Long[] ids,@Param("username") String username);

    public Integer selectCollectRecordCountByIds(@Param("ids") Long[] ids,@Param("username") String username);

    /**
     * 查询走航记录列表
     *
     * @param zhCollectRecord 走航记录
     * @return 走航记录集合
     */
    public List<ZhCollectRecord> selectCollectRecordList(ZhCollectRecord zhCollectRecord);

    public Integer selectCollectRecordCount(ZhCollectRecord zhCollectRecord);

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

    public Long getMaxId(String username);

    public ZhCollectRecord getRecently(String username);

    public void closeRecord(String username);
}
