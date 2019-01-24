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
import android.content.pm.ActivityInfo;
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
    private boolean isCamera = false;
    private boolean isAutoClose = true;
    private boolean isClosed = false;
    private String mUserOption;
    private boolean isApConnected = false;

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
                if (isAutoClose) {
                    close();
                }
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

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // Fix to be portrait
        UncaughtException uncaughtException = new UncaughtException(getApplicationContext(),
                new Callback() {
                    @Override
                    public void onException(String message) {
                        notificationError(message);
                    }
                });
        Thread.setDefaultUncaughtExceptionHandler(uncaughtException);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Intent intent = getIntent();
        if (intent != null) {
            mUserOption = intent.getStringExtra(Constants.USER_OPTION);
            isApConnected = intent.getBooleanExtra(Constants.IS_AP_CONNECTED, false);
        }

        mKeyReceiver = new KeyReceiver(onKeyReceiver);
        IntentFilter keyFilter = new IntentFilter();
        keyFilter.addAction(KeyReceiver.ACTION_KEY_DOWN);
        keyFilter.addAction(KeyReceiver.ACTION_KEY_UP);
        registerReceiver(mKeyReceiver, keyFilter);
    }

    @Override
    protected void onPause() {
        if (!isClosed) {
            close();
        }
        unregisterReceiver(mKeyReceiver);

        super.onPause();
    }

    public void setKeyCallback(KeyCallback keyCallback) {
        mKeyCallback = keyCallback;
    }

    /**
     * Auto close setting
     *
     * @param autoClose true : auto close / false : not auto close
     */
    public void setAutoClose(boolean autoClose) {
        isAutoClose = autoClose;
    }

    /**
     * End processing
     */
    public void close() {
        isClosed = true;
        if (isCamera) {
            notificationCameraOpen();
        }
        notificationSuccess();
    }

    public String getUserOption() {
        return mUserOption;
    }

    public boolean isApConnected() {
        return isApConnected;
    }

    public void notificationCameraOpen() {
        isCamera = false;
        sendBroadcast(new Intent(Constants.ACTION_MAIN_CAMERA_OPEN));
    }

    public void notificationCameraClose() {
        isCamera = true;
        sendBroadcast(new Intent(Constants.ACTION_MAIN_CAMERA_CLOSE));
    }

    /**
     * Sound of normal capture
     */
    public void notificationAudioShutter() {
        sendBroadcast(new Intent(Constants.ACTION_AUDIO_SHUTTER));
    }

    /**
     * Sound of starting long exposure capture
     */
    public void notificationAudioOpen() {
        sendBroadcast(new Intent(Constants.ACTION_AUDIO_SH_OPEN));
    }

    /**
     * Sound of ending long exposure capture
     */
    public void notificationAudioClose() {
        sendBroadcast(new Intent(Constants.ACTION_AUDIO_SH_CLOSE));
    }

    /**
     * Sound of starting movie recording
     */
    public void notificationAudioMovStart() {
        sendBroadcast(new Intent(Constants.ACTION_AUDIO_MOVSTART));
    }

    /**
     * Sound of stopping movie recording
     */
    public void notificationAudioMovStop() {
        sendBroadcast(new Intent(Constants.ACTION_AUDIO_MOVSTOP));
    }

    /**
     * Sound of working self-timer
     */
    public void notificationAudioSelf() {
        sendBroadcast(new Intent(Constants.ACTION_AUDIO_SELF));
    }

    /**
     * Sound of warning
     */
    public void notificationAudioWarning() {
        sendBroadcast(new Intent(Constants.ACTION_AUDIO_WARNING));
    }

    /**
     * Turn on LED3 with color
     *
     * @param ledColor target LED
     */
    public void notificationLed3Show(@NonNull LedColor ledColor) {
        Intent intent = new Intent(Constants.ACTION_LED_SHOW);
        intent.putExtra(Constants.TARGET, LedTarget.LED3.toString());
        intent.putExtra(Constants.COLOR, ledColor.toString());
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
            Intent intent = new Intent(Constants.ACTION_LED_SHOW);
            intent.putExtra(Constants.TARGET, ledTarget.toString());
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

        Intent intent = new Intent(Constants.ACTION_LED_BLINK);
        intent.putExtra(Constants.TARGET, ledTarget.toString());
        intent.putExtra(Constants.COLOR, ledColor.toString());
        intent.putExtra(Constants.PERIOD, period);
        sendBroadcast(intent);
    }

    /**
     * Turn off LED
     *
     * @param ledTarget target LED
     */
    public void notificationLedHide(@NonNull LedTarget ledTarget) {
        Intent intent = new Intent(Constants.ACTION_LED_HIDE);
        intent.putExtra(Constants.TARGET, ledTarget.toString());
        sendBroadcast(intent);
    }

    public void notificationWlanOff() {
        sendBroadcast(new Intent(Constants.ACTION_WLAN_OFF));
    }

    public void notificationWlanAp() {
        sendBroadcast(new Intent(Constants.ACTION_WLAN_AP));
    }

    public void notificationWlanCl() {
        sendBroadcast(new Intent(Constants.ACTION_WLAN_CL));
    }

    public void notificationDatabaseUpdate(@NonNull String[] targets) {
        Intent intent = new Intent(Constants.ACTION_DATABASE_UPDATE);
        intent.putExtra(Constants.TARGETS, targets);
        sendBroadcast(intent);
    }

    /**
     * Notifying Completion of Plug-in when the plug-in ends normally
     */
    public void notificationSuccess() {
        Intent intent = new Intent(Constants.ACTION_FINISH_PLUGIN);
        intent.putExtra(Constants.PACKAGE_NAME, getPackageName());
        intent.putExtra(Constants.EXIT_STATUS, ExitStatus.SUCCESS.toString());
        sendBroadcast(intent);

        finishAndRemoveTask();
    }

    /**
     * Notifying Completion of Plug-in when the plug-in ends with error
     *
     * @param message error message
     */
    public void notificationError(String message) {
        Intent intent = new Intent(Constants.ACTION_FINISH_PLUGIN);
        intent.putExtra(Constants.PACKAGE_NAME, getPackageName());
        intent.putExtra(Constants.EXIT_STATUS, ExitStatus.FAILURE.toString());
        intent.putExtra(Constants.MESSAGE, message);
        sendBroadcast(intent);

        finishAndRemoveTask();
    }

    /**
     * Notifying Occurrences of Errors
     */
    public void notificationErrorOccured() {
        sendBroadcast(new Intent(Constants.ACTION_ERROR_OCCURED));
    }
}
