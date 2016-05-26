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
package com.amazonaws.services.cloudfront.model.transform.log;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cloudfront.model.log.GetLogRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Create GetLog Request Marshaller
 */
public class GetLogRequestMarshaller
        implements Marshaller<Request<GetLogRequest>, GetLogRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;

    static {
        String path = "/2016-05-20/log/{DistributionId}/logs";
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

    public Request<GetLogRequest> marshall(GetLogRequest getLogRequest) {
        if (getLogRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<GetLogRequest> request = new DefaultRequest<GetLogRequest>(getLogRequest, "cdn");
        request.setHttpMethod(HttpMethodName.GET);
        request.addHeader("x-action", "GetLog");
        request.addHeader("x-version", "2016-05-20");

        String uriResourcePath = RESOURCE_PATH_TEMPLATE;

        if (DYNAMIC_QUERY_PARAMS.containsKey("DistributionId")) {
            System.out.println("contains");
            String name = DYNAMIC_QUERY_PARAMS.get("DistributionId");
            String value = (getLogRequest.getDistributionId() == null) ? null : StringUtils.fromString(getLogRequest.getDistributionId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{DistributionId}",
                    (getLogRequest.getDistributionId() == null) ? "" : StringUtils.fromString(getLogRequest.getDistributionId()));
        }
        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        if (getLogRequest.getStartTime() != null) {
            request.addParameter("startTime", getLogRequest.getStartTime().toString());
        }
        if (getLogRequest.getEndTime() != null) {
            request.addParameter("endTime", getLogRequest.getEndTime().toString());
        }
        if (getLogRequest.getPageIndex() != null) {
            request.addParameter("pageIndex", getLogRequest.getPageIndex().toString());
        }
        if (getLogRequest.getPageSize() != null) {
            request.addParameter("pageSize", getLogRequest.getPageSize().toString());
        }

        request.addHeader("Content-Type", "application/xml");
        request.addHeader("Accept", "application/xml");

        return request;
    }
}
