package com.ruoyi.zh.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.IdUtils;
import com.ruoyi.common.utils.TimeTool;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.influxdb.BatchData;
import com.ruoyi.framework.influxdb.InfluxdbUtils;
import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.mina.DensityVo;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.zh.domain.DensityLog;
import com.ruoyi.zh.domain.DensityRealTime;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.domain.ZhFile;
import com.ruoyi.zh.dto.DensityDto;
import com.ruoyi.zh.dto.ZhCollectRecordDto;
import com.ruoyi.zh.mapper.CollectRecordMapper;
import com.ruoyi.zh.service.IDensityLogService;
import com.ruoyi.zh.service.IDensityRealTimeService;
import com.ruoyi.zh.service.ICollectRecordService;
import com.ruoyi.zh.service.IZhFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 走航记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@Service
@Slf4j
public class CollectRecordServiceImpl implements ICollectRecordService {
    @Autowired
    private CollectRecordMapper collectRecordMapper;

    @Autowired
    IDensityRealTimeService densityRealTimeService;
    @Autowired
    IDensityLogService densityLogService;

    @Autowired
    public InfluxdbUtils influxdbUtils;

    @Autowired
    public IZhFileService zhFileService;

    /**
     * 查询走航记录
     *
     * @param id 走航记录ID
     * @return 走航记录
     */
    @Override
    public ZhCollectRecord selectCollectRecordById(Long id) {
        return collectRecordMapper.selectCollectRecordById(id);
    }

    /**
     * 查询走航记录列表
     *
     * @param zhCollectRecord 走航记录
     * @return 走航记录
     */
    @Override
    public List<ZhCollectRecord> selectCollectRecordList(ZhCollectRecord zhCollectRecord) {
        return collectRecordMapper.selectCollectRecordList(zhCollectRecord);
    }

    /**
     * 新增走航记录
     *
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    @Override
    public int insertCollectRecord(ZhCollectRecord zhCollectRecord) {
        return collectRecordMapper.insertCollectRecord(zhCollectRecord);
    }

    /**
     * 修改走航记录
     *
     * @param zhCollectRecord 走航记录
     * @return 结果
     */
    @Override
    public int updateCollectRecord(ZhCollectRecord zhCollectRecord) {
        return collectRecordMapper.updateCollectRecord(zhCollectRecord);
    }

    /**
     * 批量删除走航记录
     *
     * @param ids 需要删除的走航记录ID
     * @return 结果
     */
    @Override
    public int deleteCollectRecordByIds(Long[] ids) {
        return collectRecordMapper.deleteCollectRecordByIds(ids);
    }

    /**
     * 删除走航记录信息
     *
     * @param id 走航记录ID
     * @return 结果
     */
    @Override
    public int deleteCollectRecordById(Long id) {
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

        Map<String, List<DensityRealTime>> map=new HashMap<>();
        for (DensityRealTime s: list) {
             if(map.containsKey(s.getTime() + "_" + s.getCode())){
                 map.get(s.getTime() + "_" + s.getCode()).add(s);
             }else{
                 List<DensityRealTime> listtemp=new ArrayList<DensityRealTime>();
                 listtemp.add(s);
                 map.put(s.getTime() + "_" + s.getCode(),listtemp);
             }
        }

        Map<String, DensityLog> mapLogs=new HashMap<>();
        for (DensityLog s: densityLogs) {
//            if(mapLogs.containsKey(s.getTime() + "_" + s.getCode())){
//                mapLogs.put(s.getTime() + "_" + s.getCode());
//            }else{
//                mapLogs.put(s.getTime() + "_" + s.getCode(),new ArrayList<DensityRealTime>());
//            }
            mapLogs.put(s.getTime() + "_" + s.getCode(),s);
        }



//        Map<String, List<DensityRealTime>> map = list.stream()
//                .collect(Collectors.groupingBy(s -> s.getTime() + "_" + s.getCode()));
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
//            List<DensityLog> collect = densityLogs.stream().filter(t -> t.getTime().equals(strs[0]) && t.getCode().equals(strs[1])).collect(Collectors.toList());
//            List<DensityLog> collect = null;
//
//            if (collect == null || collect.size() <= 0) {
//                continue;
//            }
//            DensityLog densityLog = densityLogService.getOne(dr,deviceModel,serverIp);
            DensityLog densityLog = null;
            if(mapLogs.containsKey(key)){
                densityLog = mapLogs.get(key);
            }
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
        Collections.sort(result);
        return result;
    }

    @Override
    public List<String> searchStrMic(DensityDto densityDto) {
        List<String> datas=new ArrayList<>();
        //返回结果对象
        List<DensityVo> result = new ArrayList<>();
        //查询log日志表(经纬度)
        List<DensityLog> densityLogs = densityLogService.list(densityDto);
        //查询当前所有的浓度数据
        List<DensityRealTime> list = densityRealTimeService.list(densityDto);
        //如果没有浓度数据则返回
        if (list == null || list.size() <= 0) {
            return datas;
        }
        //按照时间将浓度数据分组
        Map<String, List<DensityRealTime>> map=new HashMap<>();
        for (DensityRealTime s: list) {
            if(map.containsKey(s.getTime() + "_" + s.getCode())){
                map.get(s.getTime() + "_" + s.getCode()).add(s);
            }else{
                List<DensityRealTime> listtemp=new ArrayList<DensityRealTime>();
                listtemp.add(s);
                map.put(s.getTime() + "_" + s.getCode(),listtemp);
            }
        }
        Map<String, DensityLog> mapLogs=new HashMap<>();
        for (DensityLog s: densityLogs) {
            mapLogs.put(s.getTime() + "_" + s.getCode(),s);
        }

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

            DensityLog densityLog = null;
            if(mapLogs.containsKey(key)){
                densityLog = mapLogs.get(key);
            }
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
        Collections.sort(result);

        for (int i = 0; i < result.size(); i++) {
            List<DensityVo.KV> values = result.get(i).getValues();
            //名字
            StringBuilder name=new StringBuilder();
            name.append("时间;经度;纬度");
            //浓度值
            StringBuilder mics=new StringBuilder();
            mics.append(result.get(i).getTime()+";"+result.get(i).getLng()+";"+result.get(i).getLat());
            for (DensityVo.KV value: values) {
                if(i==0){
                    name.append(";"+value.getName());
                }
                mics.append(";"+value.getValue());
            }
            if(i==0){
                datas.add(name.toString());
            }
            datas.add(mics.toString());
        }
        return datas;
    }

    @Override
    public ZhCollectRecordDto getRecently() {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ZhCollectRecord zhCollectRecord=collectRecordMapper.getRecently();
        if(zhCollectRecord==null){
            return null;
        }
        ZhCollectRecordDto zhCollectRecordDto=new ZhCollectRecordDto(zhCollectRecord);
        DensityDto densityDto=new DensityDto();
        densityDto.setCode(zhCollectRecord.getDeviceCode());
        densityDto.setStartDate(sim.format(zhCollectRecord.getStartTime()));
//        List<DensityVo> densityVos = searchMic(densityDto);
        List<String> datas = searchStrMic(densityDto);
        zhCollectRecordDto.setDatas(datas);
        return zhCollectRecordDto;
    }

    @Override
    public Long importData(String deviceCode, /*String recordName,*/ MultipartFile file,String pointname) {
        Date startTime = null;
        Date endTime = null;
        ZhCollectRecord collectionRecord=null;
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream(), "GBK"));
            String temp = null;
            int index = 1;
            // 按行读取字符串
            String[] names = null;
            List<BatchData> batchDatas = new ArrayList<>();
            List<BatchData> logBatchDatas = new ArrayList<>();
            while ((temp = bf.readLine()) != null) {
                if(temp.isEmpty()){
                    continue;
                }
                //标题
                if (index == 1) {
                    names = temp.split(";");
                } else {
                    //浓度值
                    String[] values = temp.split(";");
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date time = sdf.parse(values[0]);
//                    List<BatchData> batchDatas = new ArrayList<>();
//
//                    List<BatchData> logBatchDatas = new ArrayList<>();
                    for (int i = 3; i < values.length; i++) {
                        BatchData batchData = new BatchData();
                        Map<String, String> tags = new HashMap<>(5);
                        tags.put("code", deviceCode);
                        tags.put("name", names[i]);
                        Map<String, Object> fileds = new HashMap<>(4);
                        fileds.put("value", Double.parseDouble(values[i]));


                        startTime = startTime == null ? time : startTime;
                        endTime = endTime == null ? time : endTime;
                        if (startTime.getTime() > time.getTime()) {
                            startTime = time;
                        }
                        if (endTime.getTime() < time.getTime()) {
                            endTime = time;
                        }
                        batchData.setTags(tags);
                        batchData.setFields(fileds);
                        batchData.setTime(time.getTime());
                        batchData.setTable("DensityRealtime");
                        batchDatas.add(batchData);
                    }
//                    influxdbUtils.batchInsertAndTime(batchDatas);
//                    influxdbUtils.batchInsertAndTime(logBatchDatas);
                    BatchData logBatchData = new BatchData();
                    Map<String, String> logTags = new HashMap<>();
                    logTags.put("code", deviceCode);
                    Map<String, Object> logFileds = new HashMap<>();
                    logFileds.put("lat", Double.parseDouble(values[2]));
                    logFileds.put("lng", Double.parseDouble(values[1]));
//                    logFileds.put("lat", (double) Math.round(Double.parseDouble(values[2]) * 1000000) / 1000000);
//                    logFileds.put("lng", (double) Math.round(Double.parseDouble(values[1]) * 1000000) / 1000000);
                    logBatchData.setTags(logTags);
                    logBatchData.setFields(logFileds);
                    logBatchData.setTable("DensityLog");
                    logBatchData.setTime(time.getTime());
                    logBatchDatas.add(logBatchData);
//                    influxdbUtils.insertAndTime(logTags,"DensityLog",logFileds,time.getTime());
                }
                index++;
            }

            influxdbUtils.batchInsertAndTime(batchDatas);
            influxdbUtils.batchInsertAndTime(logBatchDatas);
            bf.close();
            //插入走航记录
            collectionRecord = new ZhCollectRecord();
            collectionRecord.setDeviceCode(deviceCode);
            collectionRecord.setStartTime(startTime);
            collectionRecord.setEndTime(endTime);
            collectionRecord.setFactorCount(names.length-3);
            collectionRecord.setPointName(pointname);
            collectRecordMapper.insertCollectRecord(collectionRecord);
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
//        catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        } catch (ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
        return collectionRecord.getId();
    }

    @Override
    @Transactional
    public List<Long> importListData(String deviceCode, List<MultipartFile> files, String pointname) {
        List<Long> ids=new ArrayList<>();
        for (MultipartFile file: files) {
            Date startTime = null;
            Date endTime = null;
            List<BatchData> batchDatas = new ArrayList<>();
            List<BatchData> logBatchDatas = new ArrayList<>();
            ZhCollectRecord collectionRecord=null;
            try {
                BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream(), "GBK"));
                String temp = null;
                int index = 1;
                // 按行读取字符串
                String[] names = null;
                while ((temp = bf.readLine()) != null) {
                    if(temp.isEmpty()){
                        continue;
                    }
                    //标题
                    if (index == 1) {
                        names = temp.split(";");
                    } else {
                        //浓度值
                        String[] values = temp.split(";");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date time = sdf.parse(values[0]);
                        for (int i = 3; i < values.length; i++) {
                            BatchData batchData = new BatchData();
                            Map<String, String> tags = new HashMap<>(5);
                            tags.put("code", deviceCode);
                            tags.put("name", names[i]);
                            Map<String, Object> fileds = new HashMap<>(4);
                            fileds.put("value", Double.parseDouble(values[i]));
                            startTime = startTime == null ? time : startTime;
                            endTime = endTime == null ? time : endTime;
                            if (startTime.getTime() > time.getTime()) {
                                startTime = time;
                            }
                            if (endTime.getTime() < time.getTime()) {
                                endTime = time;
                            }
                            batchData.setTags(tags);
                            batchData.setFields(fileds);
                            batchData.setTime(time.getTime());
                            batchData.setTable("DensityRealtime");
                            batchDatas.add(batchData);
                        }
                        BatchData logBatchData = new BatchData();
                        Map<String, String> logTags = new HashMap<>();
                        logTags.put("code", deviceCode);
                        Map<String, Object> logFileds = new HashMap<>();
                        logFileds.put("lat", Double.parseDouble(values[2]));
                        logFileds.put("lng", Double.parseDouble(values[1]));
                        logBatchData.setTags(logTags);
                        logBatchData.setFields(logFileds);
                        logBatchData.setTable("DensityLog");
                        logBatchData.setTime(time.getTime());
                        logBatchDatas.add(logBatchData);
                    }
                    index++;
                }
                bf.close();

                influxdbUtils.batchInsertAndTime(batchDatas);
                influxdbUtils.batchInsertAndTime(logBatchDatas);

                //插入走航记录
                collectionRecord = new ZhCollectRecord();
                collectionRecord.setDeviceCode(deviceCode);
                collectionRecord.setStartTime(startTime);
                collectionRecord.setEndTime(endTime);
                collectionRecord.setFactorCount(names.length-3);
                collectionRecord.setPointName(pointname);
                collectRecordMapper.insertCollectRecord(collectionRecord);
                ids.add(collectionRecord.getId());
            }catch (Exception e) {
                log.error(e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return null;
            }
        }
        return ids;
    }

    @Override
    public List<ZhCollectRecordDto> readListData(String deviceCode, List<MultipartFile> files, String pointname) {
        List<ZhCollectRecordDto> collectRecordDtos=new ArrayList<>();
        String jar_parent_path="";
        try {
            jar_parent_path = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String rootPath=jar_parent_path+File.separator+"importData"+File.separator+DateUtils.getDate();
        File fileRoot=new File(rootPath);
        if(!fileRoot.exists()){
            fileRoot.mkdirs();
        }
        for (MultipartFile file: files) {
            ZhFile zhFile=new ZhFile();
            List<String> datas=new ArrayList<>();
            //文件名
            String fileOldName=file.getOriginalFilename();
            //文件后缀名
            String suffix = fileOldName.substring(fileOldName.lastIndexOf(".") + 1);
            String fileNewName=IdUtils.fastSimpleUUID()+ "." +suffix;
            String filePath=rootPath+File.separator+fileNewName;
            zhFile.setFileName(fileOldName);
            zhFile.setPath(filePath);
            zhFile.setSize(file.getSize());
//            zhFile.setCreateBy(DateUtils.getTime());
//            zhFile.setCreateBy(sysUser.getCreateBy());
            //保存本地文件
            File fileLocal=new File(filePath);

            try {
                file.transferTo(fileLocal);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
            Date startTime = null;
            Date endTime = null;
            ZhCollectRecord collectionRecord=null;

            try {
//                BufferedReader bf = new BufferedReader(new InputStreamReader(file.getInputStream(), "GBK"));
                BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(fileLocal), "GBK"));
                String temp = null;
                int index = 1;
                // 按行读取字符串
                String[] names = null;
                while ((temp = bf.readLine()) != null) {
                    if(temp.isEmpty()){
                        continue;
                    }
                    datas.add(temp);
                    //标题
                    if (index == 1) {
                        names = temp.split(";");
                    } else {
                        //浓度值
                        String[] values = temp.split(";");
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date time = sdf.parse(values[0]);
                        //判断起始时间
                        startTime = startTime == null ? time : startTime;
                        endTime = endTime == null ? time : endTime;
                        if (startTime.getTime() > time.getTime()) {
                            startTime = time;
                        }
                        if (endTime.getTime() < time.getTime()) {
                            endTime = time;
                        }
                    }
                    index++;
                }
                bf.close();
                //插入走航记录
                collectionRecord = new ZhCollectRecord();
                collectionRecord.setDeviceCode(deviceCode);
                collectionRecord.setStartTime(startTime);
                collectionRecord.setEndTime(endTime);
                collectionRecord.setFactorCount(names.length-3);
                collectionRecord.setPointName(pointname);
                collectRecordMapper.insertCollectRecord(collectionRecord);
                zhFile.setCollectRecordId(collectionRecord.getId());
                ZhCollectRecordDto zhCollectRecordDto=new ZhCollectRecordDto(collectionRecord);
                zhCollectRecordDto.setDatas(datas);
                zhCollectRecordDto.setZhFile(zhFile);
                collectRecordDtos.add(zhCollectRecordDto);
                //走航文件
                int i = zhFileService.insertZhFile(zhFile);
            }catch (Exception e) {
                log.error(e.getMessage());
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return null;
            }
        }
        return collectRecordDtos;
    }

    @Override
    public ZhCollectRecordDto getPointsById(Long id) {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        ZhCollectRecord zhCollectRecord = collectRecordMapper.selectCollectRecordById(id);
        if(zhCollectRecord==null){
            return null;
        }
        ZhCollectRecordDto zhCollectRecordDto=new ZhCollectRecordDto(zhCollectRecord);
        DensityDto densityDto=new DensityDto();
        densityDto.setCode(zhCollectRecord.getDeviceCode());
        densityDto.setStartDate(sim.format(zhCollectRecord.getStartTime()));
        if(zhCollectRecord.getEndTime()!=null){
            densityDto.setEndDate(sim.format(zhCollectRecord.getEndTime()));
        }
        List<DensityVo> densityVos = searchMic(densityDto);
        zhCollectRecordDto.setPoints(densityVos);
        return zhCollectRecordDto;
    }

    @Override
    public List<ZhCollectRecordDto> getPointsStrByIds(Long[] ids) {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ZhCollectRecordDto> zhCollectRecordDtos=new ArrayList<>();
        List<ZhCollectRecord> zhCollectRecords = collectRecordMapper.selectCollectRecordByIds(ids);
        if(zhCollectRecords==null||zhCollectRecords.size()<=0){
            return zhCollectRecordDtos;
        }
        for (ZhCollectRecord zhCollectRecord: zhCollectRecords) {
            ZhCollectRecordDto zhCollectRecordDto=new ZhCollectRecordDto(zhCollectRecord);
            DensityDto densityDto=new DensityDto();
            densityDto.setCode(zhCollectRecord.getDeviceCode());
            densityDto.setStartDate(sim.format(zhCollectRecord.getStartTime()));
            if(zhCollectRecord.getEndTime()!=null){
                densityDto.setEndDate(sim.format(zhCollectRecord.getEndTime()));
            }
            List<String> datas = searchStrMic(densityDto);
            zhCollectRecordDto.setDatas(datas);
            zhCollectRecordDtos.add(zhCollectRecordDto);
        }
        return zhCollectRecordDtos;
    }

    @Override
    public List<ZhCollectRecordDto> getPointsByIds(Long[] ids) {
        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<ZhCollectRecordDto> zhCollectRecordDtos=new ArrayList<>();
        List<ZhCollectRecord> zhCollectRecords = collectRecordMapper.selectCollectRecordByIds(ids);
        if(zhCollectRecords==null||zhCollectRecords.size()<=0){
            return zhCollectRecordDtos;
        }
        for (ZhCollectRecord zhCollectRecord: zhCollectRecords) {
            ZhCollectRecordDto zhCollectRecordDto=new ZhCollectRecordDto(zhCollectRecord);
            DensityDto densityDto=new DensityDto();
            densityDto.setCode(zhCollectRecord.getDeviceCode());
            densityDto.setStartDate(sim.format(zhCollectRecord.getStartTime()));
            if(zhCollectRecord.getEndTime()!=null){
                densityDto.setEndDate(sim.format(zhCollectRecord.getEndTime()));
            }
            List<DensityVo> datas = searchMic(densityDto);
            zhCollectRecordDto.setPoints(datas);
            zhCollectRecordDtos.add(zhCollectRecordDto);
        }
        return zhCollectRecordDtos;
    }

    @Override
    public String exportData(Long id) {
        String profile = RuoYiConfig.getDownloadPath();
        ZhCollectRecordDto pointsById = getPointsById(id);
        if(pointsById==null){
            return null;
        }
        List<DensityVo> points = pointsById.getPoints();
        SimpleDateFormat sdfday=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfhour=new SimpleDateFormat("HH：mm：ss");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timestr="-"+pointsById.getPointName()+sdfday.format(pointsById.getStartTime())+"("+sdfhour.format(pointsById.getStartTime())+"-";
        if(pointsById.getEndTime()==null){
            timestr+=sdfhour.format(new Date());
        }else{
            timestr+=sdfhour.format(pointsById.getEndTime());
        }
        timestr+=")"+".txt";
//        String fileName=pointsById.getPointName()+"走航"+sdf.format(pointsById.getStartTime())+".txt";
        String fileName=timestr;
        createFileName(points,fileName);
//        BufferedWriter fileWriter = null;
//        try {
//            fileWriter=new BufferedWriter (new OutputStreamWriter (new FileOutputStream (profile+""+fileName,true),"GBK"));
////            fileWriter = new FileWriter(profile+"/"+fileName);//创建文本文件
//            for (int i = 0; i <points.size(); i++) {
//                StringBuffer sb1=new StringBuffer();
//
//                StringBuffer sb=new StringBuffer();
//                sb1.append("时间;经度;纬度;");
//                sb.append(points.get(i).getTime()+";"+points.get(i).getLng()+";"+points.get(i).getLat()+";");
//                int tempindex=0;
//                for (DensityVo.KV value : points.get(i).getValues()) {
//                    sb1.append(value.getName());
//                    sb.append(value.getValue());
//                    if(tempindex<points.get(i).getValues().size()-1){
//                        if(i==0){
//                            sb1.append(";");
//                        }
//                        sb.append(";");
//                    }
//                    tempindex++;
//                }
//                if(i==0){
//                    fileWriter.write(sb1.toString()+"\r\n");//写入 \r\n换行
//                }
//                fileWriter.write(sb.toString()+"\r\n");//写入 \r\n换行
//            }
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return fileName;
    }

    public void createFileName(List<DensityVo> points,String fileName){
        String profile = RuoYiConfig.getDownloadPath();
        File downloaPath=new File(profile);
        if (!downloaPath.exists()) {
            downloaPath.mkdirs();
        }
        SimpleDateFormat sdfday=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfhour=new SimpleDateFormat("HH：mm：ss");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        BufferedWriter fileWriter = null;
        try {
            fileWriter=new BufferedWriter (new OutputStreamWriter (new FileOutputStream (profile+""+fileName,true),"GBK"));
//            fileWriter=new BufferedWriter (new OutputStreamWriter (new FileOutputStream (profile+""+fileName,true),"UTF-8"));
//            fileWriter = new FileWriter(profile+"/"+fileName);//创建文本文件
            for (int i = 0; i <points.size(); i++) {
                StringBuffer sb1=new StringBuffer();

                StringBuffer sb=new StringBuffer();
                sb1.append("时间;经度;纬度;");
                sb.append(points.get(i).getTime()+";"+points.get(i).getLng()+";"+points.get(i).getLat()+";");
                int tempindex=0;
                for (DensityVo.KV value : points.get(i).getValues()) {
                    sb1.append(value.getName());
                    sb.append(value.getValue());
                    if(tempindex<points.get(i).getValues().size()-1){
                        if(i==0){
                            sb1.append(";");
                        }
                        sb.append(";");
                    }
                    tempindex++;
                }
                if(i==0){
                    fileWriter.write(sb1.toString()+"\r\n");//写入 \r\n换行
                }
                if(i<=points.size()-2){
                    fileWriter.write(sb.toString()+"\r\n");//写入 \r\n换行
                }
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public String exportDataByIds(Long[] ids) {
        List<ZhCollectRecordDto> zhCollectRecordDtos = getPointsByIds(ids);
        List<DensityVo> points = new ArrayList<>();
        if(zhCollectRecordDtos==null||zhCollectRecordDtos.size()<=0){
            return "";
        }
//        Set<Integer> sets=new HashSet<>();
        for (int i = 0; i < zhCollectRecordDtos.size(); i++) {
            points.addAll(zhCollectRecordDtos.get(i).getPoints());
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH：mm：ss");
        String fileName="合并文件"+sdf.format(new Date())+".txt";
        createFileName(points,fileName);
        return fileName;
    }

    @Override
    public List<ZhCollectRecord> selectCollectRecordByIds(Long[] ids) {
        if(ids==null){
            return new ArrayList<ZhCollectRecord>();
        }
        return collectRecordMapper.selectCollectRecordByIds(ids);
    }

    @Override
    public void closeRecord() {
        collectRecordMapper.closeRecord();
    }


}
