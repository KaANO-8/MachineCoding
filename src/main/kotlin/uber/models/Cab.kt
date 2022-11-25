package uber.models

data class Cab(
    val id: String,
    val name: String,
    var currentLocation: Location,
    var isAvailable: Boolean = true,
    var currentTrip: Trip
)
