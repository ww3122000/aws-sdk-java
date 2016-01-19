package com.amazonaws.services.cloudfront.model;

/**
 * 地区枚举值
 * 
 * @author wangwei
 *
 */
public enum KscRegionEnum {

	/** 全部 all **/
	all("all", "全部", "all"),
	
	/** 澳门 Macau **/
	mo("mo", "澳门", "Macau"),
	
	/** 香港 HongKong **/
	hk("hk", "香港", "HongKong"),
	
	/** 新加坡  Singapore **/
	sg("sg", "新加坡", "Singapore"),
	
	/** 韩国 Korea **/
	kr("kr", "韩国", "Korea"),
	
	/** 台湾 Taiwan **/
	tw("tw", "台湾", "Taiwan"),
	
	/** 美国 USA **/
	us("us", "美国", "USA"),
	
	/** 澳大利亚 Australia **/
	au("au", "澳大利亚", "Australia"),
	
	/** 日本 Japan **/
	jp("jp", "日本", "Japan"),
	
	/** 加拿大 Canada **/
	ca("ca", "加拿大", "Canada"),
	
	/** 中国大陆 China **/
	cn("cn", "中国大陆", "China"),
	
	/** 未知 Unknown **/
	other("other", "未知", "Unknown");

	/**
	 * 枚举值
	 */
	private String value;

	/**
	 * 中文名
	 */
	private String chineseName;

	/**
	 * 英文名
	 */
	private String englishName;
	

	private KscRegionEnum(String value, String chineseName, String englishName) {
		this.value = value;
		this.chineseName = chineseName;
		this.englishName = englishName;
	}
	
	/**
	 * 根据枚举的文本值返回对应的枚举实例
	 * @param enumValue 枚举的文本值
	 * @return 对应的枚举实例
	 */
	public static KscRegionEnum getByValue(String enumValue) {
		for (KscRegionEnum em : KscRegionEnum.values()) {
			if (em.getValue().equals(enumValue)) {
				return em;
			}
		}
		throw new IllegalArgumentException("No KscRegionEnum found by value " + enumValue);
	}

	@Override
	public String toString() {
		return this.value;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

}
