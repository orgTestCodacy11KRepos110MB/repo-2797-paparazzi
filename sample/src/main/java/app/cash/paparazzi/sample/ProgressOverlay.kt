package app.cash.paparazzi.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

@Composable
fun ProgressOverlay(text: String) {
  Dialog(
    onDismissRequest = { },
    DialogProperties(
      dismissOnBackPress = false,
      dismissOnClickOutside = false,
    ),
  ) {
    Box(
      contentAlignment = Alignment.Center,
      modifier = Modifier
        .background(Color.White, shape = RoundedCornerShape(8.dp))
        .testTag("progressOverlay"),

      ) {
      Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
      ) {
        Text(
          text,
          fontSize = 18.sp,
          modifier = Modifier
            .testTag("progressOverlayMessage"),
        )
        Spacer(Modifier.height(20.dp))
        CircularProgressIndicator()
      }
    }
  }
}
