package com.ruoyi.zh.controller;

import java.util.List;

import com.ruoyi.zh.dto.ZhCategoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.zh.domain.ZhCategory;
import com.ruoyi.zh.service.IZhCategoryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 颜色标准Controller
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@RestController
@RequestMapping("/zh/category")
@Api(tags = "颜色标准")
public class ZhCategoryController extends BaseController
{
    @Autowired
    private IZhCategoryService zhCategoryService;

    /**
     * 查询颜色标准列表
     */
//    @PreAuthorize("@ss.hasPermi('zh:category:list')")
    @GetMapping("/list")
    @ApiOperation("色标准列表(分页)")
    public TableDataInfo list(ZhCategory zhCategory)
    {
        startPage();
        List<ZhCategory> list = zhCategoryService.selectZhCategoryList(zhCategory);
        return getDataTable(list);
    }

    @GetMapping("/all")
    @ApiOperation("获取所有标准")
    public AjaxResult all()
    {
        List<ZhCategoryDto> list = zhCategoryService.getAll(null);
        return AjaxResult.success(list);
    }

    @GetMapping("/exportByIds/{ids}")
    @ApiOperation("导出标准")
    public AjaxResult exportByIds(@PathVariable Long[] ids)
    {
        return zhCategoryService.exportByIds(ids);
//        return AjaxResult.success(filename);
    }

    @PostMapping("/importData")
    @ApiOperation("导入标准")
    public AjaxResult importData(@RequestParam(value="files") List<MultipartFile> files)
    {
        return zhCategoryService.importData(files);
    }

    /**
     * 导出颜色标准列表
     */
    @PreAuthorize("@ss.hasPermi('zh:category:export')")
    @Log(title = "颜色标准", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhCategory zhCategory)
    {
        List<ZhCategory> list = zhCategoryService.selectZhCategoryList(zhCategory);
        ExcelUtil<ZhCategory> util = new ExcelUtil<ZhCategory>(ZhCategory.class);
        return util.exportExcel(list, "category");
    }

    /**
     * 获取颜色标准详细信息
     */
    @PreAuthorize("@ss.hasPermi('zh:category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhCategoryService.selectZhCategoryById(id));
    }

    /**
     * 新增颜色标准
     */
    @PreAuthorize("@ss.hasPermi('zh:category:add')")
    @Log(title = "颜色标准", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhCategory zhCategory)
    {
        return toAjax(zhCategoryService.insertZhCategory(zhCategory));
    }

    /**
     * 修改颜色标准
     */
//    @PreAuthorize("@ss.hasPermi('zh:category:edit')")
    @Log(title = "颜色标准", businessType = BusinessType.UPDATE)
    @PutMapping
    @ApiOperation("修改标准名称")
    public AjaxResult edit(@RequestBody ZhCategory zhCategory)
    {
        return toAjax(zhCategoryService.updateZhCategory(zhCategory));
    }

    /**
     * 删除颜色标准
     */
    @PreAuthorize("@ss.hasPermi('zh:category:remove')")
    @Log(title = "颜色标准", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhCategoryService.deleteZhCategoryByIds(ids));
    }

    /**
     * 当前标准每个物质的颜色
     */
//    @PreAuthorize("@ss.hasPermi('zh:category:remove')")
    @GetMapping(value = "/factorColor/{id}")
    @ApiOperation("根据标准id列出所有物质颜色")
    public AjaxResult getCategoryFactors(@PathVariable("id") Long id){
        AjaxResult ajaxResult=AjaxResult.success(zhCategoryService.getCategoryFactors(id));
        return ajaxResult;
    }
}
