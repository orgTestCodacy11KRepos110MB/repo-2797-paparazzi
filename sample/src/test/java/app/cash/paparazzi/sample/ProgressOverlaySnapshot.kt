package app.cash.paparazzi.sample

import app.cash.paparazzi.DeviceConfig.Companion.PIXEL_5
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test

class ProgressOverlaySnapshot {
  @get:Rule
  val paparazzi = Paparazzi(
    deviceConfig = PIXEL_5,
    theme = "android:Theme.Material.Light.NoActionBar"
  )

  @Test
  fun exampleMessage() {
    paparazzi.snapshot {
      ProgressOverlay("This is a test")
    }
  }
}
