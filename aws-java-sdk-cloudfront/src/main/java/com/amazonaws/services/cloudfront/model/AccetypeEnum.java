package com.amazonaws.services.cloudfront.model;

/**
 * 加速类型枚举
 * @author wangwei <br/> 
 * 2016年1月19日 下午6:08:42 <br/>
 */
public enum AccetypeEnum {
    /**
     * 上行加速
     */
    upload("upload"),
    /**
     * 点播加速
     */
    vodstream("vodstream"),
    /**
     * 直播加速
     */
    livestream("livestream"),
    /**
     * 网页加速
     */
    web("web"),
    /**
     * 下载加速
     */
    download("download");
    
    private String value;
    
    private AccetypeEnum(String value) {
        this.value = value;
    }

    /**
     * 根据枚举的文本值返回对应的枚举实例.
     *
     * @param enumValue 枚举的文本值
     * @return 对应的枚举实例
     */
    public static RegionEnum getByValue(String enumValue) {
        for (RegionEnum em : RegionEnum.values()) {
            if (em.getValue().equals(enumValue)) {
                return em;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

}
