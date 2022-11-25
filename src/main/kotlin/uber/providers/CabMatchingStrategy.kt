package uber.providers

import uber.models.Cab
import uber.models.Location
import uber.models.Rider

interface CabMatchingStrategy {
    fun matchCabToRider(rider: Rider, cabs: List<Cab>, source: Location, destination: Location): Cab
}