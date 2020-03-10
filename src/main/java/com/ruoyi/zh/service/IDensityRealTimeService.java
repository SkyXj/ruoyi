package com.ruoyi.zh.service;

import com.ruoyi.zh.domain.DensityRealTime;
import com.ruoyi.zh.dto.DensityDto;

import java.util.List;

public interface IDensityRealTimeService {
    List<DensityRealTime> list(DensityDto densityDto);
}
