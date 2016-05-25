package com.amazonaws.services.cloudfront.model.log;

import java.util.HashMap;
import java.util.Map;

/**
 * 粒度 枚举类
 * @author wangwei
 *
 */
public enum GranularityEnum {
	/** 按天 1 */
	DAY(1),

	/** 按小时 0 */
	HOUR(0);

	public final Integer value;

	private GranularityEnum(Integer value) {
		this.value = value;
	}

	private static Map<Integer, GranularityEnum> map = new HashMap<Integer, GranularityEnum>();

	static {
		for (GranularityEnum em : GranularityEnum.values()) {
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
	public static GranularityEnum getByValue(Integer value) {
		return map.get(value);
	}

	public Integer getValue() {
		return value;
	}
	
}
