# RICOH THETA Plug-in SDK

Version: 3.0.0

## Contents

* [Terms of Service](#terms)
* [Files included in the archive](#files)
* [Technical requirements for development](#requirements)
* [Contents of the SDK](#contents)
* [How to Use](#how_to_use)
* [See Also](#see_also)
* [Troubleshooting](#troubleshooting)
* [Trademark Information](#trademark)

<a name="terms"></a>
## Terms of Service

> You agree to comply with all applicable export and import laws and regulations applicable to the jurisdiction in which the Software was obtained and in which it is used. Without limiting the foregoing, in connection with use of the Software, you shall not export or re-export the Software  into any U.S. embargoed countries (currently including, but necessarily limited to, Crimea – Region of Ukraine, Cuba, Iran, North Korea, Sudan and Syria) or  to anyone on the U.S. Treasury Department’s list of Specially Designated Nationals or the U.S. Department of Commerce Denied Person’s List or Entity List.  By using the Software, you represent and warrant that you are not located in any such country or on any such list.  You also agree that you will not use the Software for any purposes prohibited by any applicable laws, including, without limitation, the development, design, manufacture or production of missiles, nuclear, chemical or biological weapons.

By using the RICOH THETA Plug-in SDK, you are agreeing to the above and the license terms, [LICENSE.txt](LICENSE.txt).

Copyright &copy; 2018 Ricoh Company, Ltd.

<a name="files"></a>
## Files included in the archive

```
├── README.md:            This file
├── LICENSE.txt:          Files concerning the contract
├── app:                  Sample project
├── build.gradle:         Android Studio build script
├── gradle:               Android Studio build script
├── gradle.properties:    Android Studio build script
├── gradlew:              Android Studio build script
├── gradlew.bat:          Android Studio build script
└── settings.gradle:      Android Studio build script
```

<a name="requirements"></a>
## Technical requirements for development

This SDK has been tested under the following conditions.

### Camera

#### Hardware

* RICOH THETA V ; Firmware version must be 2.30.1 or later
* RICOH THETA Z1
* RICOH THETA X

### Development Environment

This SDK has been confirmed under the following conditions.

#### Operating System

* Windows 10 Version 21H1
* macOS Monterey Version 12.2

#### Development environment

* Android&trade; Studio 4.2.2
* gradle 3.5.3
* Android&trade; SDK (API Level 29)
* compileSdkVersion 29
* minSdkVersion 25
* targetSdkVersion 29

<a name="contents"></a>
## Contents of the SDK

* This SDK is a plug-in sample project of Android&trade; Studio.
* This SDK just implements shooting picture function via WebAPI. You can modify this sample project to create your own plug-in.
* This SDK imports ([RICOH THETA Plug-in Library](https://github.com/ricohapi/theta-plugin-library)) which provides support features to develop plug-in.

<a name="how_to_use"></a>
## How to Use

1. Import plug-in sdk as a project into Android&trade; Studio.
1. Rewrite the sample code like following. By inheriting `PluginActivity` you can use methods provided by RICOH THETA Plug-in Library.

    ```java
    public class MainActivity extends PluginActivity {
        @Override
        protected void onCreate (Bundle savedInstanceState) {
            super.onCreate (savedInstanceState);
            setContentView (R.layout.activity_main);
    ```

1. Connect RICOH THETA with USB cable.
1. Execute Run by Android&trade; Studio, APK will be installed to RICOH THETA and you can debug it.

<a name="see_also"></a>
## See Also

* The latest information related to plug-in development is published on [api.ricoh](https://api.ricoh/docs/theta-plugin/).
* The latest SDK is released on [the GitHub project](https://github.com/ricohapi/theta-plugin-sdk).

<a name="troubleshooting"></a>
## Troubleshooting

If you had a request or found a problem, please create an issue on [the GitHub project](https://github.com/ricohapi/theta-plugin-sdk/issues).

<a name="trademark"></a>
## Trademark Information

The names of products and services described in this document are trademarks or registered trademarks of each company.

* Android, Nexus, Google Chrome, Google Play, Google Play logo, Google Maps, Google+, Gmail, Google Drive, Google Cloud Print and YouTube are trademarks of Google Inc.
* Apple, Apple logo, Macintosh, Mac, Mac OS, OS X, AppleTalk, Apple TV, App Store, AirPrint, Bonjour, iPhone, iPad, iPad mini, iPad Air, iPod, iPod mini, iPod classic, iPod touch, iWork, Safari, the App Store logo, the AirPrint logo, Retina and iPad Pro are trademarks of Apple Inc., registered in the United States and other countries. The App Store is a service mark of Apple Inc.
* Bluetooth Low Energy and Bluetooth are trademarks or registered trademarks of US Bluetooth SIG, INC., in the United States and other countries.
* Microsoft, Windows, Windows Vista, Windows Live, Windows Media, Windows Server System, Windows Server, Excel, PowerPoint, Photosynth, SQL Server, Internet Explorer, Azure, Active Directory, OneDrive, Outlook, Wingdings, Hyper-V, Visual Basic, Visual C ++, Surface, SharePoint Server, Microsoft Edge, Active Directory, BitLocker, .NET Framework and Skype are registered trademarks or trademarks of Microsoft Corporation in the United States and other countries. The name of Skype, the trademarks and logos associated with it, and the "S" logo are trademarks of Skype or its affiliates.
* Wi-Fi™, Wi-Fi Certified Miracast, Wi-Fi Certified logo, Wi-Fi Direct, Wi-Fi Protected Setup, WPA, WPA 2 and Miracast are trademarks of the Wi-Fi Alliance.
* The official name of Windows is Microsoft Windows Operating System.
* All other trademarks belong to their respective owners.
