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
import com.ruoyi.zh.domain.ZhLinkCategoryFactorColor;
import com.ruoyi.zh.service.IZhLinkCategoryFactorColorService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.web.page.TableDataInfo;

/**
 * 物质因子颜色关联Controller
 * 
 * @author ruoyi
 * @date 2020-08-10
 */
@RestController
@RequestMapping("/zh/category_factor_color")
public class ZhLinkCategoryFactorColorController extends BaseController
{
    @Autowired
    private IZhLinkCategoryFactorColorService zhLinkCategoryFactorColorService;

    /**
     * 查询物质因子颜色关联列表
     */
    //@PreAuthorize("@ss.hasPermi('zh:category_factor_color:list')")
    @GetMapping("/list")
    public AjaxResult list(ZhLinkCategoryFactorColor zhLinkCategoryFactorColor)
    {
//        startPage();
        List<ZhLinkCategoryFactorColor> list = zhLinkCategoryFactorColorService.selectZhLinkCategoryFactorColorList(zhLinkCategoryFactorColor);
        return AjaxResult.success(list);
    }

    /**
     * 导出物质因子颜色关联列表
     */
    //@PreAuthorize("@ss.hasPermi('zh:category_factor_color:export')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(ZhLinkCategoryFactorColor zhLinkCategoryFactorColor)
    {
        List<ZhLinkCategoryFactorColor> list = zhLinkCategoryFactorColorService.selectZhLinkCategoryFactorColorList(zhLinkCategoryFactorColor);
        ExcelUtil<ZhLinkCategoryFactorColor> util = new ExcelUtil<ZhLinkCategoryFactorColor>(ZhLinkCategoryFactorColor.class);
        return util.exportExcel(list, "category_factor_color");
    }

    /**
     * 获取物质因子颜色关联详细信息
     */
    //@PreAuthorize("@ss.hasPermi('zh:category_factor_color:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zhLinkCategoryFactorColorService.selectZhLinkCategoryFactorColorById(id));
    }

    /**
     * 新增物质因子颜色关联
     */
    //@PreAuthorize("@ss.hasPermi('zh:category_factor_color:add')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZhLinkCategoryFactorColor zhLinkCategoryFactorColor)
    {
        return toAjax(zhLinkCategoryFactorColorService.insertZhLinkCategoryFactorColor(zhLinkCategoryFactorColor));
    }

    @Log(title = "物质因子颜色关联", businessType = BusinessType.INSERT)
    @PostMapping("/batch")
    public AjaxResult addBatch(@RequestBody List<ZhLinkCategoryFactorColor> zhLinkCategoryFactorColors)
    {
        int i=0;

        if(zhLinkCategoryFactorColors!=null&&zhLinkCategoryFactorColors.size()>0){
            ZhLinkCategoryFactorColor temp=new ZhLinkCategoryFactorColor();
            temp.setCategoryId(zhLinkCategoryFactorColors.get(0).getCategoryId());
            List<ZhLinkCategoryFactorColor> colors = zhLinkCategoryFactorColorService.selectZhLinkCategoryFactorColorList(temp);
            if(colors!=null&&colors.size()>0){
             for (ZhLinkCategoryFactorColor color:colors){
                 zhLinkCategoryFactorColorService.deleteZhLinkCategoryFactorColorById(color.getId());
             }
            }
            for (ZhLinkCategoryFactorColor zhLinkCategoryFactorColor : zhLinkCategoryFactorColors) {
                zhLinkCategoryFactorColorService.insertZhLinkCategoryFactorColor(zhLinkCategoryFactorColor);
                i++;
            }
        }
        return toAjax(i);
    }

    /**
     * 修改物质因子颜色关联
     */
    //@PreAuthorize("@ss.hasPermi('zh:category_factor_color:edit')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZhLinkCategoryFactorColor zhLinkCategoryFactorColor)
    {
        return toAjax(zhLinkCategoryFactorColorService.updateZhLinkCategoryFactorColor(zhLinkCategoryFactorColor));
    }

    /**
     * 删除物质因子颜色关联
     */
    //@PreAuthorize("@ss.hasPermi('zh:category_factor_color:remove')")
    @Log(title = "物质因子颜色关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zhLinkCategoryFactorColorService.deleteZhLinkCategoryFactorColorByIds(ids));
    }
}
