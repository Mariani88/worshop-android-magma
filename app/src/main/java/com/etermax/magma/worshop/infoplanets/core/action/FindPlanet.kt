package com.etermax.magma.worshop.infoplanets.core.action

import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.core.domain.PlanetRepository
import io.reactivex.Single

class FindPlanet(private val planetsRepository: PlanetRepository) {

    operator fun invoke(): Single<Planet> =
        Single.fromCallable { planetsRepository.findById(1L) }
}