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
package com.amazonaws.services.cloudfront.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cloudfront.model.CalculateBandwidth;
import com.amazonaws.services.cloudfront.model.CalculateBandwidthRequest;
import com.amazonaws.services.cloudfront.model.Paths;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.XMLWriter;

/**
 * Create Invalidation Request Marshaller
 */
public class CalculateBandwidthRequestMarshaller implements Marshaller<Request<CalculateBandwidthRequest>, CalculateBandwidthRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "2015-09-17/distribution/bandwidth";
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

    public Request<CalculateBandwidthRequest> marshall(CalculateBandwidthRequest calculateBandwidthRequest) {

        if (calculateBandwidthRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<CalculateBandwidthRequest> request = new DefaultRequest<CalculateBandwidthRequest>(calculateBandwidthRequest, "AmazonCloudFront");
        request.setHttpMethod(HttpMethodName.POST);

        String uriResourcePath = RESOURCE_PATH_TEMPLATE;
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("DistributionId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("DistributionId");
            String value = (calculateBandwidthRequest.getDistributionId() == null) ? null : StringUtils.fromString(calculateBandwidthRequest.getDistributionId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{DistributionId}", (calculateBandwidthRequest.getDistributionId() == null) ? "" : StringUtils.fromString(calculateBandwidthRequest.getDistributionId())); 
        }

        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }

            StringWriter stringWriter = new StringWriter();
            XMLWriter xmlWriter = new XMLWriter(stringWriter, "http://cloudfront.amazonaws.com/doc/2015-09-17/");

                    if (calculateBandwidthRequest != null) {
            CalculateBandwidth calculateBandwidth = calculateBandwidthRequest.getCalculateBandwidth();
            if (calculateBandwidth != null) {
                xmlWriter.startElement("CalculateBandwidth");
                if (calculateBandwidth != null) {
                    String userId = calculateBandwidth.getUserId();
                    if (userId != null) {
                        xmlWriter.startElement("UserId").value(userId).endElement();
                    }
                    
                    String dimension = calculateBandwidth.getDimension();
                    if (dimension != null) {
                    	xmlWriter.startElement("Dimension").value(dimension).endElement();
                    }
                    
                    String type = calculateBandwidth.getOutType();
                    if (type != null) {
                        xmlWriter.startElement("OutType").value(type).endElement();
                    }
                    
                    String startTime = calculateBandwidth.getStartTime();
                    if (startTime != null) {
                        xmlWriter.startElement("StartTime").value(startTime).endElement();
                    }
                    
                    String endTime = calculateBandwidth.getEndTime();
                    if (endTime != null) {
                        xmlWriter.startElement("EndTime").value(endTime).endElement();
                    }
                    
                    String domain = calculateBandwidth.getDomain();
                    if (domain != null) {
                        xmlWriter.startElement("Domain").value(domain).endElement();
                    }
                    String region = calculateBandwidth.getRegion();
                    if (region != null) {
                    	xmlWriter.startElement("Region").value(region).endElement();
                    }
                    String accetype = calculateBandwidth.getAccetype();
                    if (accetype != null) {
                    	xmlWriter.startElement("Accetype").value(accetype).endElement();
                    }
                }
                xmlWriter.endElement();
            }
        }

            try {
                String content = stringWriter.getBuffer().toString();
                System.out.println("content: " + content);
                request.setContent(new StringInputStream(content));
                request.addHeader("Content-Length", Integer.toString(stringWriter.getBuffer().toString().getBytes(UTF8).length));
                request.addHeader("Content-Type", "application/xml");
            } catch (UnsupportedEncodingException e) {
                throw new AmazonClientException("Unable to marshall request to XML", e);
            }

        return request;
    }
}
