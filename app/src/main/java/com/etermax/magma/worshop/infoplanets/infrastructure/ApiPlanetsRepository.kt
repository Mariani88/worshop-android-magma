package com.etermax.magma.worshop.infoplanets.infrastructure

import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.core.domain.PlanetRepository

class ApiPlanetsRepository(private val client: PlanetClient): PlanetRepository {

    override fun findById(planetId: Long): Planet {
        val planetResponse = client.findPlanet(planetId)

        return Planet()
    }
}