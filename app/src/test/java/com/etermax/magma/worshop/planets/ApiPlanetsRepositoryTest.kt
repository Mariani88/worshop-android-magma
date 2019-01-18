package com.etermax.magma.worshop.planets

import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.infrastructure.ApiPlanetsRepository
import com.etermax.magma.worshop.infoplanets.infrastructure.PlanetClient
import com.etermax.magma.worshop.infoplanets.infrastructure.PlanetResponse
import org.junit.Test
import retrofit2.Response
import java.util.*


class ApiPlanetsRepositoryTest {

    private lateinit var apiPlanetsRepository: ApiPlanetsRepository
    private lateinit var client: PlanetClient
    private lateinit var receivedPlanet: Planet
    private lateinit var validResponse: Response<PlanetResponse>
    private lateinit var planetResponse: PlanetResponse

    /*
    parseo correcto
    fallo por status code erroneo
    body vacio

     */

    @Test
    fun sjdfkdjfkdjfkd() {
        givenThatApiReturnValidResponse()
        givenAPlanetRepository()

        whenFindPlanet()

        thenReturnPlanet()
    }

    private fun thenReturnPlanet() {

    }

    private fun whenFindPlanet() {
        receivedPlanet = apiPlanetsRepository.findById(PLANET_ID)
    }

    private fun givenAPlanetRepository() {
        apiPlanetsRepository = ApiPlanetsRepository(client)
    }

    private fun givenThatApiReturnValidResponse() {
        planetResponse = PlanetResponse(
            name,
            rotationPeriod,
            orbitalPeriod,
            diameter,
            climate,
            gravity,
            terrain,
            surfaceWater,
            population,
            residents,
            films,
            created,
            edited,
            url


        )

        validResponse = Response.success(planetResponse)
    }

    private companion object {
        const val PLANET_ID = 1L

        val name = "Alderaan"
        val rotationPeriod = 24
        val orbitalPeriod = 364
        val diameter = 12500
        val climate: String
        val gravity: String
        val terrain: String
        val surfaceWater: Int
        val population: Long
        val residents: List<String>
        val films: List<String>
        val created: Date
        val edited: Date
        val url: String
    }


    /*
    const val URL = "https://swapi.co/api/"
    val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val client = retrofit.create<PlanetClient>(PlanetClient::class.java)
     */


}