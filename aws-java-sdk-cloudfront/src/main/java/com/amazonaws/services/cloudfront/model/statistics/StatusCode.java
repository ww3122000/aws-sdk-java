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
@XmlRootElement(name = "StatusCode")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatusCode {

    /** 状态码. */
    @XmlElement(name = "Code")
    protected String code;

    /** 数量. */
    @XmlElement(name = "Count")
    protected Long count;

    /** 流量. */
    @XmlElement(name = "Flow")
    protected Long flow;

    /** 命中数. */
    @XmlElement(name = "Hit")
    protected Long hit;

    /** 命中流量. */
    @XmlElement(name = "HitFlow")
    protected Long hitFlow;

    /** miss数. */
    @XmlElement(name = "Miss")
    protected Long miss;

    /** miss流量. */
    @XmlElement(name = "MissFlow")
    protected Long missFlow;
    
    /**
     * Instantiates a new status code.
     *
     * @param code the code
     * @param count the count
     * @param flow the flow
     * @param hit the hit
     * @param hitFlow the hit flow
     * @param miss the miss
     * @param missFlow the miss flow
     */
    public StatusCode(String code, Long count, Long flow, Long hit, Long hitFlow, Long miss, Long missFlow) {
        super();
        this.code = code;
        this.count = count;
        this.flow = flow;
        this.hit = hit;
        this.hitFlow = hitFlow;
        this.miss = miss;
        this.missFlow = missFlow;
    }

    /**
     * Instantiates a new status code.
     */
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
     * Gets the 命中数.
     *
     * @return the 命中数
     */
    public Long getHit() {
        return hit;
    }

    /**
     * Sets the 命中数.
     *
     * @param hit the new 命中数
     */
    public void setHit(Long hit) {
        this.hit = hit;
    }

    /**
     * Gets the miss数.
     *
     * @return the miss数
     */
    public Long getMiss() {
        return miss;
    }

    /**
     * Sets the miss数.
     *
     * @param miss the new miss数
     */
    public void setMiss(Long miss) {
        this.miss = miss;
    }

    /**
     * Gets the 流量.
     *
     * @return the 流量
     */
    public Long getFlow() {
        return flow;
    }

    /**
     * Sets the 流量.
     *
     * @param flow the new 流量
     */
    public void setFlow(Long flow) {
        this.flow = flow;
    }

    /**
     * Gets the 命中流量.
     *
     * @return the 命中流量
     */
    public Long getHitFlow() {
        return hitFlow;
    }

    /**
     * Sets the 命中流量.
     *
     * @param hitFlow the new 命中流量
     */
    public void setHitFlow(Long hitFlow) {
        this.hitFlow = hitFlow;
    }

    /**
     * Gets the miss流量.
     *
     * @return the miss流量
     */
    public Long getMissFlow() {
        return missFlow;
    }

    /**
     * Sets the miss流量.
     *
     * @param missFlow the new miss流量
     */
    public void setMissFlow(Long missFlow) {
        this.missFlow = missFlow;
    }

	@Override
	public String toString() {
		return "StatusCode [code=" + code + ", count=" + count + ", flow=" + flow + ", hit=" + hit + ", hitFlow="
				+ hitFlow + ", miss=" + miss + ", missFlow=" + missFlow + "]";
	}
    
}
