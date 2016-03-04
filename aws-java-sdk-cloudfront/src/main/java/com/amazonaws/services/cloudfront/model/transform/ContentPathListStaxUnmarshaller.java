/*
 * Copyright 2010-2016 Amazon.com, Inc. or its affiliates. All Rights Reserved.
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

import com.amazonaws.services.cloudfront.model.ContentPathList;
import com.amazonaws.services.cloudfront.model.ContentPathTypeEnum;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * ContentPathList List StAX Unmarshaller
 */
public class ContentPathListStaxUnmarshaller implements Unmarshaller<ContentPathList, StaxUnmarshallerContext> {

    public ContentPathList unmarshall(StaxUnmarshallerContext context) throws Exception {
    	ContentPathList contentPathList = new ContentPathList();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return contentPathList;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("UserId", targetDepth)) {
                    contentPathList.setUserId(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("QueryName", targetDepth)) {
                    contentPathList.setQueryName(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Type", targetDepth)) {
                    contentPathList.setType(ContentPathTypeEnum.getByValue(StringStaxUnmarshaller.getInstance().unmarshall(context)));
                    continue;
                }
                if (context.testExpression("StartTimeMillis", targetDepth)) {
                    contentPathList.setStartTimeMillis(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("EndTimeMillis", targetDepth)) {
                	contentPathList.setEndTimeMillis(LongStaxUnmarshaller.getInstance().unmarshall(context));
                	continue;
                }
                if (context.testExpression("PageIndex", targetDepth)) {
                	contentPathList.setPageIndex(IntegerStaxUnmarshaller.getInstance().unmarshall(context));
                	continue;
                }
                if (context.testExpression("PageSize", targetDepth)) {
                	contentPathList.setPageSize(IntegerStaxUnmarshaller.getInstance().unmarshall(context));
                	continue;
                }
                if (context.testExpression("Quantity", targetDepth)) {
                    contentPathList.setQuantity(IntegerStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("Items/ContentPath", targetDepth)) {
                    contentPathList.getItems().add(ContentPathStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return contentPathList;
                }
            }
        }
    }

    private static ContentPathListStaxUnmarshaller instance;
    public static ContentPathListStaxUnmarshaller getInstance() {
        if (instance == null) instance = new ContentPathListStaxUnmarshaller();
        return instance;
    }
}
    