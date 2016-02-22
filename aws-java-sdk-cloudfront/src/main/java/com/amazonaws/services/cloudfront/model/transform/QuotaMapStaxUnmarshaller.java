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

import java.util.HashMap;

import javax.xml.stream.events.XMLEvent;

import com.amazonaws.services.cloudfront.model.Quota;
import com.amazonaws.transform.MapEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * Quota StAX Unmarshaller
 */
public class QuotaMapStaxUnmarshaller implements Unmarshaller<HashMap<String, Long>, StaxUnmarshallerContext> {

    public HashMap<String, Long> unmarshall(StaxUnmarshallerContext context) throws Exception {
    	
    	HashMap<String, Long> map = new HashMap<String, Long>();
    	
    	Quota quota = new Quota();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return map;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("entry", targetDepth)) {
                	MapEntry<String, Long> entry = MapEntryStaxUnmarshaller.getInstance().unmarshall(context);
                	map.put(entry.getKey(), entry.getValue());
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return map;
                }
            }
        }
    }

    private static QuotaMapStaxUnmarshaller instance;
    public static QuotaMapStaxUnmarshaller getInstance() {
        if (instance == null) instance = new QuotaMapStaxUnmarshaller();
        return instance;
    }
}
    