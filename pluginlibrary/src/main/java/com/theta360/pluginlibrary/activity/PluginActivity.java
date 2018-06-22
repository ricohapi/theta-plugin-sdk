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

package com.theta360.pluginlibrary.activity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import com.theta360.pluginlibrary.UncaughtException;
import com.theta360.pluginlibrary.UncaughtException.Callback;
import com.theta360.pluginlibrary.callback.KeyCallback;
import com.theta360.pluginlibrary.receiver.KeyReceiver;
import com.theta360.pluginlibrary.values.ExitStatus;
import com.theta360.pluginlibrary.values.LedColor;
import com.theta360.pluginlibrary.values.LedTarget;

/**
 * PluginActivity
 */
public abstract class PluginActivity extends AppCompatActivity {
    private static final String ACTION_MAIN_CAMERA_CLOSE = "com.theta360.plugin.ACTION_MAIN_CAMERA_CLOSE";
    private static final String ACTION_MAIN_CAMERA_OPEN = "com.theta360.plugin.ACTION_MAIN_CAMERA_OPEN";
    private static final String ACTION_FINISH_PLUGIN = "com.theta360.plugin.ACTION_FINISH_PLUGIN";
    private static final String ACTION_ERROR_OCCURED = "com.theta360.plugin.ACTION_ERROR_OCCURED";
    private static final String PACKAGE_NAME = "packageName";
    private static final String EXIT_STATUS = "exitStatus";
    private static final String MESSAGE = "message";

    private static final String ACTION_LED_SHOW = "com.theta360.plugin.ACTION_LED_SHOW";
    private static final String ACTION_LED_BLINK = "com.theta360.plugin.ACTION_LED_BLINK";
    private static final String ACTION_LED_HIDE = "com.theta360.plugin.ACTION_LED_HIDE";
    private static final String TARGET = "target";
    private static final String COLOR = "color";
    private static final String PERIOD = "period";

    private static final String ACTION_AUDIO_SHUTTER = "com.theta360.plugin.ACTION_AUDIO_SHUTTER";
    private static final String ACTION_AUDIO_SH_OPEN = "com.theta360.plugin.ACTION_AUDIO_SH_OPEN";
    private static final String ACTION_AUDIO_SH_CLOSE = "com.theta360.plugin.ACTION_AUDIO_SH_CLOSE";
    private static final String ACTION_AUDIO_MOVSTART = "com.theta360.plugin.ACTION_AUDIO_MOVSTART";
    private static final String ACTION_AUDIO_MOVSTOP = "com.theta360.plugin.ACTION_AUDIO_MOVSTOP";
    private static final String ACTION_AUDIO_SELF = "com.theta360.plugin.ACTION_AUDIO_SELF";
    private static final String ACTION_AUDIO_WARNING = "com.theta360.plugin.ACTION_AUDIO_WARNING";

    private static final String ACTION_WLAN_OFF = "com.theta360.plugin.ACTION_WLAN_OFF";
    private static final String ACTION_WLAN_AP = "com.theta360.plugin.ACTION_WLAN_AP";
    private static final String ACTION_WLAN_CL = "com.theta360.plugin.ACTION_WLAN_CL";

    private static final String ACTION_DATABASE_UPDATE = "com.theta360.plugin.ACTION_DATABASE_UPDATE";
    private static final String TARGETS = "targets";

    private boolean isCamera = false;
    private KeyCallback mKeyCallback;
    private KeyReceiver mKeyReceiver;
    private KeyReceiver.Callback onKeyReceiver = new KeyReceiver.Callback() {
        @Override
        public void onKeyDownCallback(int keyCode, KeyEvent event) {
            if (event.getKeyCode() == KeyReceiver.KEYCODE_MEDIA_RECORD
                    && event.isLongPress()) {
                if (mKeyCallback != null) {
                    mKeyCallback.onKeyLongPress(keyCode, event);
                }
                if (isCamera) {
                    notificationCameraOpen();
                }
                notificationSuccess();
            } else {
                if (mKeyCallback != null) {
                    if (event.getRepeatCount() == 0) {
                        mKeyCallback.onKeyDown(keyCode, event);
                    } else if (event.isLongPress()) {
                        mKeyCallback.onKeyLongPress(keyCode, event);
                    }
                }
            }
        }

        @Override
        public void onKeyUpCallback(int keyCode, KeyEvent event) {
            if (mKeyCallback != null) {
                mKeyCallback.onKeyUp(keyCode, event);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UncaughtException uncaughtException = new UncaughtException(getApplicationContext(),
                new Callback() {
                    @Override
                    public void onException(String message) {
                        notificationError(message);
                        finish();
                    }
                });
        Thread.setDefaultUncaughtExceptionHandler(uncaughtException);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mKeyReceiver = new KeyReceiver(onKeyReceiver);
        IntentFilter keyFilter = new IntentFilter();
        keyFilter.addAction(KeyReceiver.ACTION_KEY_DOWN);
        keyFilter.addAction(KeyReceiver.ACTION_KEY_UP);
        registerReceiver(mKeyReceiver, keyFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(mKeyReceiver);

        super.onPause();
    }

    public void setKeyCallback(KeyCallback keyCallback) {
        mKeyCallback = keyCallback;
    }

    public void notificationCameraOpen() {
        isCamera = false;
        sendBroadcast(new Intent(ACTION_MAIN_CAMERA_OPEN));
    }

    public void notificationCameraClose() {
        isCamera = true;
        sendBroadcast(new Intent(ACTION_MAIN_CAMERA_CLOSE));
    }

    /**
     * Sound of normal capture
     */
    public void notificationAudioShutter() {
        sendBroadcast(new Intent(ACTION_AUDIO_SHUTTER));
    }

    /**
     * Sound of starting long exposure capture
     */
    public void notificationAudioOpen() {
        sendBroadcast(new Intent(ACTION_AUDIO_SH_OPEN));
    }

    /**
     * Sound of ending long exposure capture
     */
    public void notificationAudioClose() {
        sendBroadcast(new Intent(ACTION_AUDIO_SH_CLOSE));
    }

    /**
     * Sound of starting movie recording
     */
    public void notificationAudioMovStart() {
        sendBroadcast(new Intent(ACTION_AUDIO_MOVSTART));
    }

    /**
     * Sound of stopping movie recording
     */
    public void notificationAudioMovStop() {
        sendBroadcast(new Intent(ACTION_AUDIO_MOVSTOP));
    }

    /**
     * Sound of working self-timer
     */
    public void notificationAudioSelf() {
        sendBroadcast(new Intent(ACTION_AUDIO_SELF));
    }

    /**
     * Sound of warning
     */
    public void notificationAudioWarning() {
        sendBroadcast(new Intent(ACTION_AUDIO_WARNING));
    }

    /**
     * Turn on LED3 with color
     *
     * @param ledTarget target LED
     */
    public void notificationLed3Show(@NonNull LedColor ledColor) {
       Intent intent = new Intent(ACTION_LED_SHOW);
       intent.putExtra(TARGET, LedTarget.LED3.toString());
       intent.putExtra(COLOR, ledColor.toString());
       sendBroadcast(intent);
    }

    /**
     * Turn on LED
     *
     * @param ledTarget target LED
     */
    public void notificationLedShow(@NonNull LedTarget ledTarget) {
        if (ledTarget == LedTarget.LED3) {
            notificationLed3Show(LedColor.BLUE);
        } else {
            Intent intent = new Intent(ACTION_LED_SHOW);
            intent.putExtra(TARGET, ledTarget.toString());
            sendBroadcast(intent);
        }
    }

    /**
     * Blink LED
     *
     * @param ledTarget target LED
     * @param ledColor color
     * @param period period 250-2000 (msec)
     */
    public void notificationLedBlink(@NonNull LedTarget ledTarget, LedColor ledColor, int period) {
        if (ledColor == null) {
            ledColor = LedColor.BLUE;
        }
        if (period < 250) {
            period = 250;
        }
        if (period > 2000) {
            period = 2000;
        }

        Intent intent = new Intent(ACTION_LED_BLINK);
        intent.putExtra(TARGET, ledTarget.toString());
        intent.putExtra(COLOR, ledColor.toString());
        intent.putExtra(PERIOD, period);
        sendBroadcast(intent);
    }

    /**
     * Turn off LED
     *
     * @param ledTarget target LED
     */
    public void notificationLedHide(@NonNull LedTarget ledTarget) {
        Intent intent = new Intent(ACTION_LED_HIDE);
        intent.putExtra(TARGET, ledTarget.toString());
        sendBroadcast(intent);
    }

    public void notificationWlanOff() {
        sendBroadcast(new Intent(ACTION_WLAN_OFF));
    }

    public void notificationWlanAp() {
        sendBroadcast(new Intent(ACTION_WLAN_AP));
    }

    public void notificationWlanCl() {
        sendBroadcast(new Intent(ACTION_WLAN_CL));
    }

    public void notificationDatabaseUpdate(@NonNull String[] targets) {
        Intent intent = new Intent(ACTION_DATABASE_UPDATE);
        intent.putExtra(TARGETS, targets);
        sendBroadcast(intent);
    }

    /**
     * Notifying Completion of Plug-in when the plug-in ends normally
     */
    public void notificationSuccess() {
        Intent intent = new Intent(ACTION_FINISH_PLUGIN);
        intent.putExtra(PACKAGE_NAME, getPackageName());
        intent.putExtra(EXIT_STATUS, ExitStatus.SUCCESS.toString());
        sendBroadcast(intent);
        finish();
    }

    /**
     * Notifying Completion of Plug-in when the plug-in ends with error
     *
     * @param message error message
     */
    public void notificationError(String message) {
        Intent intent = new Intent(ACTION_FINISH_PLUGIN);
        intent.putExtra(PACKAGE_NAME, getPackageName());
        intent.putExtra(EXIT_STATUS, ExitStatus.FAILURE.toString());
        intent.putExtra(MESSAGE, message);
        sendBroadcast(intent);
        finish();
    }

    /**
     * Notifying Occurrences of Errors
     */
    public void notificationErrorOccured() {
        sendBroadcast(new Intent(ACTION_ERROR_OCCURED));
    }
}
