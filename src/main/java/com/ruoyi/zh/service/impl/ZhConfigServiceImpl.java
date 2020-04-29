package com.ruoyi.zh.service.impl;

import java.util.List;

import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.project.system.domain.SysUser;
import com.ruoyi.zh.tool.UserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.ruoyi.zh.mapper.ZhConfigMapper;
import com.ruoyi.zh.domain.ZhConfig;
import com.ruoyi.zh.service.IZhConfigService;

/**
 * 配置信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-08
 */
@Service
public class ZhConfigServiceImpl implements IZhConfigService 
{
    @Autowired
    private ZhConfigMapper zhConfigMapper;

    /**
     * 查询配置信息
     * 
     * @param id 配置信息ID
     * @return 配置信息
     */
    @Override
    public ZhConfig selectZhConfigById(Long id)
    {
        return zhConfigMapper.selectZhConfigById(id);
    }

    @Override
    public ZhConfig selectZhConfigByUserName() {
        return zhConfigMapper.selectZhConfigByUserName(UserInfoUtil.getUserName());
    }

    /**
     * 查询配置信息列表
     * 
     * @param zhConfig 配置信息
     * @return 配置信息
     */
    @Override
    public List<ZhConfig> selectZhConfigList(ZhConfig zhConfig)
    {
        return zhConfigMapper.selectZhConfigList(zhConfig);
    }

    /**
     * 新增配置信息
     * 
     * @param zhConfig 配置信息
     * @return 结果
     */
    @Override
    public int insertZhConfig(ZhConfig zhConfig)
    {
        zhConfig.setCreateBy(UserInfoUtil.getUserName());
        return zhConfigMapper.insertZhConfig(zhConfig);
    }

    /**
     * 修改配置信息
     * 
     * @param zhConfig 配置信息
     * @return 结果
     */
    @Override
    public int updateZhConfig(ZhConfig zhConfig)
    {
        zhConfig.setUpdateBy(UserInfoUtil.getUserName());
        return zhConfigMapper.updateZhConfig(zhConfig);
    }

    @Override
    public int insertOrUpdateZhConfig(ZhConfig zhConfig) {
        ZhConfig old = selectZhConfigByUserName();
        if (old == null) {
            return insertZhConfig(zhConfig);
        } else {
            zhConfig.setId(old.getId());
            return updateZhConfig(zhConfig);
        }
    }

    /**
     * 批量删除配置信息
     * 
     * @param ids 需要删除的配置信息ID
     * @return 结果
     */
    @Override
    public int deleteZhConfigByIds(Long[] ids)
    {
        return zhConfigMapper.deleteZhConfigByIds(ids);
    }

    /**
     * 删除配置信息信息
     * 
     * @param id 配置信息ID
     * @return 结果
     */
    @Override
    public int deleteZhConfigById(Long id)
    {
        return zhConfigMapper.deleteZhConfigById(id);
    }
}
