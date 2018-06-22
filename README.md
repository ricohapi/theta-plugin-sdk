# RICOH THETA Plug-in SDK

Version: 1.0.0

## Contents

* [Terms of Service](#terms)
* [Files included in the archive](#files)
* [Technical requirements for development](#requirements)
* [Contents of the SDK](#contents)
* [Getting Started](#started)
* [Where to find the latest information](#information)
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
├── pluginlibrary:        Plug-in library (utility program)
└── settings.gradle:      Android Studio build script
```

<a name="requirements"></a>
## Technical requirements for development

The SDK was tested with a RICOH THETA V under the following conditions.

### Camera

#### Hardware

* RICOH THETA V

#### Firmware

* ver.2.30.1 and above

    > Information on checking and updating the firmware is [here](https://theta360.com/en/support/manual/v/content/pc/pc_09.html).

### Development Environment

This SDK has been confirmed to operate under the following conditions.

#### Operating System

* Windows 10 Version 1709
* macOS High Sierra ver.10.13

#### Development environment

* Android&trade; Studio 3.1+
* gradle 3.1.3
* Android&trade; SDK (API Level 25)
* compileSdkVersion 26
* buildToolsVersion "27.0.3"
* minSdkVersion 25
* targetSdkVersion 25

<a name="contents"></a>
## Contents of the SDK

* This SDK is a Plug-in sample project of Android&trade; Studio.
* This SDK implements the basic parts necessary for developing plug-ins. You can create your own development project based on this project.
* This SDK includes a plug-in library ([pluginlibrary](pluginlibrary)) to support plug-in development of RICOH THETA. The plug-in library is the main part of the SDK, with its own part of the RICOH THETA plug-in being consolidated.
* The plug-in library implements the following functions that a standard plug-in should implement.
    * Get button operation event
    * Plug-in termination processing
    * LED control
    * Control of speaker

<a name="started"></a>
## Getting Started

1. Import plug-in sdk as a project into Android&trade; Studio.
1. Please rewrite the sample program in app accordingly and create a program.

    * By inheriting `PluginActivity` you will be able to use library methods.

        ```java
        public class MainActivity extends PluginActivity {
            @Override
            protected void onCreate (Bundle savedInstanceState) {
                super.onCreate (savedInstanceState);
                setContentView (R.layout.activity_main);
        ```

    * Please refer to [the web SDK document](https://api.ricoh/docs/theta-plugin/) for development precautions.

1. Please connect RICOH THETA V with USB.
1. By running it, installing and debuging is possible.
1. To build for distribution, build *apk* with *Build APK (s)* in the Build menu.

<a name="information"></a>
## Where to find the latest information

* The latest information is published on [the WEB site](https://api.ricoh/docs/theta-plugin/).
* The latest SDK is released on [the GitHub project](https://github.com/ricohapi/theta-plugin-sdk).

<a name="troubleshooting"></a>
## Troubleshooting

If you have a request, create an issue on [the GitHub project](https://github.com/ricohapi/theta-plugin-sdk/issues).

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
