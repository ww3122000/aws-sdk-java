package com.amazonaws.services.cloudfront.model.statistics;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 具体一个域名的状态码命中率按时间详细.
 *
 * @author wangwei <br/>
 * 2016年3月8日 下午8:18:16 <br/>
 */
@XmlRootElement(name="StatusCodeHitRateDetail")
@XmlAccessorType (XmlAccessType.FIELD)
public class StatusCodeHitRateDetail {

    /** The time. */
    @XmlElement(name = "Time")
    protected Long time;

    /** The total count. */
    @XmlElement(name = "TotalCount")
    protected Long totalCount;

    /** The total hit. */
    @XmlElement(name = "TotalHit")
    protected Long totalHit;

    /** The total miss. */
    @XmlElement(name = "TotalMiss")
    protected Long totalMiss;

    /** 各种状态码的命中率. */
    @XmlElement(name = "Codes")
    protected List<StatusCode> codes;
    
    public StatusCodeHitRateDetail() {
		super();
		codes = new ArrayList<StatusCode>();
	}

	/**
     * Gets the time.
     *
     * @return the time
     */
    public Long getTime() {
        return time;
    }

    /**
     * Sets the time.
     *
     * @param time the new time
     */
    public void setTime(Long time) {
        this.time = time;
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
     * Gets the 各种状态码的命中率.
     *
     * @return the 各种状态码的命中率
     */
    public List<StatusCode> getCodes() {
        return codes;
    }

    /**
     * Sets the 各种状态码的命中率.
     *
     * @param codes the new 各种状态码的命中率
     */
    public void setCodes(List<StatusCode> codes) {
        this.codes = codes;
    }

	@Override
	public String toString() {
		return "StatusCodeHitRateDetail [time=" + time + ", totalCount=" + totalCount + ", totalHit=" + totalHit
				+ ", totalMiss=" + totalMiss + ", codes=" + codes + "]";
	}
    
}
