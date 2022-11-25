package chess.model.piece

import chess.model.box.Box

abstract class Piece(val white: Boolean) {
    var isKilled: Boolean = false
    abstract fun canMove(start: Box, end: Box): Boolean
}