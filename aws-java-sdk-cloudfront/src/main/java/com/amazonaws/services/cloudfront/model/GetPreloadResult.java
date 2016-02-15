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
public class GetPreloadResult implements Serializable, Cloneable {

    /**
     * The preload's information.
     */
    private Preload preload;

    /**
     * The preload's information.
     *
     * @return The preload's information.
     */
    public Preload getPreload() {
        return preload;
    }

    /**
     * The preload's information.
     *
     * @param preload The preload's information.
     */
    public void setPreload(Preload preload) {
        this.preload = preload;
    }

    /**
     * The preload's information.
     * <p>
     * Returns a reference to this object so that method calls can be chained together.
     *
     * @param preload The preload's information.
     *
     * @return A reference to this updated object so that method calls can be chained
     *         together.
     */
    public GetPreloadResult withPreload(Preload preload) {
        this.preload = preload;
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
        if (getPreload() != null) sb.append("Preload: " + getPreload() );
        sb.append("}");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int hashCode = 1;

        hashCode = prime * hashCode + ((getPreload() == null) ? 0 : getPreload().hashCode());
        return hashCode;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;

        if (obj instanceof GetPreloadResult == false) return false;
        GetPreloadResult other = (GetPreloadResult)obj;

        if (other.getPreload() == null ^ this.getPreload() == null) return false;
        if (other.getPreload() != null && other.getPreload().equals(this.getPreload()) == false) return false;
        return true;
    }

    @Override
    public GetPreloadResult clone() {
        try {
            return (GetPreloadResult) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(
                    "Got a CloneNotSupportedException from Object.clone() "
                            + "even though we're Cloneable!",
                    e);
        }

    }

}
    