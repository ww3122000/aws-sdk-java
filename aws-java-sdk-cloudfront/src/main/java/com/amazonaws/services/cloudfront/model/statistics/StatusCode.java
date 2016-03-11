package com.amazonaws.services.cloudfront.model.statistics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 状态码的命中率.
 *
 * @author wangwei <br/>
 * 2016年3月8日 下午8:16:03 <br/>
 */
@XmlRootElement(name="StatusCode")
@XmlAccessorType (XmlAccessType.FIELD)
public class StatusCode {
    
    /** 状态码. */
    @XmlElement(name = "Code")
    protected String code;
    
    /** 数量. */
    @XmlElement(name = "Count")
    protected Long count;
    
    /** 命中. */
    @XmlElement(name = "Hit")
    protected Long hit;
    
    /** 没有命中. */
    @XmlElement(name = "Miss")
    protected Long miss;
    
    public StatusCode(String code, Long count, Long hit, Long miss) {
        super();
        this.code = code;
        this.count = count;
        this.hit = hit;
        this.miss = miss;
    }

    public StatusCode() {
        super();
    }


    /**
     * Gets the 状态码.
     *
     * @return the 状态码
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the 状态码.
     *
     * @param code the new 状态码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets the 数量.
     *
     * @return the 数量
     */
    public Long getCount() {
        return count;
    }

    /**
     * Sets the 数量.
     *
     * @param count the new 数量
     */
    public void setCount(Long count) {
        this.count = count;
    }

    /**
     * Gets the 命中.
     *
     * @return the 命中
     */
    public Long getHit() {
        return hit;
    }

    /**
     * Sets the 命中.
     *
     * @param hit the new 命中
     */
    public void setHit(Long hit) {
        this.hit = hit;
    }

    /**
     * Gets the 没有命中.
     *
     * @return the 没有命中
     */
    public Long getMiss() {
        return miss;
    }

    /**
     * Sets the 没有命中.
     *
     * @param miss the new 没有命中
     */
    public void setMiss(Long miss) {
        this.miss = miss;
    }

	@Override
	public String toString() {
		return "StatusCode [code=" + code + ", count=" + count + ", hit=" + hit + ", miss=" + miss + "]";
	}
    
}
