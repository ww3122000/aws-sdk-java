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

import com.amazonaws.services.cloudfront.model.statistics.RealTimeStatusCodeHitRate;

/**
 * <p>
 * The returned result of the corresponding request.
 * </p>
 */
public class RealTimeStatusCodeHitRateResult implements Serializable, Cloneable {

    /**
     * The fully qualified URI of the distribution and invalidation batch
     * request, including the Invalidation ID.
     */
    private String location;

    
    private RealTimeStatusCodeHitRate realTimeStatusCodeHitRate;

    /**
     * The fully qualified URI of the distribution and invalidation batch
     * request, including the Invalidation ID.
     *
     * @return The fully qualified URI of the distribution and invalidation batch
     *         request, including the Invalidation ID.
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * The fully qualified URI of the distribution and invalidation batch
     * request, including the Invalidation ID.
     *
     * @param location The fully qualified URI of the distribution and invalidation batch
     *         request, including the Invalidation ID.
     */
    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     * The fully qualified URI of the distribution and invalidation batch
     * request, including the Invalidation ID.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param location The fully qualified URI of the distribution and invalidation batch
     *         request, including the Invalidation ID.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public RealTimeStatusCodeHitRateResult withLocation(String location) {
        this.location = location;
        return this;
    }

	public RealTimeStatusCodeHitRate getRealTimeStatusCodeHitRate() {
		return realTimeStatusCodeHitRate;
	}

	public void setRealTimeStatusCodeHitRate(RealTimeStatusCodeHitRate realTimeStatusCodeHitRate) {
		this.realTimeStatusCodeHitRate = realTimeStatusCodeHitRate;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((realTimeStatusCodeHitRate == null) ? 0 : realTimeStatusCodeHitRate.hashCode());
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
		RealTimeStatusCodeHitRateResult other = (RealTimeStatusCodeHitRateResult) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (realTimeStatusCodeHitRate == null) {
			if (other.realTimeStatusCodeHitRate != null)
				return false;
		} else if (!realTimeStatusCodeHitRate.equals(other.realTimeStatusCodeHitRate))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "RealTimeStatusCodeHitRateResult [location=" + location + ", realTimeStatusCodeHitRate="
				+ realTimeStatusCodeHitRate + "]";
	}

	@Override
    public RealTimeStatusCodeHitRateResult clone() {
        try {
            return (RealTimeStatusCodeHitRateResult) super.clone();
        
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                    + "even though we're Cloneable!",
                    e);
        }
        
    }

}
    