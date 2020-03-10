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
import com.ruoyi.zh.domain.ZhSimpleColor;
import com.ruoyi.zh.service.IZhSimpleColorService;
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
@RequestMapping("/zh/simpleColor")
public class ZhSimpleColorController extends BaseController
{
    @Autowired
    private IZhSimpleColorService zhSimpleColorService;

    /**
     * 查询物质因子颜色关联列表
     */
    @PreAuthorize("@ss.hasPermi('zh:simpleColor:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhSimpleColor zhSimpleColor)
    {
        startPage();
        List<ZhSimpleColor> list = zhSimpleColorService.selectZhSimpleColorList(zhSimpleColor);
        return getDataTable(list);
    }

    /**
     * 导出物质因子颜色关联列表
     */
    @PreAuthorize("@ss.hasPermi('zh:simpleColor:export')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhSimpleColor zhSimpleColor)
    {
        List<ZhSimpleColor> list = zhSimpleColorService.selectZhSimpleColorList(zhSimpleColor);
        ExcelUtil<ZhSimpleColor> util = new ExcelUtil<ZhSimpleColor>(ZhSimpleColor.class);
        return util.exportExcel(list, "simpleColor");
    }

    /**
     * 获取物质因子颜色关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('zh:simpleColor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhSimpleColorService.selectZhSimpleColorById(id));
    }

    /**
     * 新增物质因子颜色关联
     */
    @PreAuthorize("@ss.hasPermi('zh:simpleColor:add')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhSimpleColor zhSimpleColor)
    {
        return toAjax(zhSimpleColorService.insertZhSimpleColor(zhSimpleColor));
    }

    /**
     * 修改物质因子颜色关联
     */
    @PreAuthorize("@ss.hasPermi('zh:simpleColor:edit')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhSimpleColor zhSimpleColor)
    {
        return toAjax(zhSimpleColorService.updateZhSimpleColor(zhSimpleColor));
    }

    /**
     * 删除物质因子颜色关联
     */
    @PreAuthorize("@ss.hasPermi('zh:simpleColor:remove')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhSimpleColorService.deleteZhSimpleColorByIds(ids));
    }
}
