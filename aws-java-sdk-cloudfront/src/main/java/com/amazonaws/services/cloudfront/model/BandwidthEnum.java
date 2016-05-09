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
     * 1：域名维度带宽 
     */
    bandwidth("bandwidth"),
    
    /**
     * 2：域名维度带宽峰值
     */
    bandwidthPeakValue("bandwidthPeakValue"),
    
    /**
     * 3：域名维度流量总和
     */
    totalFlow("totalFlow"),
	
	/**
     * 4：用户维度的带宽
     */
    userBandwidth("userBandwidth"),
    
    /**
     * 5：用户维度查询时间范围内带宽峰值
     */
    userBandwidthPeakValue("userBandwidthPeakValue"),
    
    /**
     * 6：用户维度查询时间范围内流量总和
     */
    userTotalFlow("userTotalFlow"),
    
    /**
     * 11：直播流流量
     */
    videoFlow("videoFlow"),
    
    /**
     * 12：直播流访问数
     */
    videoClickPerMinute("videoClickPerMinute");
	
    
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
