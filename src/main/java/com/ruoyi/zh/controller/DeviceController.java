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
import com.ruoyi.zh.domain.ZhDevice;
import com.ruoyi.zh.service.IDeviceService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 走航Controller
 * 
 * @author ruoyi
 * @date 2020-02-23
 */
@RestController
@RequestMapping("/zh/device")
public class DeviceController extends BaseController
{
    @Autowired
    private IDeviceService zhDeviceService;

    /**
     * 查询走航列表
     */
//    @PreAuthorize("@ss.hasPermi('zh:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhDevice zhDevice)
    {
        startPage();
        List<ZhDevice> list = zhDeviceService.selectDeviceList(zhDevice);
        return getDataTable(list);
    }

    /**
     * 导出走航列表
     */
    @PreAuthorize("@ss.hasPermi('zh:device:export')")
    @Log(title = "走航", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhDevice zhDevice)
    {
        List<ZhDevice> list = zhDeviceService.selectDeviceList(zhDevice);
        ExcelUtil<ZhDevice> util = new ExcelUtil<ZhDevice>(ZhDevice.class);
        return util.exportExcel(list, "device");
    }

    /**
     * 获取走航详细信息
     */
//    @PreAuthorize("@ss.hasPermi('zh:device:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhDeviceService.selectDeviceById(id));
    }

    /**
     * 新增走航
     */
//    @PreAuthorize("@ss.hasPermi('zh:device:add')")
    @Log(title = "走航", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhDevice zhDevice)
    {
        return toAjax(zhDeviceService.insertDevice(zhDevice));
    }

    /**
     * 修改走航
     */
//    @PreAuthorize("@ss.hasPermi('zh:device:edit')")
    @Log(title = "走航", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhDevice zhDevice)
    {
        return toAjax(zhDeviceService.updateDevice(zhDevice));
    }

    /**
     * 删除走航
     */
//    @PreAuthorize("@ss.hasPermi('zh:device:remove')")
    @Log(title = "走航", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhDeviceService.deleteDeviceByIds(ids));
    }
}
