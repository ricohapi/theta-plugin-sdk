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
 * HTTP communication event listener class
 */
public interface HttpEventListener {
    /**
     * Notifies you of the device status check results
     * @param newStatus true:Update available, false;No update available
     */
    void onCheckStatus(boolean newStatus);

    /**
     * Notifies you when the file is saved
     * @param latestCapturedFileId ID of saved file
     */
    void onObjectChanged(String latestCapturedFileId);

    /**
     * Notify on completion of event
     */
    void onCompleted();

    /**
     * Notify in the event of an error
     */
    void onError(String errorMessage);
}
