package chess.model.piece

import chess.model.box.Box
import kotlin.math.abs

class King(white: Boolean) : Piece(white) {
    private var castlingDone: Boolean = false

    override fun canMove(start: Box, end: Box): Boolean {
        if (start.piece?.white == end.piece?.white)
            return false

        val x = abs(start.x - end.x)
        val y = abs(start.y - end.y)

        if (x + y == 1)
            return true

        return isValidCastling()
    }

    private fun isValidCastling(): Boolean {
        castlingDone = true
        return true
    }

    fun isCastlingDone() = castlingDone

    fun isCastlingMove(start: Box, end: Box): Boolean {
        return true
    }
}