package com.etermax.magma.worshop.infoplanets.infrastructure

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PlanetClient {

    @GET("planets/{planet_id}")
    fun findPlanet(@Path("planet_id") planetId: Long): Call<PlanetResponse>

}