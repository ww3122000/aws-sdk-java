package com.amazonaws.services.cloudfront.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 流量带宽统计中的 cdn 类型枚举<br>
 * 下载业务或者视频业务
 * 
 * @author wangwei
 *
 */
public enum CdnTypeEnum {
	/** 下载业务 */
	download("download"),

	/** 视频业务 */
	video("video");

	public final String value;

	private CdnTypeEnum(String value) {
		this.value = value;
	}

	private static Map<String, CdnTypeEnum> map = new HashMap<String, CdnTypeEnum>();

	static {
		for (CdnTypeEnum em : CdnTypeEnum.values()) {
			map.put(em.value, em);
		}
	}

	/**
	 * 根据枚举的文本值返回对应的枚举实例.
	 *
	 * @param enumValue
	 *            枚举的文本值
	 * @return 对应的枚举实例
	 */
	public static CdnTypeEnum getByValue(String value) {
		return map.get(value);
	}

	public String getValue() {
		return value;
	}
	
}
