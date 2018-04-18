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
 * LedColor
 */
public enum LedColor {
    RED("red", 0b001),
    GREEN("green", 0b010),
    BLUE("blue", 0b100),
    CYAN("cyan", 0b110),
    MAGENTA("magenta", 0b101),
    YELLOW("yellow", 0b011),
    WHITE("white", 0b111),;

    private final String mLedColor;
    private final int mLedColorInt;

    LedColor(final String ledColor, final int ledColorInt) {
        this.mLedColor = ledColor;
        this.mLedColorInt = ledColorInt;
    }

    public static LedColor getValue(final String _ledColor) {
        for (LedColor ledColor : LedColor.values()) {
            if (ledColor.toString().equals(_ledColor)) {
                return ledColor;
            }
        }

        return LedColor.BLUE;
    }

    @Override
    public String toString() {
        return this.mLedColor;
    }

    public int toInt() {
        return this.mLedColorInt;
    }
}
