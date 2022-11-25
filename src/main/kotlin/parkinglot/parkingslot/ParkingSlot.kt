package parkinglot.parkingslot

import parkinglot.vehicle.Vehicle
import parkinglot.enums.ParkingSlotType

abstract class ParkingSlot(val type: ParkingSlotType) {
    lateinit var number: String
    private var free: Boolean = true
    private var vehicle: Vehicle? = null

    fun assignVehicle(vehicle: Vehicle) {
        this.vehicle = vehicle
        free = false
    }

    fun removeVehicle(): Boolean {
        this.vehicle = null
        free = true
        return true
    }
}