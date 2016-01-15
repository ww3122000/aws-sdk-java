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

import com.amazonaws.services.cloudfront.model.CalculateBandwidthResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * Create CalculateBandwidthResult Result StAX Unmarshaller
 */
public class CalculateBandwidthResultStaxUnmarshaller implements Unmarshaller<CalculateBandwidthResult, StaxUnmarshallerContext> {

    public CalculateBandwidthResult unmarshall(StaxUnmarshallerContext context) throws Exception {
        CalculateBandwidthResult calculateBandwidthResult = new CalculateBandwidthResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        if (context.isStartOfDocument()) {
            calculateBandwidthResult.setLocation(context.getHeader("Location"));
        }

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return calculateBandwidthResult;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("CalculateBandwidth", targetDepth)) {
                    calculateBandwidthResult.setCalculateBandwidth(CalculateBandwidthStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return calculateBandwidthResult;
                }
            }
        }
    }

    private static CalculateBandwidthResultStaxUnmarshaller instance;
    public static CalculateBandwidthResultStaxUnmarshaller getInstance() {
        if (instance == null) instance = new CalculateBandwidthResultStaxUnmarshaller();
        return instance;
    }
}
    