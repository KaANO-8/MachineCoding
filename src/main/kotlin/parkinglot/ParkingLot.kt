package parkinglot

import parkinglot.vehicle.Vehicle
import java.lang.IllegalStateException

// This will be a singleton driver class

object ParkingLot {
    private lateinit var name: String
    private lateinit var address: String
    private lateinit var parkingRate: ParkingRate
    // contains all maxCount of slots
    // contains count of active slots per type

    private val entrancePanels = mutableMapOf<String, EntrancePanel>()
    private val exitPanels = mutableMapOf<String, ExitPanel>()
    private val parkingFloors = mutableMapOf<String, ParkingFloor>()
    private val activeTickets = mutableMapOf<String, ParkingTicket>()

    @Synchronized fun getNewParkingTicket(vehicle: Vehicle): ParkingTicket {
        if(isFull(vehicle)) {
            throw IllegalStateException("Parking full")
        }
        val ticket = ParkingTicket()
        vehicle.assignTicket(ticket)
        // inc slot count for vehicle type
        activeTickets["ticketnumber"] = ticket
        return ticket
    }

    fun exit(vehicle: Vehicle) {
        // remove from active tickets
        // unassign ticket
    }

    private fun isFull(vehicle: Vehicle): Boolean {
        // check logic to parking full for a slot of vehicle type

        return false
    }

    fun addEntranceGate() {}
    fun addExitPanel() {}
    fun addParkingFloor() {}
}