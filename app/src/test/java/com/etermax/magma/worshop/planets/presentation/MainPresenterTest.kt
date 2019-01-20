package com.etermax.magma.worshop.planets.presentation

import com.etermax.magma.worshop.infoplanets.core.action.FindPlanet
import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.presentation.presenter.InfoPlanetReducedDataModel
import com.etermax.magma.worshop.infoplanets.presentation.presenter.MainPresenter
import com.etermax.magma.worshop.infoplanets.presentation.view.MainView
import com.etermax.magma.worshop.planets.rules.RxCustomSchedulersRule
import io.reactivex.Single
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*
import java.lang.RuntimeException
import java.util.*

class MainPresenterTest {

    @JvmField
    @Rule
    val rxCustomSchedulersRule = RxCustomSchedulersRule()

    private lateinit var mainPresenter: MainPresenter
    private lateinit var mainView: MainView
    private lateinit var findPlanet: FindPlanet
    private lateinit var planet: Planet

    @Test
    fun findInfoPlanetShowSearching(){
        givenAFindAction()
        givenAMainPresenter()

        whenFindInfoPlanet()

        thenVerifyThatShowSearching()
    }

    @Test
    fun findInfoPlanetFindPlanetAndShowInfo(){
        givenFindPlanetReturnPlanet()
        givenAMainPresenter()

        whenFindInfoPlanet()

        thenVerifyThatShowSearching()
        thenVerifyCallFindPlanetAction()
        thenVerifyShowItInView()
    }

    @Test
    fun findInfoPlanetWhenThereIsAnError(){
        givenFindPlanetReturnError()
        givenAMainPresenter()

        whenFindInfoPlanet()

        thenVerifyThatShowSearching()
        thenVerifyCallFindPlanetAction()
        thenVerifyShowErrorOnView()
    }

    private fun thenVerifyShowErrorOnView() {
        verify(mainView, times (1)).showErrorMessage()
    }

    private fun givenFindPlanetReturnError() {
        givenAFindAction()
        `when`(findPlanet.invoke()).thenReturn(Single.error(RuntimeException()))
    }

    private fun givenFindPlanetReturnPlanet() {
        planet = Planet(PLANET_ID, NAME, ROTATION_PERIOD, ORBITAL_PERIOD, DIAMETER, CLIMATE, GRAVITY, TERRAIN,
            SURFACE_WATER, POPULATION, RESIDENTS, FILMS, CREATED, EDITED, URL)
        givenAFindAction()
        `when`(findPlanet.invoke()).thenReturn(Single.just( planet ))
    }

    private fun givenAFindAction() {
        findPlanet = mock(FindPlanet::class.java)
    }

    private fun thenVerifyShowItInView() {
        verify(mainView, times(1))
            .showInfoPlanet(InfoPlanetReducedDataModel(NAME, ORBITAL_PERIOD, ROTATION_PERIOD))
    }

    private fun thenVerifyCallFindPlanetAction() {
        verify(findPlanet, times(1)).invoke()
    }

    private fun thenVerifyThatShowSearching() {
        verify(mainView, times(1)).showSearching()
    }

    private fun whenFindInfoPlanet() {
        mainPresenter.findInfoPlanet()
    }

    private fun givenAMainPresenter() {
        mainView = mock(MainView::class.java)
        mainPresenter = MainPresenter(mainView, findPlanet)
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
            "https://swapi.co/api/people/81/")

        val FILMS = listOf("https://swapi.co/api/films/6/", "https://swapi.co/api/films/1/")
        val CREATED = Date()
        val EDITED = Date()
        const val URL = "https://swapi.co/api/planets/2/"
    }
}