package ies.sequeros

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "TiendaTemplate",
        state= WindowState(WindowPlacement.Fullscreen)
    ) {
        App()
    }
}