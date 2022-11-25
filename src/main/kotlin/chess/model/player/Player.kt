package chess.model.player

class Player(
    private val playerId: String,
    private val whiteSide: Boolean,
    private val exp: Int,
    account: Account,
    name: String,
    age: Int,
    phone: String
) : Person(name, age, phone, account) {
    fun isWhiteSide() = whiteSide
}
