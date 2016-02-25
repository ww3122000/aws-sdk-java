package com.amazonaws.services.cloudfront.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 配额的枚举
 * @author wangwei <br/> 
 * 2016年2月22日 下午4:11:43 <br/>
 */
public enum QuotaNameEnum {
    /** 文件刷新 */
    invalidation_file("invalidation_file"),
    
    /** 目录刷新 */
    invalidation_dir("invalidation_dir"),
    
    /** 预加载 */
    preload("preload"),
    
    // 下面的这些都是通过@QuotaControl 配置在方法上面的，一次执行增加一次
    /** 刷新详细信息 */
    invalidation_detail("invalidation_detail"), 
    
    /** 分页查询刷新列表 */
    list_invalidations("list_invalidations"),
    
    /** 预加载详细信息 */
    preload_detail("preload_detail"),
    
    /** 分页查询预加载列表 */
    list_preloads("list_preloads"),
    
    /** 配额使用量 */
    quota_usage_amount("quota_usage_amount"),
    
    /** 配额信息 */
    quota_config("quota_config"),
    
    /** 流量带宽 */
    bandwidth("bandwidth");
    
    private static Map<String, QuotaNameEnum> map = new HashMap<String, QuotaNameEnum>();
    private static List<String> quotaNames = new ArrayList<String>();
    
    static{
        for (QuotaNameEnum em : QuotaNameEnum.values()) {
            map.put(em.getValue(), em);
            quotaNames.add(em.getValue());
        }
        
    }
    
    private String value;
    
    private QuotaNameEnum(String value) {
        this.value = value;
    }

    /**
     * 根据枚举的文本值返回对应的枚举实例.
     *
     * @param enumValue 枚举的文本值
     * @return 对应的枚举实例
     */
    public static QuotaNameEnum getByValue(String enumValue) {
        return map.get(enumValue);
    }
    
    public String getValue() {
        return value;
    }

    /**
     * 获得所有的配额名，
     * @return
     */
    public static List<String> getQuotaNames() {
        return quotaNames;
    }
    
}
