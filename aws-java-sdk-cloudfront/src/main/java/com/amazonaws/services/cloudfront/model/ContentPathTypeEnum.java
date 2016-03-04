package com.amazonaws.services.cloudfront.model;

import java.util.HashMap;
import java.util.Map;

public enum ContentPathTypeEnum {
    /** 文件刷新 */
	REFRESH_FILE("refreshFile"),
	
	 /** 目录刷新 */
	REFRESH_DIR("refreshDir"),
	
	 /** 文件预热 */
	PRELOAD_FILE("preloadFile");

	public final String value;

	private ContentPathTypeEnum(String value) {
		this.value = value;
	}
	
	 private static Map<String, ContentPathTypeEnum> map = new HashMap<String, ContentPathTypeEnum>();
	    
	    static{
	        for (ContentPathTypeEnum em : ContentPathTypeEnum.values()) {
	            map.put(em.value, em);
	        }
	    }
	    
	    /**
	    * 根据枚举的文本值返回对应的枚举实例.
	    *
	    * @param enumValue 枚举的文本值
	    * @return 对应的枚举实例
	    */
	   public static ContentPathTypeEnum getByValue(String value) {
	       return map.get(value);
	   }

	
}
