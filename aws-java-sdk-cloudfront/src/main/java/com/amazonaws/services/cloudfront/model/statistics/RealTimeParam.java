package com.amazonaws.services.cloudfront.model.statistics;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 实时状态码<br>.
 *
 * @author wangwei <br/>
 * 2016年3月8日 下午8:06:08 <br/>
 */
@XmlRootElement(name="RealTimeStatusCodeHitRate")
@XmlAccessorType (XmlAccessType.FIELD)
public class RealTimeParam {

    /** 用户id. */
    @XmlElement(name = "UserId")
    protected String userId;

    /** 开始时间. */
    @XmlElement(name = "StartTime")
    protected Date startTime;

    /** 结束时间. */
    @XmlElement(name = "EndTime")
    protected Date endTime;

    /** 域名，以分号分隔, 如果没有则为all. */
    @XmlElement(name = "Domains")
    protected String domains;

	/**
	 * Gets the 用户id.
	 *
	 * @return the 用户id
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * Sets the 用户id.
	 *
	 * @param userId
	 *            the new 用户id
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * Gets the 开始时间.
	 *
	 * @return the 开始时间
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * Sets the 开始时间.
	 *
	 * @param startTime
	 *            the new 开始时间
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * Gets the 结束时间.
	 *
	 * @return the 结束时间
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * Sets the 结束时间.
	 *
	 * @param endTime
	 *            the new 结束时间
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * Gets the 域名，以分号分隔, 如果没有则为all.
	 *
	 * @return the 域名，以分号分隔, 如果没有则为all
	 */
	public String getDomains() {
		return domains;
	}

	/**
	 * Sets the 域名，以分号分隔, 如果没有则为all.
	 *
	 * @param domains
	 *            the new 域名，以分号分隔, 如果没有则为all
	 */
	public void setDomains(String domains) {
		this.domains = domains;
	}

}
