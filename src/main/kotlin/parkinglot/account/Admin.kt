package parkinglot.account

import parkinglot.parkingslot.ParkingSlot

class Admin: Person() {
    fun addParkingFloor(floor: String) {}
    fun addParkingSlot(floorName: String, slot: ParkingSlot) {}

}