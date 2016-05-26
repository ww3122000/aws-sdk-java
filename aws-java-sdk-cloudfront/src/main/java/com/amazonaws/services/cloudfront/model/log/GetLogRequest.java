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

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.cloudfront.model.AccetypeEnum;
import org.joda.time.DateTime;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
public class GetLogRequest extends AmazonWebServiceRequest implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4055106971593998926L;//这是指定的么？
	
	/**
     * The distribution's id.
     */
    private String distributionId;

	private Long startTime;  //Date or DateTime ?
	private Long endTime;

	private Integer pageIndex;

	private Integer pageSize;

    public GetLogRequest() {
    }

    public GetLogRequest(String distributionId, Long startTime, Long endTime, Integer pageIndex, Integer pageSize) {
        this.distributionId = distributionId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
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
	public GetLogRequest clone() {
		return (GetLogRequest) super.clone();
	}
}
