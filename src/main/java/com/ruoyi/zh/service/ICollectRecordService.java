package com.ruoyi.zh.service;

import com.ruoyi.mina.DensityVo;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.dto.DensityDto;
import com.ruoyi.zh.dto.OperationData;
import com.ruoyi.zh.dto.ZhCollectRecordDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 走航记录Service接口
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
public interface ICollectRecordService 
{
    /**
     * 查询走航记录
     * 
     * @param id 走航记录ID
     * @return 走航记录
     */
    public ZhCollectRecord selectCollectRecordById(Long id);

    /**
     * 查询走航记录列表
     * 
     * @param zhCollectRecord 走航记录
     * @return 走航记录集合
     */
    public List<ZhCollectRecordDto> selectCollectRecordDtoList(ZhCollectRecord zhCollectRecord);

    public Integer selectCollectRecordCount(ZhCollectRecord zhCollectRecord);


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
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    public int updateCollectRecord(ZhCollectRecord zhCollectRecord);

    /**
     * 批量删除走航记录
     * 
     * @param ids 需要删除的走航记录ID
     * @return 结果
     */
    public int deleteCollectRecordByIds(Long[] ids);

    /**
     * 删除走航记录信息
     * 
     * @param id 走航记录ID
     * @return 结果
     */
    public int deleteCollectRecordById(Long id);

    public Long getMaxId();

    public List<DensityVo> searchMic(DensityDto densityDto);

    public List<String> searchStrMic(DensityDto densityDto);

    public List<String> readStrMic(String filePath);

    public ZhCollectRecordDto getRecently();

    public Long importData(String deviceCode, /*String recordName,*/ MultipartFile file,String pointname);

    public List<Long> importListData(String deviceCode,List<MultipartFile> files,String pointname);

    public List<ZhCollectRecordDto> readListData(String deviceCode,List<MultipartFile> files,String pointname);

    public boolean checkFiles(List<ZhCollectRecordDto> zhCollectRecordDtos);

    public ZhCollectRecordDto getPointsById(Long id);

    public List<ZhCollectRecordDto> getPointsByIds(Long[] ids);

    public List<ZhCollectRecordDto> getPointsStrByIds(Long[] ids);

    public String exportData(Long id);

    public String exportOperationData(OperationData operationData);

    public String exportOperationDataByIds(List<OperationData> operationDatas);

    public String exportDataByIds(Long[] ids);

    public List<ZhCollectRecordDto> selectCollectRecordByIds(Long[] ids);

    public Integer selectCollectRecordCountByIds(Long[] ids);

    public List<ZhCollectRecordDto> getZhCollectRecordDtoByZhCollectRecord(List<ZhCollectRecord> collectRecords);

    public void closeRecord();
}
