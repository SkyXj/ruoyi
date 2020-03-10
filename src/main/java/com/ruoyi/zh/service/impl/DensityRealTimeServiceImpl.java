package com.ruoyi.zh.service.impl;


import com.ruoyi.framework.influxdb.InfluxdbUtils;
import com.ruoyi.zh.domain.DensityRealTime;
import com.ruoyi.zh.dto.DensityDto;
import com.ruoyi.zh.service.IDensityRealTimeService;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class DensityRealTimeServiceImpl implements IDensityRealTimeService {


    @Resource
    private InfluxdbUtils influxdbUtils;


    @Override
    public List<DensityRealTime> list(DensityDto densityDto) {
        List<DensityRealTime> list = new ArrayList<>();
        String query = "SELECT * FROM DensityRealtime WHERE " +
                "time> '" + densityDto.getStartDate() + "' - 8h " +
                (StringUtils.isEmpty(densityDto.getEndDate())?"":"and time <='" + densityDto.getEndDate() + "' - 8h ") +
                "and code='" + densityDto.getCode() + "'" +
                "";
        QueryResult queryResult = influxdbUtils.query(query);
        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
        list = resultMapper.toPOJO(queryResult, DensityRealTime.class);
        return list;
    }

}
