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
import com.ruoyi.zh.domain.ZhCollectRecord;
import com.ruoyi.zh.service.IZhCollectRecordService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 走航记录Controller
 * 
 * @author ruoyi
 * @date 2020-02-24
 */
@RestController
@RequestMapping("/zh/collectRecord")
public class ZhCollectRecordController extends BaseController
{
    @Autowired
    private IZhCollectRecordService zhCollectRecordService;

    /**
     * 查询走航记录列表
     */
    @PreAuthorize("@ss.hasPermi('zh:collectRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhCollectRecord zhCollectRecord)
    {
        startPage();
        List<ZhCollectRecord> list = zhCollectRecordService.selectZhCollectRecordList(zhCollectRecord);
        return getDataTable(list);
    }

    /**
     * 导出走航记录列表
     */
    @PreAuthorize("@ss.hasPermi('zh:collectRecord:export')")
    @Log(title = "走航记录", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhCollectRecord zhCollectRecord)
    {
        List<ZhCollectRecord> list = zhCollectRecordService.selectZhCollectRecordList(zhCollectRecord);
        ExcelUtil<ZhCollectRecord> util = new ExcelUtil<ZhCollectRecord>(ZhCollectRecord.class);
        return util.exportExcel(list, "collectRecord");
    }

    /**
     * 获取走航记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('zh:collectRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhCollectRecordService.selectZhCollectRecordById(id));
    }

    /**
     * 新增走航记录
     */
    @PreAuthorize("@ss.hasPermi('zh:collectRecord:add')")
    @Log(title = "走航记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhCollectRecord zhCollectRecord)
    {
        return toAjax(zhCollectRecordService.insertZhCollectRecord(zhCollectRecord));
    }

    /**
     * 修改走航记录
     */
    @PreAuthorize("@ss.hasPermi('zh:collectRecord:edit')")
    @Log(title = "走航记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhCollectRecord zhCollectRecord)
    {
        return toAjax(zhCollectRecordService.updateZhCollectRecord(zhCollectRecord));
    }

    /**
     * 删除走航记录
     */
    @PreAuthorize("@ss.hasPermi('zh:collectRecord:remove')")
    @Log(title = "走航记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhCollectRecordService.deleteZhCollectRecordByIds(ids));
    }
}
