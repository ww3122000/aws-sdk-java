package com.amazonaws.services.cloudfront.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 加速类型枚举 1.下载加速 2.直播加速
 * @author wangwei <br/> 
 * 2016年1月19日 下午6:08:42 <br/>
 */
public enum AccetypeEnum {
    /**
     * 上行加速
     */
    upload("upload", 4),
    /**
     * 点播加速
     */
    vodstream("vodstream", 3),
    /**
     * 直播加速
     */
    livestream("livestream", 2),
    /**
     * 网页加速
     */
    web("web", 5),
    /**
     * 下载加速
     */
    download("download", 1);
    
    private String value;
    private Integer code;
    
    private static Map<String, AccetypeEnum> map = new HashMap<String, AccetypeEnum>();
    private static Map<Integer, AccetypeEnum> codeMap = new HashMap<Integer, AccetypeEnum>();
    
    static{
        for (AccetypeEnum em : AccetypeEnum.values()) {
            map.put(em.getValue(), em);
            codeMap.put(em.code, em);
        }
    }
    
    private AccetypeEnum(String value, int code) {
        this.value = value;
        this.code = code;
    }

    /**
     * 根据枚举的文本值返回对应的枚举实例.
     *
     * @param enumValue 枚举的文本值
     * @return 对应的枚举实例
     */
    public static AccetypeEnum getByValue(String enumValue) {
        return map.get(enumValue);
    }
    
    public static AccetypeEnum getByCode(Integer code) {
        return codeMap.get(code);
    }

    public String getValue() {
        return value;
    }

    public Integer getCode() {
        return code;
    }
    
}
