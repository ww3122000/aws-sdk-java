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

import static com.amazonaws.util.StringUtils.UTF8;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cloudfront.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.XMLWriter;

/**
 * List Distributions By Web A C L Id Request Marshaller
 */
public class ListDistributionsByWebACLIdRequestMarshaller implements Marshaller<Request<ListDistributionsByWebACLIdRequest>, ListDistributionsByWebACLIdRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "2015-09-17/distributionsByWebACLId/{WebACLId}?Marker={Marker}&MaxItems={MaxItems}";
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

    public Request<ListDistributionsByWebACLIdRequest> marshall(ListDistributionsByWebACLIdRequest listDistributionsByWebACLIdRequest) {

        if (listDistributionsByWebACLIdRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<ListDistributionsByWebACLIdRequest> request = new DefaultRequest<ListDistributionsByWebACLIdRequest>(listDistributionsByWebACLIdRequest, "AmazonCloudFront");
        request.setHttpMethod(HttpMethodName.GET);

        String uriResourcePath = RESOURCE_PATH_TEMPLATE;
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("Marker")) {
            String name = DYNAMIC_QUERY_PARAMS.get("Marker");
            String value = (listDistributionsByWebACLIdRequest.getMarker() == null) ? null : StringUtils.fromString(listDistributionsByWebACLIdRequest.getMarker());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{Marker}", (listDistributionsByWebACLIdRequest.getMarker() == null) ? "" : StringUtils.fromString(listDistributionsByWebACLIdRequest.getMarker())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("MaxItems")) {
            String name = DYNAMIC_QUERY_PARAMS.get("MaxItems");
            String value = (listDistributionsByWebACLIdRequest.getMaxItems() == null) ? null : StringUtils.fromString(listDistributionsByWebACLIdRequest.getMaxItems());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{MaxItems}", (listDistributionsByWebACLIdRequest.getMaxItems() == null) ? "" : StringUtils.fromString(listDistributionsByWebACLIdRequest.getMaxItems())); 
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("WebACLId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("WebACLId");
            String value = (listDistributionsByWebACLIdRequest.getWebACLId() == null) ? null : StringUtils.fromString(listDistributionsByWebACLIdRequest.getWebACLId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{WebACLId}", (listDistributionsByWebACLIdRequest.getWebACLId() == null) ? "" : StringUtils.fromString(listDistributionsByWebACLIdRequest.getWebACLId())); 
        }

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

        return request;
    }
}
