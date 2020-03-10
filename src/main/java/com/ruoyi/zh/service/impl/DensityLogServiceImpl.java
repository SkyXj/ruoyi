package com.ruoyi.zh.service.impl;


import com.ruoyi.framework.influxdb.InfluxdbUtils;
import com.ruoyi.zh.domain.DensityLog;
import com.ruoyi.zh.domain.DensityRealTime;
import com.ruoyi.zh.dto.DensityDto;
import com.ruoyi.zh.service.IDensityLogService;
import io.swagger.models.auth.In;
import org.influxdb.dto.QueryResult;
import org.influxdb.impl.InfluxDBResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DensityLogServiceImpl implements IDensityLogService {


    @Autowired
    InfluxdbUtils InfluxdbUtils;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public DensityLog getOne(DensityRealTime densityRealTime, String deviceModel, String serverIp) {
//        String deviceCode = densityRealTime.getDeviceCode();
//        EsDevice esDevice = iEsDeviceService.getEsDeviceByDeviceCode(deviceCode);
//        String serverIp = iEsDeviceService.getServerIp(deviceCode);
        List<DensityLog> list= new ArrayList<>();
        if (!StringUtils.isEmpty(serverIp)) {
            String query = "SELECT * FROM DensityLog WHERE 1=1" +
                    "and time='"+densityRealTime.getTime()+"' "+
                    "and code='"+densityRealTime.getCode()+"'";
            QueryResult queryResult = InfluxdbUtils.query(query);
            InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
            list = resultMapper.toPOJO(queryResult, DensityLog.class);
        }
        if(list!=null&&list.size()>0){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<DensityLog> list(DensityDto densityDto) {
        List<DensityLog> list= new ArrayList<>();
        String query = "SELECT * FROM DensityLog WHERE 1=1 "+
                "and time> '" + densityDto.getStartDate() + "' - 8h " +
                (StringUtils.isEmpty(densityDto.getEndDate())?"":"and time <='" + densityDto.getEndDate() + "' - 8h ") +
                "and code='"+densityDto.getCode()+"'";
        QueryResult queryResult = InfluxdbUtils.query(query);
        InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
        list = resultMapper.toPOJO(queryResult, DensityLog.class);
        if(list!=null&&list.size()>0){
            return list;
        }
        return list;
    }

    public String instantToString(Instant instant) {
        try {
            return dateFormat.format(new Date(instant.toEpochMilli()).getTime()-8*3600000);
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }


}
