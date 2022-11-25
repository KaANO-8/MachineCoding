package chess.model.piece

import chess.model.box.Box

class Knight(white: Boolean): Piece(white) {
    override fun canMove(start: Box, end: Box): Boolean {
        TODO("Not yet implemented")
        // add logic to make the knight move to the desired location
    }
}