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

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.cloudfront.model.log.ListLogSettingRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

/**
 * Create RealTimeStatusCodeHitRater Request Marshaller
 */
public class ListLogSettingRequestMarshaller
		implements Marshaller<Request<ListLogSettingRequest>, ListLogSettingRequest> {

	private static final String RESOURCE_PATH_TEMPLATE;
	private static final Map<String, String> STATIC_QUERY_PARAMS;
	private static final Map<String, String> DYNAMIC_QUERY_PARAMS;

	static {
		String path = "/2016-05-20/log/logSetting";
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

	public Request<ListLogSettingRequest> marshall(
			ListLogSettingRequest listLogSettingRequest) {

		if (listLogSettingRequest == null) {
			throw new AmazonClientException("Invalid argument passed to marshall(...)");
		}

		Request<ListLogSettingRequest> request = new DefaultRequest<ListLogSettingRequest>(
				listLogSettingRequest, "cdn");
		request.setHttpMethod(HttpMethodName.GET);
		request.addHeader("x-action", "GetLogSetting");
        request.addHeader("x-version", "2016-05-20");

		String uriResourcePath = RESOURCE_PATH_TEMPLATE;

		if (DYNAMIC_QUERY_PARAMS.containsKey("DistributionId")) {
			String name = DYNAMIC_QUERY_PARAMS.get("DistributionId");
			String value = (listLogSettingRequest.getDistributionId() == null) ? null
					: StringUtils.fromString(listLogSettingRequest.getDistributionId());

			if (!(value == null || value.isEmpty())) {
				request.addParameter(name, value);
			}
		} else {
			uriResourcePath = uriResourcePath.replace("{DistributionId}",
					(listLogSettingRequest.getDistributionId() == null) ? ""
							: StringUtils.fromString(listLogSettingRequest.getDistributionId()));
		}

		request.setResourcePath(uriResourcePath.replaceAll("//", "/"));

		for (Map.Entry<String, String> entry : STATIC_QUERY_PARAMS.entrySet()) {
			request.addParameter(entry.getKey(), entry.getValue());
		}

		if(listLogSettingRequest.getGranularity() != null){
        	request.addParameter("granularity", listLogSettingRequest.getGranularity().getValue().toString());
        }
		if(listLogSettingRequest.getStatus() != null){
			request.addParameter("status", listLogSettingRequest.getStatus().getValue().toString());
		}
		if(listLogSettingRequest.getType() != null){
			request.addParameter("type", listLogSettingRequest.getType().getValue().toString());
		}
		if(!StringUtils.isNullOrEmpty(listLogSettingRequest.getDomain())){
			request.addParameter("domain", listLogSettingRequest.getDomain());
		}
		if(listLogSettingRequest.getPageIndex() != null){
			request.addParameter("pageIndex", listLogSettingRequest.getPageIndex().toString());
		}
		if(listLogSettingRequest.getPageSize() != null){
			request.addParameter("pageSize", listLogSettingRequest.getPageSize().toString());
		}

		request.addHeader("Content-Type", "application/xml");
		request.addHeader("Accept", "application/xml");

		return request;
	}
}
