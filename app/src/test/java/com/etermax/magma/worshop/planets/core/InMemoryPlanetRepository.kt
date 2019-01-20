package com.etermax.magma.worshop.planets.core

import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.core.domain.PlanetRepository

class InMemoryPlanetRepository(planets: List<Planet>): PlanetRepository{

    private val planetById: Map<Long, Planet> = planets.associateBy { it.planetId }

    override fun findById(planetId: Long) = planetById[planetId]!!
}