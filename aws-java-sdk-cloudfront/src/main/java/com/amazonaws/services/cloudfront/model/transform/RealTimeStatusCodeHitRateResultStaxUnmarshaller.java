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

import javax.xml.stream.events.XMLEvent;

import com.amazonaws.services.cloudfront.model.RealTimeStatusCodeHitRateResult;
import com.amazonaws.services.cloudfront.model.statistics.RealTimeStatusCodeHitRateStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * Create RealTimeStatusCodeHitRateResult Result StAX Unmarshaller
 */
public class RealTimeStatusCodeHitRateResultStaxUnmarshaller implements Unmarshaller<RealTimeStatusCodeHitRateResult, StaxUnmarshallerContext> {

    public RealTimeStatusCodeHitRateResult unmarshall(StaxUnmarshallerContext context) throws Exception {
    	RealTimeStatusCodeHitRateResult realTimeStatusCodeHitRateResult = new RealTimeStatusCodeHitRateResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        if (context.isStartOfDocument()) {
            realTimeStatusCodeHitRateResult.setLocation(context.getHeader("Location"));
        }

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return realTimeStatusCodeHitRateResult;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("RealTimeStatusCodeHitRate", targetDepth)) {
                    realTimeStatusCodeHitRateResult.setRealTimeStatusCodeHitRate(RealTimeStatusCodeHitRateStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return realTimeStatusCodeHitRateResult;
                }
            }
        }
    }

    private static RealTimeStatusCodeHitRateResultStaxUnmarshaller instance;
    public static RealTimeStatusCodeHitRateResultStaxUnmarshaller getInstance() {
        if (instance == null) instance = new RealTimeStatusCodeHitRateResultStaxUnmarshaller();
        return instance;
    }
}
    