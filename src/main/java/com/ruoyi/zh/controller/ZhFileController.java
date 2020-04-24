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
import com.ruoyi.zh.domain.ZhFile;
import com.ruoyi.zh.service.IZhFileService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 文件Controller
 * 
 * @author hxsdd
 * @date 2020-04-24
 */
@RestController
@RequestMapping("/zh/file")
public class ZhFileController extends BaseController
{
    @Autowired
    private IZhFileService zhFileService;

    /**
     * 查询文件列表
     */
    @PreAuthorize("@ss.hasPermi('zh:file:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZhFile zhFile)
    {
        startPage();
        List<ZhFile> list = zhFileService.selectZhFileList(zhFile);
        return getDataTable(list);
    }

    /**
     * 导出文件列表
     */
    @PreAuthorize("@ss.hasPermi('zh:file:export')")
    @Log(title = "文件", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhFile zhFile)
    {
        List<ZhFile> list = zhFileService.selectZhFileList(zhFile);
        ExcelUtil<ZhFile> util = new ExcelUtil<ZhFile>(ZhFile.class);
        return util.exportExcel(list, "file");
    }

    /**
     * 获取文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('zh:file:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhFileService.selectZhFileById(id));
    }

    /**
     * 新增文件
     */
    @PreAuthorize("@ss.hasPermi('zh:file:add')")
    @Log(title = "文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhFile zhFile)
    {
        return toAjax(zhFileService.insertZhFile(zhFile));
    }

    /**
     * 修改文件
     */
    @PreAuthorize("@ss.hasPermi('zh:file:edit')")
    @Log(title = "文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhFile zhFile)
    {
        return toAjax(zhFileService.updateZhFile(zhFile));
    }

    /**
     * 删除文件
     */
    @PreAuthorize("@ss.hasPermi('zh:file:remove')")
    @Log(title = "文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhFileService.deleteZhFileByIds(ids));
    }
}
