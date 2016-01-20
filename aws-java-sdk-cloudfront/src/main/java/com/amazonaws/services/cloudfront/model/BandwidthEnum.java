package com.amazonaws.services.cloudfront.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 加速类型枚举
 * @author wangwei <br/> 
 * 2016年1月19日 下午6:08:42 <br/>
 */
public enum BandwidthEnum {
    
    /**
     * 1：带宽 
     */
    bandwidth("bandwidth"),
    
    /**
     * 2：带宽峰值
     */
    bandwidthPeakValue("bandwidthPeakValue"),
    
    /**
     * 3：流量总和
     */
    totalFlow("totalFlow");
    
    private String value;
	
    
    private static Map<String, BandwidthEnum> map = new HashMap<String, BandwidthEnum>();
    
    static{
        for (BandwidthEnum em : BandwidthEnum.values()) {
            map.put(em.getValue(), em);
        }
    }
    
    private BandwidthEnum(String value) {
        this.value = value;
    }

    /**
     * 根据枚举的文本值返回对应的枚举实例.
     *
     * @param enumValue 枚举的文本值
     * @return 对应的枚举实例
     */
    public static BandwidthEnum getByValue(String enumValue) {
        return map.get(enumValue);
    }

    public String getValue() {
        return value;
    }

}
