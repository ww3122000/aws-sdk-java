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

import com.amazonaws.services.cloudfront.model.AccetypeEnum;
import com.amazonaws.services.cloudfront.model.log.CdnLogSetting;
import com.amazonaws.services.cloudfront.model.log.GranularityEnum;
import com.amazonaws.services.cloudfront.model.log.StatusEnum;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

/**
 * CalculateBandwidth StAX Unmarshaller
 */
public class CdnLogSettingStaxUnmarshaller implements Unmarshaller<CdnLogSetting, StaxUnmarshallerContext> {

    public CdnLogSetting unmarshall(StaxUnmarshallerContext context) throws Exception {
    	CdnLogSetting setting = new CdnLogSetting();
        int originalDepth = context.getCurrentDepth();
        int targetDepth = originalDepth + 1;
        if (context.isStartOfDocument()) targetDepth += 1;

        while (true) {
            XMLEvent xmlEvent = context.nextEvent();
            if (xmlEvent.isEndDocument()) return setting;

            if (xmlEvent.isAttribute() || xmlEvent.isStartElement()) {
                if (context.testExpression("id", targetDepth)) {
                    setting.setDomainId(LongStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("domain", targetDepth)) {
                    setting.setDomain(StringStaxUnmarshaller.getInstance().unmarshall(context));
                    continue;
                }
                if (context.testExpression("type", targetDepth)) {
                	Integer type = IntegerStaxUnmarshaller.getInstance().unmarshall(context);
                	AccetypeEnum accetypeEnum = AccetypeEnum.getByCode(type);
                	setting.setType(accetypeEnum);
                	continue;
                }
                if (context.testExpression("logSetting/granularity", targetDepth)) {
                	Integer granularity = IntegerStaxUnmarshaller.getInstance().unmarshall(context);
                	setting.setGranularity(GranularityEnum.getByValue(granularity));
                    continue;
                }
                if (context.testExpression("logSetting/status", targetDepth)) {
                	Integer status = IntegerStaxUnmarshaller.getInstance().unmarshall(context);
                	setting.setStatus(StatusEnum.getByValue(status));
                	continue;
                }
                
            } else if (xmlEvent.isEndElement()) {
                if (context.getCurrentDepth() < originalDepth) {
                    return setting;
                }
            }
        }
    }

    private static CdnLogSettingStaxUnmarshaller instance;
    public static CdnLogSettingStaxUnmarshaller getInstance() {
        if (instance == null) instance = new CdnLogSettingStaxUnmarshaller();
        return instance;
    }
}
    