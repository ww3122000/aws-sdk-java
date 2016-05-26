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

import com.amazonaws.services.cloudfront.model.AccetypeEnum;
import com.amazonaws.services.cloudfront.model.log.CdnLog;
import com.amazonaws.services.cloudfront.model.log.GranularityEnum;
import com.amazonaws.services.cloudfront.model.log.StatusEnum;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

import javax.xml.stream.events.XMLEvent;

/**
 * CalculateBandwidth StAX Unmarshaller
 */
public class CdnLogStaxUnmarshaller implements Unmarshaller<CdnLog, StaxUnmarshallerContext> {

    public CdnLog unmarshall(StaxUnmarshallerContext context) throws Exception {
        CdnLog cdnLog = new CdnLog();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return cdnLog;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("id", targetDepth)) {
                    cdnLog.setId(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }

                if (context.testExpression("domainId", targetDepth)) {
                    cdnLog.setDomainId(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("region", targetDepth)) {
                    cdnLog.setRegion(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("bucket", targetDepth)) {
                    cdnLog.setBucket(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("name", targetDepth)) {
                    cdnLog.setName(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("url", targetDepth)) {
                    cdnLog.setUrl(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("logTime", targetDepth)) {
                    cdnLog.setLogTime(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("createTime", targetDepth)) {
                    cdnLog.setCreateTime(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
//                if (context.testExpression("type", targetDepth)) {
//                	Integer type = IntegerStaxUnmarshaller.getInstance().unmarshall(context);
//                	AccetypeEnum accetypeEnum = AccetypeEnum.getByCode(type);
//                    cdnLog.setType(accetypeEnum);
//                	continue;
//                }
//
//                if (context.testExpression("cdnLog/granularity", targetDepth)) {
//                	Integer granularity = IntegerStaxUnmarshaller.getInstance().unmarshall(context);
//                    cdnLog.setGranularity(GranularityEnum.getByValue(granularity));
//                    continue;
//                }
//                if (context.testExpression("cdnLog/status", targetDepth)) {
//                	Integer status = IntegerStaxUnmarshaller.getInstance().unmarshall(context);
//                    cdnLog.setStatus(StatusEnum.getByValue(status));
//                	continue;
//                }


            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return cdnLog;
                }
            }
        }
    }

    private static CdnLogStaxUnmarshaller instance;
    public static CdnLogStaxUnmarshaller getInstance() {
        if (instance == null) instance = new CdnLogStaxUnmarshaller();
        return instance;
    }
}
    