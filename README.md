# updatewrapper

Gradle plugin that updates the gradle wrapper

[![Build Status](https://travis-ci.org/Commit451/updatewrapper.svg?branch=master)](https://travis-ci.org/Commit451/updatewrapper) [![](https://jitpack.io/v/Commit451/updatewrapper.svg)](https://jitpack.io/#Commit451/updatewrapper)

# Gradle Dependency
This plugin is available via JitPack

```groovy
apply plugin: 'com.commit451.updatewrapper'

buildscript {
  repositories {
    jcenter()
    maven { url "https://jitpack.io" }
  }

  dependencies {
    classpath 'com.github.Commit451:updatewrapper:latest.version.here'
  }
}
```

# Usage
```shell
./gradlew updatewrapper
```

# Can't You Update The Wrapper Without This Plugin?
Yes.

Basically, this plugin finds the latest version of Gradle via the GitHub API and runs the command:
```gradle
./gradlew wrapper --gradle-version {version} --distribution-type all
```
But, sometimes it is nice to just update the wrapper without having to look up the latest version.

# Thanks
Thanks to Ben Manes for his [versions plugin](https://github.com/ben-manes/gradle-versions-plugin) and Square for [SQLDelight](https://github.com/square/sqldelight) which were both great references for creating a Gradle plugin. The [docs](https://docs.gradle.org/current/userguide/custom_plugins.html#sec:custom_plugins_standalone_project) also helped out immensely.

License
--------

    Copyright 2017 Commit 451

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
