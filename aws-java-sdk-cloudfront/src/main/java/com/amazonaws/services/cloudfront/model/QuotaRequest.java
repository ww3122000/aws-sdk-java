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

/**
 * 用户配额的请求
 */
public class QuotaRequest extends AmazonWebServiceRequest implements Serializable, Cloneable {
	
	/**
	 * 用户的 id，默认为用户的 id，使用者不需要传递
	 */
	private String userId;
	
    /**
     * Default constructor for a new CreateInvalidationRequest object.  Callers should use the
     * setter or fluent setter (with...) methods to initialize this object after creating it.
     */
    public QuotaRequest() {}
    
    
    /**
	 * Gets the 用户的 id，默认为用户的 id，使用者不需要传递.
	 *
	 * @return the 用户的 id，默认为用户的 id，使用者不需要传递
	 */
    public String getUserId() {
		return userId;
	}

	/**
	 * Sets the 用户的 id，默认为用户的 id，使用者不需要传递.
	 *
	 * @param userId
	 *            the new 用户的 id，默认为用户的 id，使用者不需要传递
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
    public QuotaRequest clone() {
        
            return (QuotaRequest) super.clone();
    }

}
    