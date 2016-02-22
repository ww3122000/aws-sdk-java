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

import com.amazonaws.transform.MapEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * Quota StAX Unmarshaller
 */
public class MapEntryStaxUnmarshaller implements Unmarshaller<MapEntry<String, Long>, StaxUnmarshallerContext> {

    public MapEntry<String, Long> unmarshall(StaxUnmarshallerContext context) throws Exception {
    	
    	MapEntry<String, Long> entry = new MapEntry<String, Long>();
    	
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return entry;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("key", targetDepth)) {
                	entry.setKey(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("value", targetDepth)) {
                	entry.setValue(LongStaxUnmarshaller.getInstance().unmarshall(context));
                	continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return entry;
                }
            }
        }
    }

    private static MapEntryStaxUnmarshaller instance;
    public static MapEntryStaxUnmarshaller getInstance() {
        if (instance == null) instance = new MapEntryStaxUnmarshaller();
        return instance;
    }
}
    