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
import java.util.Map.Entry;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cloudfront.model.Quota;
import com.amazonaws.services.cloudfront.model.UpdateQuotaRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.XMLWriter;

/**
 */
public class UpdateQuotaConfigRequestMarshaller implements Marshaller<Request<UpdateQuotaRequest>, UpdateQuotaRequest> {

    private static final String RESOURCE_PATH_TEMPLATE;
    private static final Map<String, String> STATIC_QUERY_PARAMS;
    private static final Map<String, String> DYNAMIC_QUERY_PARAMS;
    static {
        String path = "/2015-09-17/quota/config/{userId}";
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

    public Request<UpdateQuotaRequest> marshall(UpdateQuotaRequest updateQuotaRequest) {

        if (updateQuotaRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<UpdateQuotaRequest> request = new DefaultRequest<UpdateQuotaRequest>(updateQuotaRequest, "AmazonCloudFront");
        request.setHttpMethod(HttpMethodName.PUT);
        request.addHeader("x-action", "UpdateQuotaConfig");
        request.addHeader("x-version", "2015-09-17");
        

        String uriResourcePath = RESOURCE_PATH_TEMPLATE;
        
        for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
            request.addParameter(entry.getKey(), entry.getValue());
        }
        
        if (DYNAMIC_QUERY_PARAMS.containsKey("userId")) {
            String name = DYNAMIC_QUERY_PARAMS.get("userId");
            String value = (updateQuotaRequest.getUserId() == null) ? null : StringUtils.fromString(updateQuotaRequest.getUserId());

            if (!(value == null || value.isEmpty())) {
                request.addParameter(name, value);
            }
        } else {
            uriResourcePath = uriResourcePath.replace("{userId}", (updateQuotaRequest.getUserId() == null) ? "" : StringUtils.fromString(updateQuotaRequest.getUserId())); 
        }
        
        request.setResourcePath(uriResourcePath.replaceAll("//", "/"));
        
		StringWriter stringWriter = new StringWriter();
		XMLWriter xmlWriter = new XMLWriter(stringWriter, "http://cloudfront.amazonaws.com/doc/2015-09-17/");

		if (updateQuotaRequest != null) {
			Quota quota = updateQuotaRequest.getQuota();
			if (quota != null) {
				xmlWriter.startElement("Quota");
				Map<String, Long> map = quota.getDetail();
				
				if (map != null && map.size() > 0) {
					xmlWriter.startElement("Detail");
					for(Entry<String, Long> entry : map.entrySet()){
						xmlWriter.startElement("entry");
						
						xmlWriter.startElement("key").value(entry.getKey()).endElement();
						xmlWriter.startElement("value").value(entry.getValue()).endElement();
						xmlWriter.endElement();
					}
					xmlWriter.endElement();
				}
				xmlWriter.endElement();
			}
		}

		try {
			String content = stringWriter.getBuffer().toString();
			request.setContent(new StringInputStream(content));
			request.addHeader("Content-Length",Integer.toString(stringWriter.getBuffer().toString().getBytes(UTF8).length));
			request.addHeader("Content-Type", "application/xml");
		} catch (UnsupportedEncodingException e) {
			throw new AmazonClientException("Unable to marshall request to XML", e);
		}
        
        return request;
    }
}
