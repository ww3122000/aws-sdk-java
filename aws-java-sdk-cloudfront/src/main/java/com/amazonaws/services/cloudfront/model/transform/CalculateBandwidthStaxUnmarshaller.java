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

import com.amazonaws.services.cloudfront.model.CalculateBandwidth;
import com.amazonaws.services.cloudfront.model.Preload;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * CalculateBandwidth StAX Unmarshaller
 */
public class CalculateBandwidthStaxUnmarshaller implements Unmarshaller<CalculateBandwidth, StaxUnmarshallerContext> {

    public CalculateBandwidth unmarshall(StaxUnmarshallerContext context) throws Exception {
        CalculateBandwidth calculateBandwidth = new CalculateBandwidth();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return calculateBandwidth;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("UserId", targetDepth)) {
                    calculateBandwidth.setUserId(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Dimension", targetDepth)) {
                    calculateBandwidth.setDimension(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("OutType", targetDepth)) {
                	calculateBandwidth.setOutType(StringStaxUnmarshaller.getInstance().unmarshall(context));
                	continue;
                }
                if (context.testExpression("StartTime", targetDepth)) {
                    calculateBandwidth.setStartTime(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("EndTime", targetDepth)) {
                    calculateBandwidth.setEndTime(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Domain", targetDepth)) {
                    calculateBandwidth.setDomain(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Bandwidth", targetDepth)) {
                    calculateBandwidth.setBandwidth(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Region", targetDepth)) {
                	calculateBandwidth.setRegion(StringStaxUnmarshaller.getInstance().unmarshall(context));
                	continue;
                }
                if (context.testExpression("Accetype", targetDepth)) {
                	calculateBandwidth.setAccetype(StringStaxUnmarshaller.getInstance().unmarshall(context));
                	continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return calculateBandwidth;
                }
            }
        }
    }

    private static CalculateBandwidthStaxUnmarshaller instance;
    public static CalculateBandwidthStaxUnmarshaller getInstance() {
        if (instance == null) instance = new CalculateBandwidthStaxUnmarshaller();
        return instance;
    }
}
    