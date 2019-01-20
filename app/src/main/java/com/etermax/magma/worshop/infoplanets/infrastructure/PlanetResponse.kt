package com.etermax.magma.worshop.infoplanets.infrastructure

import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

class PlanetResponse(
    @JsonProperty("name") val name: String,
    @JsonProperty("rotation_period") val rotationPeriod: Int,
    @JsonProperty("orbital_period") val orbitalPeriod: Int,
    @JsonProperty("diameter") val diameter: Int,
    @JsonProperty("climate") val climate: String,
    @JsonProperty("gravity") val gravity: String,
    @JsonProperty("terrain") val terrain: String,
    @JsonProperty("surface_water") val surfaceWater: Int,
    @JsonProperty("population") val population: Long,
    @JsonProperty("residents") val residents: List<String>,
    @JsonProperty("films") val films: List<String>,
    @JsonProperty("created") val created: Date,
    @JsonProperty("edited") val edited: Date,
    @JsonProperty("url") val url: String
) {

    companion object {
        fun toPlanet(planetResponse: PlanetResponse, planetId: Long): Planet {
            return Planet(planetId, planetResponse.name, planetResponse.rotationPeriod, planetResponse.orbitalPeriod, planetResponse.diameter,
                planetResponse.climate, planetResponse.gravity, planetResponse.terrain, planetResponse.surfaceWater, planetResponse.population,
                planetResponse.residents, planetResponse.films, planetResponse.created, planetResponse.edited, planetResponse.url)
        }
    }
}
