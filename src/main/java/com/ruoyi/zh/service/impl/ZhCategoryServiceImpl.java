package com.ruoyi.zh.service.impl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.zh.domain.*;
import com.ruoyi.zh.dto.ZhCategoryDto;
import com.ruoyi.zh.dto.ZhFactorDto;
import com.ruoyi.zh.mapper.*;
import com.ruoyi.zh.service.IZhLinkCategoryFactorSimpleColorService;
import com.ruoyi.zh.tool.UserInfoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.service.IZhCategoryService;
import org.springframework.web.multipart.MultipartFile;

/**
 * 颜色标准Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@Service
@Slf4j
public class ZhCategoryServiceImpl implements IZhCategoryService 
{
    @Autowired
    private ZhCategoryMapper zhCategoryMapper;

    @Autowired
    private ZhFactorMapper zhFactorMapper;

    @Autowired
    private ZhLinkCategoryFactorColorMapper zhLinkCategoryFactorColorMapper;

    @Autowired
    private ZhLinkCategoryFactorSimpleColorMapper zhLinkCategoryFactorSimpleColorMapper;

    @Autowired
    private ZhColorMapper zhColorMapper;

    /**
     * 查询颜色标准
     * 
     * @param id 颜色标准ID
     * @return 颜色标准
     */
    @Override
    public ZhCategory selectZhCategoryById(Long id)
    {
        return zhCategoryMapper.selectZhCategoryById(id);
    }


    @Override
    public AjaxResult exportByIds(Long[] ids)
    {
        String profile = RuoYiConfig.getDownloadPath();
        File downloaPath = new File(profile);
        if (!downloaPath.exists()) {
            downloaPath.mkdirs();
        }
        List<ZhCategory> zhCategories = zhCategoryMapper.getCategoryByIds(ids);
        List<ZhCategoryDto> result=new ArrayList<>();
        if(zhCategories==null||zhCategories.size()<=0){
            return AjaxResult.error();
        }
        for (ZhCategory category:zhCategories) {
            ZhCategoryDto zhCategoryDto=new ZhCategoryDto();
            Long id = category.getId();
            zhCategoryDto.setId(id);
            zhCategoryDto.setName(category.getName());
            ZhLinkCategoryFactorColor categoryFactorColor=new ZhLinkCategoryFactorColor();
            categoryFactorColor.setCategoryId(id);
            List<ZhLinkCategoryFactorColor> zhLinkCategoryFactorColors = zhLinkCategoryFactorColorMapper.selectZhLinkCategoryFactorColorList(categoryFactorColor);
            if(zhLinkCategoryFactorColors==null||zhLinkCategoryFactorColors.size()<=0){
                continue;
            }
            List<ZhFactorDto> zhFactorDtos=new ArrayList<>();
            for (ZhLinkCategoryFactorColor color: zhLinkCategoryFactorColors) {
                ZhFactorDto zhFactorDto=new ZhFactorDto();
                ZhLinkCategoryFactorSimpleColor cer=new ZhLinkCategoryFactorSimpleColor();
                cer.setFactorName(color.getFactorName());
                cer.setCategoryId(id);

                zhFactorDto.setColorStr(color.getColorStr());
                zhFactorDto.setName(color.getFactorName());
                zhFactorDto.setId(color.getId());

                List<ZhLinkCategoryFactorSimpleColor> zhLinkCategoryFactorSimpleColors = zhLinkCategoryFactorSimpleColorMapper.selectZhLinkCategoryFactorSimpleColorList(cer);
                if(zhLinkCategoryFactorSimpleColors==null||zhLinkCategoryFactorSimpleColors.size()<=0){
                    zhFactorDtos.add(zhFactorDto);
                    continue;
                }
                ZhLinkCategoryFactorSimpleColor color1 = zhLinkCategoryFactorSimpleColors.get(0);
                zhFactorDto.setSimpleColorJson(color1.getSimpleColorJson());
                zhFactorDto.setThreshold(color1.getThreshold());
                zhFactorDtos.add(zhFactorDto);
            }
            zhCategoryDto.setFactors(zhFactorDtos);
            result.add(zhCategoryDto);
        }
        BufferedWriter bufferedWriter=null;
        String filename=System.currentTimeMillis()+".txt";
        String filePath=profile+filename;
        try {
            bufferedWriter=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(filePath)),"GBK"));
            for (int i = 0; i < result.size(); i++) {
                String str = JSONObject.toJSONString(result.get(i));
                bufferedWriter.write(str);
                if(i<result.size()-1){
                    //写入 \r\n换行
                    bufferedWriter.write("\r\n");
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            log.error("导出文件发生错误："+e.getMessage());
        }
        return AjaxResult.success(filename);
    }
    /**
     * 查询颜色标准列表
     * 
     * @param zhCategory 颜色标准
     * @return 颜色标准
     */
    @Override
    public List<ZhCategory> selectZhCategoryList(ZhCategory zhCategory)
    {
        zhCategory.setCreateBy(UserInfoUtil.getUserName());
        return zhCategoryMapper.selectZhCategoryList(zhCategory);
    }

    @Override
    public List<ZhCategoryDto> getAll(ZhCategory zhCategory) {
        zhCategory=new ZhCategory();
        zhCategory.setCreateBy(UserInfoUtil.getUserName());
        List<ZhCategory> zhCategories = zhCategoryMapper.selectZhCategoryList(zhCategory);
        List<ZhCategoryDto> result=new ArrayList<>();
        if(zhCategories==null||zhCategories.size()<=0){
            return new ArrayList<ZhCategoryDto>();
        }
        for (ZhCategory category:zhCategories ) {
            ZhCategoryDto zhCategoryDto=new ZhCategoryDto();
            Long id = category.getId();
            zhCategoryDto.setId(id);
            zhCategoryDto.setName(category.getName());
            ZhLinkCategoryFactorColor categoryFactorColor=new ZhLinkCategoryFactorColor();
            categoryFactorColor.setCategoryId(id);
            List<ZhLinkCategoryFactorColor> zhLinkCategoryFactorColors = zhLinkCategoryFactorColorMapper.selectZhLinkCategoryFactorColorList(categoryFactorColor);
            if(zhLinkCategoryFactorColors==null||zhLinkCategoryFactorColors.size()<=0){
                continue;
            }
            List<ZhFactorDto> zhFactorDtos=new ArrayList<>();
            for (ZhLinkCategoryFactorColor color: zhLinkCategoryFactorColors) {
                ZhFactorDto zhFactorDto=new ZhFactorDto();
                ZhLinkCategoryFactorSimpleColor cer=new ZhLinkCategoryFactorSimpleColor();
                cer.setFactorName(color.getFactorName());
                cer.setCategoryId(id);

                zhFactorDto.setColorStr(color.getColorStr());
                zhFactorDto.setName(color.getFactorName());
                zhFactorDto.setId(color.getId());


                List<ZhLinkCategoryFactorSimpleColor> zhLinkCategoryFactorSimpleColors = zhLinkCategoryFactorSimpleColorMapper.selectZhLinkCategoryFactorSimpleColorList(cer);
                if(zhLinkCategoryFactorSimpleColors==null||zhLinkCategoryFactorSimpleColors.size()<=0){
                    zhFactorDtos.add(zhFactorDto);
                    continue;
                }
                ZhLinkCategoryFactorSimpleColor color1 = zhLinkCategoryFactorSimpleColors.get(0);
                zhFactorDto.setSimpleColorJson(color1.getSimpleColorJson());
                zhFactorDto.setThreshold(color1.getThreshold());
                zhFactorDtos.add(zhFactorDto);
            }
            zhCategoryDto.setFactors(zhFactorDtos);
            result.add(zhCategoryDto);
        }
        return result;
    }

    @Override
    public AjaxResult importData(List<MultipartFile> files) {
        try {
            if(files==null||files.size()<=0){
                return AjaxResult.error("文件为空");
            }
            List<ZhCategoryDto> zhCategoryDtos=new ArrayList<>();
            for (MultipartFile file: files) {
                try {
                    BufferedReader buff=new BufferedReader(new InputStreamReader(file.getInputStream(),"GBK"));
                    String temp=null;
                    while ((temp=buff.readLine())!=null){
                        ZhCategoryDto zhCategoryDto = JSONObject.parseObject(temp, ZhCategoryDto.class);
                        zhCategoryDtos.add(zhCategoryDto);
                    }

                } catch (IOException e) {
                    return AjaxResult.error("格式错误");
                }
            }
            if(zhCategoryDtos==null||zhCategoryDtos.size()<=0){
                return AjaxResult.error("无数据");
            }
            for (ZhCategoryDto zhCategoryDto : zhCategoryDtos) {
                ZhCategory zhCategory=new ZhCategory();
                zhCategory.setName(zhCategoryDto.getName());

                zhCategory.setCreateTime(DateUtils.getNowDate());
                zhCategory.setCreateBy(UserInfoUtil.getUserName());

                int i = zhCategoryMapper.insertZhCategory(zhCategory);
                List<ZhFactorDto> factors = zhCategoryDto.getFactors();
                if(factors==null||factors.size()==0){
                    continue;
                }
                for (ZhFactorDto factorDto : factors) {
                    ZhLinkCategoryFactorColor zhLinkCategoryFactorColor=new ZhLinkCategoryFactorColor();
                    zhLinkCategoryFactorColor.setFactorName(factorDto.getName());
                    zhLinkCategoryFactorColor.setCategoryId(zhCategory.getId());
                    zhLinkCategoryFactorColor.setColorStr(factorDto.getColorStr());

                    zhLinkCategoryFactorColor.setCreateTime(DateUtils.getNowDate());
                    zhLinkCategoryFactorColor.setCreateBy(UserInfoUtil.getUserName());

                    int i1 = zhLinkCategoryFactorColorMapper.insertZhLinkCategoryFactorColor(zhLinkCategoryFactorColor);
                    if(StringUtils.isBlank(factorDto.getSimpleColorJson())){
                        continue;
                    }
                    ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor=new ZhLinkCategoryFactorSimpleColor();
                    zhLinkCategoryFactorSimpleColor.setCategoryId(zhCategory.getId());
                    zhLinkCategoryFactorSimpleColor.setFactorName(factorDto.getName());
                    zhLinkCategoryFactorSimpleColor.setSimpleColorJson(factorDto.getSimpleColorJson());
                    zhLinkCategoryFactorSimpleColor.setThreshold(factorDto.getThreshold());

                    zhLinkCategoryFactorSimpleColor.setCreateTime(DateUtils.getNowDate());
                    zhLinkCategoryFactorSimpleColor.setCreateBy(UserInfoUtil.getUserName());
                    int i2 = zhLinkCategoryFactorSimpleColorMapper.insertZhLinkCategoryFactorSimpleColor(zhLinkCategoryFactorSimpleColor);
                }
            }
            return AjaxResult.success();
        } catch (Exception e) {
            log.error(e.getMessage());
            return AjaxResult.error();
        }
    }


    /**
     * 新增颜色标准
     * 
     * @param zhCategory 颜色标准
     * @return 结果
     */
    @Override
    public int insertZhCategory(ZhCategory zhCategory)
    {
        zhCategory.setCreateTime(DateUtils.getNowDate());
        zhCategory.setCreateBy(UserInfoUtil.getUserName());
        return zhCategoryMapper.insertZhCategory(zhCategory);
    }

    /**
     * 修改颜色标准
     * 
     * @param zhCategory 颜色标准
     * @return 结果
     */
    @Override
    public int updateZhCategory(ZhCategory zhCategory)
    {
        zhCategory.setUpdateTime(DateUtils.getNowDate());
        zhCategory.setUpdateBy(UserInfoUtil.getUserName());
        return zhCategoryMapper.updateZhCategory(zhCategory);
    }

    /**
     * 批量删除颜色标准
     * 
     * @param ids 需要删除的颜色标准ID
     * @return 结果
     */
    @Override
    public int deleteZhCategoryByIds(Long[] ids)
    {
        return zhCategoryMapper.deleteZhCategoryByIds(ids);
    }

    @Override
    public List<ZhCategory> getCategoryByIds(Long[] ids)
    {
        return zhCategoryMapper.getCategoryByIds(ids);
    }

    /**
     * 删除颜色标准信息
     * 
     * @param id 颜色标准ID
     * @return 结果
     */
    @Override
    public int deleteZhCategoryById(Long id)
    {
        return zhCategoryMapper.deleteZhCategoryById(id);
    }

    @Override
    public ZhCategoryDto getCategoryFactors(Long id) {
        ZhCategory zhCategory = zhCategoryMapper.selectZhCategoryById(id);
        //返回结果
        ZhCategoryDto zhCategoryDto=new ZhCategoryDto(zhCategory);
        List<ZhFactorDto> zhFactorDtos=new ArrayList<>();
        //关联表
        ZhLinkCategoryFactorColor zhLinkCategoryFactorColor=new ZhLinkCategoryFactorColor();
        zhLinkCategoryFactorColor.setCategoryId(id);
        //关联表
        List<ZhLinkCategoryFactorColor> zhLinkCategoryFactorColors = zhLinkCategoryFactorColorMapper.selectZhLinkCategoryFactorColorList(zhLinkCategoryFactorColor);
        if(zhLinkCategoryFactorColors==null||zhLinkCategoryFactorColors.size()<=0){
            return  zhCategoryDto;
        }
        for (ZhLinkCategoryFactorColor linkCategoryFactorColor: zhLinkCategoryFactorColors) {
//            ZhFactor zhFactor = zhFactorMapper.selectZhFactorById(linkCategoryFactorColor.getFactorId());
//            ZhColor zhColor = zhColorMapper.selectZhColorById(linkCategoryFactorColor.getColorId());
//            ZhFactorDto zhFactorDto=new ZhFactorDto(zhFactor,zhColor);
//            zhFactorDtos.add(zhFactorDto);
        }
        zhCategoryDto.setFactors(zhFactorDtos);
        return zhCategoryDto;
    }
}
