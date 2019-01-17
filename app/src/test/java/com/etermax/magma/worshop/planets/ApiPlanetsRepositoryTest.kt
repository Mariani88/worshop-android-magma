package com.etermax.magma.worshop.planets

import com.etermax.magma.worshop.infoplanets.infrastructure.ApiPlanetsRepository
import com.etermax.magma.worshop.infoplanets.infrastructure.PlanetClient
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


class ApiPlanetsRepositoryTest {

    private lateinit var apiPlanetsRepository: ApiPlanetsRepository

    @Test
    fun sjdfkdjfkdjfkd(){

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val client = retrofit.create<PlanetClient>(PlanetClient::class.java)
        apiPlanetsRepository = ApiPlanetsRepository(client)
        apiPlanetsRepository.findById(1L)



    }

    private companion object {
        const val URL = "https://swapi.co/api/"
    }

}