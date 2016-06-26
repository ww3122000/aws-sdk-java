package com.amazonaws.services.cloudfront.model.statistics;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 实时状态码<br>.
 *
 * @author wangwei <br/>
 * 2016年3月8日 下午8:06:08 <br/>
 */
@XmlRootElement(name="RealTimeStatusCodeHitRate")
@XmlAccessorType (XmlAccessType.FIELD)
public class RealTimeStatusCodeHitRate {
    /** 是否返回状态码详细信息. */
    @XmlElement(name = "StatusCodeDetail")
    protected Boolean statusCodeDetail = false;

    /** 用户id. */
    @XmlElement(name = "UserId")
    protected String userId;

    /** 开始时间. */
    @XmlElement(name = "StartTime")
    protected Long startTime;

    /** 结束时间. */
    @XmlElement(name = "EndTime")
    protected Long endTime;

    /** 域名，以分号分隔, 如果没有则为all. */
    @XmlElement(name = "Domains")
    protected String domains;

    /** 状态码的命中率按域名详细信息. */
    @XmlElement(name = "Data")
    protected List<StatusCodeHitRate> data;
    

    public RealTimeStatusCodeHitRate() {
		super();
		data = new ArrayList<StatusCodeHitRate>();
	}

    public Boolean getStatusCodeDetail() {
        return statusCodeDetail;
    }

    public void setStatusCodeDetail(Boolean statusCodeDetail) {
        this.statusCodeDetail = statusCodeDetail;
    }

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
     * @param userId the new 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the 开始时间.
     *
     * @return the 开始时间
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * Sets the 开始时间.
     *
     * @param startTime the new 开始时间
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the 结束时间.
     *
     * @return the 结束时间
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     * Sets the 结束时间.
     *
     * @param endTime the new 结束时间
     */
    public void setEndTime(Long endTime) {
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
     * @param domains the new 域名，以分号分隔, 如果没有则为all
     */
    public void setDomains(String domains) {
        this.domains = domains;
    }

    /**
     * Gets the 状态码的命中率按域名详细信息.
     *
     * @return the 状态码的命中率按域名详细信息
     */
    public List<StatusCodeHitRate> getData() {
        return data;
    }

    /**
     * Sets the 状态码的命中率按域名详细信息.
     *
     * @param data the new 状态码的命中率按域名详细信息
     */
    public void setData(List<StatusCodeHitRate> data) {
        this.data = data;
    }

	@Override
	public String toString() {
		return "RealTimeStatusCodeHitRate [userId=" + userId + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", domains=" + domains + ", data=" + data + "]";
	}
    
}
