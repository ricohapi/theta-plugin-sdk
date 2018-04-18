/**
 * Copyright 2018 Ricoh Company, Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.theta360.pluginapplication.network;

/**
 * Image data class
 */
public class ImageData {
    private byte[] mRawData;
    private Double pitch = 0.0d;
    private Double roll = 0.0d;
    private Double yaw = 0.0d;

    /**
     * Acquire raw data of image
     * @return Raw data of image
     */
    public byte[] getRawData() {
        return mRawData;
    }

    /**
     * Set raw data of image
     * @param rawData Raw data of image
     */
    public void setRawData(byte[] rawData) {
        mRawData = rawData;
    }

    /**
     * Acquire pitch angle
     * @return Pitch angle
     */
    public Double getPitch() {
        return pitch;
    }

    /**
     * Set pitch angle
     * @param pitch Pitch angle (value must be between -90 and 90)
     */
    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    /**
     * Acquire roll angle
     * @return Roll angle
     */
    public Double getRoll() {
        return roll;
    }

    /**
     * Set roll angle
     * @param roll Roll angle (value must be between -180 and 180)
     */
    public void setRoll(Double roll) {
        this.roll = roll;
    }

    /**
     * Acquire yaw angle
     * @return Yaw angle
     */
    public Double getYaw() {
        return yaw;
    }

    /**
     * Set yaw angle
     * @param yaw Yaw angle (value must be between 0 and 360)
     */
    public void setYaw(Double yaw) {
        this.yaw = yaw;
    }
}
