package com.ruoyi.zh.service.impl;

import com.ruoyi.common.utils.TimeTool;
import com.ruoyi.mina.DensityVo;
import com.ruoyi.zh.domain.DensityLog;
import com.ruoyi.zh.domain.DensityRealTime;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.dto.DensityDto;
import com.ruoyi.zh.mapper.CollectRecordMapper;
import com.ruoyi.zh.service.IDensityLogService;
import com.ruoyi.zh.service.IDensityRealTimeService;
import com.ruoyi.zh.service.ICollectRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 走航记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@Service
public class CollectRecordServiceImpl implements ICollectRecordService
{
    @Autowired
    private CollectRecordMapper collectRecordMapper;

    @Autowired
    IDensityRealTimeService densityRealTimeService;
    @Autowired
    IDensityLogService densityLogService;

    /**
     * 查询走航记录
     * 
     * @param id 走航记录ID
     * @return 走航记录
     */
    @Override
    public ZhCollectRecord selectCollectRecordById(Long id)
    {
        return collectRecordMapper.selectCollectRecordById(id);
    }

    /**
     * 查询走航记录列表
     * 
     * @param zhCollectRecord 走航记录
     * @return 走航记录
     */
    @Override
    public List<ZhCollectRecord> selectCollectRecordList(ZhCollectRecord zhCollectRecord)
    {
        return collectRecordMapper.selectCollectRecordList(zhCollectRecord);
    }

    /**
     * 新增走航记录
     * 
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    @Override
    public int insertCollectRecord(ZhCollectRecord zhCollectRecord)
    {
        return collectRecordMapper.insertCollectRecord(zhCollectRecord);
    }

    /**
     * 修改走航记录
     * 
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    @Override
    public int updateCollectRecord(ZhCollectRecord zhCollectRecord)
    {
        return collectRecordMapper.updateCollectRecord(zhCollectRecord);
    }

    /**
     * 批量删除走航记录
     * 
     * @param ids 需要删除的走航记录ID
     * @return 结果
     */
    @Override
    public int deleteCollectRecordByIds(Long[] ids)
    {
        return collectRecordMapper.deleteCollectRecordByIds(ids);
    }

    /**
     * 删除走航记录信息
     * 
     * @param id 走航记录ID
     * @return 结果
     */
    @Override
    public int deleteCollectRecordById(Long id)
    {
        return collectRecordMapper.deleteCollectRecordById(id);
    }

    @Override
    public Long getMaxId() {
        return collectRecordMapper.getMaxId();
    }

    @Override
    public List<DensityVo> searchMic(DensityDto densityDto) {

        //返回结果对象
        List<DensityVo> result = new ArrayList<>();

        //查询log日志表(经纬度)
        List<DensityLog> densityLogs = densityLogService.list(densityDto);

        //查询当前所有的浓度数据
        List<DensityRealTime> list = densityRealTimeService.list(densityDto);

        if (list == null || list.size() <= 0) {
            return result;
        }

        Map<String, List<DensityRealTime>> map = list.stream()
                .collect(Collectors.groupingBy(s -> s.getTime() + "_" + s.getCode()));
        for (String key : map.keySet()) {
            String[] strs = key.split("_");
            DensityVo vo = new DensityVo();
            try {
                vo.setTime(TimeTool.parseUTCText(strs[0]));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            DensityRealTime dr = new DensityRealTime();
            dr.setTime(strs[0]);
            dr.setCode(strs[1]);
            List<DensityLog> collect = densityLogs.stream().filter(t -> t.getTime().equals(strs[0]) && t.getCode().equals(strs[1])).collect(Collectors.toList());
            if(collect==null||collect.size()<=0) {
                continue;
            }
//            DensityLog densityLog = densityLogService.getOne(dr,deviceModel,serverIp);
            DensityLog densityLog = collect.get(0);
            if (densityLog == null) {
                continue;
            }
            List<DensityVo.KV> kvs = new ArrayList<>();
            List<DensityRealTime> drts = map.get(key);
            if (drts == null || drts.size() <= 0) {
                continue;
            }
            for (DensityRealTime densityRealTime : drts) {
                DensityVo.KV kv = vo.new KV();
                if ("TVOC".equals(densityRealTime.getName().trim())) {
//                    BigDecimal bg = new BigDecimal(densityRealTime.getValue() / 1000 / 1000 / 10);
                    BigDecimal bg = new BigDecimal(densityRealTime.getValue());
                    double d3 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                    vo.setTvoc(d3);
//                    vo.setTvoc(String.format("%.2f", vo.getTvoc()));
                }
                BigDecimal bg = new BigDecimal(densityRealTime.getValue());
                double d4 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
                kv.setName(densityRealTime.getName());
                kv.setValue(d4);
                kvs.add(kv);
            }
            vo.setValues(kvs);
            vo.setLng(densityLog.getLng());
            vo.setLat(densityLog.getLat());
            result.add(vo);
        }
        return result;
    }


}
