package snakeladder.domain

import snakeladder.model.*
import java.util.LinkedList
import java.util.Queue
import kotlin.random.Random


class Game(private val numberOfLadders: Int, private val numberOfSnakes: Int, private val boardSize: Int) {

    private val players: Queue<Player>
    private val snakes: MutableSet<Snake>
    private val ladders: MutableSet<Ladder>
    private val board: Board
    private val dice: Dice

    init {
        players = LinkedList()
        snakes = mutableSetOf()
        ladders = mutableSetOf()
        board = Board(1, boardSize)
        dice = Dice(1, 6, 1)
        addSnakes()
        addLadders()
    }

    private fun addSnakes() {
        for (i in 1..numberOfSnakes) {
            while (true) {
                val snakeHead = Random.nextInt(1, boardSize)
                val snakeTail = Random.nextInt(1, snakeHead)
                val snake = Snake(snakeHead, snakeTail)
                if (snake !in snakes) {
                    snakes.add(snake)
                    break
                }
            }
        }
    }

    private fun addLadders() {
        for (i in 1..numberOfLadders) {
            while (true) {
                val ladderStart = Random.nextInt(1, boardSize)
                val ladderEnd = Random.nextInt(ladderStart + 1, boardSize)
                val ladder = Ladder(ladderStart, ladderEnd)
                if (ladder !in ladders) {
                    ladders.add(ladder)
                    break
                }
            }
        }
    }

    fun play() {
        while (true) {
            // base condition
            if (players.size < 2)
                break

            val player = players.poll()
            val nextDicePos = dice.roll()

            if (player.notOpen() && (nextDicePos == 1 || nextDicePos == 6)) {
                player.position = getPosition(1)
                players.offer(player)
            } else if (player.hasOpen()) {
                val nextPos = player.position + nextDicePos
                when {
                    nextPos > board.end -> players.offer(player)
                    nextPos == board.end -> {
                        player.position = board.end
                        player.won = true
                        println("${player.name} has won!")
                    }
                    else -> {
                        player.position = getPosition(nextPos)
                        println("${player.name} has moved to ${player.position}")
                        players.offer(player)
                    }
                }
            }
        }
    }


    fun addPlayer(player: Player) {
        players.offer(player)
    }

    private fun getPosition(nextPos: Int): Int {
        for (snake in snakes) {
            if (nextPos == snake.head) {
                println("Snake bit!")
                return snake.tail
            }
        }

        for (ladder in ladders) {
            if (nextPos == ladder.start) {
                println("Climbed ladder!")
                return ladder.end
            }
        }

        return nextPos
    }
}