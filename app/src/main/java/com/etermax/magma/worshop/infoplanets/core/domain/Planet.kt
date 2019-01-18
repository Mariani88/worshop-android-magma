package com.etermax.magma.worshop.infoplanets.core.domain

import java.util.*

data class Planet(val name: String, val rotationPeriod: Int, val orbitalPeriod: Int, val diameter: Int,
                  val climate: String, val gravity: String, val terrain: String, val surfaceWater: Int,
                  val population: Long, val residents: List<String>, val films: List<String>, val created: Date,
                  val edited: Date, val url: String)