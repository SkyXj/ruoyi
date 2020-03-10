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
import com.ruoyi.zh.domain.ZhLinkCategoryFactorSimpleColor;
import com.ruoyi.zh.service.IZhLinkCategoryFactorSimpleColorService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 物质因子颜色关联Controller
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@RestController
@RequestMapping("/zh/categoryFactorSimpleColor")
public class ZhLinkCategoryFactorSimpleColorController extends BaseController
{
    @Autowired
    private IZhLinkCategoryFactorSimpleColorService zhLinkCategoryFactorSimpleColorService;

    /**
     * 查询物质因子颜色关联列表
     */
    @PreAuthorize("@ss.hasPermi('zh:categoryFactorSimpleColor:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor)
    {
        startPage();
        List<ZhLinkCategoryFactorSimpleColor> list = zhLinkCategoryFactorSimpleColorService.selectZhLinkCategoryFactorSimpleColorList(zhLinkCategoryFactorSimpleColor);
        return getDataTable(list);
    }

    /**
     * 导出物质因子颜色关联列表
     */
    @PreAuthorize("@ss.hasPermi('zh:categoryFactorSimpleColor:export')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor)
    {
        List<ZhLinkCategoryFactorSimpleColor> list = zhLinkCategoryFactorSimpleColorService.selectZhLinkCategoryFactorSimpleColorList(zhLinkCategoryFactorSimpleColor);
        ExcelUtil<ZhLinkCategoryFactorSimpleColor> util = new ExcelUtil<ZhLinkCategoryFactorSimpleColor>(ZhLinkCategoryFactorSimpleColor.class);
        return util.exportExcel(list, "categoryFactorSimpleColor");
    }

    /**
     * 获取物质因子颜色关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('zh:categoryFactorSimpleColor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhLinkCategoryFactorSimpleColorService.selectZhLinkCategoryFactorSimpleColorById(id));
    }

    /**
     * 新增物质因子颜色关联
     */
    @PreAuthorize("@ss.hasPermi('zh:categoryFactorSimpleColor:add')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor)
    {
        return toAjax(zhLinkCategoryFactorSimpleColorService.insertZhLinkCategoryFactorSimpleColor(zhLinkCategoryFactorSimpleColor));
    }

    /**
     * 修改物质因子颜色关联
     */
    @PreAuthorize("@ss.hasPermi('zh:categoryFactorSimpleColor:edit')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhLinkCategoryFactorSimpleColor zhLinkCategoryFactorSimpleColor)
    {
        return toAjax(zhLinkCategoryFactorSimpleColorService.updateZhLinkCategoryFactorSimpleColor(zhLinkCategoryFactorSimpleColor));
    }

    /**
     * 删除物质因子颜色关联
     */
    @PreAuthorize("@ss.hasPermi('zh:categoryFactorSimpleColor:remove')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhLinkCategoryFactorSimpleColorService.deleteZhLinkCategoryFactorSimpleColorByIds(ids));
    }
}
