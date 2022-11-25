package uber.providers

import uber.models.Location

interface PricingStrategy {
    fun findPrice(source: Location, destination: Location): Double
}