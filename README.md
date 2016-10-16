# MukkiaSevaigal
Android library for commonly used functions

# Features:

You can easily:

* Toast Messages
* Log
* Show SnackBar
* Save to Preferences
* Retrieve saved value from Preferences
* and many more utility functions.

## Requirements:

This library works form API-11

## Getting Started :

Add Gradle dependency :

```gradle
dependencies {
   compile 'yogesh.firzen:MukkiyaSevaigal:1.0.0'
}
```

AppCompat, Google Design, CommonsIO library is required by this library.

```gradle
dependencies {
   compile 'com.android.support:appcompat-v7:24.2.1'
   compile 'com.android.support:design:24.2.1'
   compile 'commons-io:commons-io:2.4'
}
```

## Usage:

* For [Toasts](https://github.com/Yogesh0795/MukkiaSevaigal/wiki/Toasts):
  - `M.T(context,"Hello World");`
* For [Logs](https://github.com/Yogesh0795/MukkiaSevaigal/wiki/Logs):
  - `M.L("TAG","Hello World!");`
* For [SnackBar](https://github.com/Yogesh0795/MukkiaSevaigal/SnackBar):
  - `M.S(activityView,"Hello World");`
* To save a value in [Preferences](https://github.com/Yogesh0795/MukkiaSevaigal/Preferences):
  - `P.save(context,"key",value);`
* To retreive value from [Preferences](https://github.com/Yogesh0795/MukkiaSevaigal/Preferences):
  - `P.getInt(context,"key");`
  - `P.getString(context,"key");`
  - `P.getFloat(context,"key");`
  - `P.getBoolean(context,"key");`
  - and more
