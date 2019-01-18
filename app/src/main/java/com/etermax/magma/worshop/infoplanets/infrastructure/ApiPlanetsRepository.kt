package com.etermax.magma.worshop.infoplanets.infrastructure

import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.core.domain.PlanetRepository
import retrofit2.Response

class ApiPlanetsRepository(private val client: PlanetClient): PlanetRepository {

    override fun findById(planetId: Long): Planet {
        val response = client.findPlanet(planetId).execute()
        val planetResponse = checkResponse(response)
        return PlanetResponse.toPlanet(planetResponse)
    }

    private fun checkResponse(response: Response<PlanetResponse>): PlanetResponse {
        if(!response.isSuccessful) throw BadResponse("response return ${response.code()}")
        return response.body() ?: throw BadResponse("Invalid response, empty body")
    }
}