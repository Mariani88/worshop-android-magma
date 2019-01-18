package com.etermax.magma.worshop.infoplanets.infrastructure

import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.core.domain.PlanetRepository
import retrofit2.Response

class ApiPlanetsRepository(private val client: PlanetClient): PlanetRepository {

    override fun findById(planetId: Long): Planet {
        val response = client.findPlanet(planetId).execute()
        checkResponse(response)




        return PlanetResponse.toPlanet(response.body()!!)
    }

    private fun checkResponse(response: Response<PlanetResponse>) {
        if(!response.isSuccessful) throw BadResponse("response return ${response.code()}")
    }
}