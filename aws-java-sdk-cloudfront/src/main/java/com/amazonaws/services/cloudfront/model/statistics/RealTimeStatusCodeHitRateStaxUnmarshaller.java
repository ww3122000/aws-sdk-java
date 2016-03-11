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
public class RealTimeStatusCodeHitRateStaxUnmarshaller implements Unmarshaller<RealTimeStatusCodeHitRate, StaxUnmarshallerContext> {

    public RealTimeStatusCodeHitRate unmarshall(StaxUnmarshallerContext context) throws Exception {
    	RealTimeStatusCodeHitRate rate = new RealTimeStatusCodeHitRate();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return rate;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("UserId", targetDepth)) {
                    rate.setUserId(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("StartTime", targetDepth)) {
                    rate.setStartTime(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("EndTime", targetDepth)) {
                    rate.setEndTime(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Domains", targetDepth)) {
                    rate.setDomains(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Data/StatusCodeHitRate", targetDepth)) {
                	rate.getData().add(StatusCodeHitRateUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return rate;
                }
            }
        }
    }

    private static RealTimeStatusCodeHitRateStaxUnmarshaller instance;
    public static RealTimeStatusCodeHitRateStaxUnmarshaller getInstance() {
        if (instance == null) instance = new RealTimeStatusCodeHitRateStaxUnmarshaller();
        return instance;
    }
}
    