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
import com.ruoyi.zh.domain.ZhConfig;
import com.ruoyi.zh.service.IZhConfigService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 配置信息Controller
 * 
 * @author ruoyi
 * @date 2020-04-08
 */
@RestController
@RequestMapping("/zh/config")
public class ZhConfigController extends BaseController
{
    @Autowired
    private IZhConfigService zhConfigService;

    /**
     * 查询配置信息列表
     */
//    @PreAuthorize("@ss.hasPermi('zh:config:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhConfig zhConfig)
    {
        startPage();
        List<ZhConfig> list = zhConfigService.selectZhConfigList(zhConfig);
        return getDataTable(list);
    }

    /**
     * 导出配置信息列表
     */
//    @PreAuthorize("@ss.hasPermi('zh:config:export')")
    @Log(title = "配置信息", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhConfig zhConfig)
    {
        List<ZhConfig> list = zhConfigService.selectZhConfigList(zhConfig);
        ExcelUtil<ZhConfig> util = new ExcelUtil<ZhConfig>(ZhConfig.class);
        return util.exportExcel(list, "config");
    }

    /**
     * 获取配置信息详细信息
     */
//    @PreAuthorize("@ss.hasPermi('zh:config:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhConfigService.selectZhConfigById(id));
    }

    /**
     * 新增配置信息
     */
//    @PreAuthorize("@ss.hasPermi('zh:config:add')")
    @Log(title = "配置信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhConfig zhConfig)
    {
        return toAjax(zhConfigService.insertZhConfig(zhConfig));
    }

    /**
     * 修改配置信息
     */
//    @PreAuthorize("@ss.hasPermi('zh:config:edit')")
    @Log(title = "配置信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhConfig zhConfig)
    {
        return toAjax(zhConfigService.updateZhConfig(zhConfig));
    }

    /**
     * 删除配置信息
     */
//    @PreAuthorize("@ss.hasPermi('zh:config:remove')")
    @Log(title = "配置信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhConfigService.deleteZhConfigByIds(ids));
    }
}
