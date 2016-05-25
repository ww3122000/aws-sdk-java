package com.amazonaws.services.cloudfront.model.log;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志开启状态 枚举类 1开启；0关闭
 * @author wangwei
 *
 */
public enum StatusEnum {
	/** 开启 1 */
	OPEN(1),

	/** 关闭 0*/
	CLOSE(0);

	public final Integer value;

	private StatusEnum(Integer value) {
		this.value = value;
	}

	private static Map<Integer, StatusEnum> map = new HashMap<Integer, StatusEnum>();

	static {
		for (StatusEnum em : StatusEnum.values()) {
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
	public static StatusEnum getByValue(Integer value) {
		return map.get(value);
	}

	public Integer getValue() {
		return value;
	}
	
}
