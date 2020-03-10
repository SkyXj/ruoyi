package com.ruoyi.zh.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.mina.handler.MsgHandler;
import com.ruoyi.zh.domain.TestExcel;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("cesium")
@RestController
public class CesiumController {

    @GetMapping("export")
    @ApiOperation("导出")
    public AjaxResult export(){
        ExcelUtil<TestExcel> excelExcelUtil=new ExcelUtil<>(TestExcel.class);
        List<TestExcel> list = TestExcel.getList(MsgHandler.list);
        AjaxResult ajaxResult=excelExcelUtil.exportExcel(list,"test");
        return ajaxResult;
    }


    @GetMapping("testData")
    @ApiOperation("测试数据")
    public AjaxResult testData(){
        AjaxResult ajaxResult=AjaxResult.success(MsgHandler.list);
        return ajaxResult;
    }


}
