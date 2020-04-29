package com.ruoyi.zh.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.mapper.CollectRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhFileMapper;
import com.ruoyi.zh.domain.ZhFile;
import com.ruoyi.zh.service.IZhFileService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * 文件Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-26
 */
@Service
@Slf4j
public class ZhFileServiceImpl implements IZhFileService 
{
    @Autowired
    private ZhFileMapper zhFileMapper;

    @Autowired
    private CollectRecordMapper collectRecordMapper;

    /**
     * 查询文件
     * 
     * @param id 文件ID
     * @return 文件
     */
    @Override
    public ZhFile selectZhFileById(Long id)
    {
        return zhFileMapper.selectZhFileById(id);
    }

    @Override
    public ZhFile selectZhFileByCollectId(Long collect_record_id) {
        return zhFileMapper.selectZhFileByCollectId(collect_record_id);
    }

    /**
     * 查询文件列表
     * 
     * @param zhFile 文件
     * @return 文件
     */
    @Override
    public List<ZhFile> selectZhFileList(ZhFile zhFile)
    {
        return zhFileMapper.selectZhFileList(zhFile);
    }

    /**
     * 新增文件
     * 
     * @param zhFile 文件
     * @return 结果
     */
    @Override
    public int insertZhFile(ZhFile zhFile)
    {
        zhFile.setCreateTime(DateUtils.getNowDate());
        return zhFileMapper.insertZhFile(zhFile);
    }

    /**
     * 修改文件
     * 
     * @param zhFile 文件
     * @return 结果
     */
    @Override
    public int updateZhFile(ZhFile zhFile)
    {
        zhFile.setUpdateTime(DateUtils.getNowDate());
        return zhFileMapper.updateZhFile(zhFile);
    }

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的文件ID
     * @return 结果
     */
    @Override
    public int deleteZhFileByIds(Long[] ids)
    {
        return zhFileMapper.deleteZhFileByIds(ids);
    }

    /**
     * 删除文件信息
     * 
     * @param id 文件ID
     * @return 结果
     */
    @Override
    public int deleteZhFileById(Long id)
    {
        return zhFileMapper.deleteZhFileById(id);
    }

    @Override
    @Transactional
    public int warehouse(Long id) {
        try {
            ZhFile zhFile = selectZhFileById(id);
            zhFile.setDurability(1);
            ZhCollectRecord zhCollectRecord = collectRecordMapper.selectCollectRecordById(zhFile.getCollectRecordId());
            zhCollectRecord.setType(1);
            collectRecordMapper.updateCollectRecord(zhCollectRecord);
        } catch (Exception e) {
            log.error(e.getMessage());
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
        return 1;
    }
}
