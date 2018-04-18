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

package com.theta360.pluginapplication.model;

import android.graphics.Bitmap;

/**
 * Photo object storage class
 */
public class Photo {

    private Double mOrientationAngle;

    private Double mElevationAngle;
    private Double mHorizontalAngle;

    private Bitmap mPhoto;

    private Photo() {
    }

    /**
     * Constructor
     * @param photo Photo object
     */
    public Photo(Bitmap photo) {
        this(photo, null, null, null);
    }

    /**
     * Constructor
     * @param photo Photo object
     * @param orientationAngle Orientation angle
     * @param elevationAngle Elevation angle
     * @param horizontalAngle Horizontal angle
     */
    public Photo(Bitmap photo, Double orientationAngle, Double elevationAngle, Double horizontalAngle) {
        this();

        mOrientationAngle = orientationAngle;
        mElevationAngle = elevationAngle;
        mHorizontalAngle = horizontalAngle;

        mPhoto = photo;
    }

    /**
     * Acquires the orientation angle
     * @return Orientation angle
     */
    public Double getOrientationAngle() {
        return mOrientationAngle;
    }

    /**
     * Acquires the elevation angle
     * @return Elevation angle
     */
    public Double getElevetionAngle() {
        return mElevationAngle;
    }

    /**
     * Acquires the horizontal angle
     * @return Horizontal angle
     */
    public Double getHorizontalAngle() {
        return mHorizontalAngle;
    }

    /**
     * Acquires the photo object
     * @return Photo object
     */
    public Bitmap getPhoto() {
        return mPhoto;
    }

    /**
     * Updates the photo object
     * @param drawable Photo object
     */
    public void updatePhoto(Bitmap drawable) {
        mPhoto = drawable;
    }

}
