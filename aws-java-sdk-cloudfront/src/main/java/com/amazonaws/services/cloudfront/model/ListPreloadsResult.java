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
package com.amazonaws.services.cloudfront.model;

import java.io.Serializable;

/**
 * <p>
 * The returned result of the corresponding request.
 * </p>
 */
public class ListPreloadsResult implements Serializable, Cloneable {

    /**
     * Information about preload batches.
     */
    private PreloadList preloadList;

    /**
     * Information about preload batches.
     *
     * @return Information about preload batches.
     */
    public PreloadList getPreloadList() {
        return preloadList;
    }

    /**
     * Information about preload batches.
     *
     * @param preloadList Information about preload batches.
     */
    public void setPreloadList(PreloadList preloadList) {
        this.preloadList = preloadList;
    }

    /**
     * Information about preload batches.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param preloadList Information about preload batches.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public ListPreloadsResult withPreloadList(PreloadList preloadList) {
        this.preloadList = preloadList;
        return this;
    }

    /**
     * Returns a string representation of this object; useful for testing and
     * debugging.
     *
     * @return A string representation of this object.
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPreloadList() != null) sb.append("PreloadList: " + getPreloadList() );
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getPreloadList() == null) ? 0 : getPreloadList().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof ListPreloadsResult == false) return false;
        ListPreloadsResult other = (ListPreloadsResult)obj;

        if (other.getPreloadList() == null ^ this.getPreloadList() == null) return false;
        if (other.getPreloadList() != null && other.getPreloadList().equals(this.getPreloadList()) == false) return false;
        return true;
    }

    @Override
    public ListPreloadsResult clone() {
        try {
            return (ListPreloadsResult) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!",
                    e);
        }

    }

}
    