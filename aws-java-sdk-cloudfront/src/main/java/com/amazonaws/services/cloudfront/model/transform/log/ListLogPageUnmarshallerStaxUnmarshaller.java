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

import com.amazonaws.services.cloudfront.model.log.ListLogPage;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * CalculateBandwidth StAX Unmarshaller
 */
public class ListLogPageUnmarshallerStaxUnmarshaller implements Unmarshaller<ListLogPage, StaxUnmarshallerContext> {

    public ListLogPage unmarshall(StaxUnmarshallerContext context) throws Exception {
    	ListLogPage page = new ListLogPage();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return page;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("totalCount", targetDepth)) {
                    page.setTotalCount(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("totalPages", targetDepth)) {
                    page.setTotalPages(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("pageSize", targetDepth)) {
                    page.setPageSize(IntegerStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("pageNo", targetDepth)) {
                    page.setPageNo(IntegerStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("data/data", targetDepth)) {
                	page.getData().add(CdnLogSettingStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return page;
                }
            }
        }
    }

    private static ListLogPageUnmarshallerStaxUnmarshaller instance;
    public static ListLogPageUnmarshallerStaxUnmarshaller getInstance() {
        if (instance == null) instance = new ListLogPageUnmarshallerStaxUnmarshaller();
        return instance;
    }
}
    