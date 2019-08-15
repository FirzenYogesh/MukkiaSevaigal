# MukkiaSevaigal
Android Utility library for commonly used functions

# Features:

You can easily:

* Toast Messages
* Log
* Show SnackBar
* Save to Preferences
* Retrieve saved value from Preferences
* and many more utility functions.

## Requirements:

This library works form API-14

## Getting Started :

To use this library simply import it by placing the following line under dependencies in your app module's build.gradle file

This library is hosted in jCenter

```gradle
dependencies {
   implementation 'yogesh.firzen:MukkiyaSevaigal:3.0.3'
}
```

If any problem occured while importing please add this line to your app module's build.gradle file

```
   repositories {
      maven {url "https://dl.bintray.com/firzenyogesh/maven"}
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
  
## Authors

* **Yogesh Sundaresan** -  [GitHub](https://github.com/FirzenYogesh)


## License

```
Copyright 2016 Yogesh Sundaresan

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
