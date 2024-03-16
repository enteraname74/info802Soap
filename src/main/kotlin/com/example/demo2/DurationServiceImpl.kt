package com.example.demo2

import jakarta.jws.WebService
import java.math.BigDecimal
import java.math.RoundingMode


@WebService(
    serviceName = "DurationService",
    portName = "8080",
    endpointInterface = "com.example.demo2.DurationService",
)
class DurationServiceImpl : DurationService {

    override fun travelDuration(totalDistance: Float, totalChargingStations: Int, carChargingTime: Float): Float {
        // We define an average car speed at 100 km/h.
        val initialTravelDuration = totalDistance / 100
        val chargingTime = totalChargingStations * carChargingTime

        val result = initialTravelDuration + chargingTime

        // We round the result to 2 decimals to make the result more clear for the user
        val roundedResult = BigDecimal(result.toDouble()).setScale(2, RoundingMode.HALF_EVEN).toFloat()

        return roundedResult
    }
}