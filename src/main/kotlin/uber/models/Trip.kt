package uber.models

data class Trip(
    val rider: Rider,
    val cab: Cab,
    var tripStatus: TripStatus = TripStatus.IN_PROGRESS,
    val price: Double,
    val source: Location,
    val destination: Location
) {
    fun endTrip() {
        tripStatus = TripStatus.FINISHED
    }
}

enum class TripStatus {
    IN_PROGRESS, FINISHED
}
