package uber.models

import kotlin.math.pow
import kotlin.math.sqrt

data class Location(val x: Double, val y: Double) {

    fun distance(destination: Location): Double =
        sqrt((x - destination.x).pow(2.0) + (y - destination.y).pow(2.0))
}
