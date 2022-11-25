package parkinglot.vehicle

import parkinglot.ParkingTicket
import parkinglot.enums.VehicleType

abstract class Vehicle(val vehicleType: VehicleType) {
    private lateinit var licenseNumber: String
    private var ticket: ParkingTicket?  = null

    fun assignTicket(ticket: ParkingTicket) {
        this.ticket = ticket
    }
}