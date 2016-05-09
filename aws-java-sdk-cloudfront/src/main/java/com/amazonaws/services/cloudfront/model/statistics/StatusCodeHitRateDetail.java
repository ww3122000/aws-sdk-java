package com.amazonaws.services.cloudfront.model.statistics;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 具体一个域名的状态码命中率按时间详细.
 *
 * @author wangwei <br/>
 * 2016年3月8日 下午8:18:16 <br/>
 */
@XmlRootElement(name = "StatusCodeHitRateDetail")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatusCodeHitRateDetail {

    /** 时间点. */
    @XmlElement(name = "Time")
    protected Long time;

    /** 当前时间断内的总请求数. */
    @XmlElement(name = "TotalCount")
    protected Long totalCount;

    /** 当前时间断内的总请求流量. */
    @XmlElement(name = "TotalFlow")
    protected Long totalFlow;

    /** 当前时间断内的总命中数. */
    @XmlElement(name = "TotalHit")
    protected Long totalHit;

    /** 当前时间断内的总命中流量. */
    @XmlElement(name = "TotalHitFlow")
    protected Long totalHitFlow;

    /** 当前时间断内的总miss数. */
    @XmlElement(name = "TotalMiss")
    protected Long totalMiss;

    /** 当前时间断内的总没有命中流量. */
    @XmlElement(name = "TotalMissFlow")
    protected Long totalMissFlow;

    /** 各种状态码的命中率细节. */
    @XmlElementWrapper(name = "Codes")
    @XmlElement(name = "StatusCode")
    protected List<StatusCode> codes;
    
    public StatusCodeHitRateDetail() {
		super();
		codes = new ArrayList<StatusCode>();
	}

    /**
     * Gets the 时间点.
     *
     * @return the 时间点
     */
    public Long getTime() {
        return time;
    }

    /**
     * Sets the 时间点.
     *
     * @param time the new 时间点
     */
    public void setTime(Long time) {
        this.time = time;
    }

    /**
     * Gets the 当前时间断内的总请求数.
     *
     * @return the 当前时间断内的总请求数
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the 当前时间断内的总请求数.
     *
     * @param totalCount the new 当前时间断内的总请求数
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Gets the 当前时间断内的总请求流量.
     *
     * @return the 当前时间断内的总请求流量
     */
    public Long getTotalFlow() {
        return totalFlow;
    }

    /**
     * Sets the 当前时间断内的总请求流量.
     *
     * @param totalFlow the new 当前时间断内的总请求流量
     */
    public void setTotalFlow(Long totalFlow) {
        this.totalFlow = totalFlow;
    }

    /**
     * Gets the 当前时间断内的总命中数.
     *
     * @return the 当前时间断内的总命中数
     */
    public Long getTotalHit() {
        return totalHit;
    }

    /**
     * Sets the 当前时间断内的总命中数.
     *
     * @param totalHit the new 当前时间断内的总命中数
     */
    public void setTotalHit(Long totalHit) {
        this.totalHit = totalHit;
    }

    /**
     * Gets the 当前时间断内的总命中流量.
     *
     * @return the 当前时间断内的总命中流量
     */
    public Long getTotalHitFlow() {
        return totalHitFlow;
    }

    /**
     * Sets the 当前时间断内的总命中流量.
     *
     * @param totalHitFlow the new 当前时间断内的总命中流量
     */
    public void setTotalHitFlow(Long totalHitFlow) {
        this.totalHitFlow = totalHitFlow;
    }

    /**
     * Gets the 当前时间断内的总miss数.
     *
     * @return the 当前时间断内的总miss数
     */
    public Long getTotalMiss() {
        return totalMiss;
    }

    /**
     * Sets the 当前时间断内的总miss数.
     *
     * @param totalMiss the new 当前时间断内的总miss数
     */
    public void setTotalMiss(Long totalMiss) {
        this.totalMiss = totalMiss;
    }

    /**
     * Gets the 当前时间断内的总没有命中流量.
     *
     * @return the 当前时间断内的总没有命中流量
     */
    public Long getTotalMissFlow() {
        return totalMissFlow;
    }

    /**
     * Sets the 当前时间断内的总没有命中流量.
     *
     * @param totalMissFlow the new 当前时间断内的总没有命中流量
     */
    public void setTotalMissFlow(Long totalMissFlow) {
        this.totalMissFlow = totalMissFlow;
    }

    /**
     * Gets the 各种状态码的命中率细节.
     *
     * @return the 各种状态码的命中率细节
     */
    public List<StatusCode> getCodes() {
        return codes;
    }

    /**
     * Sets the 各种状态码的命中率细节.
     *
     * @param codes the new 各种状态码的命中率细节
     */
    public void setCodes(List<StatusCode> codes) {
        this.codes = codes;
    }

	@Override
	public String toString() {
		return "StatusCodeHitRateDetail [time=" + time + ", totalCount=" + totalCount + ", totalFlow=" + totalFlow
				+ ", totalHit=" + totalHit + ", totalHitFlow=" + totalHitFlow + ", totalMiss=" + totalMiss
				+ ", totalMissFlow=" + totalMissFlow + ", codes=" + codes + "]";
	}

}
