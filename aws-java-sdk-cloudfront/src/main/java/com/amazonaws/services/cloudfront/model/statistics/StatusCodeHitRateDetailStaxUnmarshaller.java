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

package com.amazonaws.services.cloudfront.model.statistics;

import javax.xml.stream.events.XMLEvent;

import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * CalculateBandwidth StAX Unmarshaller
 */
public class StatusCodeHitRateDetailStaxUnmarshaller implements Unmarshaller<StatusCodeHitRateDetail, StaxUnmarshallerContext> {

    public StatusCodeHitRateDetail unmarshall(StaxUnmarshallerContext context) throws Exception {
    	StatusCodeHitRateDetail detail = new StatusCodeHitRateDetail();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return detail;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("Time", targetDepth)) {
                    detail.setTime(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("TotalCount", targetDepth)) {
                    detail.setTotalCount(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("TotalHit", targetDepth)) {
                    detail.setTotalHit(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("TotalMiss", targetDepth)) {
                    detail.setTotalMiss(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Codes/StatusCode", targetDepth)) {
                	detail.getCodes().add(StatusCodeSatxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return detail;
                }
            }
        }
    }

    private static StatusCodeHitRateDetailStaxUnmarshaller instance;
    public static StatusCodeHitRateDetailStaxUnmarshaller getInstance() {
        if (instance == null) instance = new StatusCodeHitRateDetailStaxUnmarshaller();
        return instance;
    }
}
    