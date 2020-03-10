package com.ruoyi.zh.service;


import com.ruoyi.zh.domain.DensityLog;
import com.ruoyi.zh.domain.DensityRealTime;
import com.ruoyi.zh.dto.DensityDto;

import java.util.List;

public interface IDensityLogService {

    DensityLog getOne(DensityRealTime densityRealTime, String deviceModel, String serverIp);

    List<DensityLog> list(DensityDto densityDto);
}
