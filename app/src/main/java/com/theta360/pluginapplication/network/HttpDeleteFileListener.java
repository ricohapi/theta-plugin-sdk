package com.theta360.pluginapplication.network;

import java.util.ArrayList;

public interface HttpDeleteFileListener {

	/**
	 * Notifies you of the device status check results
	 * @param newStatus true:Update available, false;No update available
	 */
	void onCheckStatus(boolean newStatus);

	/**
	 * Notifies you when the files are deleted
	 * @param deletedImages Urls of images that were deleted
	 * */
	void onObjectChanged(ArrayList<String> deletedImages);

	/**
	 * Notify on completion of event
	 */
	void onCompleted();

	/**
	 * Notify in the event of an error
	 */
	void onError(String errorMessage);

}
