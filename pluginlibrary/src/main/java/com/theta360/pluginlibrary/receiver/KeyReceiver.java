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

package com.theta360.pluginlibrary.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.KeyEvent;

/**
 * KeyReceiver
 */
public class KeyReceiver extends BroadcastReceiver {
    public static final int KEYCODE_CAMERA = 27;
    public static final int KEYCODE_MEDIA_RECORD = 130;
    public static final int KEYCODE_WLAN_ON_OFF = 284;

    public static final String ACTION_KEY_DOWN = "com.theta360.plugin.ACTION_KEY_DOWN";
    public static final String ACTION_KEY_UP = "com.theta360.plugin.ACTION_KEY_UP";
    private static final String KEY_CODE = "keyCode";
    private static final String KEY_EVENT = "KeyEvent";

    private Callback mCallback;

    public KeyReceiver(@NonNull Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();

        int keyCode = intent.getIntExtra(KEY_CODE, 0);
        KeyEvent event = intent.getParcelableExtra(KEY_EVENT);
        switch (action) {
            case ACTION_KEY_DOWN:
                mCallback.onKeyDownCallback(keyCode, event);
                break;
            case ACTION_KEY_UP:
                mCallback.onKeyUpCallback(keyCode, event);
                break;
        }
    }

    public interface Callback {
        void onKeyDownCallback(int keyCode, KeyEvent event);

        void onKeyUpCallback(int keyCode, KeyEvent event);
    }
}
