package tictactoe.board

import tictactoe.model.Symbol

class Board {
    private val gameBoard = Array(3) { Array<Symbol>(3) { Symbol.BLANK } }

    fun reset() {
        // reset the board
        for (i in gameBoard.indices)
            for (j in gameBoard[0].indices)
                gameBoard[i][j] = Symbol.BLANK
    }

    @Throws(ArrayIndexOutOfBoundsException::class)
    fun getBox(x: Int, y: Int): Symbol {
        if (x !in 0..2 || y !in 0..2)
            throw ArrayIndexOutOfBoundsException()
        return gameBoard[x][y]
    }
}
