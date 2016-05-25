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
package com.amazonaws.services.cloudfront.model.log;

import java.io.Serializable;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.cloudfront.model.AccetypeEnum;

/**
 * <p>
 * RealTimeStatusCodeHitRate.
 * </p>
 *
 */
public class ListLogSettingRequest extends AmazonWebServiceRequest implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4055106971593998926L;
	
	/**
     * The distribution's id.
     */
    private String distributionId;

	/**
	 * 粒度
	 */
	private GranularityEnum granularity;

	/**
	 * 日志开启状态
	 */
	private StatusEnum status;

	/**
	 * 加速类型
	 */
	private AccetypeEnum type;

	/**
	 * 查询的域名
	 */
	private String domain;

	private Integer pageIndex;

	private Integer pageSize;

	public GranularityEnum getGranularity() {
		return granularity;
	}

	public void setGranularity(GranularityEnum granularity) {
		this.granularity = granularity;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public AccetypeEnum getType() {
		return type;
	}

	public void setType(AccetypeEnum type) {
		this.type = type;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Integer getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getDistributionId() {
		return distributionId;
	}

	public void setDistributionId(String distributionId) {
		this.distributionId = distributionId;
	}

	@Override
	public ListLogSettingRequest clone() {

		return (ListLogSettingRequest) super.clone();
	}

}
