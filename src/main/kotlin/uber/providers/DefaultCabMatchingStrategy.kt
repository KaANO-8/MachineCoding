package uber.providers

import uber.models.Cab
import uber.models.Location
import uber.models.Rider
import java.lang.IllegalStateException

class DefaultCabMatchingStrategy: CabMatchingStrategy {
    override fun matchCabToRider(rider: Rider, cabs: List<Cab>, source: Location, destination: Location): Cab {
        if(cabs.isEmpty())
            throw IllegalStateException("There are no cabs available")
        return cabs.minBy { it.currentLocation.distance(source) }
    }
}