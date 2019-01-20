package com.etermax.magma.worshop.planets.core

import com.etermax.magma.worshop.infoplanets.core.action.FindPlanet
import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import io.reactivex.Single
import org.junit.Test
import java.util.*

class FindPlanetTest {

    private lateinit var findPlanet: FindPlanet
    private lateinit var planet: Planet
    private lateinit var planetSingle: Single<Planet>

    @Test
    fun findPlanetReturnAPlanet() {
        givenAFindAction()

        whenFindPlanet()

        thenReturnPlanet()
    }

    private fun thenReturnPlanet() {
        planetSingle.test().await()
            .assertComplete()
            .assertNoErrors()
            .assertValue(planet)
    }

    private fun whenFindPlanet() {
        planetSingle = findPlanet()
    }

    private fun givenAFindAction() {
        planet = Planet(PLANET_ID, NAME, ROTATION_PERIOD, ORBITAL_PERIOD, DIAMETER, CLIMATE, GRAVITY, TERRAIN,
            SURFACE_WATER, POPULATION, RESIDENTS, FILMS, CREATED, EDITED, URL)
        findPlanet = FindPlanet(InMemoryPlanetRepository(listOf(planet)))
    }

    private companion object {
        const val PLANET_ID = 1L
        const val NAME = "Alderaan"
        const val ROTATION_PERIOD = 24
        const val ORBITAL_PERIOD = 364
        const val DIAMETER = 12500
        const val CLIMATE = "temperate"
        const val GRAVITY = "1 standard"
        const val TERRAIN = "grasslands, mountains"
        const val SURFACE_WATER = 40
        const val POPULATION = 2000000000L
        val RESIDENTS = listOf(
            "https://swapi.co/api/people/5/",
            "https://swapi.co/api/people/68/",
            "https://swapi.co/api/people/81/")

        val FILMS = listOf("https://swapi.co/api/films/6/", "https://swapi.co/api/films/1/")
        val CREATED = Date()
        val EDITED = Date()
        const val URL = "https://swapi.co/api/planets/2/"
    }
}