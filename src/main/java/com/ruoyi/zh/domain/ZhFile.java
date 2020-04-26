package com.ruoyi.zh.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.framework.web.domain.BaseEntity;

/**
 * 文件对象 zh_file
 * 
 * @author ruoyi
 * @date 2020-04-26
 */
public class ZhFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 文件名 */
    @Excel(name = "文件名")
    private String fileName;

    /** 文件大小kb */
    @Excel(name = "文件大小kb")
    private Long size;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String path;

    /** 是否入库 */
    @Excel(name = "是否入库")
    private Integer durability;

    /** 走航id */
    @Excel(name = "走航id")
    private Long collectRecordId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setSize(Long size) 
    {
        this.size = size;
    }

    public Long getSize() 
    {
        return size;
    }
    public void setPath(String path) 
    {
        this.path = path;
    }

    public String getPath() 
    {
        return path;
    }
    public void setDurability(Integer durability) 
    {
        this.durability = durability;
    }

    public Integer getDurability() 
    {
        return durability;
    }
    public void setCollectRecordId(Long collectRecordId) 
    {
        this.collectRecordId = collectRecordId;
    }

    public Long getCollectRecordId() 
    {
        return collectRecordId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("size", getSize())
            .append("path", getPath())
            .append("durability", getDurability())
            .append("collectRecordId", getCollectRecordId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
