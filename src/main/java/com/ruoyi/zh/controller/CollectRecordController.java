package com.ruoyi.zh.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.mina.DensityVo;
import com.ruoyi.mina.handler.MsgHandler;
import com.ruoyi.zh.domain.TestExcel;
import com.ruoyi.zh.dto.DensityDto;
import com.ruoyi.zh.dto.ZhCollectRecordDto;
import io.swagger.annotations.ApiOperation;
import org.aspectj.weaver.loadtime.Aj;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.service.ICollectRecordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 走航记录Controller
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@RestController
@RequestMapping("/zh/collectRecord")
public class CollectRecordController extends BaseController
{
    @Autowired
    private ICollectRecordService zhCollectRecordService;

    /**
     * 查询走航记录列表
     */
//    @PreAuthorize("@ss.hasPermi('zh:collectRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhCollectRecord zhCollectRecord)
    {
        startPage();
        List<ZhCollectRecord> list = zhCollectRecordService.selectCollectRecordList(zhCollectRecord);
        return getDataTable(list);
    }

    @GetMapping("/selectByIds")
    public TableDataInfo selectByIds(Long[] ids)
    {
        startPage();
        List<ZhCollectRecord> list = zhCollectRecordService.selectCollectRecordByIds(ids);
        return getDataTable(list);
    }

    /**
     * 导出走航记录列表
     */
//    @PreAuthorize("@ss.hasPermi('zh:collectRecord:export')")
    @Log(title = "走航记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhCollectRecord zhCollectRecord)
    {
        List<ZhCollectRecord> list = zhCollectRecordService.selectCollectRecordList(zhCollectRecord);
        ExcelUtil<ZhCollectRecord> util = new ExcelUtil<ZhCollectRecord>(ZhCollectRecord.class);
        return util.exportExcel(list, "collectRecord");
    }

    @Log(title = "根据id导出走航记录", businessType = BusinessType.EXPORT)
    @GetMapping("/exportByIds/{ids}")
    public AjaxResult exportByIds(@PathVariable(value = "ids")Long[] ids)
    {
        AjaxResult ajaxResult=AjaxResult.success(zhCollectRecordService.exportDataByIds(ids));
        return  ajaxResult;
    }

    /**
     * 获取走航记录详细信息
     */
//    @PreAuthorize("@ss.hasPermi('zh:collectRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhCollectRecordService.selectCollectRecordById(id));
    }

    /**
     * 新增走航记录
     */
//    @PreAuthorize("@ss.hasPermi('zh:collectRecord:add')")
    @Log(title = "走航记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhCollectRecord zhCollectRecord)
    {
        return toAjax(zhCollectRecordService.insertCollectRecord(zhCollectRecord));
    }

    /**
     * 修改走航记录
     */
//    @PreAuthorize("@ss.hasPermi('zh:collectRecord:edit')")
    @Log(title = "走航记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhCollectRecord zhCollectRecord)
    {
        return toAjax(zhCollectRecordService.updateCollectRecord(zhCollectRecord));
    }

    /**
     * 删除走航记录
     */
//    @PreAuthorize("@ss.hasPermi('zh:collectRecord:remove')")
    @Log(title = "走航记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhCollectRecordService.deleteCollectRecordByIds(ids));
    }

    @PostMapping("/searchMic")
    @ApiOperation("查询走航点数据")
    @ResponseBody
    public AjaxResult search(@RequestBody DensityDto densityDto) {
        List<DensityVo> search = zhCollectRecordService.searchMic(densityDto);
        ExcelUtil<TestExcel> excelExcelUtil=new ExcelUtil<>(TestExcel.class);
        List<TestExcel> list = TestExcel.getList(search);
        AjaxResult ajaxResult=excelExcelUtil.exportExcel(list,"走航");
        return ajaxResult;
    }

    @GetMapping("/getRecently")
    @ApiOperation("查询最后一次走航")
    public AjaxResult getRecently() {
        ZhCollectRecordDto zhCollectRecordDto = zhCollectRecordService.getRecently();
//        if(zhCollectRecordDto==null){
//            return AjaxResult.success(new ArrayList<DensityVo>());
//        }
//        DensityDto densityDto=new DensityDto();
//        SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        densityDto.setStartDate(sim.format(zhCollectRecordDto.getStartTime()));
//        List<DensityVo> search = zhCollectRecordService.searchMic(densityDto);
        return AjaxResult.success(zhCollectRecordDto);
    }

    @PostMapping("/importData")
    @ApiOperation("导入历史走航数据")
    public AjaxResult importData(@RequestParam(value="file") List<MultipartFile> files,
                                 @RequestParam(value="deviceCode") String deviceCode,
                                 @RequestParam(value="pointname") String pointname){
        AjaxResult ajaxResult=AjaxResult.success(zhCollectRecordService.importListData(deviceCode,files,pointname));
        return  ajaxResult;
    }

    @GetMapping("/getPointsById")
    @ApiOperation("查询最后一次走航")
    public AjaxResult getPointsById(@RequestParam(value="id") Long id) {
        AjaxResult ajaxResult=AjaxResult.success(zhCollectRecordService.getPointsById(id));
        return  ajaxResult;
    }

    @GetMapping("/getPointsByIds/{ids}")
    @ApiOperation("查询最后一次走航")
    public AjaxResult getPointsByIds(@PathVariable(value="ids") Long[] ids) {
        AjaxResult ajaxResult=AjaxResult.success(zhCollectRecordService.getPointsStrByIds(ids));
        return  ajaxResult;
    }

    @GetMapping("/exportData")
    @ApiOperation("导出历史走航数据")
    public AjaxResult exportData(@RequestParam(value="id") Long id){
        AjaxResult ajaxResult=AjaxResult.success(zhCollectRecordService.exportData(id));
        return  ajaxResult;
    }

    @GetMapping("/closeRecord")
    @ApiOperation("关闭走航记录")
    public AjaxResult closeRecord(){
        zhCollectRecordService.closeRecord();
        AjaxResult ajaxResult=AjaxResult.success();
        return  ajaxResult;
    }
}
