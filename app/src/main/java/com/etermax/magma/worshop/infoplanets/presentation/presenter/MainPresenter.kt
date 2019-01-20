package com.etermax.magma.worshop.infoplanets.presentation.presenter

import com.etermax.magma.worshop.infoplanets.core.action.FindPlanet
import com.etermax.magma.worshop.infoplanets.core.domain.Planet
import com.etermax.magma.worshop.infoplanets.presentation.view.MainView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainPresenter(private val mainView: MainView, private val findPlanet: FindPlanet) {

    fun findInfoPlanet(): Disposable =
        Single.just(mainView.showSearching())
            .flatMap { findPlanet() }
            .map { it.toReducedDataModel() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ mainView.showInfoPlanet(it) }, { mainView.showErrorMessage() })

    private fun Planet.toReducedDataModel() = InfoPlanetReducedDataModel(name, orbitalPeriod, rotationPeriod)

    private companion object {

    }
}