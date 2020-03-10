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
import com.ruoyi.zh.domain.ZhFactor;
import com.ruoyi.zh.service.IZhFactorService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 因子Controller
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@RestController
@RequestMapping("/zh/factor")
public class ZhFactorController extends BaseController
{
    @Autowired
    private IZhFactorService zhFactorService;

    /**
     * 查询因子列表
     */
    @PreAuthorize("@ss.hasPermi('zh:factor:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhFactor zhFactor)
    {
        startPage();
        List<ZhFactor> list = zhFactorService.selectZhFactorList(zhFactor);
        return getDataTable(list);
    }

    /**
     * 导出因子列表
     */
    @PreAuthorize("@ss.hasPermi('zh:factor:export')")
    @Log(title = "因子", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhFactor zhFactor)
    {
        List<ZhFactor> list = zhFactorService.selectZhFactorList(zhFactor);
        ExcelUtil<ZhFactor> util = new ExcelUtil<ZhFactor>(ZhFactor.class);
        return util.exportExcel(list, "factor");
    }

    /**
     * 获取因子详细信息
     */
    @PreAuthorize("@ss.hasPermi('zh:factor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhFactorService.selectZhFactorById(id));
    }

    /**
     * 新增因子
     */
    @PreAuthorize("@ss.hasPermi('zh:factor:add')")
    @Log(title = "因子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhFactor zhFactor)
    {
        return toAjax(zhFactorService.insertZhFactor(zhFactor));
    }

    /**
     * 修改因子
     */
    @PreAuthorize("@ss.hasPermi('zh:factor:edit')")
    @Log(title = "因子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhFactor zhFactor)
    {
        return toAjax(zhFactorService.updateZhFactor(zhFactor));
    }

    /**
     * 删除因子
     */
    @PreAuthorize("@ss.hasPermi('zh:factor:remove')")
    @Log(title = "因子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhFactorService.deleteZhFactorByIds(ids));
    }
}
