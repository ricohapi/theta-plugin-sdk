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

package com.theta360.pluginlibrary.values;

/**
 * LedTarget
 */
public enum LedTarget {
    LED3("LED3"),//WLAN
    LED4("LED4"),//Still
    LED5("LED5"),//Video
    LED6("LED6"),//Live
    LED7("LED7"),//Video recording
    LED8("LED8");//Error

    private final String mLedTarget;

    LedTarget(final String ledTarget) {
        this.mLedTarget = ledTarget;
    }

    public static LedTarget getValue(String _ledTarget) {
        for (LedTarget ledTarget : LedTarget.values()) {
            if (ledTarget.toString().equals(_ledTarget)) {
                return ledTarget;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.mLedTarget;
    }
}
