/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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
 * The returned result of the listContentPaths request.
 * </p>
 */
public class ListContentPathsResult implements Serializable, Cloneable {

    /**
     * Information about invalidation batches.
     */
    private ContentPathList listContentPaths;

	public ContentPathList getListContentPaths() {
		return listContentPaths;
	}

	public void setListContentPaths(ContentPathList listContentPaths) {
		this.listContentPaths = listContentPaths;
	}

}
    