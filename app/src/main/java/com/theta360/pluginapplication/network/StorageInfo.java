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
 * Information class of device storage
 */
public class StorageInfo {
    int mRemainingPictures = 0;
    long mRemainingSpace = 0;
    long mTotalSpace = 0;

    /**
     * Acquire remaining number of images that can be shot
     * @return Remaining number of images that can be shot
     */
    public int getFreeSpaceInImages() {
        return mRemainingPictures;
    }

    /**
     * Set remaining number of images that can be shot
     * @param remainingPictures Remaining number of images that can be shot
     */
    public void setFreeSpaceInImages(int remainingPictures) {
        mRemainingPictures = remainingPictures;
    }

    /**
     * Acquire remaining capacity
     * @return Remaining capacity (unit: bytes)
     */
    public long getFreeSpaceInBytes() {
        return mRemainingSpace;
    }

    /**
     * Set remaining capacity
     * @param remainingSpace Remaining capacity (unit: bytes)
     */
    public void setFreeSpaceInBytes(long remainingSpace) {
        mRemainingSpace = remainingSpace;
    }

    /**
     * Acquire total capacity of device
     * @return Total capacity of device (unit: bytes)
     */
    public long getMaxCapacity() {
        return mTotalSpace;
    }

    /**
     * Set total capacity of device
     * @param totalSpace Total capacity of device (unit: bytes)
     */
    public void setMaxCapacity(long totalSpace) {
        mTotalSpace = totalSpace;
    }
}
