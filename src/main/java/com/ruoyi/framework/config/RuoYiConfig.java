package com.ruoyi.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 读取项目相关配置
 * 
 * @author ruoyi
 */
@Component
@ConfigurationProperties(prefix = "ruoyi")
public class RuoYiConfig
{
    /** 项目名称 */
    private String name;

    /** 版本 */
    private String version;

    /** 版权年份 */
    private String copyrightYear;

    /** 实例演示开关 */
    private boolean demoEnabled;

    /** 上传路径 */
    private static String profile;

    /** 获取地址开关 */
    private static boolean addressEnabled;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getVersion()
    {
        return version;
    }

    public void setVersion(String version)
    {
        this.version = version;
    }

    public String getCopyrightYear()
    {
        return copyrightYear;
    }

    public void setCopyrightYear(String copyrightYear)
    {
        this.copyrightYear = copyrightYear;
    }

    public boolean isDemoEnabled()
    {
        return demoEnabled;
    }

    public void setDemoEnabled(boolean demoEnabled)
    {
        this.demoEnabled = demoEnabled;
    }

    public static String getProfile()
    {
        String jar_parent_path="";
        try {
            jar_parent_path = new File(ResourceUtils.getURL("classpath:").getPath()).getParentFile().getParentFile().getParent();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        jar_parent_path=jar_parent_path.replace("file:","");
        return jar_parent_path;
//        return profile;
    }

    public void setProfile(String profile)
    {
        RuoYiConfig.profile = profile;
    }

    public static boolean isAddressEnabled()
    {
        return addressEnabled;
    }

    public void setAddressEnabled(boolean addressEnabled)
    {
        RuoYiConfig.addressEnabled = addressEnabled;
    }

    /**
     * 获取头像上传路径
     */
    public static String getAvatarPath()
    {
        return getProfile() + File.separator+"avatar";
    }

    /**
     * 获取下载路径
     */
    public static String getDownloadPath()
    {
        return getProfile() + File.separator+"download"+File.separator;
    }

    /**
     * 获取上传路径
     */
    public static String getUploadPath()
    {
        return getProfile() + File.separator+"upload";
    }
}