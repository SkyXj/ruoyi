package com.ruoyi.zh.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhFactorMapper;
import com.ruoyi.zh.domain.ZhFactor;
import com.ruoyi.zh.service.IZhFactorService;

/**
 * 因子Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-04
 */
@Service
public class ZhFactorServiceImpl implements IZhFactorService 
{
    @Autowired
    private ZhFactorMapper zhFactorMapper;

    /**
     * 查询因子
     * 
     * @param id 因子ID
     * @return 因子
     */
    @Override
    public ZhFactor selectZhFactorById(Long id)
    {
        return zhFactorMapper.selectZhFactorById(id);
    }

    /**
     * 查询因子列表
     * 
     * @param zhFactor 因子
     * @return 因子
     */
    @Override
    public List<ZhFactor> selectZhFactorList(ZhFactor zhFactor)
    {
        return zhFactorMapper.selectZhFactorList(zhFactor);
    }

    /**
     * 新增因子
     * 
     * @param zhFactor 因子
     * @return 结果
     */
    @Override
    public int insertZhFactor(ZhFactor zhFactor)
    {
        zhFactor.setCreateTime(DateUtils.getNowDate());
        return zhFactorMapper.insertZhFactor(zhFactor);
    }

    /**
     * 修改因子
     * 
     * @param zhFactor 因子
     * @return 结果
     */
    @Override
    public int updateZhFactor(ZhFactor zhFactor)
    {
        zhFactor.setUpdateTime(DateUtils.getNowDate());
        return zhFactorMapper.updateZhFactor(zhFactor);
    }

    /**
     * 批量删除因子
     * 
     * @param ids 需要删除的因子ID
     * @return 结果
     */
    @Override
    public int deleteZhFactorByIds(Long[] ids)
    {
        return zhFactorMapper.deleteZhFactorByIds(ids);
    }

    /**
     * 删除因子信息
     * 
     * @param id 因子ID
     * @return 结果
     */
    @Override
    public int deleteZhFactorById(Long id)
    {
        return zhFactorMapper.deleteZhFactorById(id);
    }
}
