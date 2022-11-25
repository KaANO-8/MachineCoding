package chess.model.game

import chess.model.GameStatus
import chess.model.box.Board
import chess.model.piece.King
import chess.model.player.Player
import java.lang.IllegalStateException
import java.util.LinkedList
import java.util.Queue

class Game {
    private val players: Queue<Player> = LinkedList()
    private var gameStatus: GameStatus = GameStatus.INACTIVE
    private val moves = mutableListOf<Move>()
    private val board: Board = Board()

    fun init(p1: Player, p2: Player) {
        if (p1.isWhiteSide()) {
            players.offer(p1)
            players.offer(p2)
        } else {
            players.offer(p2)
            players.offer(p1)

        }
        board.resetBoard()
        gameStatus = GameStatus.ACTIVE
    }

    fun isEnd() = gameStatus != GameStatus.ACTIVE

    fun gameStatus() = gameStatus

    fun playerMove(p: Player, startX: Int, startY: Int, endX: Int, endY: Int): Boolean {
        // Case 1
        if (players.isNotEmpty() && players.peek() != p)
            throw IllegalStateException("Not a valid player")
        val player = players.peek()
        val startBox = board.getBox(startX, startY)
        val endBox = board.getBox(endX, endY)
        val move = Move(player, startBox, endBox)
        return makeMove(move)
    }

    private fun makeMove(move: Move): Boolean {
        // Case 2
        val srcPiece = move.start.piece ?: return false


        // Case 3
        // if white piece is not being moved by white player
        if (srcPiece.white != move.player.isWhiteSide())
            return false

        // Case 4
        // is valid move
        if (move.start.piece?.canMove(move.start, move.end) == false)
            return false

        // kill the piece
        val destPiece = move.end.piece
        if (destPiece != null) {
            destPiece.isKilled = true
            move.pieceKilled = destPiece
        }

        // castling?
        if (destPiece != null  && destPiece is King && destPiece.isCastlingMove(move.start, move.end))
            move.isCastlingMove = true
            // update game status

        moves.add(move)

        players.offer(move.player)

        return true
    }
}