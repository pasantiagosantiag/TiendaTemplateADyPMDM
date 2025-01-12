package ies.sequeros.administracion.graficos

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ies.sequeros.administracion.usuarios.UsuarioViewModel
import org.jetbrains.letsPlot.Figure
import org.jetbrains.letsPlot.Stat
import org.jetbrains.letsPlot.annotations.layerLabels
import org.jetbrains.letsPlot.geom.geomPie
import org.jetbrains.letsPlot.ggsize
import org.jetbrains.letsPlot.letsPlot
import org.jetbrains.letsPlot.skia.compose.PlotPanel
import org.jetbrains.letsPlot.themes.elementBlank
import org.jetbrains.letsPlot.themes.theme

@Composable
fun EjemploGrafico(usuarioViewModel: UsuarioViewModel) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            // horizontalAlignment = Alignment.CenterHorizontally
            verticalAlignment = Alignment.CenterVertically,

            ) {

            PlotPanel(
                figure = createFigure(),
                modifier = Modifier.fillMaxSize()
            ) { computationMessages ->
                computationMessages.forEach { println("[DEMO APP MESSAGE] $it") }
            }
        }
    }
}
private fun createFigure(): Figure {
    //tema del gráfico
    val blankTheme = theme(line= elementBlank(), axis= elementBlank(), panelGrid = elementBlank(), axisLine = elementBlank(), axisTitle = elementBlank())
    //dimensiones
    val (w, h) = 800 to 250

    //datos transformados, marca y número de productos
    val data = mapOf(
        "Marca" to listOf("Samsung","LG","Roca"),
        "Productos" to  listOf(1,2,3)
    )
    //composición
    val p = letsPlot(data) +
            blankTheme+
            geomPie(
                stat = Stat.identity, size=40, stroke = 1, color="white", hole=0.5,
                labels = layerLabels().line("@Marca (@Productos)").size(16)
            ) { slice = "Productos"; fill = "Marca" } +
            ggsize(w,h)

    return p
}