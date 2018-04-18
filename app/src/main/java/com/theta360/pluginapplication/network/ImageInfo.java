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
 * Information class of media file
 */
public class ImageInfo {
    public static String FILE_FORMAT_CODE_EXIF_JPEG = "JPEG";
    public static String FILE_FORMAT_CODE_EXIF_MPEG = "MPEG";

    private String mFileName;
    private String mFileId;
    private long mFileSize;
    private String mCaptureDate;
    private String mFileFormat;
    private int mWidth;
    private int mHeight;

    /**
     * Acquire file name
     * @return File name
     */
    public String getFileName() {
        return mFileName;
    }

    /**
     * Set file name
     * @param fileName File name
     */
    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    /**
     * Acquire File ID
     * @return File ID
     */
    public String getFileId() {
        return mFileId;
    }

    /**
     * Set File ID
     * @param fileId File ID
     */
    public void setFileId(String fileId) {
        mFileId = fileId;
    }

    /**
     * Acquire file size
     * @return File size (unit: bytes)
     */
    public long getFileSize() {
        return mFileSize;
    }

    /**
     * Set file size
     * @param fileSize File size (unit: bytes)
     */
    public void setFileSize(long fileSize) {
        mFileSize = fileSize;
    }

    /**
     * Acquire shooting time
     * @return Shooting time
     */
    public String getCaptureDate() {
        return mCaptureDate;
    }

    /**
     * Set shooting time
     * @param captureDate Shooting time
     */
    public void setCaptureDate(String captureDate) {
        mCaptureDate = captureDate;
    }

    /**
     * Acquire media format
     * @return Media format
     */
    public String getFileFormat() {
        return mFileFormat;
    }

    /**
     * Set media format<p>
     * Set {@link ImageInfo#FILE_FORMAT_CODE_EXIF_JPEG} or {@link ImageInfo#FILE_FORMAT_CODE_EXIF_MPEG}.
     * @param fileFormat Media format
     */
    public void setFileFormat(String fileFormat) {
        mFileFormat = fileFormat;
    }

    /**
     * Acquire image width
     * @return Image width
     */
    public int getWidth() {
        return mWidth;
    }

    /**
     * Set image width
     * @param width Image width
     */
    public void setWidth(int width) {
        mWidth = width;
    }

    /**
     * Acquire image height
     * @return Image height
     */
    public int getHeight() {
        return mHeight;
    }

    /**
     * Set image height
     * @param height Image height
     */
    public void setHeight(int height) {
        mHeight = height;
    }
}
