package com.ruoyi.zh.controller;

import java.util.List;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.zh.domain.ZhCategory;
import com.ruoyi.zh.service.IZhCategoryService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 颜色标准Controller
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@RestController
@RequestMapping("/zh/category")
public class ZhCategoryController extends BaseController
{
    @Autowired
    private IZhCategoryService zhCategoryService;

    /**
     * 查询颜色标准列表
     */
    @PreAuthorize("@ss.hasPermi('zh:category:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhCategory zhCategory)
    {
        startPage();
        List<ZhCategory> list = zhCategoryService.selectZhCategoryList(zhCategory);
        return getDataTable(list);
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
    @PreAuthorize("@ss.hasPermi('zh:category:edit')")
    @Log(title = "颜色标准", businessType = BusinessType.UPDATE)
    @PutMapping
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
}
