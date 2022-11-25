package snakeladder.model

import kotlin.random.Random

data class Dice(val minValue: Int, val maxValue: Int, var currentValue: Int) {
    fun roll(): Int = Random.nextInt(minValue, maxValue + 1)
}
