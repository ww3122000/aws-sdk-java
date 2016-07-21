package com.amazonaws.services.cloudfront.model;

/**
 * 地区枚举值.
 *
 * @author wangwei
 */
public enum RegionEnum {

    /**  全部 all *. */
    all("all", "全部", "all"),

    /**  中国大陆 China *. */
    CN("CN", "中国大陆", "China"),

    /**  北美洲 NorthAmerica *. */
    NA("NA", "北美洲", "NorthAmerica"),

    /**  亚洲(除中国大陆) Asia *. */
    AS("AS", "亚洲(除中国大陆)", "Asia"),

    /**  欧洲 Europe *. */
    EU("EU", "欧洲", "Europe"),

    /**  南美洲 SouthAmerica *. */
    SA("SA", "南美洲", "SouthAmerica"),

    /**  大洋洲 Oceanica *. */
    AU("AU", "大洋洲", "Oceanica"),

    /**  非洲 Africa *. */
    AF("AF", "非洲", "Africa"),

    /**  未知 Unknown *. */
    other("other", "未知", "Unknown");

    /** 枚举值. */
    private String value;

    /** 中文名. */
    private String chineseName;

    /** 英文名. */
    private String englishName;

    /**
     * Instantiates a new ksc region enum.
     *
     * @param value the value
     * @param chineseName the chinese name
     * @param englishName the english name
     */
    private RegionEnum(String value, String chineseName, String englishName) {
        this.value = value;
        this.chineseName = chineseName;
        this.englishName = englishName;
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

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return this.value;
    }

    /**
     * Gets the 枚举值.
     *
     * @return the 枚举值
     */
    public String getValue() {
        return value;
    }

    /**
     * Gets the 中文名.
     *
     * @return the 中文名
     */
    public String getChineseName() {
        return chineseName;
    }

    /**
     * Sets the 中文名.
     *
     * @param chineseName the new 中文名
     */
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    /**
     * Gets the 英文名.
     *
     * @return the 英文名
     */
    public String getEnglishName() {
        return englishName;
    }

}
