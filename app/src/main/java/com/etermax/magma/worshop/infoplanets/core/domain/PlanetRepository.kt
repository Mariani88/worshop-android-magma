package com.etermax.magma.worshop.infoplanets.core.domain

interface PlanetRepository {

    fun findById(planetId: Long): Planet
}