package com.ruoyi.zh.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
import com.ruoyi.mina.DensityVo;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.domain.ZhFile;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ZhCollectRecordDto {
    /** id */
    private Long id;

    /** 设备编号 */
    @Excel(name = "设备编号")
    private String deviceCode;

    /** 开始时间 */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date startTime;

    /** 结束时间 */
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date endTime;

    /** 敏感点名称 */
    @Excel(name = "敏感点名称")
    private String pointName;

    /** 物质总数 */
    @Excel(name = "物质总数")
    private Integer factorCount;

    private Boolean show;

    private List<DensityVo> points;

    private List<String> datas;

    private ZhFile zhFile;

    public ZhCollectRecordDto(ZhCollectRecord zhCollectRecord){
        this.id=zhCollectRecord.getId();
        this.deviceCode=zhCollectRecord.getDeviceCode();
        this.startTime=zhCollectRecord.getStartTime();
        this.endTime=zhCollectRecord.getEndTime();
        this.pointName=zhCollectRecord.getPointName();
        this.factorCount=zhCollectRecord.getFactorCount();
        this.show=zhCollectRecord.getShow();
    }

    public List<ZhCollectRecordDto> zhCollectRecordDtos(List<ZhCollectRecord> zhCollectRecords){
        List<ZhCollectRecordDto> zhCollectRecordDtos=new ArrayList<>();
        if(zhCollectRecords!=null&&zhCollectRecords.size()>0){
            for (ZhCollectRecord zhCollectRecord:zhCollectRecords){
                zhCollectRecordDtos.add(new ZhCollectRecordDto(zhCollectRecord));
            }
        }
        return zhCollectRecordDtos;
    }

    public List<ZhCollectRecord> ZhCollectRecords(List<ZhCollectRecordDto> zhCollectRecordDtos){
        List<ZhCollectRecord> ZhCollectRecord=new ArrayList<>();
        if(zhCollectRecordDtos!=null&&zhCollectRecordDtos.size()>0){
            for (ZhCollectRecordDto zhCollectRecordDto:zhCollectRecordDtos){
                ZhCollectRecord.add(new ZhCollectRecord(zhCollectRecordDto));
            }
        }
        return ZhCollectRecord;
    }

    public ZhCollectRecordDto(){

    }
}
