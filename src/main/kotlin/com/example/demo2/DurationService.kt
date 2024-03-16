package com.example.demo2

import jakarta.jws.WebMethod
import jakarta.jws.WebService

@WebService
interface DurationService {

    @WebMethod
    fun travelDuration(totalDistance: Float, totalChargingStations: Int, carChargingTime: Float): Float
}