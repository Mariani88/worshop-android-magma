package com.etermax.magma.worshop.infoplanets.infrastructure

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


//    {
//        "name": "Alderaan",
//        "rotation_period": "24",
//        "orbital_period": "364",
//        "diameter": "12500",
//        "climate": "temperate",
//        "gravity": "1 standard",
//        "terrain": "grasslands, mountains",
//        "surface_water": "40",
//        "population": "2000000000",
//        "residents": [
//        "https://swapi.co/api/people/5/",
//        "https://swapi.co/api/people/68/",
//        "https://swapi.co/api/people/81/"
//        ],
//        "films": [
//        "https://swapi.co/api/films/6/",
//        "https://swapi.co/api/films/1/"
//        ],
//        "created": "2014-12-10T11:35:48.479000Z",
//        "edited": "2014-12-20T20:58:18.420000Z",
//        "url": "https://swapi.co/api/planets/2/"
//    }


}
