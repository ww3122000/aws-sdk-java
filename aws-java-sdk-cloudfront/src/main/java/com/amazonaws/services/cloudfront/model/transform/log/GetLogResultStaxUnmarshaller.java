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

import javax.xml.stream.events.XMLEvent;

import com.amazonaws.services.cloudfront.model.log.GetLogResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * Create GetLogResult Result StAX Unmarshaller
 */
public class GetLogResultStaxUnmarshaller implements Unmarshaller<GetLogResult, StaxUnmarshallerContext> {

    public GetLogResult unmarshall(StaxUnmarshallerContext context) throws Exception {
        GetLogResult getLogResult = new GetLogResult();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;

        if (context.isStartOfDocument()) {
            getLogResult.setLocation(context.getHeader("Location"));
        }

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return getLogResult;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("KscPage", targetDepth)) {
                    getLogResult.setLogPage(LogPageUnmarshallerStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return getLogResult;
                }
            }
        }
    }

    private static GetLogResultStaxUnmarshaller instance;
    public static GetLogResultStaxUnmarshaller getInstance() {
        if (instance == null) instance = new GetLogResultStaxUnmarshaller();
        return instance;
    }
}
    