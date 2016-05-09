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
package com.amazonaws.services.cloudfront.model.transform;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cloudfront.model.ListContentPathsRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * List ContentPaths Request Marshaller
 */
public class ListContentPathsRequestMarshaller implements Marshaller<Request<ListContentPathsRequest>, ListContentPathsRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
          
        String path = "/2015-09-17/distribution/content-path?"
        		+ "UserId={UserId}&QueryName={QueryName}&Type={Type}&StartTime={StartTime}&EndTime={EndTime}"
        		+ "&PageIndex={PageIndex}&PageSize={PageSize}";
        Map<String, String> staticMap = new HashMap<String, String>();
        Map<String, String> dynamicMap = new HashMap<String, String>();

        int index = path.indexOf("?");
        if (index != -1) {
            String queryString = path.substring(index + 1);
            path = path.substring(0, index);

            for (String s : queryString.split("[;&]")) {
                index = s.indexOf("=");
                if (index != -1) {
                    String name = s.substring(0, index);
                    String value = s.substring(index + 1);

                    if (value.startsWith("{") && value.endsWith("}")) {
                        dynamicMap.put(value.substring(1, value.length() - 1), name);
                    } else {
                        staticMap.put(name, value);
                    }
                }
            }
        }

        RESOURCE_PATH_TEMPLATE = path;
        STATIC_QUERY_PARAMS = Collections.unmodifiableMap(staticMap);
        DYNAMIC_QUERY_PARAMS = Collections.unmodifiableMap(dynamicMap);
    }

    public Request<ListContentPathsRequest> marshall(ListContentPathsRequest listContentPathsRequest) {

        if (listContentPathsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListContentPathsRequest> request = new DefaultRequest<ListContentPathsRequest>(listContentPathsRequest, "AmazonCloudFront");
        request.setHttpMethod(HttpMethodName.GET);
        request.addHeader("x-action", "ListInvalidationsByContentPath");
        request.addHeader("x-version", "2015-09-17");

        String uriResourcePath = RESOURCE_PATH_TEMPLATE;
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("UserId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("UserId");
            String value = (listContentPathsRequest.getUserId() == null) ? null : StringUtils.fromLong(listContentPathsRequest.getUserId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{UserId}", (listContentPathsRequest.getUserId() == null) ? "" : StringUtils.fromLong(listContentPathsRequest.getUserId())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("QueryName")) {
            String name = DYNAMIC_QUERY_PARAMS.get("QueryName");
            String value = (listContentPathsRequest.getQueryName() == null) ? null : StringUtils.fromString(listContentPathsRequest.getQueryName());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{QueryName}", (listContentPathsRequest.getQueryName() == null) ? "" : StringUtils.fromString(listContentPathsRequest.getQueryName())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("Type")) {
            String name = DYNAMIC_QUERY_PARAMS.get("Type");
            String value = (listContentPathsRequest.getType() == null) ? null : listContentPathsRequest.getType().value;

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{Type}", (listContentPathsRequest.getType() == null) ? "" : listContentPathsRequest.getType().value); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("StartTime")) {
        	String name = DYNAMIC_QUERY_PARAMS.get("StartTime");
        	String value = (listContentPathsRequest.getStartTime() == null) ? null : StringUtils.fromLong(listContentPathsRequest.getStartTime().getTime());
        	
        	if (!(value == null || value.isEmpty())) {
        		request.addParameter(name, value);
        	}
        } else {
        	uriResourcePath = uriResourcePath.replace("{StartTime}", (listContentPathsRequest.getStartTime() == null) ? "" : StringUtils.fromLong(listContentPathsRequest.getStartTime().getTime())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("EndTime")) {
        	String name = DYNAMIC_QUERY_PARAMS.get("EndTime");
        	String value = (listContentPathsRequest.getEndTime() == null) ? null : StringUtils.fromLong(listContentPathsRequest.getEndTime().getTime());
        	
        	if (!(value == null || value.isEmpty())) {
        		request.addParameter(name, value);
        	}
        } else {
        	uriResourcePath = uriResourcePath.replace("{EndTime}", (listContentPathsRequest.getEndTime() == null) ? "" : StringUtils.fromLong(listContentPathsRequest.getEndTime().getTime())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("PageIndex")) {
        	String name = DYNAMIC_QUERY_PARAMS.get("PageIndex");
        	String value = (listContentPathsRequest.getPageIndex() == null) ? null : StringUtils.fromInteger(listContentPathsRequest.getPageIndex());
        	
        	if (!(value == null || value.isEmpty())) {
        		request.addParameter(name, value);
        	}
        } else {
        	uriResourcePath = uriResourcePath.replace("{PageSize}", (listContentPathsRequest.getPageIndex() == null) ? "" : StringUtils.fromInteger(listContentPathsRequest.getPageIndex())); 
        }
        if (DYNAMIC_QUERY_PARAMS.containsKey("PageSize")) {
        	String name = DYNAMIC_QUERY_PARAMS.get("PageSize");
        	String value = (listContentPathsRequest.getPageSize() == null) ? null : StringUtils.fromInteger(listContentPathsRequest.getPageSize());
        	
        	if (!(value == null || value.isEmpty())) {
        		request.addParameter(name, value);
        	}
        } else {
        	uriResourcePath = uriResourcePath.replace("{PageSize}", (listContentPathsRequest.getPageSize() == null) ? "" : StringUtils.fromInteger(listContentPathsRequest.getPageSize())); 
        }

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        return request;
    }
}
