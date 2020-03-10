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
import com.ruoyi.zh.domain.ZhPoint;
import com.ruoyi.zh.service.IPointService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 控点Controller
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@RestController
@RequestMapping("/zh/point")
public class PointController extends BaseController
{
    @Autowired
    private IPointService zhPointService;

    /**
     * 查询控点列表
     */
    @PreAuthorize("@ss.hasPermi('zh:point:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhPoint zhPoint)
    {
        startPage();
        List<ZhPoint> list = zhPointService.selectPointList(zhPoint);
        return getDataTable(list);
    }

    /**
     * 导出控点列表
     */
    @PreAuthorize("@ss.hasPermi('zh:point:export')")
    @Log(title = "控点", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhPoint zhPoint)
    {
        List<ZhPoint> list = zhPointService.selectPointList(zhPoint);
        ExcelUtil<ZhPoint> util = new ExcelUtil<ZhPoint>(ZhPoint.class);
        return util.exportExcel(list, "point");
    }

    /**
     * 获取控点详细信息
     */
    @PreAuthorize("@ss.hasPermi('zh:point:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhPointService.selectPointById(id));
    }

    /**
     * 新增控点
     */
    @PreAuthorize("@ss.hasPermi('zh:point:add')")
    @Log(title = "控点", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhPoint zhPoint)
    {
        return toAjax(zhPointService.insertPoint(zhPoint));
    }

    /**
     * 修改控点
     */
    @PreAuthorize("@ss.hasPermi('zh:point:edit')")
    @Log(title = "控点", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhPoint zhPoint)
    {
        return toAjax(zhPointService.updatePoint(zhPoint));
    }

    /**
     * 删除控点
     */
    @PreAuthorize("@ss.hasPermi('zh:point:remove')")
    @Log(title = "控点", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhPointService.deletePointByIds(ids));
    }
}
