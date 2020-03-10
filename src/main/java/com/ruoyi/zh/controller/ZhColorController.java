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
import com.ruoyi.zh.domain.ZhColor;
import com.ruoyi.zh.service.IZhColorService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 颜色Controller
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@RestController
@RequestMapping("/zh/color")
public class ZhColorController extends BaseController
{
    @Autowired
    private IZhColorService zhColorService;

    /**
     * 查询颜色列表
     */
    @PreAuthorize("@ss.hasPermi('zh:color:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhColor zhColor)
    {
        startPage();
        List<ZhColor> list = zhColorService.selectZhColorList(zhColor);
        return getDataTable(list);
    }

    /**
     * 导出颜色列表
     */
    @PreAuthorize("@ss.hasPermi('zh:color:export')")
    @Log(title = "颜色", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhColor zhColor)
    {
        List<ZhColor> list = zhColorService.selectZhColorList(zhColor);
        ExcelUtil<ZhColor> util = new ExcelUtil<ZhColor>(ZhColor.class);
        return util.exportExcel(list, "color");
    }

    /**
     * 获取颜色详细信息
     */
    @PreAuthorize("@ss.hasPermi('zh:color:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhColorService.selectZhColorById(id));
    }

    /**
     * 新增颜色
     */
    @PreAuthorize("@ss.hasPermi('zh:color:add')")
    @Log(title = "颜色", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhColor zhColor)
    {
        return toAjax(zhColorService.insertZhColor(zhColor));
    }

    /**
     * 修改颜色
     */
    @PreAuthorize("@ss.hasPermi('zh:color:edit')")
    @Log(title = "颜色", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhColor zhColor)
    {
        return toAjax(zhColorService.updateZhColor(zhColor));
    }

    /**
     * 删除颜色
     */
    @PreAuthorize("@ss.hasPermi('zh:color:remove')")
    @Log(title = "颜色", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhColorService.deleteZhColorByIds(ids));
    }
}
