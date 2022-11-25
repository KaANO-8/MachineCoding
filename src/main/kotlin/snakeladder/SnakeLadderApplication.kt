package snakeladder

import snakeladder.domain.Game
import snakeladder.model.Player

fun main() {
    val game = Game(8, 8, 100)
    game.addPlayer(Player("Rahul"))
    game.addPlayer(Player("Prachi"))
    game.addPlayer(Player("Rohit"))
    game.addPlayer(Player("Rohan"))

    game.play()
}