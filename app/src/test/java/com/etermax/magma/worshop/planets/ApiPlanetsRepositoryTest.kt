package com.etermax.magma.worshop.planets

import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.infrastructure.ApiPlanetsRepository
import com.etermax.magma.worshop.infoplanets.infrastructure.BadResponse
import com.etermax.magma.worshop.infoplanets.infrastructure.PlanetClient
import com.etermax.magma.worshop.infoplanets.infrastructure.PlanetResponse
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Call
import retrofit2.Response
import java.util.*

class ApiPlanetsRepositoryTest {

    private lateinit var apiPlanetsRepository: ApiPlanetsRepository
    private lateinit var client: PlanetClient
    private lateinit var receivedPlanet: Planet
    private lateinit var validResponse: Response<PlanetResponse>
    private lateinit var planetResponse: PlanetResponse
    private var exception: Throwable? = null

    /*
    parseo correcto
    fallo por status code erroneo
    body vacio

     */

    @Test
    fun apiResponseSuccessfullyReturningAPlanet() {
        givenThatApiReturnValidResponse()
        givenAPlanetRepository()

        whenFindPlanet()

        thenReturnPlanet()
    }

    @Test
    fun apiReturnBadResponse(){
        givenApiReturnBadResponse()
        givenAPlanetRepository()

        whenFindPlanet()

        thenExceptionIsThrown()
    }

    private fun thenExceptionIsThrown() {
        assertThat(exception).isNotNull()
        assertThat(exception).isInstanceOf(BadResponse::class.java)
    }

    private fun givenApiReturnBadResponse() {
        val call: Call<PlanetResponse> = mock(Call::class.java) as Call<PlanetResponse>
        val badResponse = Response.error<PlanetResponse>(403, ResponseBody.create(MediaType.parse("APPLICATION/JSON"), "" ))
        `when`(call.execute()).thenReturn(badResponse)
        client = mock(PlanetClient::class.java).also { `when`(it.findPlanet(PLANET_ID)).thenReturn(call) }
    }

    private fun thenReturnPlanet() {
        assertThat(receivedPlanet.climate).isEqualTo(CLIMATE)
        assertThat(receivedPlanet.rotationPeriod).isEqualTo(ROTATION_PERIOD)
        assertThat(receivedPlanet.orbitalPeriod).isEqualTo(ORBITAL_PERIOD)
        assertThat(receivedPlanet.name).isEqualTo(NAME)
        assertThat(receivedPlanet.gravity).isEqualTo(GRAVITY)
        assertThat(receivedPlanet.terrain).isEqualTo(TERRAIN)
        assertThat(receivedPlanet.surfaceWater).isEqualTo(SURFACE_WATER)
        assertThat(receivedPlanet.residents).isEqualTo(RESIDENTS)
        assertThat(receivedPlanet.films).isEqualTo(FILMS)
        assertThat(receivedPlanet.created).isEqualTo(CREATED)
        assertThat(receivedPlanet.edited).isEqualTo(EDITED)
        assertThat(receivedPlanet.url).isEqualTo(URL)
        assertThat(receivedPlanet.diameter).isEqualTo(DIAMETER)
    }

    private fun whenFindPlanet() {
        exception = catchThrowable {  receivedPlanet = apiPlanetsRepository.findById(PLANET_ID) }
    }

    private fun givenAPlanetRepository() {
        apiPlanetsRepository = ApiPlanetsRepository(client)
    }

    private fun givenThatApiReturnValidResponse() {
        planetResponse = PlanetResponse(NAME, ROTATION_PERIOD, ORBITAL_PERIOD, DIAMETER, CLIMATE, GRAVITY, TERRAIN,
            SURFACE_WATER, POPULATION, RESIDENTS, FILMS, CREATED, EDITED, URL)
        validResponse = Response.success(planetResponse)
        val call: Call<PlanetResponse> = mock(Call::class.java) as Call<PlanetResponse>
        `when`(call.execute()).thenReturn(validResponse)
        client = mock(PlanetClient::class.java).also { `when`(it.findPlanet(PLANET_ID)).thenReturn(call) }
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
            "https://swapi.co/api/people/81/"
        )

        val FILMS = listOf("https://swapi.co/api/films/6/", "https://swapi.co/api/films/1/")
        val CREATED = Date()
        val EDITED = Date()
        const val URL = "https://swapi.co/api/planets/2/"
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