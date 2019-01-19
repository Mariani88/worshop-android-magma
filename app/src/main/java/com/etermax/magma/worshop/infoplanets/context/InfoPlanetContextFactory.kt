package com.etermax.magma.worshop.infoplanets.context

import com.etermax.magma.worshop.infoplanets.infrastructure.PlanetClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class InfoPlanetContextFactory {

    companion object {

        private const val URL = "https://swapi.co/api/"

        fun infoPlanetApiClient(): PlanetClient {
            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .build()

            return retrofit.create<PlanetClient>(PlanetClient::class.java)
        }
    }
}