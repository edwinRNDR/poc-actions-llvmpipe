import org.openrndr.application
import org.openrndr.color.ColorRGBa
import org.openrndr.draw.loadFont
import org.openrndr.draw.loadImage
import org.openrndr.draw.renderTarget
import org.openrndr.draw.tint
import java.io.File
import kotlin.math.cos
import kotlin.math.sin

fun main() = application {
    configure {
        width = 640
        height = 480
    }

    program {
        val image = loadImage("data/images/pm5544.png")
        val font = loadFont("data/fonts/IBMPlexMono-Regular.ttf", 64.0)

        val rt = renderTarget(640, 480) {
            colorBuffer()
        }

        extend {
            drawer.withTarget(rt) {
                drawer.ortho(rt)
                drawer.background(ColorRGBa.PINK)
                drawer.fill = ColorRGBa.WHITE
                drawer.circle(width / 2.0, height / 2.0, 100.0)
            }
            rt.colorBuffer(0).saveToFile(File("result.png"), async = false)
            application.exit()
        }
    }
}