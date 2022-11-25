package uber.providers

import uber.models.Location

class DefaultPricingStrategy: PricingStrategy {
    override fun findPrice(source: Location, destination: Location): Double {
        val dynamicFare = source.distance(destination) * PER_KM_RATE
        return BASE_FARE + dynamicFare
    }

    companion object {
        private const val BASE_FARE = 35
        private const val PER_KM_RATE = 15
    }
}