package snakeladder.model

data class Player(val name: String, var position: Int = 0, var won: Boolean = false) {
    fun notOpen(): Boolean = position == 0
    fun hasOpen(): Boolean = position != 0
}