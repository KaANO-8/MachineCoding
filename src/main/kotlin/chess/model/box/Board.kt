package chess.model.box

import java.lang.IllegalStateException

class Board {
    var board: MutableList<MutableList<Box>> = mutableListOf()

    fun resetBoard() {
        // add init function here
        // place the pieces on the box and fill remaining ones with null
        /*for (i in 0 until 8) {
            val row = Array<Box?>(8) { null }
            for (j in 0 until 8) {
                row[j] = when(i) {
                    0 -> {
                        when(j) {
                            0, 7 -> {
                                Box(i, j, Knight(true))
                            }
                            else -> {Box(i, j, true)}
                        }
                    }
                    1 -> {

                    }
                    6 -> {

                    }
                    7 -> {

                    }
                    else -> { }
                }
            }
        }*/
    }

    fun getBox(x: Int, y: Int): Box {
        if (x !in 0..7 || y !in 0..7)
            throw IllegalStateException("Index out of bounds!")
        return board[x][y]
    }
}
