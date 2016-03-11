package com.amazonaws.services.cloudfront.model.statistics;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class StatusCodeHitRate.
 */
@XmlRootElement(name="StatusCodeHitRate")
@XmlAccessorType (XmlAccessType.FIELD)
public class StatusCodeHitRate {
    
    /** 域名. */
    @XmlElement(name = "Domain")
    protected String domain;
    
    /** The total count. */
    @XmlElement(name = "TotalCount")
    protected Long totalCount;
    
    /** The total hit. */
    @XmlElement(name = "TotalHit")
    protected Long totalHit;
    
    /** The total miss. */
    @XmlElement(name = "TotalMiss")
    protected Long totalMiss;
    
    /** 具体一个域名的状态码命中率按时间详细. */
    @XmlElement(name = "Detail")
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
     * Gets the total count.
     *
     * @return the total count
     */
    public Long getTotalCount() {
        return totalCount;
    }

    /**
     * Sets the total count.
     *
     * @param totalCount the new total count
     */
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * Gets the total hit.
     *
     * @return the total hit
     */
    public Long getTotalHit() {
        return totalHit;
    }

    /**
     * Sets the total hit.
     *
     * @param totalHit the new total hit
     */
    public void setTotalHit(Long totalHit) {
        this.totalHit = totalHit;
    }

    /**
     * Gets the total miss.
     *
     * @return the total miss
     */
    public Long getTotalMiss() {
        return totalMiss;
    }

    /**
     * Sets the total miss.
     *
     * @param totalMiss the new total miss
     */
    public void setTotalMiss(Long totalMiss) {
        this.totalMiss = totalMiss;
    }

    /**
     * Gets the detail.
     *
     * @return the detail
     */
    public List<StatusCodeHitRateDetail> getDetail() {
        return detail;
    }

    /**
     * Sets the detail.
     *
     * @param detail the new detail
     */
    public void setDetail(List<StatusCodeHitRateDetail> detail) {
        this.detail = detail;
    }

	@Override
	public String toString() {
		return "StatusCodeHitRate [domain=" + domain + ", totalCount=" + totalCount + ", totalHit=" + totalHit
				+ ", totalMiss=" + totalMiss + ", detail=" + detail + "]";
	}
    
}
