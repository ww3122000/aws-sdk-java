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
public class StatusCodeSatxUnmarshaller implements Unmarshaller<StatusCode, StaxUnmarshallerContext> {

    public StatusCode unmarshall(StaxUnmarshallerContext context) throws Exception {
    	StatusCode code = new StatusCode();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return code;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("Code", targetDepth)) {
                    code.setCode(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Count", targetDepth)) {
                    code.setCount(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Hit", targetDepth)) {
                    code.setHit(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Miss", targetDepth)) {
                    code.setMiss(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return code;
                }
            }
        }
    }

    private static StatusCodeSatxUnmarshaller instance;
    public static StatusCodeSatxUnmarshaller getInstance() {
        if (instance == null) instance = new StatusCodeSatxUnmarshaller();
        return instance;
    }
}
    