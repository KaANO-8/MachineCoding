package parkinglot

import parkinglot.parkingslot.HandicappedSlot
import parkinglot.parkingslot.ParkingSlot
import parkinglot.vehicle.Vehicle

class ParkingFloor(private val name: String) {
    private val handicappedSlot = mutableMapOf<String, HandicappedSlot>()

    fun addParkingSlot(slot: ParkingSlot) {
        when(slot) {
            is HandicappedSlot -> {
                handicappedSlot[slot.number] = slot
            }
        }
    }

    fun assignVehicleToSlot(slot: ParkingSlot, vehicle: Vehicle) {
        slot.assignVehicle(vehicle)
    }

    fun markSlotFree(slot: ParkingSlot) {
        slot.removeVehicle()
    }
}