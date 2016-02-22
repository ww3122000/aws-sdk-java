package com.amazonaws.services.cloudfront.model;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户配额及使用量
 */
@XmlRootElement(name = "Quota")
@XmlAccessorType(XmlAccessType.FIELD)
public class Quota implements Serializable, Cloneable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 4692411821506386432L;

    @XmlElementWrapper(name = "Detail")
    private HashMap<String, Long> detail;


	public HashMap<String, Long> getDetail() {
		return detail;
	}

	public void setDetail(HashMap<String, Long> detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Quota [detail=" + detail + "]";
	}
}
