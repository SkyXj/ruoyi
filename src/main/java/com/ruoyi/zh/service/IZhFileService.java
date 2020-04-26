package com.ruoyi.zh.service;

import com.ruoyi.zh.domain.ZhFile;
import java.util.List;

/**
 * 文件Service接口
 * 
 * @author ruoyi
 * @date 2020-04-26
 */
public interface IZhFileService 
{
    /**
     * 查询文件
     * 
     * @param id 文件ID
     * @return 文件
     */
    public ZhFile selectZhFileById(Long id);

    /**
     * 查询文件
     *
     * @param collect_record_id 走航记录
     * @return 文件
     */
    public ZhFile selectZhFileByCollectId(Long collect_record_id);

    /**
     * 查询文件列表
     * 
     * @param zhFile 文件
     * @return 文件集合
     */
    public List<ZhFile> selectZhFileList(ZhFile zhFile);

    /**
     * 新增文件
     * 
     * @param zhFile 文件
     * @return 结果
     */
    public int insertZhFile(ZhFile zhFile);

    /**
     * 修改文件
     * 
     * @param zhFile 文件
     * @return 结果
     */
    public int updateZhFile(ZhFile zhFile);

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的文件ID
     * @return 结果
     */
    public int deleteZhFileByIds(Long[] ids);

    /**
     * 删除文件信息
     * 
     * @param id 文件ID
     * @return 结果
     */
    public int deleteZhFileById(Long id);
}
