package ies.sequeros

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application
import appModule
import org.koin.core.context.GlobalContext.startKoin
import org.koin.core.context.GlobalContext.stopKoin

fun main() = application {
    startKoin {
        modules(appModule)
    }
    Window(
        onCloseRequest = ::exitApplication,
        title = "TiendaTemplate",
        state= WindowState(WindowPlacement.Fullscreen)
    ) {
        App()
    }
    stopKoin()
}