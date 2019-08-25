/*
 * Copyright (C) 2019 Square, Inc.
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
package app.cash.paparazzi

import java.io.File

data class Environment(
  val platformDir: String,
  val appTestDir: String,
  val resDir: String
) {
  val testResDir: String = "$appTestDir/app/build/intermediates/classes/production/release/"
  val assetsDir = "$appTestDir/src/main/assets/"
}

fun detectEnvironment(): Environment {
  val userDir = System.getProperty("user.dir")
  val userHome = System.getProperty("user.home")
  val androidHome = System.getenv("ANDROID_HOME") ?: "$userHome/Library/Android/sdk"
  // TODO: detect platformDir by finding the highest SDK in ANDROID_HOME.
  val platformDir = "$androidHome/platforms/android-28/"
  val resDir = File("build/intermediates/paparazzi/resources.txt").readLines().first()
  return Environment(platformDir, userDir, resDir)
}