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

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * An 计算带宽.
 * </p>
 */
@XmlRootElement(name="CalculateBandwidth")
@XmlAccessorType (XmlAccessType.FIELD)
public class CalculateBandwidth implements Serializable, Cloneable {

    /**
     * The user's id.
     */
    @XmlElement(name = "UserId")
    private String userId;

    /**
     * 维度.
     */
    @XmlElement(name = "Dimension")
    private String dimension;
    
    /** 返回结果格式类型：1：自定义json 2：标准json 3：xml. */
    @XmlElement(name = "OutType")
    private String outType;

    /**
     * 起始时间.
     */
    @XmlElement(name = "StartTime")
    private String startTime;

    /**
     * 结束时间.
     */
    @XmlElement(name = "EndTime")
    private String endTime;
    
    /** 域名. */
    @XmlElement(name = "Domain")
    private String domain;

    /** 带宽. */
    @XmlElement(name = "Bandwidth")
    private String bandwidth;
    
    /**  地区 *. */
    @XmlElement(name = "Region")
    private String region;
    
    /**  加速类型 *. */
    @XmlElement(name = "Accetype")
    private String accetype;

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

    /**
     * Gets the 维度.
     *
     * @return the 维度
     */
    public String getDimension() {
        return dimension;
    }

    /**
     * Sets the 维度.
     *
     * @param dimension the new 维度
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    /**
     * Gets the 返回结果格式类型：1：自定义json 2：标准json 3：xml.
     *
     * @return the 返回结果格式类型：1：自定义json 2：标准json 3：xml
     */
    public String getOutType() {
        return outType;
    }

    /**
     * Sets the 返回结果格式类型：1：自定义json 2：标准json 3：xml.
     *
     * @param outType the new 返回结果格式类型：1：自定义json 2：标准json 3：xml
     */
    public void setOutType(String outType) {
        this.outType = outType;
    }
    
    /**
     * Gets the 加速类型 *.
     *
     * @return the 加速类型 *
     */
    public String getAccetype() {
        return accetype;
    }

    /**
     * Sets the 加速类型 *.
     *
     * @param accetype the new 加速类型 *
     */
    public void setAccetype(String accetype) {
        this.accetype = accetype;
    }

    /**
     * Gets the 地区 *.
     *
     * @return the 地区 *
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the 地区 *.
     *
     * @param region the new 地区 *
     */
    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "CalculateBandwidth [userId=" + userId + ", dimension=" + dimension + ", outType=" + outType + ", startTime=" + startTime + ", endTime=" + endTime + ", domain=" + domain
                + ", bandwidth=" + bandwidth + ", region=" + region + ", accetype=" + accetype + "]";
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
