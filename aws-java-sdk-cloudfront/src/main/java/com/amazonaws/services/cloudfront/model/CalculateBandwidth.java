/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.cloudfront.model;

import java.io.Serializable;

/**
 * <p>
 * An 计算带宽.
 * </p>
 */
public class CalculateBandwidth implements Serializable, Cloneable {

    /**
     * The user's id.
     */
    private String userId;

    /**
     * The response style type.
     */
    private String type;

    /**
     * 起始时间.
     */
    private String startTime;

    /**
     * 结束时间.
     */
    private String endTime;
    
    /**
     * 域名
     */
    private String domain;

    /** 带宽. */
    private String bandwidth;

    /**
     * Gets the user's id.
     *
     * @return the user's id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user's id.
     *
     * @param userId the new user's id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the response style type.
     *
     * @return the response style type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the response style type.
     *
     * @param type the new response style type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the 起始时间.
     *
     * @return the 起始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * Sets the 起始时间.
     *
     * @param startTime the new 起始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the 结束时间.
     *
     * @return the 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * Sets the 结束时间.
     *
     * @param endTime the new 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the 带宽.
     *
     * @return the 带宽
     */
    public String getBandwidth() {
        return bandwidth;
    }

    /**
     * Sets the 带宽.
     *
     * @param bandwidth the new 带宽
     */
    public void setBandwidth(String bandwidth) {
        this.bandwidth = bandwidth;
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
    
    

    @Override
    public String toString() {
        return "CalculateBandwidth [userId=" + userId + ", type=" + type + ", startTime=" + startTime + ", endTime=" + endTime + ", domain=" + domain + ", bandwidth=" + bandwidth + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bandwidth == null) ? 0 : bandwidth.hashCode());
        result = prime * result + ((domain == null) ? 0 : domain.hashCode());
        result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
        result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
        result = prime * result + ((type == null) ? 0 : type.hashCode());
        result = prime * result + ((userId == null) ? 0 : userId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CalculateBandwidth other = (CalculateBandwidth) obj;
        if (bandwidth == null) {
            if (other.bandwidth != null)
                return false;
        } else if (!bandwidth.equals(other.bandwidth))
            return false;
        if (domain == null) {
            if (other.domain != null)
                return false;
        } else if (!domain.equals(other.domain))
            return false;
        if (endTime == null) {
            if (other.endTime != null)
                return false;
        } else if (!endTime.equals(other.endTime))
            return false;
        if (startTime == null) {
            if (other.startTime != null)
                return false;
        } else if (!startTime.equals(other.startTime))
            return false;
        if (type == null) {
            if (other.type != null)
                return false;
        } else if (!type.equals(other.type))
            return false;
        if (userId == null) {
            if (other.userId != null)
                return false;
        } else if (!userId.equals(other.userId))
            return false;
        return true;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#clone()
     */
    @Override
    public CalculateBandwidth clone() {
        try {
            return (CalculateBandwidth) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!",
                    e);
        }

    }

}
