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

import com.amazonaws.services.cloudfront.model.QuotaResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * Quota Result StAX Unmarshaller
 */
public class QuotaResultStaxUnmarshaller implements Unmarshaller<QuotaResult, StaxUnmarshallerContext> {

    public QuotaResult unmarshall(StaxUnmarshallerContext context) throws Exception {
    	QuotaResult quotaResult = new QuotaResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return quotaResult;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("Quota", targetDepth)) {
                    quotaResult.setQuota(QuotaStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return quotaResult;
                }
            }
        }
    }

    private static QuotaResultStaxUnmarshaller instance;
    public static QuotaResultStaxUnmarshaller getInstance() {
        if (instance == null) instance = new QuotaResultStaxUnmarshaller();
        return instance;
    }
}
    