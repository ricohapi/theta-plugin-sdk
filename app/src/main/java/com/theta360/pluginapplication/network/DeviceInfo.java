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
 * Device information class
 */
public class DeviceInfo {
    private String mModel = "";
    private String mDeviceVersion = "";
    private String mSerialNumber = "";

    /**
     * Constructor
     */
    public DeviceInfo() {
    }

    /**
     * Acquire model name
     * @return Model name
     */
    public String getModel() {
        return mModel;
    }

    /**
     * Set model name
     * @param model Model name
     */
    public void setModel(String model) {
        mModel = model;
    }

    /**
     * Acquire serial number
     * @return Serial number
     */
    public String getSerialNumber() {
        return mSerialNumber;
    }

    /**
     * Set serial number
     * @param serialNumber Serial number
     */
    public void setSerialNumber(String serialNumber) {
        mSerialNumber = serialNumber;
    }

    /**
     * Acquire firmware version
      * @return Firmware version
     */
    public String getDeviceVersion() {
        return mDeviceVersion;
    }

    /**
     * Set firmware version
     * @param version Firmware version
     */
    public void setDeviceVersion(String version) {
        mDeviceVersion = version;
    }
}
