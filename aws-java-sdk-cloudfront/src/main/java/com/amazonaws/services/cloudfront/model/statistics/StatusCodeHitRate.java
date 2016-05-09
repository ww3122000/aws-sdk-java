package com.amazonaws.services.cloudfront.model.statistics;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 状态码，命中率流量信息.
 */
@XmlRootElement(name="StatusCodeHitRate")
@XmlAccessorType (XmlAccessType.FIELD)
public class StatusCodeHitRate {
    
    /** 域名. */
    @XmlElement(name = "Domain")
    protected String domain;
    
    /** 总请求数. */
    @XmlElement(name = "TotalCount")
    protected Long totalCount;
    
    /** 总请求流量. */
    @XmlElement(name = "TotalFlow")
    protected Long totalFlow;
    
    /** 总命中数. */
    @XmlElement(name = "TotalHit")
    protected Long totalHit;
    
    /** 总命中流量. */
    @XmlElement(name = "TotalHitFlow")
    protected Long totalHitFlow;
    
    /** 总miss数. */
    @XmlElement(name = "TotalMiss")
    protected Long totalMiss;
    
    /** 总没有命中流量. */
    @XmlElement(name = "TotalMissFlow")
    protected Long totalMissFlow;
    
    /** 具体一个域名的状态码命中率按时间详细. */
    @XmlElementWrapper(name = "Detail")
    @XmlElement(name="StatusCodeHitRateDetail")
    protected List<StatusCodeHitRateDetail> detail;
    
    public StatusCodeHitRate() {
		super();
		detail = new ArrayList<StatusCodeHitRateDetail>();
	}

    /**
     * Gets the 域名.
     *
     * @return the 域名
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets the 域名.
     *
     * @param domain the new 域名
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * Gets the 总请求数.
     *
     * @return the 总请求数
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the 总请求数.
     *
     * @param totalCount the new 总请求数
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Gets the 总命中数.
     *
     * @return the 总命中数
     */
    public Long getTotalHit() {
        return totalHit;
    }

    /**
     * Sets the 总命中数.
     *
     * @param totalHit the new 总命中数
     */
    public void setTotalHit(Long totalHit) {
        this.totalHit = totalHit;
    }

    /**
     * Gets the 总没有命中数.
     *
     * @return the 总没有命中数
     */
    public Long getTotalMiss() {
        return totalMiss;
    }
    
    /**
     * Sets the 总没有命中数.
     *
     * @param totalMiss the new 总没有命中数
     */
    public void setTotalMiss(Long totalMiss) {
        this.totalMiss = totalMiss;
    }

    /**
     * Gets the 具体一个域名的状态码命中率按时间详细.
     *
     * @return the 具体一个域名的状态码命中率按时间详细
     */
    public List<StatusCodeHitRateDetail> getDetail() {
        return detail;
    }

    /**
     * Sets the 具体一个域名的状态码命中率按时间详细.
     *
     * @param detail the new 具体一个域名的状态码命中率按时间详细
     */
    public void setDetail(List<StatusCodeHitRateDetail> detail) {
        this.detail = detail;
    }

    /**
     * Gets the 总请求流量.
     *
     * @return the 总请求流量
     */
    public Long getTotalFlow() {
        return totalFlow;
    }

    /**
     * Sets the 总请求流量.
     *
     * @param totalFlow the new 总请求流量
     */
    public void setTotalFlow(Long totalFlow) {
        this.totalFlow = totalFlow;
    }

    /**
     * Gets the 总命中流量.
     *
     * @return the 总命中流量
     */
    public Long getTotalHitFlow() {
        return totalHitFlow;
    }

    /**
     * Sets the 总命中流量.
     *
     * @param totalHitFlow the new 总命中流量
     */
    public void setTotalHitFlow(Long totalHitFlow) {
        this.totalHitFlow = totalHitFlow;
    }

    /**
     * Gets the 总没有命中流量.
     *
     * @return the 总没有命中流量
     */
    public Long getTotalMissFlow() {
        return totalMissFlow;
    }

    /**
     * Sets the 总没有命中流量.
     *
     * @param totalMissFlow the new 总没有命中流量
     */
    public void setTotalMissFlow(Long totalMissFlow) {
        this.totalMissFlow = totalMissFlow;
    }

	@Override
	public String toString() {
		return "StatusCodeHitRate [domain=" + domain + ", totalCount=" + totalCount + ", totalFlow=" + totalFlow
				+ ", totalHit=" + totalHit + ", totalHitFlow=" + totalHitFlow + ", totalMiss=" + totalMiss
				+ ", totalMissFlow=" + totalMissFlow + ", detail=" + detail + "]";
	}
    
}
