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

/**
 * Constant used by the program
 */
public interface Constants {

    /** Radius of sphere for photo */
    static final int TEXTURE_SHELL_RADIUS = 2;
    /** Number of sphere polygon partitions for photo, which must be an even number */
    static final int SHELL_DIVIDES = 40;

    /** Maximum value that can be specified as the camera FOV variable */
    static final int CAMERA_FOV_DEGREE_MAX = 100;
    /** Minimum value that can be specified as the camera FOV variable */
    static final int CAMERA_FOV_DEGREE_MIN = 30;

    /** Pitch width of zoom in process */
    static final float SCALE_RATIO_TICK_EXPANSION = 1.05f;
    /** Pitch width of zoom out process */
    static final float SCALE_RATIO_TICK_REDUCTION = 0.95f;

    /** Rotation threshold for scroll (X axis direction) */
    static final double THRESHOLD_SCROLL_X = 0.02;
	/** Rotation threshold for scroll (Y axis direction) */
    static final double THRESHOLD_SCROLL_Y = 0.02;

	/** Rotation amount derivative parameter for scroll (X axis direction) */
    static final float ON_SCROLL_DIVIDER_X = 400.0f;
	/** Rotation amount derivative parameter for scroll (Y axis direction) */
    static final float ON_SCROLL_DIVIDER_Y = 400.0f;

    /** Movement amount derivative parameter when inertia setting is small (X axis direction) */
    static final float ON_FLING_DIVIDER_X_FOR_INERTIA_50 = 650.0f;
    /** Movement amount derivative parameter when inertia setting is small (Y axis direction) */
    static final float ON_FLING_DIVIDER_Y_FOR_INERTIA_50 = (650.0f*3.0f);
	/** Movement amount derivative parameter when inertia setting is large (X axis direction) */
    static final float ON_FLING_DIVIDER_X_FOR_INERTIA_100 = 65.0f;
	/** Movement amount derivative parameter when inertia setting is large (Y axis direction) */
    static final float ON_FLING_DIVIDER_Y_FOR_INERTIA_100 = (65.0f*10.0f);

}
