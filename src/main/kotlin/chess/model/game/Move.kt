package chess.model.game

import chess.model.box.Box
import chess.model.piece.Piece
import chess.model.player.Player

class Move(val player: Player, val start: Box, val end: Box) {
    lateinit var pieceMoved: Piece
    lateinit var pieceKilled: Piece
    var isCastlingMove: Boolean = false
}