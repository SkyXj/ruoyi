package com.ruoyi.zh.mapper;

import com.ruoyi.zh.domain.ZhFile;
import java.util.List;

/**
 * 文件Mapper接口
 * 
 * @author hxsdd
 * @date 2020-04-24
 */
public interface ZhFileMapper 
{
    /**
     * 查询文件
     * 
     * @param id 文件ID
     * @return 文件
     */
    public ZhFile selectZhFileById(Long id);

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
     * 删除文件
     * 
     * @param id 文件ID
     * @return 结果
     */
    public int deleteZhFileById(Long id);

    /**
     * 批量删除文件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteZhFileByIds(Long[] ids);
}
