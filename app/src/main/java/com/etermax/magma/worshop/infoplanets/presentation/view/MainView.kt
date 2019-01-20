package com.etermax.magma.worshop.infoplanets.presentation.view

import com.etermax.magma.worshop.infoplanets.presentation.presenter.InfoPlanetReducedDataModel

interface MainView {
    fun showInfoPlanet(infoPlanetReducedDataModel: InfoPlanetReducedDataModel)
    fun showMessage(message: String)
}