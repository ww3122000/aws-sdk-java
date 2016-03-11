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

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.services.cloudfront.model.statistics.RealTimeParam;

/**
 * <p>
 * RealTimeStatusCodeHitRate.
 * </p>
 *
 */
public class RealTimeStatusCodeHitRateRequest extends AmazonWebServiceRequest implements Serializable, Cloneable {
    
    /**
     * The distribution's id.
     */
    private String distributionId;
    
    private RealTimeParam realTimeParam;
    
    /**
     * Default constructor for a new CreateInvalidationRequest object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public RealTimeStatusCodeHitRateRequest() {
    	super();
    }
    
    public RealTimeStatusCodeHitRateRequest(RealTimeParam realTimeParam) {
    	this(null, realTimeParam);
	}

	public RealTimeStatusCodeHitRateRequest(String distributionId, RealTimeParam realTimeParam) {
		super();
		this.distributionId = distributionId;
		this.realTimeParam = realTimeParam;
	}



	/**
     * The distribution's id.
     *
     * @return The distribution's id.
     */
    public String getDistributionId() {
        return distributionId;
    }
    
    /**
     * The distribution's id.
     *
     * @param distributionId The distribution's id.
     */
    public void setDistributionId(String distributionId) {
        this.distributionId = distributionId;
    }

	public RealTimeParam getRealTimeParam() {
		return realTimeParam;
	}

	public void setRealTimeParam(RealTimeParam realTimeParam) {
		this.realTimeParam = realTimeParam;
	}

	/**
     * The distribution's id.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param distributionId The distribution's id.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RealTimeStatusCodeHitRateRequest withDistributionId(String distributionId) {
        this.distributionId = distributionId;
        return this;
    }
    
    @Override
    public RealTimeStatusCodeHitRateRequest clone() {
        
            return (RealTimeStatusCodeHitRateRequest) super.clone();
    }

}
    